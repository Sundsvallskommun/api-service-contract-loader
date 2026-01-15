package se.sundsvall.contractloader.integration.db;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se.sundsvall.contractloader.integration.db.model.ArrendekontraktEntity;
import se.sundsvall.contractloader.integration.db.model.enums.SendStatus;

@CircuitBreaker(name = "arrendekontraktRepository")
public interface ArrendekontraktRepository extends JpaRepository<ArrendekontraktEntity, Long> {
	Page<ArrendekontraktEntity> findBySendStatusIsNullOrSendStatus(SendStatus sendStatus, Pageable pageable);
}
