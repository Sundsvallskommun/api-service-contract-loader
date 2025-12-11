--------------------------------
-- Testdata for arrende_arrendekontrakt
--------------------------------
INSERT INTO arrende_arrendekontrakt (arrendekontrakt, hyresid, kontraktsdatum, fr_o_m_datum,
                                                      t_o_m_datum, sista_debiteringsdatum, godkant_datum, uppsagt_datum,
                                                      uppsagt_av, preliminart_uppsagt_datum, onskad_avflyttning,
                                                      kontraktstyp, upps_tid_arrendator, enhet_upps_tid_arrendator,
                                                      upps_tid_hyresvard, enhet_upps_tid_hyresvard, forlangning,
                                                      enhet_forlangning, debiteringstyp, kontraktsarea, frifalt,
                                                      fakturaperiod, markning, kontraktsnamn, huvudkontrakt,
                                                      kopplat_till_id)
VALUES ('ARRENDEKONTRAKT-1', 'HYRESID-1', '2021-12-29 00:00:00', '2022-01-01 00:00:00', NULL, '2023-03-02 00:00:00',
        '2024-12-29 00:00:00', '2023-03-02 00:00:00', 'Arrendator', NULL, '2023-03-02 00:00:00', 'LÄGENHETSARRENDE',
        '3', 'månad', '3', 'månad', '', 'månad', '_ARRENDE', '245,00', '', 'år', '', '', '', ''),
       ('ARRENDEKONTRAKT-2', 'HYRESID-2', '2021-12-29 00:00:00', '2022-01-01 00:00:00', NULL, '2023-03-02 00:00:00',
        '2009-12-29 00:00:00', '2023-03-02 00:00:00', 'Arrendator', NULL, '2023-03-02 00:00:00', 'LÄGENHETSARRENDE',
        '3', 'månad', '3', 'månad', '', 'månad', '_ARRENDE', '255,00', '', 'år', '', '', '', ''),
       ('ARRENDEKONTRAKT-3', 'HYRESID-3', '2020-09-06 00:00:00', '2025-04-13 00:00:00', NULL, '2023-03-02 00:00:00',
        '2019-09-06 00:00:00', '2023-03-02 00:00:00', 'Arrendator', NULL, '2023-03-02 00:00:00', 'LÄGENHETSARRENDE',
        '3', 'månad', '3', 'månad', '0', 'månad', '_ARRENDE', '290,00', '', 'år', '', '', '', '');
--------------------------------
-- Testdata for arrende_arrendekontraktsrader
--------------------------------
INSERT INTO arrende_arrendekontraktsrader (arrendekontrakt, arrendeartikel, avitext,
                                                            debiteras_fr_o_m_datum, debiteras_t_o_m_datum, basarshyra,
                                                            arshyra, del_av_ar_fr_o_m, del_av_ar_t_o_m, indexklausul,
                                                            indexnamn, indexandel, indexbasar, indexbasmanad,
                                                            indexbasvarde, index_nuvarande_ar, index_nuvarande_manad,
                                                            index_nuvarande_varde, radnummer)
VALUES ('ARRENDEKONTRAKT-1', 'LGH  INDEX', 'LÄGENHETSARRENDE', '2022-01-01 00:00:00', '2022-12-31 00:00:00', '2450,00',
        '2450,00', NULL, NULL, 'Standard, ej lägre än bashyra', 'KPI 80', '100,00', '2009', '10', '301,11', '2009',
        '10', '301,11', '1'),
       ('ARRENDEKONTRAKT-1', 'LGH  INDEX', 'LÄGENHETSARRENDE', '2023-01-01 00:00:00', '2023-12-31 00:00:00', '2450,00',
        '2558,13', NULL, NULL, 'Standard, ej lägre än bashyra', 'KPI 80', '100,00', '2009', '10', '301,11', '2013',
        '10', '314,40', '5'),
       ('', 'LGH  INDEX', 'LÄGENHETSARRENDE', '2024-01-01 00:00:00', '2024-12-31 00:00:00', '2450,00',
        '2555,04', NULL, NULL, 'Standard, ej lägre än bashyra', 'KPI 80', '100,00', '2009', '10', '301,11', '2014',
        '10', '314,02', '6');
