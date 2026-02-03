package se.sundsvall.contractloader.integration.db;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.sundsvall.contractloader.integration.db.model.ArrendekontraktEntity;
import se.sundsvall.contractloader.integration.db.model.enums.SendStatus;

@CircuitBreaker(name = "arrendekontraktRepository")
public interface ArrendekontraktRepository extends JpaRepository<ArrendekontraktEntity, Long> {

	@Query("FROM ArrendekontraktEntity a WHERE a.sendStatus IS NULL OR a.sendStatus = :sendStatus ORDER BY a.sendStatus ASC NULLS FIRST")
	Page<ArrendekontraktEntity> findBySendStatusIsNullOrSendStatus(@Param("sendStatus") SendStatus sendStatus, Pageable pageable);
}
