package se.sundsvall.contractloader.service;

import static se.sundsvall.contractloader.integration.db.model.enums.SendStatus.FAILED;
import static se.sundsvall.contractloader.integration.db.model.enums.SendStatus.SENT;
import static se.sundsvall.contractloader.service.Constants.MUNICIPALITY_ID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import se.sundsvall.contractloader.integration.contract.ContractClient;
import se.sundsvall.contractloader.integration.db.ArrendekontraktRepository;
import se.sundsvall.contractloader.service.provider.ContractProvider;

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
		Pageable pageable = PageRequest.of(page, PAGE_SIZE);

		var pageResult = arrendekontraktRepository.findBySendStatusIsNullOrSendStatus(FAILED, pageable);
		while (pageResult.hasContent()) {
			pageResult.forEach(contract -> {
				try {
					LOGGER.info("Creating contract: {}", contract.getArrendekontrakt());
					contractClient.createContract(MUNICIPALITY_ID, contractProvider.toContract(contract));
					arrendekontraktRepository.save(contract.withSendStatus(SENT));
				} catch (Exception _) {
					LOGGER.error("Something went wrong for contract: {}", contract.getArrendekontrakt());
					arrendekontraktRepository.save(contract.withSendStatus(FAILED));
				}
			});
			if (!pageResult.hasNext()) {
				break;
			}
			pageResult = arrendekontraktRepository.findBySendStatusIsNullOrSendStatus(FAILED, PageRequest.of(0, PAGE_SIZE));
		}
	}
}
