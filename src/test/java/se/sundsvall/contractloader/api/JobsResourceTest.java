package se.sundsvall.contractloader.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import se.sundsvall.contractloader.service.ExportService;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("junit")
class JobsResourceTest {
	private static final String MUNICIPALITY_ID = "2281";
	private static final String PATH = "/" + MUNICIPALITY_ID + "/jobs";

	@MockitoBean
	private ExportService exportServiceMock;

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void exporter() {

		// Call
		webTestClient.post().uri(PATH + "/exporter")
			.exchange()
			.expectStatus().isNoContent();

		verify(exportServiceMock).export();
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
