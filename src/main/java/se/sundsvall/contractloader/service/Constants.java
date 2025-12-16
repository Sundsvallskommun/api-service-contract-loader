package se.sundsvall.contractloader.service;

import static generated.se.sundsvall.contract.IntervalType.HALF_YEARLY;
import static generated.se.sundsvall.contract.IntervalType.QUARTERLY;
import static generated.se.sundsvall.contract.IntervalType.YEARLY;
import static generated.se.sundsvall.contract.LeaseType.*;
import static generated.se.sundsvall.contract.StakeholderType.ASSOCIATION;
import static generated.se.sundsvall.contract.StakeholderType.MUNICIPALITY;
import static generated.se.sundsvall.contract.StakeholderType.ORGANIZATION;
import static generated.se.sundsvall.contract.StakeholderType.PERSON;

import generated.se.sundsvall.contract.IntervalType;
import generated.se.sundsvall.contract.LeaseType;
import generated.se.sundsvall.contract.StakeholderType;
import java.util.Map;

public final class Constants {

	public static final String MUNICIPALITY_ID = "2281";
	public static final String TOMTRATT = "TOMTRÄTT";
	public static final String BATPLATS = "BÅTPLATS";
	public static final String BOSTADSARRENDE_JUNIBOSAND = "BOSTADSARRENDE JUNIBOSAND";
	public static final String ALLMAN_PLATSUPPLATELSE = "ALLMÄN PLATSUPPLÅTELSE";
	public static final String LAGENHETSARRENDE = "LÄGENHETSARRENDE";
	public static final String NYTTJANDERATT = "NYTTJANDERÄTT";
	public static final String BOSTADSARRENDE = "BOSTADSARRENDE";
	public static final String ANLAGAGGNINGSARRENDE = "ANLÄGGNINGSARRENDE";
	public static final String HYRESOBJECT = "HYRESOBJEKT";
	public static final String OVRIG_AVGIFT = "ÖVRIG AVGIFT";
	public static final String JAKTARRENDE = "JAKTARRENDE";
	public static final String LAGENHETSARRENDE_PARKERING = "LÄGENHETSARRENDE PARKERING";
	public static final String JORDBRUKSARRENDE = "JORDBRUKSARRENDE";

	public static final String INVOICE_INFO_GROUP_NAME = "InvoiceInfo";
	public static final String INVOICE_INFO_MARKUP_PARAMETER = "markup";
	public static final String INVOICE_INFO_ARTICLE_PARAMETER = "article";
	public static final String CONTRACT_DETAILS_GROUP_NAME = "ContractDetails";
	public static final String CONTRACT_DETAILS_MIGRATED_FROM_PARAMETER = "migratedFrom";
	public static final String CONTRACT_DETAILS_MIGRATED_FROM_VALUE = "Xpand";
	public static final String CONTRACT_DETAILS_CONTRACT_NUMBER_PARAMETER = "contractNumber";
	public static final String CONTRACT_DETAILS_CONTRACT_NAME_PARAMETER = "contractName";
	public static final String CONTRACT_DETAILS_MAIN_CONTRACT_REFERENCE_PARAMETER = "mainContractReference";
	public static final String CONTRACT_DETAILS_CONTRACT_DATE_PARAMETER = "contractDate";
	public static final String CONTRACT_DETAILS_FINAL_BILLING_DATE_PARAMETER = "finalBillingDate";
	public static final String CONTRACT_DETAILS_TERMINATION_DATE_PARAMETER = "terminationDate";
	public static final String CONTRACT_DETAILS_TERMINATED_BY_PARAMETER = "terminatedBy";
	public static final String CONTRACT_DETAILS_ORIGINAL_CONTRACT_TYPE_PARAMETER = "originalContractType";
	public static final String CONTRACT_DETAILS_ORIGINAL_FILE_PARAMETER = "originalContractFilename";

