package se.sundsvall.contractloader.integration.estateinfo;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static se.sundsvall.contractloader.integration.estateinfo.configuration.EstateInfoConfiguration.CLIENT_ID;

import generated.se.sundsvall.estateinfo.EstateDesignationResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import se.sundsvall.contractloader.integration.estateinfo.configuration.EstateInfoConfiguration;

@FeignClient(name = CLIENT_ID, url = "${integration.estateinfo.url}", configuration = EstateInfoConfiguration.class)
@CircuitBreaker(name = CLIENT_ID)
public interface EstateInfoClient {

	/**
	 * Get estate information by property designation.
	 *
	 * @param  municipalityId the municipality ID
	 * @param  designation    the property designation to search for
	 * @return                a list of estate designation responses containing district information
	 */
	@GetMapping(path = "/{municipalityId}/estate-by-designation", produces = APPLICATION_JSON_VALUE)
	List<EstateDesignationResponse> getEstateByDesignation(
		@PathVariable String municipalityId,
		@RequestParam String designation);

}
