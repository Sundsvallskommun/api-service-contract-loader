package se.sundsvall.contractloader.integration.db.model.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import se.sundsvall.contractloader.integration.db.model.enums.SendStatus;

@Converter(autoApply = true)
public class SendStatusConverter implements AttributeConverter<SendStatus, String> {

	@Override
	public String convertToDatabaseColumn(SendStatus attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.toString();
	}

	@Override
	public SendStatus convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		return SendStatus.valueOf(dbData);
	}
}
