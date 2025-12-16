package se.sundsvall.contractloader.service;

import static se.sundsvall.contractloader.service.Constants.MUNICIPALITY_ID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se.sundsvall.contractloader.integration.contract.ContractClient;
import se.sundsvall.contractloader.integration.db.ArrendekontraktRepository;
import se.sundsvall.contractloader.service.provider.ContractProvider;

@Service
public class ExportService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExportService.class);
	private static final int PAGE_SIZE = 50;

	private final ArrendekontraktRepository arrendekontraktRepository;
	private final ContractClient contractClient;
	private final ContractProvider contractProvider;

	public ExportService(ArrendekontraktRepository arrendekontraktRepository, ContractClient contractClient, ContractProvider contractProvider) {
		this.arrendekontraktRepository = arrendekontraktRepository;
		this.contractClient = contractClient;
		this.contractProvider = contractProvider;
	}

	public void export() {
		int page = 0;
		Pageable pageable = PageRequest.of(page, PAGE_SIZE);

		var pageResult = arrendekontraktRepository.findAll(pageable);
		while (pageResult.hasContent()) {
			pageResult.forEach(contract -> {
				try {
					contractClient.createContract(MUNICIPALITY_ID, contractProvider.toContract(contract));
					// TODO Add success status
				} catch (Exception _) {
					// TODO Add failure status
					LOGGER.error("Something went wrong for contract: {}", contract.getArrendekontrakt());
				}
			});
			if (!pageResult.hasNext()) {
				break;
			}
			page++;
			pageResult = arrendekontraktRepository.findAll(PageRequest.of(page, PAGE_SIZE));
		}
	}
}
