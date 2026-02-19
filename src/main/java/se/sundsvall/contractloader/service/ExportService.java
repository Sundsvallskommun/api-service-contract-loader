package se.sundsvall.contractloader.service;

import java.util.HashSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import se.sundsvall.contractloader.integration.contract.ContractClient;
import se.sundsvall.contractloader.integration.db.ArrendekontraktRepository;
import se.sundsvall.contractloader.service.provider.ContractProvider;

import static se.sundsvall.contractloader.integration.db.model.enums.SendStatus.FAILED;
import static se.sundsvall.contractloader.integration.db.model.enums.SendStatus.SENT;
import static se.sundsvall.contractloader.service.Constants.MUNICIPALITY_ID;

@Service
public class ExportService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExportService.class);
	private static final int PAGE_SIZE = 10;

	private final ArrendekontraktRepository arrendekontraktRepository;
	private final ContractClient contractClient;
	private final ContractProvider contractProvider;

	public ExportService(ArrendekontraktRepository arrendekontraktRepository, ContractClient contractClient, ContractProvider contractProvider) {
		this.arrendekontraktRepository = arrendekontraktRepository;
		this.contractClient = contractClient;
		this.contractProvider = contractProvider;
	}

	@Async
	public void export() {
		int page = 0;
		var processedContracts = new HashSet<String>();

		var pageResult = arrendekontraktRepository.findBySendStatusIsNullOrSendStatus(FAILED, PageRequest.of(page, PAGE_SIZE));
		while (pageResult.hasContent()) {
			var madeProgress = false;
			for (var contract : pageResult) {
				if (processedContracts.contains(contract.getArrendekontrakt())) {
					continue;
				}
				madeProgress = true;
				try {
					LOGGER.info("Creating contract: {}", contract.getArrendekontrakt());
					processedContracts.add(contract.getArrendekontrakt());
					contractClient.createContract(MUNICIPALITY_ID, contractProvider.toContract(contract));
					arrendekontraktRepository.save(contract.withSendStatus(SENT));
				} catch (Exception e) {
					LOGGER.error("Something went wrong for contract: {}", contract.getArrendekontrakt(), e);
					arrendekontraktRepository.save(contract.withSendStatus(FAILED));
				}
			}
			if (madeProgress) {
				page = 0; // Reset to page 0 since SENT contracts dropped out of results
			} else if (pageResult.hasNext()) {
				page++; // Advance past page of already-processed FAILED contracts
			} else {
				break; // No more pages
			}
			pageResult = arrendekontraktRepository.findBySendStatusIsNullOrSendStatus(FAILED, PageRequest.of(page, PAGE_SIZE));
		}
	}
}
