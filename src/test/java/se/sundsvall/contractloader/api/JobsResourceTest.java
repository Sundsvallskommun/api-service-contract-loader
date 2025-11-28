package se.sundsvall.contractloader.api;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("junit")
class JobsResourceTest {
	private static final String MUNICIPALITY_ID = "2281";
	private static final String PATH = "/" + MUNICIPALITY_ID + "/jobs";

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void exporter() {

		// Call
		webTestClient.post().uri(PATH + "/exporter")
			.exchange()
			.expectStatus().isNoContent();

		// TODO: Add verifications when service method is implemented
	}

	@Test
	void cleaner() {

		// Call
		webTestClient.post().uri(uriBuilder -> uriBuilder.path(PATH + "/cleaner")
			.build())
			.exchange()
			.expectStatus().isNoContent();

		// TODO: Add verifications when service method is implemented
	}
}
