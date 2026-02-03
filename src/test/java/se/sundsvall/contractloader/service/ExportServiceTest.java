package se.sundsvall.contractloader.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static se.sundsvall.contractloader.integration.db.model.enums.SendStatus.FAILED;

import generated.se.sundsvall.contract.Contract;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import se.sundsvall.contractloader.integration.contract.ContractClient;
import se.sundsvall.contractloader.integration.db.ArrendekontraktRepository;
import se.sundsvall.contractloader.integration.db.model.ArrendekontraktEntity;
import se.sundsvall.contractloader.service.provider.ContractProvider;

@ExtendWith(MockitoExtension.class)
class ExportServiceTest {

	@Mock
	private ArrendekontraktRepository arrendekontraktRepositoryMock;

	@Mock
	private ContractProvider contractProviderMock;

	@Mock
	private ContractClient contractClientMock;

	@InjectMocks
	private ExportService exportService;

	@Test
	void export() {
		// Arrange
		final var pageable = PageRequest.of(0, 10);
		final var kontrakt1 = "kontrakt1";
		final var kontrakt2 = "kontrakt2";
		final var arrendekontrakt1 = new ArrendekontraktEntity().withArrendekontrakt(kontrakt1);
		final var arrendekontrakt2 = new ArrendekontraktEntity().withArrendekontrakt(kontrakt2);
		final var contract1 = new Contract().externalReferenceId(kontrakt1);
		final var contract2 = new Contract().externalReferenceId(kontrakt2);

		when(arrendekontraktRepositoryMock.findBySendStatusIsNullOrSendStatus(FAILED, pageable)).thenReturn(new PageImpl<>(List.of(arrendekontrakt1, arrendekontrakt2)));
		when(contractProviderMock.toContract(arrendekontrakt1)).thenReturn(contract1);
		when(contractProviderMock.toContract(arrendekontrakt2)).thenReturn(contract2);

		// Act
		exportService.export();

		// Assert
		verify(arrendekontraktRepositoryMock).findBySendStatusIsNullOrSendStatus(FAILED, pageable);
		verify(arrendekontraktRepositoryMock).save(arrendekontrakt1);
		verify(arrendekontraktRepositoryMock).save(arrendekontrakt2);
		verify(contractProviderMock, times(2)).toContract(any(ArrendekontraktEntity.class));
		verify(contractClientMock, times(2)).createContract(anyString(), any(Contract.class));
		verifyNoMoreInteractions(arrendekontraktRepositoryMock, contractProviderMock, contractClientMock);
	}

	@Test
	void exportWhenException() {
		// Arrange
		final var pageable = PageRequest.of(0, 10);
		final var kontrakt1 = "kontrakt1";
		final var kontrakt2 = "kontrakt2";
		final var arrendekontrakt1 = new ArrendekontraktEntity().withArrendekontrakt(kontrakt1);
		final var arrendekontrakt2 = new ArrendekontraktEntity().withArrendekontrakt(kontrakt2);
		final var contract = new Contract().externalReferenceId(kontrakt2);

		when(arrendekontraktRepositoryMock.findBySendStatusIsNullOrSendStatus(FAILED, pageable)).thenReturn(new PageImpl<>(List.of(arrendekontrakt1, arrendekontrakt2)));
		when(contractProviderMock.toContract(arrendekontrakt1)).thenThrow(Problem.valueOf(Status.I_AM_A_TEAPOT, "Error occurred"));
		when(contractProviderMock.toContract(arrendekontrakt2)).thenReturn(contract);

		// Act
		exportService.export();

		// Assert
		verify(arrendekontraktRepositoryMock).findBySendStatusIsNullOrSendStatus(FAILED, pageable);
		verify(arrendekontraktRepositoryMock).save(arrendekontrakt1);
		verify(arrendekontraktRepositoryMock).save(arrendekontrakt2);
		verify(contractProviderMock, times(2)).toContract(any(ArrendekontraktEntity.class));
		verify(contractClientMock).createContract(anyString(), any(Contract.class));
		verifyNoMoreInteractions(arrendekontraktRepositoryMock, contractProviderMock, contractClientMock);
	}
}
