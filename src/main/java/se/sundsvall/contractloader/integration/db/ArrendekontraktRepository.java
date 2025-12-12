package se.sundsvall.contractloader.integration.db;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.data.jpa.repository.JpaRepository;
import se.sundsvall.contractloader.integration.db.model.ArrendekontraktEntity;

@CircuitBreaker(name = "arrendekontraktRepository")
public interface ArrendekontraktRepository extends JpaRepository<ArrendekontraktEntity, Long> {
}
