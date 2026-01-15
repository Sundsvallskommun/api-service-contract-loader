package se.sundsvall.contractloader.integration.db;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import se.sundsvall.contractloader.integration.db.model.ArrendatorEntity;
import se.sundsvall.contractloader.integration.db.model.ArrendekontraktEntity;
import se.sundsvall.contractloader.integration.db.model.ArrendekontraktsradEntity;
import se.sundsvall.contractloader.integration.db.model.FastighetEntity;
import se.sundsvall.contractloader.integration.db.model.enums.SendStatus;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@ActiveProfiles("junit")
@Sql({
	"/db/scripts/truncate.sql",
	"/db/scripts/testdata-junit.sql"
})
class ArrendekontraktRepositoryTest {

	@Autowired
	private ArrendekontraktRepository repository;

	@Test
	void findAllByStatusSent() {
		Pageable pageable = PageRequest.of(0, 5);
		final List<ArrendekontraktEntity> contracts = repository.findBySendStatusIsNullOrSendStatus(SendStatus.FAILED, pageable).getContent();

		contracts.forEach(contract -> repository.save(contract.withSendStatus(SendStatus.SENT)));
		assertThat(contracts)
			.hasSize(3)
			.extracting(
				ArrendekontraktEntity::getArrendekontrakt)
			.containsExactlyInAnyOrder(
				"ARRENDEKONTRAKT-1",
				"ARRENDEKONTRAKT-2",
				"ARRENDEKONTRAKT-3");

		assertThat(contracts.getFirst().getArrendatorer()).hasSize(1)
			.extracting(
				ArrendatorEntity::getNamn,
				ArrendatorEntity::getPersonOrgNr)
			.containsExactly(
				tuple("ANKA KALLE", "191010101010"));

		assertThat(contracts.getFirst().getArrendekontraktsrader()).hasSize(2)
			.extracting(
				ArrendekontraktsradEntity::getArrendeartikel,
				ArrendekontraktsradEntity::getArshyra)
			.containsExactly(
				tuple("LGH  INDEX", "2450,00"),
				tuple("LGH  INDEX", "2558,13"));

		assertThat(contracts.getFirst().getFastighet())
			.isNotNull()
			.extracting(
				FastighetEntity::getFastighetsnr,
				FastighetEntity::getFastighetsbeteckning)
			.containsExactly("123", "SUNDSVALL TEST 1");
	}
}