--------------------------------
-- Testdata for fasthetsbas_fastighet
--------------------------------
INSERT INTO fastighetsbas_fastighet (hyresid,foretag,foretagsnamn,fastighetsnr,fastighetsbeteckning,kommun,trakt,block,fangesdatum,agarforhallande,agare,agarenamn,postadress,postadress2,postnummer,ort,land,tomtratt,tomtratt_dodad_datum,fran_datum,till_datum,en_forvaltningsenhet_kopplad) VALUES
	 ('HYRESID-1','3','STADSBYGGNADSKONTORET','123','SUNDSVALL TEST 1','SUNDSVALL','TEST','1','1900-01-02 00:00:00','ägd','','','','','','','','Nej','','','',''),
	 ('HYRESID-2','3','STADSBYGGNADSKONTORET','456','SUNDSVALL TEST 3','SUNDSVALL','TEST','3','1900-01-02 00:00:00','ägd','','','','','','','','Nej','','','',''),
	 ('HYRESID-3','3','STADSBYGGNADSKONTORET','789','SUNDSVALL TEST 9:15','SUNDSVALL','TEST','9:15','1900-01-02 00:00:00','ägd','','','','','','','','Nej','','','','');
--------------------------------
-- Testdata for arrende_arrendator
--------------------------------
INSERT INTO arrende_arrendator (arrendekontrakt,kontaktid,person_org_nr,kategori,namn,fornamn,efternamn,avdelning,kontraktsrelation,relaterad_fr_o_m_datum,relaterad_t_o_m_datum,ordning,postadress,postadress2,postnummer,ort,land,telefon_mobil,telefon_hem,telefon_arbete,e_post,foredraget_kontaktsatt,svefaktura,betalarnummer_kontakt,betalarnummerlangd_kontakt,clearingnummer_kontakt,konto_kontakt,efakturaadress) VALUES
	 ('ARRENDEKONTRAKT-1','TEST','191010101010','Person','ANKA KALLE','KALLE','ANKA','','Kontraktsinnehavare','2010-07-01 00:00:00',NULL,'1','VÄGEN 16','','12345','ANKEBORG','SVERIGE','','','','','Ej angivet','Nej','','','','',''),
	 ('ARRENDEKONTRAKT-2','TEST','196010101010','Person','ANKA KAJSA','KAJSA','ANKA','','Kontraktsinnehavare','1999-09-01 00:00:00',NULL,'1','STORGATAN 12','','45678','ANKEBORG','SVERIGE','','','','','Ej angivet','Nej','','','','',''),
	 ('ARRENDEKONTRAKT-3','TEST','199010101010','Person','VON ANKA JOAKIM','JOAKIM','VON ANKA','','Kontraktsinnehavare','1999-09-01 00:00:00',NULL,'1','GATAN 103','','89101','ANKEBORG','SVERIGE','','','','','Ej angivet','Nej','','','','','');
--------------------------------
-- Testdata for arrende_arrendeartikel
--------------------------------
INSERT INTO arrende_arrendeartikel (arrendeartikel,artikelbenamning,avitext,artikelgrupp,artikeltyp,reglering,pris,ingar_i_kontraktssumma,avdrag,debiteras_alltid_hel_period,avvikelsetolerans_procent,summarad,aktiv) VALUES
	 ('JAKT INDEX','JAKTARRENDE','JAKTARRENDE  INDEX','','Basavgift','Index','0,00','Ja','Nej','Nej','','','Ja'),
	 ('JORD','JORDBRUKSARRENDE','JORDBRUKSARRENDE','','Basavgift','(Ingen)','0,00','Ja','Nej','Nej','','','Ja'),
	 ('LGH','LÄGENHETSARRENDE','ARRENDE-AVGIFT','','Basavgift','(Ingen)','0,00','Ja','Nej','Nej','','','Ja'),
	 ('LGH  INDEX','LÄGENHETSARRENDE','ARRENDE-AVGIFT  INDEX','','Basavgift','Index','0,00','Ja','Nej','Nej','','','Ja');
-------------------------------
-- Testdata for gemensamt_notering
--------------------------------
INSERT INTO gemensamt_notering (noteringsnamn,prioritet,typ,folder,objektid,objektid2,foretag,forvaltningsenhet,fastighetsnr,byggnad,arrendeobjekt,byggnadsdel,markyta,`system`,uppgang_vaning,bilplats,lokal,bostad,underhallsenhet,ovrigt_hyresobjekt,rum,komponent,noteringsid,filnamn) VALUES
	 ('Standard','Normal','Normal','Fastighet','','','3','','123','','','','','','','','','','','','','','','(Standard).txt'),
	 ('Standard','Normal','Normal','Fastighet','','','3','','456','','','','','','','','','','','','','','','(Standard).txt'),
	 ('Standard','Normal','Normal','Fastighet','','','3','','789','','','','','','','','','','','','','','','(Standard).txt');