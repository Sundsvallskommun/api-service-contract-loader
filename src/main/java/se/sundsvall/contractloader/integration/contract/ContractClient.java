package se.sundsvall.contractloader.integration.contract;

import generated.se.sundsvall.contract.Contract;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import se.sundsvall.contractloader.integration.contract.configuration.ContractConfiguration;

import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static se.sundsvall.contractloader.integration.contract.configuration.ContractConfiguration.CLIENT_ID;

@FeignClient(name = CLIENT_ID, url = "${integration.contract.url}", configuration = ContractConfiguration.class)
@CircuitBreaker(name = CLIENT_ID)
public interface ContractClient {

	/**
	 * Creates a contract in Contract service.
	 *
	 * @param  municipalityId                       the municipality ID.
	 * @param  contract                             the contract to create
	 *                                              provided partyType and legalId.
	 * @throws org.zalando.problem.ThrowableProblem
	 */
	@PostMapping(path = "/{municipalityId}/contracts", consumes = APPLICATION_JSON_VALUE, produces = ALL_VALUE)
	ResponseEntity<Void> createContract(
		@PathVariable String municipalityId,
		@RequestBody Contract contract);
}
