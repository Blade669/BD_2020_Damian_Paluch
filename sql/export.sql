--------------------------------------------------------
--  File created - wtorek-maja-19-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence DIAGNOZY_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##WARSZTAT"."DIAGNOZY_SEQ"  MINVALUE 1 MAXVALUE 2147483647 INCREMENT BY 1 START WITH 181 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence FUNKCJA_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##WARSZTAT"."FUNKCJA_SEQ"  MINVALUE 1 MAXVALUE 2147483647 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence KLIENCI_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##WARSZTAT"."KLIENCI_SEQ"  MINVALUE 1 MAXVALUE 2147483647 INCREMENT BY 1 START WITH 101 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence KLIENCI_UZYTKOWNICY_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##WARSZTAT"."KLIENCI_UZYTKOWNICY_SEQ"  MINVALUE 1 MAXVALUE 2147483647 INCREMENT BY 1 START WITH 150 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence PRACOWNICY_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##WARSZTAT"."PRACOWNICY_SEQ"  MINVALUE 1 MAXVALUE 2147483647 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence PRACOWNICY_UZYTKOWNICY_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##WARSZTAT"."PRACOWNICY_UZYTKOWNICY_SEQ"  MINVALUE 1 MAXVALUE 2147483647 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence PRZEGLADY_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##WARSZTAT"."PRZEGLADY_SEQ"  MINVALUE 1 MAXVALUE 2147483647 INCREMENT BY 1 START WITH 127 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SAMOCHODY_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##WARSZTAT"."SAMOCHODY_SEQ"  MINVALUE 1 MAXVALUE 2147483647 INCREMENT BY 1 START WITH 181 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SAMOCHODY_USLUGI_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##WARSZTAT"."SAMOCHODY_USLUGI_SEQ"  MINVALUE 1 MAXVALUE 2147483647 INCREMENT BY 1 START WITH 121 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence USLUGI_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##WARSZTAT"."USLUGI_SEQ"  MINVALUE 1 MAXVALUE 2147483647 INCREMENT BY 1 START WITH 71 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table DIAGNOZY
--------------------------------------------------------

  CREATE TABLE "C##WARSZTAT"."DIAGNOZY" 
   (	"ID" NUMBER, 
	"ID_SAMOCHODU" NUMBER, 
	"UWAGI_KLIENTA" VARCHAR2(200 BYTE), 
	"UWAGI_MECHANIKA" VARCHAR2(200 BYTE), 
	"ID_MECHANIKA" NUMBER, 
	"DATA" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table FUNKCJA
--------------------------------------------------------

  CREATE TABLE "C##WARSZTAT"."FUNKCJA" 
   (	"ID" NUMBER, 
	"NAZWA" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table KLIENCI
--------------------------------------------------------

  CREATE TABLE "C##WARSZTAT"."KLIENCI" 
   (	"ID" NUMBER, 
	"IMIE" VARCHAR2(30 BYTE), 
	"NAZWISKO" VARCHAR2(30 BYTE), 
	"NR_TEL" NUMBER, 
	"ID_UZYTKOWNIKA" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" 
  INMEMORY PRIORITY NONE MEMCOMPRESS FOR QUERY LOW 
  DISTRIBUTE AUTO NO DUPLICATE ;
--------------------------------------------------------
--  DDL for Table KLIENCI_UZYTKOWNICY
--------------------------------------------------------

  CREATE TABLE "C##WARSZTAT"."KLIENCI_UZYTKOWNICY" 
   (	"ID" NUMBER, 
	"LOGIN" VARCHAR2(20 BYTE), 
	"HASLO" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PRACOWNICY
--------------------------------------------------------

  CREATE TABLE "C##WARSZTAT"."PRACOWNICY" 
   (	"ID" NUMBER, 
	"IMIE" VARCHAR2(30 BYTE), 
	"NAZWISKO" VARCHAR2(30 BYTE), 
	"NR_TEL" NUMBER, 
	"ADRES" VARCHAR2(50 BYTE), 
	"ID_UZYTKOWNIKA" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PRACOWNICY_UZYTKOWNICY
--------------------------------------------------------

  CREATE TABLE "C##WARSZTAT"."PRACOWNICY_UZYTKOWNICY" 
   (	"ID" NUMBER, 
	"LOGIN" VARCHAR2(30 BYTE), 
	"HASLO" VARCHAR2(30 BYTE), 
	"ID_FUNKCJI" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PRZEGLADY
--------------------------------------------------------

  CREATE TABLE "C##WARSZTAT"."PRZEGLADY" 
   (	"ID" NUMBER, 
	"ID_SAMOCHODU" NUMBER, 
	"DATA" DATE, 
	"DATA_WAZNOSCI" DATE, 
	"ID_MECHANIKA" NUMBER, 
	"WYNIK" VARCHAR2(9 BYTE), 
	"UWAGI" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table SAMOCHODY
--------------------------------------------------------

  CREATE TABLE "C##WARSZTAT"."SAMOCHODY" 
   (	"ID" NUMBER, 
	"MARKA" VARCHAR2(30 BYTE), 
	"MODEL" VARCHAR2(30 BYTE), 
	"POJ_SILNIKA" VARCHAR2(30 BYTE), 
	"ROK" NUMBER, 
	"ID_KLIENTA" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table SAMOCHODY_USLUGI
--------------------------------------------------------

  CREATE TABLE "C##WARSZTAT"."SAMOCHODY_USLUGI" 
   (	"ID" NUMBER, 
	"ID_USLUGI" NUMBER, 
	"ID_SAMOCHODU" NUMBER, 
	"ID_MECHANIKA" NUMBER, 
	"DATA" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USLUGI
--------------------------------------------------------

  CREATE TABLE "C##WARSZTAT"."USLUGI" 
   (	"ID" NUMBER, 
	"NAZWA" VARCHAR2(30 BYTE), 
	"OPIS" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into C##WARSZTAT.DIAGNOZY
SET DEFINE OFF;
Insert into C##WARSZTAT.DIAGNOZY (ID,ID_SAMOCHODU,UWAGI_KLIENTA,UWAGI_MECHANIKA,ID_MECHANIKA,DATA) values ('175','25','Auto nie odpala',null,null,to_date('20/05/29','RR/MM/DD'));
Insert into C##WARSZTAT.DIAGNOZY (ID,ID_SAMOCHODU,UWAGI_KLIENTA,UWAGI_MECHANIKA,ID_MECHANIKA,DATA) values ('171','101',null,null,null,to_date('20/05/28','RR/MM/DD'));
REM INSERTING into C##WARSZTAT.FUNKCJA
SET DEFINE OFF;
Insert into C##WARSZTAT.FUNKCJA (ID,NAZWA) values ('1','Mechanik');
Insert into C##WARSZTAT.FUNKCJA (ID,NAZWA) values ('2','Administrator');
REM INSERTING into C##WARSZTAT.KLIENCI
SET DEFINE OFF;
Insert into C##WARSZTAT.KLIENCI (ID,IMIE,NAZWISKO,NR_TEL,ID_UZYTKOWNIKA) values ('1','Piotr','Szmul','795374653','1');
Insert into C##WARSZTAT.KLIENCI (ID,IMIE,NAZWISKO,NR_TEL,ID_UZYTKOWNIKA) values ('2','Karolina','Kasprzyk','675843946','2');
REM INSERTING into C##WARSZTAT.KLIENCI_UZYTKOWNICY
SET DEFINE OFF;
Insert into C##WARSZTAT.KLIENCI_UZYTKOWNICY (ID,LOGIN,HASLO) values ('1','klient','klient1');
Insert into C##WARSZTAT.KLIENCI_UZYTKOWNICY (ID,LOGIN,HASLO) values ('2','klient2','klient2');
REM INSERTING into C##WARSZTAT.PRACOWNICY
SET DEFINE OFF;
Insert into C##WARSZTAT.PRACOWNICY (ID,IMIE,NAZWISKO,NR_TEL,ADRES,ID_UZYTKOWNIKA) values ('1','Wojciech','Skrzypek','756473846','Rzeszow Podwislocze 12','1');
Insert into C##WARSZTAT.PRACOWNICY (ID,IMIE,NAZWISKO,NR_TEL,ADRES,ID_UZYTKOWNIKA) values ('2','Karolina','Szpila','657483759','Lezajsk Rynek 4','2');
REM INSERTING into C##WARSZTAT.PRACOWNICY_UZYTKOWNICY
SET DEFINE OFF;
Insert into C##WARSZTAT.PRACOWNICY_UZYTKOWNICY (ID,LOGIN,HASLO,ID_FUNKCJI) values ('1','mechanik','mechanik1','1');
Insert into C##WARSZTAT.PRACOWNICY_UZYTKOWNICY (ID,LOGIN,HASLO,ID_FUNKCJI) values ('2','administrator','administrator1','2');
REM INSERTING into C##WARSZTAT.PRZEGLADY
SET DEFINE OFF;
Insert into C##WARSZTAT.PRZEGLADY (ID,ID_SAMOCHODU,DATA,DATA_WAZNOSCI,ID_MECHANIKA,WYNIK,UWAGI) values ('109','2',to_date('20/05/21','RR/MM/DD'),null,null,null,null);
Insert into C##WARSZTAT.PRZEGLADY (ID,ID_SAMOCHODU,DATA,DATA_WAZNOSCI,ID_MECHANIKA,WYNIK,UWAGI) values ('29','2',to_date('20/05/28','RR/MM/DD'),to_date('20/05/22','RR/MM/DD'),'1','POZYTYWNY',null);
Insert into C##WARSZTAT.PRZEGLADY (ID,ID_SAMOCHODU,DATA,DATA_WAZNOSCI,ID_MECHANIKA,WYNIK,UWAGI) values ('10','2',to_date('20/05/25','RR/MM/DD'),to_date('21/05/22','RR/MM/DD'),'1','POZYTYWNY',null);
Insert into C##WARSZTAT.PRZEGLADY (ID,ID_SAMOCHODU,DATA,DATA_WAZNOSCI,ID_MECHANIKA,WYNIK,UWAGI) values ('108','2',to_date('20/05/21','RR/MM/DD'),null,null,null,null);
REM INSERTING into C##WARSZTAT.SAMOCHODY
SET DEFINE OFF;
Insert into C##WARSZTAT.SAMOCHODY (ID,MARKA,MODEL,POJ_SILNIKA,ROK,ID_KLIENTA) values ('1','LEXUS','IS 200','1988','1998','1');
Insert into C##WARSZTAT.SAMOCHODY (ID,MARKA,MODEL,POJ_SILNIKA,ROK,ID_KLIENTA) values ('2','DODGE','VIPER','6198','2012','1');
Insert into C##WARSZTAT.SAMOCHODY (ID,MARKA,MODEL,POJ_SILNIKA,ROK,ID_KLIENTA) values ('23','LEXUS','LFA','4679','2016','1');
Insert into C##WARSZTAT.SAMOCHODY (ID,MARKA,MODEL,POJ_SILNIKA,ROK,ID_KLIENTA) values ('24','LEXUS','GS 430','4290','2000','1');
Insert into C##WARSZTAT.SAMOCHODY (ID,MARKA,MODEL,POJ_SILNIKA,ROK,ID_KLIENTA) values ('22','CHEVROLET','CORVETTE','5420','2010','2');
Insert into C##WARSZTAT.SAMOCHODY (ID,MARKA,MODEL,POJ_SILNIKA,ROK,ID_KLIENTA) values ('101','ALFA ROMEO','GULIA','3000','2019','1');
Insert into C##WARSZTAT.SAMOCHODY (ID,MARKA,MODEL,POJ_SILNIKA,ROK,ID_KLIENTA) values ('43','TOYOTA','SUPRA','2980','1997','2');
Insert into C##WARSZTAT.SAMOCHODY (ID,MARKA,MODEL,POJ_SILNIKA,ROK,ID_KLIENTA) values ('25','LEXUS','IS F','4600','2019','1');
Insert into C##WARSZTAT.SAMOCHODY (ID,MARKA,MODEL,POJ_SILNIKA,ROK,ID_KLIENTA) values ('121','ASTON MARTIN','DB9','5935','2008','1');
Insert into C##WARSZTAT.SAMOCHODY (ID,MARKA,MODEL,POJ_SILNIKA,ROK,ID_KLIENTA) values ('141','NISSAN','SKYLINE R34','3489','1996','1');
Insert into C##WARSZTAT.SAMOCHODY (ID,MARKA,MODEL,POJ_SILNIKA,ROK,ID_KLIENTA) values ('122','ALFA ROMEO','159','3489','2008','1');
REM INSERTING into C##WARSZTAT.SAMOCHODY_USLUGI
SET DEFINE OFF;
Insert into C##WARSZTAT.SAMOCHODY_USLUGI (ID,ID_USLUGI,ID_SAMOCHODU,ID_MECHANIKA,DATA) values ('2','2','1','1',to_date('20/05/01','RR/MM/DD'));
Insert into C##WARSZTAT.SAMOCHODY_USLUGI (ID,ID_USLUGI,ID_SAMOCHODU,ID_MECHANIKA,DATA) values ('1','1','1','1',to_date('20/05/05','RR/MM/DD'));
Insert into C##WARSZTAT.SAMOCHODY_USLUGI (ID,ID_USLUGI,ID_SAMOCHODU,ID_MECHANIKA,DATA) values ('23','1','2','1',to_date('20/04/29','RR/MM/DD'));
Insert into C##WARSZTAT.SAMOCHODY_USLUGI (ID,ID_USLUGI,ID_SAMOCHODU,ID_MECHANIKA,DATA) values ('21','2','23',null,to_date('30/05/11','RR/MM/DD'));
Insert into C##WARSZTAT.SAMOCHODY_USLUGI (ID,ID_USLUGI,ID_SAMOCHODU,ID_MECHANIKA,DATA) values ('24','1','23',null,to_date('20/04/29','RR/MM/DD'));
REM INSERTING into C##WARSZTAT.USLUGI
SET DEFINE OFF;
Insert into C##WARSZTAT.USLUGI (ID,NAZWA,OPIS) values ('1','Wymiana 2 opon','Usluga obejmuje zdjecie kol z jednej osi, wymiane opon i ponowne zalozenie.');
Insert into C##WARSZTAT.USLUGI (ID,NAZWA,OPIS) values ('2','Wymiana oleju','Usluga obejmuje wymiane oleju z filtrem oleju.');
Insert into C##WARSZTAT.USLUGI (ID,NAZWA,OPIS) values ('51','Ustawienie geometrii kó³','W ka¿dym kole jest ustawiana zbie¿noœæ i k¹ty pochylenia.');
--------------------------------------------------------
--  DDL for Index DIAGNOZY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##WARSZTAT"."DIAGNOZY_PK" ON "C##WARSZTAT"."DIAGNOZY" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index FUNKCJA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##WARSZTAT"."FUNKCJA_PK" ON "C##WARSZTAT"."FUNKCJA" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KLIENCI_KONTA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##WARSZTAT"."KLIENCI_KONTA_PK" ON "C##WARSZTAT"."KLIENCI_UZYTKOWNICY" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KLIENCI_KONTA_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##WARSZTAT"."KLIENCI_KONTA_UK1" ON "C##WARSZTAT"."KLIENCI_UZYTKOWNICY" ("LOGIN") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KLIENCI_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##WARSZTAT"."KLIENCI_PK" ON "C##WARSZTAT"."KLIENCI" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KLIENCI_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##WARSZTAT"."KLIENCI_UK1" ON "C##WARSZTAT"."KLIENCI" ("ID_UZYTKOWNIKA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PRACOWNICY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##WARSZTAT"."PRACOWNICY_PK" ON "C##WARSZTAT"."PRACOWNICY" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PRACOWNICY_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##WARSZTAT"."PRACOWNICY_UK1" ON "C##WARSZTAT"."PRACOWNICY" ("ID_UZYTKOWNIKA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PRACOWNICY_UZYTKOWNICY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##WARSZTAT"."PRACOWNICY_UZYTKOWNICY_PK" ON "C##WARSZTAT"."PRACOWNICY_UZYTKOWNICY" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PRACOWNICY_UZYTKOWNICY_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##WARSZTAT"."PRACOWNICY_UZYTKOWNICY_UK1" ON "C##WARSZTAT"."PRACOWNICY_UZYTKOWNICY" ("LOGIN") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PRZEGLADY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##WARSZTAT"."PRZEGLADY_PK" ON "C##WARSZTAT"."PRZEGLADY" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SAMOCHODY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##WARSZTAT"."SAMOCHODY_PK" ON "C##WARSZTAT"."SAMOCHODY" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SAMOCHODY_USLUGI_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##WARSZTAT"."SAMOCHODY_USLUGI_PK" ON "C##WARSZTAT"."SAMOCHODY_USLUGI" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index USLUGI_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##WARSZTAT"."USLUGI_PK" ON "C##WARSZTAT"."USLUGI" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger BLEDNA_DATA_DIAGNOZY
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##WARSZTAT"."BLEDNA_DATA_DIAGNOZY" 
before insert or update on diagnozy
for each row
begin
if :new.data < CURRENT_TIMESTAMP THEN
RAISE_APPLICATION_ERROR( -20006, 'Data z przeszlosci' );
end if;
end;
/
ALTER TRIGGER "C##WARSZTAT"."BLEDNA_DATA_DIAGNOZY" ENABLE;
--------------------------------------------------------
--  DDL for Trigger BLEDNA_DATA_PRZEGLADU
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##WARSZTAT"."BLEDNA_DATA_PRZEGLADU" 
before insert or update on przeglady
for each row
begin
if :new.data < CURRENT_TIMESTAMP THEN
RAISE_APPLICATION_ERROR( -20006, 'Data z przeszlosci' );
end if;
end;
/
ALTER TRIGGER "C##WARSZTAT"."BLEDNA_DATA_PRZEGLADU" ENABLE;
--------------------------------------------------------
--  DDL for Trigger BLEDNA_DATA_USLUGI
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##WARSZTAT"."BLEDNA_DATA_USLUGI" 
before insert or update on samochody_uslugi
for each row
begin
if :new.data < CURRENT_TIMESTAMP THEN
RAISE_APPLICATION_ERROR( -20006, 'Data z przeszlosci' );
end if;
end;
/
ALTER TRIGGER "C##WARSZTAT"."BLEDNA_DATA_USLUGI" ENABLE;
--------------------------------------------------------
--  DDL for Trigger DATA_W_WEEKEND_DIAGNOZY
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##WARSZTAT"."DATA_W_WEEKEND_DIAGNOZY" 
before insert or update on diagnozy
for each row
begin
IF TO_CHAR(:NEW.DATA,'d') > 5 THEN
RAISE_APPLICATION_ERROR( -20007, 'Nie pracujemy w weekend' );
end if;
end;
/
ALTER TRIGGER "C##WARSZTAT"."DATA_W_WEEKEND_DIAGNOZY" ENABLE;
--------------------------------------------------------
--  DDL for Trigger DATA_W_WEEKEND_PRZEGLADY
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##WARSZTAT"."DATA_W_WEEKEND_PRZEGLADY" 
before insert or update on przeglady
for each row
begin
IF TO_CHAR(:NEW.DATA,'d') > 5 THEN
RAISE_APPLICATION_ERROR( -20007, 'Nie pracujemy w weekend' );
end if;
end;
/
ALTER TRIGGER "C##WARSZTAT"."DATA_W_WEEKEND_PRZEGLADY" ENABLE;
--------------------------------------------------------
--  DDL for Trigger DATA_W_WEEKEND_USLUGI
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##WARSZTAT"."DATA_W_WEEKEND_USLUGI" 
before insert or update on samochody_uslugi
for each row
begin
IF TO_CHAR(:NEW.DATA,'d') > 5 THEN
RAISE_APPLICATION_ERROR( -20007, 'Nie pracujemy w weekend' );
end if;
end;
/
ALTER TRIGGER "C##WARSZTAT"."DATA_W_WEEKEND_USLUGI" ENABLE;
--------------------------------------------------------
--  DDL for Trigger DIAGNOZY_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##WARSZTAT"."DIAGNOZY_TRG" 
BEFORE INSERT ON DIAGNOZY 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT DIAGNOZY_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "C##WARSZTAT"."DIAGNOZY_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger FUNKCJA_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##WARSZTAT"."FUNKCJA_TRG" 
BEFORE INSERT ON FUNKCJA 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT FUNKCJA_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "C##WARSZTAT"."FUNKCJA_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger HASLO
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##WARSZTAT"."HASLO" BEFORE
    INSERT ON klienci_uzytkownicy
    FOR EACH ROW
BEGIN
    IF length(:new.haslo) < 6 THEN
        raise_application_error(-20002, 'Haslo musi zawierac przynajmniej 6 znakow');
    END IF;

    IF regexp_INSTR(:new.haslo, '[[:digit:]]') = 0 THEN
        raise_application_error(-20003, 'Haslo musi zawierac cyfre');
    END IF;

    NULL;
END;
/
ALTER TRIGGER "C##WARSZTAT"."HASLO" ENABLE;
--------------------------------------------------------
--  DDL for Trigger KLIENCI_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##WARSZTAT"."KLIENCI_TRG" 
BEFORE INSERT ON KLIENCI 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT KLIENCI_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "C##WARSZTAT"."KLIENCI_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger KLIENCI_UZYTKOWNICY_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##WARSZTAT"."KLIENCI_UZYTKOWNICY_TRG" 
BEFORE INSERT ON KLIENCI_UZYTKOWNICY 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT KLIENCI_UZYTKOWNICY_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "C##WARSZTAT"."KLIENCI_UZYTKOWNICY_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger KROTKI_LOGIN
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##WARSZTAT"."KROTKI_LOGIN" BEFORE
    INSERT ON KLIENCI_uzytkownicy
    FOR EACH ROW
BEGIN
    IF length(:new.login) < 6 THEN
        raise_application_error(-20001, 'Login musi zawieraæ przynajmniej 6 znaków');
    END IF;

    NULL;

end;
/
ALTER TRIGGER "C##WARSZTAT"."KROTKI_LOGIN" ENABLE;
--------------------------------------------------------
--  DDL for Trigger KROTKI_NUMER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##WARSZTAT"."KROTKI_NUMER" BEFORE
    INSERT ON KLIENCI
    FOR EACH ROW
BEGIN
    IF  length(:new.nr_tel) < 9 THEN
        raise_application_error(-20004, 'Numer telefonu musi zawierac 9 cyfr');
    END IF;

    NULL;

end;
/
ALTER TRIGGER "C##WARSZTAT"."KROTKI_NUMER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PRACOWNICY_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##WARSZTAT"."PRACOWNICY_TRG" 
BEFORE INSERT ON PRACOWNICY 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT PRACOWNICY_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "C##WARSZTAT"."PRACOWNICY_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PRACOWNICY_UZYTKOWNICY_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##WARSZTAT"."PRACOWNICY_UZYTKOWNICY_TRG" 
BEFORE INSERT ON PRACOWNICY_UZYTKOWNICY 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT PRACOWNICY_UZYTKOWNICY_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "C##WARSZTAT"."PRACOWNICY_UZYTKOWNICY_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PRZEGLADY_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##WARSZTAT"."PRZEGLADY_TRG" 
BEFORE INSERT ON PRZEGLADY 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT PRZEGLADY_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "C##WARSZTAT"."PRZEGLADY_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SAMOCHODY_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##WARSZTAT"."SAMOCHODY_TRG" 
BEFORE INSERT ON SAMOCHODY 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT SAMOCHODY_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "C##WARSZTAT"."SAMOCHODY_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SAMOCHODY_USLUGI_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##WARSZTAT"."SAMOCHODY_USLUGI_TRG" 
BEFORE INSERT ON SAMOCHODY_USLUGI 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT SAMOCHODY_USLUGI_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "C##WARSZTAT"."SAMOCHODY_USLUGI_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger USLUGI_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##WARSZTAT"."USLUGI_TRG" 
BEFORE INSERT ON USLUGI 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT USLUGI_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "C##WARSZTAT"."USLUGI_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Package CZY_MOZNA
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE "C##WARSZTAT"."CZY_MOZNA" AS
    FUNCTION czy_mozna_diagnozy (
        d_data IN VARCHAR2
    ) RETURN NUMBER;

    FUNCTION czy_mozna_przeglady (
        p_data IN VARCHAR2
    ) RETURN NUMBER;

    FUNCTION czy_mozna_uslugi (
        u_data IN VARCHAR2
    ) RETURN NUMBER;

    PROCEDURE czy_mozna_samochod (
        s_marka       IN  samochody.marka%TYPE,
        s_model       IN  samochody.model%TYPE,
        s_id_klienta  IN  samochody.id_klienta%TYPE
    ) ;

END czy_mozna;

/
--------------------------------------------------------
--  DDL for Package DODAJ_DANE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE "C##WARSZTAT"."DODAJ_DANE" AS
    PROCEDURE dodaj_samochod (
        s_marka        IN  samochody.marka%TYPE,
        s_model        IN  samochody.model%TYPE,
        s_poj_silnika  IN  samochody.poj_silnika%TYPE,
        s_rok          IN  samochody.rok%TYPE,
        s_id_klienta   IN  samochody.id_klienta%TYPE
    );

    PROCEDURE dodaj_usluge (
        su_id_uslugi     IN  samochody_uslugi.id_uslugi%TYPE,
        su_id_samochodu  IN  samochody_uslugi.id_samochodu%TYPE,
        su_data          IN  samochody_uslugi.data%TYPE
    );

    PROCEDURE dodaj_przeglad (
        p_id_samochodu  IN  przeglady.id_samochodu%TYPE,
        p_data          IN  przeglady.data%TYPE
    );

    PROCEDURE dodaj_diagnoze (
        d_id_samochodu   IN  diagnozy.id_samochodu%TYPE,
        d_uwagi_klienta  IN  diagnozy.uwagi_klienta%TYPE,
        d_data           IN  diagnozy.data%TYPE
    );

    PROCEDURE dodaj_usluge_admin (
        u_nazwa  IN  uslugi.nazwa%TYPE,
        u_opis   IN  uslugi.opis%TYPE
    );

END dodaj_dane;

/
--------------------------------------------------------
--  DDL for Package EDYTUJ_DANE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE "C##WARSZTAT"."EDYTUJ_DANE" AS
    PROCEDURE edytuj_samochod (
        s_id           IN  samochody.id%TYPE,
        s_marka        IN  samochody.marka%TYPE,
        s_model        IN  samochody.model%TYPE,
        s_poj_silnika  IN  samochody.poj_silnika%TYPE,
        s_rok          IN  samochody.rok%TYPE
    );

    PROCEDURE edytuj_dane_klienta (
        k_id        IN  klienci.id%TYPE,
        k_imie      IN  klienci.imie%TYPE,
        k_nazwisko  IN  klienci.nazwisko%TYPE,
        k_nr_tel    IN  klienci.nr_tel%TYPE
    );

    PROCEDURE edytuj_uslugi (
        u_id     IN  uslugi.id%TYPE,
        u_nazwa  IN  uslugi.nazwa%TYPE,
        u_opis   IN  uslugi.opis%TYPE
    );

    PROCEDURE edytuj_pracownikow (
        p_id        IN  pracownicy.id%TYPE,
        p_imie      IN  pracownicy.imie%TYPE,
        p_nazwisko  IN  pracownicy.nazwisko%TYPE,
        p_nr_tel    IN  pracownicy.nr_tel%TYPE,
        p_adres     IN  pracownicy.adres%TYPE
    );

    PROCEDURE edytuj_diagnoze (
        d_id               IN  diagnozy.id%TYPE,
        d_uwagi_mechanika  IN  diagnozy.uwagi_mechanika%TYPE
    );

    PROCEDURE edytuj_przeglad (
        p_id             IN  przeglady.id%TYPE,
        p_data_waznosci  IN  przeglady.data_waznosci%TYPE,
        p_wynik          IN  przeglady.wynik%TYPE,
        p_uwagi          IN  przeglady.uwagi%TYPE
    );

END edytuj_dane;

/
--------------------------------------------------------
--  DDL for Package KLIENT_REJESTRACJA
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE "C##WARSZTAT"."KLIENT_REJESTRACJA" AS
    PROCEDURE rejestruj_klienta (
        ku_login          IN  klienci_uzytkownicy.login%TYPE,
        ku_haslo          IN  klienci_uzytkownicy.haslo%TYPE,
        ku_powtorz_haslo  IN  klienci_uzytkownicy.haslo%TYPE,
        k_imie            IN  klienci.imie%TYPE,
        k_nazwisko        IN  klienci.nazwisko%TYPE,
        k_nr_tel          IN  klienci.nr_tel%TYPE
    );

END klient_rejestracja;

/
--------------------------------------------------------
--  DDL for Package LOGOWANIE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE "C##WARSZTAT"."LOGOWANIE" AS
    PROCEDURE klient_logowanie (
        k_login  IN  klienci_uzytkownicy.login%TYPE,
        k_haslo  IN  klienci_uzytkownicy.haslo%TYPE
    );
    
    PROCEDURE mechanik_logowanie (
        m_login  IN  pracownicy_uzytkownicy.login%TYPE,
        m_haslo  IN  pracownicy_uzytkownicy.haslo%TYPE
    );
    
     PROCEDURE administrator_logowanie (
        a_login  IN  pracownicy_uzytkownicy.login%TYPE,
        a_haslo  IN  pracownicy_uzytkownicy.haslo%TYPE
    );


END logowanie;

/
--------------------------------------------------------
--  DDL for Package OBSLUZ_DANE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE "C##WARSZTAT"."OBSLUZ_DANE" AS
    PROCEDURE obsluz_diagnoze (
        d_id            IN  diagnozy.id%TYPE,
        d_uwagi         IN  diagnozy.uwagi_mechanika%TYPE,
        d_id_mechanika  IN  diagnozy.id_mechanika%TYPE
    );

    PROCEDURE obsluz_przeglad (
        p_id             IN  przeglady.id%TYPE,
        p_data_waznosci  IN  przeglady.data_waznosci%TYPE,
        p_id_mechanika   IN  przeglady.id_mechanika%TYPE,
        p_wynik          IN  przeglady.wynik%TYPE,
        p_uwagi          IN  przeglady.uwagi%TYPE
    );

    PROCEDURE obsluz_usluge (
        u_id            IN  samochody_uslugi.id%TYPE,
        u_id_mechanika  IN  samochody_uslugi.id_mechanika%TYPE
    );

END obsluz_dane;

/
--------------------------------------------------------
--  DDL for Package SZUKAJ_DANYCH
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE "C##WARSZTAT"."SZUKAJ_DANYCH" AS
    PROCEDURE szukaj_diagnozy (
        d_szukane       IN   diagnozy.uwagi_klienta%TYPE,
        d_id_mechanika  IN   diagnozy.id_mechanika%TYPE,
        d_wynik         OUT  SYS_REFCURSOR
    );

    PROCEDURE szukaj_przegladu (
        p_szukane       IN   przeglady.uwagi%TYPE,
        p_id_mechanika  IN   przeglady.id_mechanika%TYPE,
        p_wynik         OUT  SYS_REFCURSOR
    );

    PROCEDURE szukaj_uslugi (
        su_szukane       IN   VARCHAR2,
        su_id_mechanika  IN   samochody_uslugi.id_mechanika%TYPE,
        su_wynik         OUT  SYS_REFCURSOR
    );

    PROCEDURE szukaj_edycji_uslugi_admin (
        ua_szukane  IN   VARCHAR2,
        ua_wynik    OUT  SYS_REFCURSOR
    );

    PROCEDURE szukaj_pracownika (
        pr_szukane  IN   VARCHAR2,
        pr_wynik    OUT  SYS_REFCURSOR
    );

    PROCEDURE szukaj_diagnozy_admin (
        da_szukane       IN   VARCHAR2,
        da_wynik         OUT  SYS_REFCURSOR
    );
    
    PROCEDURE szukaj_przegladu_admin (
        pa_szukane       IN   VARCHAR2,
        pa_wynik         OUT  SYS_REFCURSOR
    );
    
    PROCEDURE szukaj_uslugi_admin (
        su_szukane  IN   VARCHAR2,
        su_wynik    OUT  SYS_REFCURSOR
    );

END szukaj_danych;

/
--------------------------------------------------------
--  DDL for Package USUN_DANE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE "C##WARSZTAT"."USUN_DANE" AS
    PROCEDURE usun_samochod (
        s_id IN samochody.id%TYPE
    );

END usun_dane;

/
--------------------------------------------------------
--  DDL for Package WALIDACJA
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE "C##WARSZTAT"."WALIDACJA" AS
    FUNCTION czy_puste (
        sprawdz VARCHAR2
    ) RETURN NUMBER;

END walidacja;

/
--------------------------------------------------------
--  DDL for Package Body CZY_MOZNA
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE BODY "C##WARSZTAT"."CZY_MOZNA" AS

    FUNCTION czy_mozna_diagnozy (
        d_data IN VARCHAR2
    ) RETURN NUMBER AS
        licznik NUMBER;
    BEGIN
        SELECT
            COUNT(data)
        INTO licznik
        FROM
            diagnozy
        WHERE
            to_char(CAST(diagnozy.data AS TIMESTAMP), 'YYYY/MM/DD') = to_char(CAST(d_data AS TIMESTAMP), 'YYYY/MM/DD');

        IF licznik >= 3 THEN
            RETURN 1;
        ELSE
            RETURN 0;
        END IF;
    END czy_mozna_diagnozy;

    FUNCTION czy_mozna_przeglady (
        p_data IN VARCHAR2
    ) RETURN NUMBER AS
        licznik NUMBER;
    BEGIN
        SELECT
            COUNT(data)
        INTO licznik
        FROM
            przeglady
        WHERE
            to_char(CAST(data AS TIMESTAMP), 'YYYY/MM/DD') = to_char(CAST(p_data AS TIMESTAMP), 'YYYY/MM/DD');

        IF licznik >= 10 THEN
            RETURN 1;
        ELSE
            RETURN 0;
        END IF;
    END czy_mozna_przeglady;

    FUNCTION czy_mozna_uslugi (
        u_data IN VARCHAR2
    ) RETURN NUMBER AS
        licznik NUMBER;
    BEGIN
        SELECT
            COUNT(data)
        INTO licznik
        FROM
            samochody_uslugi
        WHERE
            to_char(CAST(data AS TIMESTAMP), 'YYYY/MM/DD') = to_char(CAST(u_data AS TIMESTAMP), 'YYYY/MM/DD');

        IF licznik >= 15 THEN
            RETURN 1;
        ELSE
            RETURN 0;
        END IF;
    END czy_mozna_uslugi;

    PROCEDURE czy_mozna_samochod (
        s_marka       IN  samochody.marka%TYPE,
        s_model       IN  samochody.model%TYPE,
        s_id_klienta  IN  samochody.id_klienta%TYPE
    ) AS
        licznik NUMBER;
    BEGIN
        SELECT
            count(*)
        INTO licznik
        FROM
            samochody
        WHERE
                marka = upper(s_marka)
            AND model = upper(s_model)
            AND id_klienta = s_id_klienta;

        IF licznik > 0 THEN
            raise_application_error(-20008, 'Samochod istnieje w bazie');
        END IF;
        end czy_mozna_samochod;
    END czy_mozna;

/
--------------------------------------------------------
--  DDL for Package Body DODAJ_DANE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE BODY "C##WARSZTAT"."DODAJ_DANE" AS

    PROCEDURE dodaj_samochod (
        s_marka        IN  samochody.marka%TYPE,
        s_model        IN  samochody.model%TYPE,
        s_poj_silnika  IN  samochody.poj_silnika%TYPE,
        s_rok          IN  samochody.rok%TYPE,
        s_id_klienta   IN  samochody.id_klienta%TYPE
    ) AS
    BEGIN
        INSERT INTO samochody (
            marka,
            model,
            poj_silnika,
            rok,
            id_klienta
        ) VALUES (
            upper(s_marka),
            upper(s_model),
            s_poj_silnika,
            s_rok,
            s_id_klienta
        );

        NULL;
    END dodaj_samochod;

    PROCEDURE dodaj_usluge (
        su_id_uslugi     IN  samochody_uslugi.id_uslugi%TYPE,
        su_id_samochodu  IN  samochody_uslugi.id_samochodu%TYPE,
        su_data          IN  samochody_uslugi.data%TYPE
    ) AS
    BEGIN
        INSERT INTO samochody_uslugi (
            id_uslugi,
            id_samochodu,
            data
        ) VALUES (
            su_id_uslugi,
            su_id_samochodu,
            to_char(su_data, 'YYYY-MM-DD')
        );

        NULL;
    END dodaj_usluge;

    PROCEDURE dodaj_przeglad (
        p_id_samochodu  IN  przeglady.id_samochodu%TYPE,
        p_data          IN  przeglady.data%TYPE
    ) AS
    BEGIN
        INSERT INTO przeglady (
            id_samochodu,
            data
        ) VALUES (
            p_id_samochodu,
            to_char(p_data, 'YYYY-MM-DD')
        );

        NULL;
    END dodaj_przeglad;

    PROCEDURE dodaj_diagnoze (
        d_id_samochodu   IN  diagnozy.id_samochodu%TYPE,
        d_uwagi_klienta  IN  diagnozy.uwagi_klienta%TYPE,
        d_data           IN  diagnozy.data%TYPE
    ) AS
    BEGIN
        INSERT INTO diagnozy (
            id_samochodu,
            uwagi_klienta,
            data
        ) VALUES (
            d_id_samochodu,
            upper(d_uwagi_klienta),
            to_char(d_data, 'YYYY-MM-DD')
        );

        NULL;
    END dodaj_diagnoze;

    PROCEDURE dodaj_usluge_admin (
        u_nazwa  IN  uslugi.nazwa%TYPE,
        u_opis   IN  uslugi.opis%TYPE
    ) AS
    BEGIN
        INSERT INTO uslugi (
            nazwa,
            opis
        ) VALUES (
            u_nazwa,
            u_opis
        );

        NULL;
    END dodaj_usluge_admin;

END dodaj_dane;

/
--------------------------------------------------------
--  DDL for Package Body EDYTUJ_DANE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE BODY "C##WARSZTAT"."EDYTUJ_DANE" AS

    PROCEDURE edytuj_samochod (
        s_id           IN  samochody.id%TYPE,
        s_marka        IN  samochody.marka%TYPE,
        s_model        IN  samochody.model%TYPE,
        s_poj_silnika  IN  samochody.poj_silnika%TYPE,
        s_rok          IN  samochody.rok%TYPE
    ) AS
    BEGIN
        UPDATE samochody
        SET
            samochody.marka = upper(s_marka),
            samochody.model = upper(s_model),
            samochody.poj_silnika = s_poj_silnika,
            samochody.rok = s_rok
        WHERE
            samochody.id = s_id;

        NULL;
    END edytuj_samochod;

    PROCEDURE edytuj_dane_klienta (
        k_id        IN  klienci.id%TYPE,
        k_imie      IN  klienci.imie%TYPE,
        k_nazwisko  IN  klienci.nazwisko%TYPE,
        k_nr_tel    IN  klienci.nr_tel%TYPE
    ) AS
    BEGIN
        UPDATE klienci
        SET
            klienci.imie = upper(k_imie),
            klienci.nazwisko = upper(k_nazwisko),
            klienci.nr_tel = upper(k_nr_tel)
        WHERE
            klienci.id = k_id;

        NULL;
    END edytuj_dane_klienta;

    PROCEDURE edytuj_uslugi (
        u_id     IN  uslugi.id%TYPE,
        u_nazwa  IN  uslugi.nazwa%TYPE,
        u_opis   IN  uslugi.opis%TYPE
    ) AS
    BEGIN
        UPDATE uslugi
        SET
            uslugi.nazwa = u_nazwa,
            uslugi.opis = u_opis
        WHERE
            uslugi.id = u_id;

        NULL;
    END edytuj_uslugi;

    PROCEDURE edytuj_pracownikow (
        p_id        IN  pracownicy.id%TYPE,
        p_imie      IN  pracownicy.imie%TYPE,
        p_nazwisko  IN  pracownicy.nazwisko%TYPE,
        p_nr_tel    IN  pracownicy.nr_tel%TYPE,
        p_adres     IN  pracownicy.adres%TYPE
    ) AS
    BEGIN
        UPDATE pracownicy
        SET
            pracownicy.imie = p_imie,
            pracownicy.nazwisko = p_nazwisko,
            pracownicy.nr_tel = p_nr_tel,
            pracownicy.adres = p_adres
        WHERE
            id = p_id;

        NULL;
    END edytuj_pracownikow;

    PROCEDURE edytuj_diagnoze (
        d_id               IN  diagnozy.id%TYPE,
        d_uwagi_mechanika  IN  diagnozy.uwagi_mechanika%TYPE
    ) AS
    BEGIN
        UPDATE diagnozy
        SET
            diagnozy.uwagi_mechanika = d_uwagi_mechanika
        WHERE
            id = d_id;

        NULL;
    END edytuj_diagnoze;

    PROCEDURE edytuj_przeglad (
        p_id             IN  przeglady.id%TYPE,
        p_data_waznosci  IN  przeglady.data_waznosci%TYPE,
        p_wynik          IN  przeglady.wynik%TYPE,
        p_uwagi          IN  przeglady.uwagi%TYPE
    ) AS
    BEGIN
        UPDATE przeglady
        SET
            przeglady.data_waznosci = p_data_waznosci,
            przeglady.wynik = upper(p_wynik),
            przeglady.uwagi = p_uwagi
        WHERE
            przeglady.id = p_id;

        NULL;
    END edytuj_przeglad;

END edytuj_dane;

/
--------------------------------------------------------
--  DDL for Package Body KLIENT_REJESTRACJA
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE BODY "C##WARSZTAT"."KLIENT_REJESTRACJA" AS

    PROCEDURE rejestruj_klienta (
        ku_login          IN  klienci_uzytkownicy.login%TYPE,
        ku_haslo          IN  klienci_uzytkownicy.haslo%TYPE,
        ku_powtorz_haslo  IN  klienci_uzytkownicy.haslo%TYPE,
        k_imie            IN  klienci.imie%TYPE,
        k_nazwisko        IN  klienci.nazwisko%TYPE,
        k_nr_tel          IN  klienci.nr_tel%TYPE
    ) IS
        zmienna NUMBER;
    BEGIN
        IF ( ku_haslo ) LIKE ku_powtorz_haslo THEN
            INSERT INTO klienci_uzytkownicy (
                login,
                haslo
            ) VALUES (
                ku_login,
                ku_haslo
            ) RETURNING id INTO zmienna;

            INSERT INTO klienci (
                imie,
                nazwisko,
                nr_tel,
                id_uzytkownika
            ) VALUES (
                initcap(k_imie),
                initcap(k_nazwisko),
                k_nr_tel,
                zmienna
            );

            COMMIT;
        ELSE
            raise_application_error(-20005, 'Hasla sie roznia');
        END IF;

        NULL;
    END rejestruj_klienta;

END klient_rejestracja;

/
--------------------------------------------------------
--  DDL for Package Body LOGOWANIE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE BODY "C##WARSZTAT"."LOGOWANIE" AS

    PROCEDURE klient_logowanie (
        k_login  IN  klienci_uzytkownicy.login%TYPE,
        k_haslo  IN  klienci_uzytkownicy.haslo%TYPE
    ) AS
        zmienna VARCHAR2(1);
    BEGIN
        SELECT
            '1'
        INTO zmienna
        FROM
            klienci_uzytkownicy
        WHERE
                login = k_login
            AND haslo = k_haslo;

    EXCEPTION
        WHEN no_data_found THEN
            raise_application_error(-20000, 'Bledne dane logowania');
    END klient_logowanie;

    PROCEDURE mechanik_logowanie (
        m_login  IN  pracownicy_uzytkownicy.login%TYPE,
        m_haslo  IN  pracownicy_uzytkownicy.haslo%TYPE
    ) AS
        zmienna VARCHAR2(1);
    BEGIN
        SELECT
            '1'
        INTO zmienna
        FROM
            pracownicy_uzytkownicy
        WHERE
                pracownicy_uzytkownicy.login = m_login
            AND pracownicy_uzytkownicy.haslo = m_haslo
            AND id_funkcji = 1;

    EXCEPTION
        WHEN no_data_found THEN
            raise_application_error(-20000, 'Bledne dane logowania');
    END mechanik_logowanie;
    
        PROCEDURE administrator_logowanie (
        a_login  IN  pracownicy_uzytkownicy.login%TYPE,
        a_haslo  IN  pracownicy_uzytkownicy.haslo%TYPE
    ) AS
        zmienna VARCHAR2(1);
    BEGIN
        SELECT
            '1'
        INTO zmienna
        FROM
            pracownicy_uzytkownicy
        WHERE
                pracownicy_uzytkownicy.login = a_login
            AND pracownicy_uzytkownicy.haslo = a_haslo
            AND id_funkcji = 2;

    EXCEPTION
        WHEN no_data_found THEN
            raise_application_error(-20000, 'Bledne dane logowania');
    END administrator_logowanie;

END logowanie;

/
--------------------------------------------------------
--  DDL for Package Body OBSLUZ_DANE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE BODY "C##WARSZTAT"."OBSLUZ_DANE" AS

    PROCEDURE obsluz_diagnoze (
        d_id            IN  diagnozy.id%TYPE,
        d_uwagi         IN  diagnozy.uwagi_mechanika%TYPE,
        d_id_mechanika  IN  diagnozy.id_mechanika%TYPE
    ) AS
    BEGIN
        UPDATE diagnozy
        SET
            uwagi_mechanika = upper(d_uwagi),
            id_mechanika = d_id_mechanika
        WHERE
            diagnozy.id = d_id;

        NULL;
    END obsluz_diagnoze;

    PROCEDURE obsluz_przeglad (
        p_id             IN  przeglady.id%TYPE,
        p_data_waznosci  IN  przeglady.data_waznosci%TYPE,
        p_id_mechanika   IN  przeglady.id_mechanika%TYPE,
        p_wynik          IN  przeglady.wynik%TYPE,
        p_uwagi          IN  przeglady.uwagi%TYPE
    ) AS
    BEGIN
        UPDATE przeglady
        SET
            data_waznosci = p_data_waznosci,
            id_mechanika = p_id_mechanika,
            wynik = upper(p_wynik),
            uwagi = upper(p_uwagi)
        WHERE
            przeglady.id = p_id;

        NULL;
    END obsluz_przeglad;

    PROCEDURE obsluz_usluge (
        u_id            IN  samochody_uslugi.id%TYPE,
        u_id_mechanika  IN  samochody_uslugi.id_mechanika%TYPE
    ) AS
    BEGIN
        UPDATE samochody_uslugi
        SET
            id_mechanika = u_id_mechanika
        WHERE
            samochody_uslugi.id = u_id;

        NULL;
    END obsluz_usluge;

END obsluz_dane;

/
--------------------------------------------------------
--  DDL for Package Body SZUKAJ_DANYCH
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE BODY "C##WARSZTAT"."SZUKAJ_DANYCH" AS

    PROCEDURE szukaj_diagnozy (
        d_szukane       IN   diagnozy.uwagi_klienta%TYPE,
        d_id_mechanika  IN   diagnozy.id_mechanika%TYPE,
        d_wynik         OUT  SYS_REFCURSOR
    ) AS
    BEGIN
        OPEN d_wynik FOR SELECT
                             d.*,
                             s.marka,
                             s.model
                         FROM
                             diagnozy   d,
                             samochody  s
                         WHERE
                                 s.id = d.id_samochodu
                             AND d.id_mechanika = d_id_mechanika
                             AND ( ( instr(upper(d.uwagi_mechanika), upper(d_szukane), 1) ) > 0
                                   OR ( instr(upper(s.marka), upper(d_szukane), 1) ) > 0
                                   OR ( instr(upper(s.model), upper(d_szukane), 1) ) > 0
                                   OR ( instr(to_char(d.data, 'YYYY-MM-DD'), d_szukane, 1) > 0 ) );

        NULL;
    END szukaj_diagnozy;

    PROCEDURE szukaj_przegladu (
        p_szukane       IN   przeglady.uwagi%TYPE,
        p_id_mechanika  IN   przeglady.id_mechanika%TYPE,
        p_wynik         OUT  SYS_REFCURSOR
    ) AS
    BEGIN
        OPEN p_wynik FOR SELECT
                             p.*,
                             s.marka,
                             s.model
                         FROM
                             przeglady  p,
                             samochody  s
                         WHERE
                                 s.id = p.id_samochodu
                             AND p.id_mechanika = p_id_mechanika
                             AND ( ( instr(upper(s.marka), upper(p_szukane), 1) ) > 0
                                   OR ( instr(upper(s.model), upper(p_szukane), 1) ) > 0
                                   OR ( instr(upper(p.wynik), upper(p_szukane), 1) ) > 0
                                   OR ( instr(to_char(p.data, 'YYYY-MM-DD'), p_szukane, 1) > 0 )
                                   OR ( instr(to_char(p.data_waznosci, 'YYYY-MM-DD'), p_szukane, 1) > 0 ) );

        NULL;
    END szukaj_przegladu;

    PROCEDURE szukaj_uslugi (
        su_szukane       IN   VARCHAR2,
        su_id_mechanika  IN   samochody_uslugi.id_mechanika%TYPE,
        su_wynik         OUT  SYS_REFCURSOR
    ) AS
    BEGIN
        OPEN su_wynik FOR SELECT
                              su.*,
                              s.marka,
                              s.model,
                              u.nazwa
                          FROM
                              samochody_uslugi  su,
                              samochody         s,
                              uslugi            u
                          WHERE
                                  s.id = su.id_samochodu
                              AND su.id_mechanika = su_id_mechanika
                              AND su.id_uslugi = u.id
                              AND ( ( instr(upper(s.marka), upper(su_szukane), 1) ) > 0
                                    OR ( instr(upper(s.model), upper(su_szukane), 1) ) > 0
                                    OR ( instr(upper(u.nazwa), upper(su_szukane), 1) ) > 0
                                    OR ( instr(to_char(su.data, 'YYYY-MM-DD'), su_szukane, 1) > 0 ) );

        NULL;
    END szukaj_uslugi;

    PROCEDURE szukaj_edycji_uslugi_admin (
        ua_szukane  IN   VARCHAR2,
        ua_wynik    OUT  SYS_REFCURSOR
    ) AS
    BEGIN
        OPEN ua_wynik FOR SELECT
                              *
                          FROM
                              uslugi
                          WHERE
                              ( instr(upper(nazwa), upper(ua_szukane), 1) ) > 0
                              OR ( instr(upper(opis), upper(ua_szukane), 1) ) > 0;

        NULL;
    END szukaj_edycji_uslugi_admin;

    PROCEDURE szukaj_pracownika (
        pr_szukane  IN   VARCHAR2,
        pr_wynik    OUT  SYS_REFCURSOR
    ) AS
    BEGIN
        OPEN pr_wynik FOR SELECT
                              *
                          FROM
                              pracownicy
                          WHERE
                                  id_uzytkownika = 1
                              AND ( ( instr(upper(imie), upper(pr_szukane), 1) ) > 0
                                    OR ( instr(upper(nazwisko), upper(pr_szukane), 1) ) > 0
                                    OR ( instr(nr_tel, pr_szukane, 1) > 0
                                    OR ( instr(upper(adres), upper(pr_szukane), 1) ) > 0 ) );

        NULL;
    END szukaj_pracownika;

    PROCEDURE szukaj_diagnozy_admin (
        da_szukane  IN   VARCHAR2,
        da_wynik    OUT  SYS_REFCURSOR
    ) AS
    BEGIN
        OPEN da_wynik FOR SELECT
                              d.*,
                              s.marka,
                              s.model
                          FROM
                              diagnozy   d,
                              samochody  s
                          WHERE
                                  s.id = d.id_samochodu
                              AND ( ( instr(upper(d.uwagi_mechanika), upper(da_szukane), 1) ) > 0
                                    OR ( instr(upper(s.marka), upper(da_szukane), 1) ) > 0
                                    OR ( instr(upper(s.model), upper(da_szukane), 1) ) > 0
                                    OR ( instr(upper(d.uwagi_klienta), upper(da_szukane), 1) ) > 0
                                    OR ( instr(to_char(d.data, 'YYYY-MM-DD'), da_szukane, 1) > 0 ) );

        NULL;
    END szukaj_diagnozy_admin;

    PROCEDURE szukaj_przegladu_admin (
        pa_szukane  IN   VARCHAR2,
        pa_wynik    OUT  SYS_REFCURSOR
    ) AS
    BEGIN
        OPEN pa_wynik FOR SELECT
                              p.*,
                              s.marka,
                              s.model
                          FROM
                              przeglady  p,
                              samochody  s
                          WHERE
                                  s.id = p.id_samochodu
                              AND ( ( instr(upper(s.marka), upper(pa_szukane), 1) ) > 0
                                    OR ( instr(upper(s.model), upper(pa_szukane), 1) ) > 0
                                    OR ( instr(upper(p.wynik), upper(pa_szukane), 1) ) > 0
                                    OR ( instr(upper(p.uwagi), upper(pa_szukane), 1) ) > 0
                                    OR ( instr(to_char(p.data, 'YYYY-MM-DD'), pa_szukane, 1) > 0 )
                                    OR ( instr(to_char(p.data_waznosci, 'YYYY-MM-DD'), pa_szukane, 1) > 0 ) );

        NULL;
    END szukaj_przegladu_admin;

    PROCEDURE szukaj_uslugi_admin (
        su_szukane  IN   VARCHAR2,
        su_wynik    OUT  SYS_REFCURSOR
    ) AS
    BEGIN
        OPEN su_wynik FOR SELECT
                              su.*,
                              s.marka,
                              s.model,
                              u.nazwa
                          FROM
                              samochody_uslugi  su,
                              samochody         s,
                              uslugi            u
                          WHERE
                                  s.id = su.id_samochodu
                              AND su.id_uslugi = u.id
                              AND ( ( instr(upper(s.marka), upper(su_szukane), 1) ) > 0
                                    OR ( instr(upper(s.model), upper(su_szukane), 1) ) > 0
                                    OR ( instr(upper(u.nazwa), upper(su_szukane), 1) ) > 0
                                    OR ( instr(to_char(su.data, 'YYYY-MM-DD'), su_szukane, 1) > 0 ) );

        NULL;
    END szukaj_uslugi_admin;

END szukaj_danych;

/
--------------------------------------------------------
--  DDL for Package Body USUN_DANE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE BODY "C##WARSZTAT"."USUN_DANE" AS

    PROCEDURE usun_samochod (
        s_id IN samochody.id%TYPE
    ) AS
    BEGIN
        DELETE FROM samochody
        WHERE
            id = s_id;

        NULL;
    END usun_samochod;

END usun_dane;

/
--------------------------------------------------------
--  DDL for Package Body WALIDACJA
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE BODY "C##WARSZTAT"."WALIDACJA" AS

    FUNCTION czy_puste (
        sprawdz VARCHAR2
    ) RETURN NUMBER AS
    BEGIN
        IF length(sprawdz) > 0 THEN
            RETURN 1;
        ELSE
            RETURN 0;
        END IF;
    END czy_puste;

END walidacja;

/
--------------------------------------------------------
--  Constraints for Table SAMOCHODY
--------------------------------------------------------

  ALTER TABLE "C##WARSZTAT"."SAMOCHODY" MODIFY ("POJ_SILNIKA" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."SAMOCHODY" MODIFY ("ID_KLIENTA" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."SAMOCHODY" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."SAMOCHODY" MODIFY ("MARKA" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."SAMOCHODY" MODIFY ("MODEL" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."SAMOCHODY" MODIFY ("ROK" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."SAMOCHODY" ADD CONSTRAINT "SAMOCHODY_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table USLUGI
--------------------------------------------------------

  ALTER TABLE "C##WARSZTAT"."USLUGI" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."USLUGI" ADD CONSTRAINT "USLUGI_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "C##WARSZTAT"."USLUGI" MODIFY ("NAZWA" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."USLUGI" MODIFY ("OPIS" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PRACOWNICY
--------------------------------------------------------

  ALTER TABLE "C##WARSZTAT"."PRACOWNICY" ADD CONSTRAINT "PRACOWNICY_UK1" UNIQUE ("ID_UZYTKOWNIKA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "C##WARSZTAT"."PRACOWNICY" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."PRACOWNICY" MODIFY ("IMIE" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."PRACOWNICY" MODIFY ("NAZWISKO" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."PRACOWNICY" MODIFY ("NR_TEL" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."PRACOWNICY" MODIFY ("ADRES" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."PRACOWNICY" ADD CONSTRAINT "PRACOWNICY_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "C##WARSZTAT"."PRACOWNICY" MODIFY ("ID_UZYTKOWNIKA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table KLIENCI
--------------------------------------------------------

  ALTER TABLE "C##WARSZTAT"."KLIENCI" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."KLIENCI" MODIFY ("IMIE" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."KLIENCI" MODIFY ("NAZWISKO" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."KLIENCI" MODIFY ("NR_TEL" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."KLIENCI" ADD CONSTRAINT "KLIENCI_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "C##WARSZTAT"."KLIENCI" ADD CONSTRAINT "KLIENCI_UK1" UNIQUE ("ID_UZYTKOWNIKA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PRACOWNICY_UZYTKOWNICY
--------------------------------------------------------

  ALTER TABLE "C##WARSZTAT"."PRACOWNICY_UZYTKOWNICY" MODIFY ("ID_FUNKCJI" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."PRACOWNICY_UZYTKOWNICY" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."PRACOWNICY_UZYTKOWNICY" MODIFY ("LOGIN" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."PRACOWNICY_UZYTKOWNICY" MODIFY ("HASLO" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."PRACOWNICY_UZYTKOWNICY" ADD CONSTRAINT "PRACOWNICY_UZYTKOWNICY_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "C##WARSZTAT"."PRACOWNICY_UZYTKOWNICY" ADD CONSTRAINT "PRACOWNICY_UZYTKOWNICY_UK1" UNIQUE ("LOGIN")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table FUNKCJA
--------------------------------------------------------

  ALTER TABLE "C##WARSZTAT"."FUNKCJA" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."FUNKCJA" MODIFY ("NAZWA" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."FUNKCJA" ADD CONSTRAINT "FUNKCJA_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table DIAGNOZY
--------------------------------------------------------

  ALTER TABLE "C##WARSZTAT"."DIAGNOZY" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."DIAGNOZY" MODIFY ("ID_SAMOCHODU" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."DIAGNOZY" ADD CONSTRAINT "DIAGNOZY_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "C##WARSZTAT"."DIAGNOZY" MODIFY ("DATA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PRZEGLADY
--------------------------------------------------------

  ALTER TABLE "C##WARSZTAT"."PRZEGLADY" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."PRZEGLADY" MODIFY ("ID_SAMOCHODU" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."PRZEGLADY" ADD CONSTRAINT "PRZEGLADY_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "C##WARSZTAT"."PRZEGLADY" MODIFY ("DATA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table SAMOCHODY_USLUGI
--------------------------------------------------------

  ALTER TABLE "C##WARSZTAT"."SAMOCHODY_USLUGI" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."SAMOCHODY_USLUGI" MODIFY ("ID_USLUGI" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."SAMOCHODY_USLUGI" MODIFY ("ID_SAMOCHODU" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."SAMOCHODY_USLUGI" ADD CONSTRAINT "SAMOCHODY_USLUGI_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "C##WARSZTAT"."SAMOCHODY_USLUGI" MODIFY ("DATA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table KLIENCI_UZYTKOWNICY
--------------------------------------------------------

  ALTER TABLE "C##WARSZTAT"."KLIENCI_UZYTKOWNICY" MODIFY ("LOGIN" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."KLIENCI_UZYTKOWNICY" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."KLIENCI_UZYTKOWNICY" MODIFY ("HASLO" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."KLIENCI_UZYTKOWNICY" ADD CONSTRAINT "KLIENCI_KONTA_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "C##WARSZTAT"."KLIENCI_UZYTKOWNICY" ADD CONSTRAINT "KLIENCI_KONTA_UK1" UNIQUE ("LOGIN")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DIAGNOZY
--------------------------------------------------------

  ALTER TABLE "C##WARSZTAT"."DIAGNOZY" ADD CONSTRAINT "DIAGNOZY_FK1" FOREIGN KEY ("ID_SAMOCHODU")
	  REFERENCES "C##WARSZTAT"."SAMOCHODY" ("ID") ENABLE;
  ALTER TABLE "C##WARSZTAT"."DIAGNOZY" ADD CONSTRAINT "DIAGNOZY_FK2" FOREIGN KEY ("ID_MECHANIKA")
	  REFERENCES "C##WARSZTAT"."PRACOWNICY" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table KLIENCI
--------------------------------------------------------

  ALTER TABLE "C##WARSZTAT"."KLIENCI" ADD CONSTRAINT "KLIENCI_FK2" FOREIGN KEY ("ID_UZYTKOWNIKA")
	  REFERENCES "C##WARSZTAT"."KLIENCI_UZYTKOWNICY" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PRACOWNICY
--------------------------------------------------------

  ALTER TABLE "C##WARSZTAT"."PRACOWNICY" ADD CONSTRAINT "PRACOWNICY_FK1" FOREIGN KEY ("ID_UZYTKOWNIKA")
	  REFERENCES "C##WARSZTAT"."PRACOWNICY_UZYTKOWNICY" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PRACOWNICY_UZYTKOWNICY
--------------------------------------------------------

  ALTER TABLE "C##WARSZTAT"."PRACOWNICY_UZYTKOWNICY" ADD CONSTRAINT "PRACOWNICY_UZYTKOWNICY_FK1" FOREIGN KEY ("ID_FUNKCJI")
	  REFERENCES "C##WARSZTAT"."FUNKCJA" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PRZEGLADY
--------------------------------------------------------

  ALTER TABLE "C##WARSZTAT"."PRZEGLADY" ADD CONSTRAINT "PRZEGLADY_FK1" FOREIGN KEY ("ID_SAMOCHODU")
	  REFERENCES "C##WARSZTAT"."SAMOCHODY" ("ID") ENABLE;
  ALTER TABLE "C##WARSZTAT"."PRZEGLADY" ADD CONSTRAINT "PRZEGLADY_FK2" FOREIGN KEY ("ID_MECHANIKA")
	  REFERENCES "C##WARSZTAT"."PRACOWNICY" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SAMOCHODY
--------------------------------------------------------

  ALTER TABLE "C##WARSZTAT"."SAMOCHODY" ADD CONSTRAINT "SAMOCHODY_FK1" FOREIGN KEY ("ID_KLIENTA")
	  REFERENCES "C##WARSZTAT"."KLIENCI" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SAMOCHODY_USLUGI
--------------------------------------------------------

  ALTER TABLE "C##WARSZTAT"."SAMOCHODY_USLUGI" ADD CONSTRAINT "SAMOCHODY_USLUGI_FK2" FOREIGN KEY ("ID_USLUGI")
	  REFERENCES "C##WARSZTAT"."USLUGI" ("ID") ENABLE;
  ALTER TABLE "C##WARSZTAT"."SAMOCHODY_USLUGI" ADD CONSTRAINT "SAMOCHODY_USLUGI_FK3" FOREIGN KEY ("ID_MECHANIKA")
	  REFERENCES "C##WARSZTAT"."PRACOWNICY" ("ID") ENABLE;
  ALTER TABLE "C##WARSZTAT"."SAMOCHODY_USLUGI" ADD CONSTRAINT "SAMOCHODY_USLUGI_FK1" FOREIGN KEY ("ID_SAMOCHODU")
	  REFERENCES "C##WARSZTAT"."SAMOCHODY" ("ID") ENABLE;