	public static final Map<String, LeaseType> leaseTypeMapping = Map.ofEntries(
		Map.entry(TOMTRATT, LEASEHOLD),
		Map.entry(BATPLATS, USUFRUCT_MOORING),
		Map.entry(BOSTADSARRENDE_JUNIBOSAND, LAND_LEASE_RESIDENTIAL),
		Map.entry(BOSTADSARRENDE, LAND_LEASE_RESIDENTIAL),
		Map.entry(ALLMAN_PLATSUPPLATELSE, LAND_LEASE_PUBLIC),
		Map.entry(LAGENHETSARRENDE, LAND_LEASE_MISC),
		Map.entry(NYTTJANDERATT, USUFRUCT_MISC),
		Map.entry(ANLAGAGGNINGSARRENDE, SITE_LEASE_COMMERCIAL),
		Map.entry(HYRESOBJECT, OBJECT_LEASE),
		Map.entry(OVRIG_AVGIFT, OTHER_FEE),
		Map.entry(JAKTARRENDE, USUFRUCT_HUNTING),
		Map.entry(LAGENHETSARRENDE_PARKERING, LAND_LEASE_MISC),
		Map.entry(JORDBRUKSARRENDE, USUFRUCT_FARMING));

	public static final Map<String, String> additionalInformationMapping = Map.ofEntries(
		Map.entry(TOMTRATT, "Avgift, tomträttsavgäld"),
		Map.entry(BATPLATS, "Avgift, båtplats"),
		Map.entry(BOSTADSARRENDE_JUNIBOSAND, "Avgift, bostadsarrende"),
		Map.entry(BOSTADSARRENDE, "Avgift, bostadsarrende"),
		Map.entry(ALLMAN_PLATSUPPLATELSE, "Avgift, allmän platsupplåtelse"),
		Map.entry(LAGENHETSARRENDE, "Avgift, lägenhetsarrende"),
		Map.entry(NYTTJANDERATT, "Avgift, nyttjanderätt"),
		Map.entry(ANLAGAGGNINGSARRENDE, "Avgift, anläggningsarrende"),
		Map.entry(HYRESOBJECT, "Arrendeavgift"),
		Map.entry(OVRIG_AVGIFT, "Övrig avgift"),
		Map.entry(JAKTARRENDE, "Avgift, jaktarrende"),
		Map.entry(LAGENHETSARRENDE_PARKERING, "Avgift, lägenhetsarrende"),
		Map.entry(JORDBRUKSARRENDE, "Avgift, jordbruksarrende"));

	public static final String MUNICIPALITY_NAME = "Sundsvalls kommun";
	public static final String MUNICIPALITY_ORGANIZATION_NUMBER = "212000-2411";
	public static final String MUNICIPALITY_POSTAL_CODE = "851 85";
	public static final String MUNICIPALITY_TOWN = "Sundsvall";
	public static final String ORGANIZATION_NAME_EXTENSION_KEY = "organizationNameExtension";
	public static final String ORGANIZATION_NAME_EXTENSION_VALUE = "Stadsbyggnadsnämnden";

	public static final String COMPANY_KEY = "Företag";
	public static final String MUNICIPALITY_KEY = "Kommunal";
	public static final String PERSON_KEY = "Person";
	public static final String REGION_KEY = "Landsting";
	public static final String OTHER_KEY = "Organization";

	public static final String CATEGORY_PERSON = "Person";
	public static final String CATEGORY_MUNICIPALITY = "Kommunal";
	public static final String CATEGORY_COMPANY = "Företag";
	public static final String CATEGORY_OTHER = "Övrig";

	public static final Map<String, StakeholderType> stakeholderTypeMapping = Map.of(
		CATEGORY_PERSON, PERSON,
		CATEGORY_MUNICIPALITY, MUNICIPALITY,
		CATEGORY_COMPANY, ORGANIZATION,
		CATEGORY_OTHER, ASSOCIATION);

	public static final String SEK_CURRENCY = "SEK";

	public static final String ORDERING_FIRST = "1";

	public static final Map<String, IntervalType> intervalTypeMapping = Map.of(
		"kvartal", QUARTERLY,
		"Halvår", HALF_YEARLY,
		"år", YEARLY);

	private Constants() {}
}
