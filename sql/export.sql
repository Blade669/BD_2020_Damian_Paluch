--------------------------------------------------------
--  File created - wtorek-maja-12-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence DIAGNOZY_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##WARSZTAT"."DIAGNOZY_SEQ"  MINVALUE 1 MAXVALUE 2147483647 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence FUNKCJA_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##WARSZTAT"."FUNKCJA_SEQ"  MINVALUE 1 MAXVALUE 2147483647 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence KLIENCI_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##WARSZTAT"."KLIENCI_SEQ"  MINVALUE 1 MAXVALUE 2147483647 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence KLIENCI_UZYTKOWNICY_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##WARSZTAT"."KLIENCI_UZYTKOWNICY_SEQ"  MINVALUE 1 MAXVALUE 2147483647 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
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

   CREATE SEQUENCE  "C##WARSZTAT"."PRZEGLADY_SEQ"  MINVALUE 1 MAXVALUE 2147483647 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SAMOCHODY_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##WARSZTAT"."SAMOCHODY_SEQ"  MINVALUE 1 MAXVALUE 2147483647 INCREMENT BY 1 START WITH 81 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SAMOCHODY_USLUGI_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##WARSZTAT"."SAMOCHODY_USLUGI_SEQ"  MINVALUE 1 MAXVALUE 2147483647 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence USLUGI_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##WARSZTAT"."USLUGI_SEQ"  MINVALUE 1 MAXVALUE 2147483647 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
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
	"ID_FUKCJI" NUMBER
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
	"CZY_POZYTYWNY" NUMBER(1,0), 
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
Insert into C##WARSZTAT.DIAGNOZY (ID,ID_SAMOCHODU,UWAGI_KLIENTA,UWAGI_MECHANIKA,ID_MECHANIKA,DATA) values ('1','1','Na przegladzie stwierdzono uszkodzony amortyzator: lewy tylny do wymiany.',null,null,to_date('20/03/13','RR/MM/DD'));
REM INSERTING into C##WARSZTAT.FUNKCJA
SET DEFINE OFF;
Insert into C##WARSZTAT.FUNKCJA (ID,NAZWA) values ('1','Mechanik');
Insert into C##WARSZTAT.FUNKCJA (ID,NAZWA) values ('2','Administrator');
REM INSERTING into C##WARSZTAT.KLIENCI
SET DEFINE OFF;
Insert into C##WARSZTAT.KLIENCI (ID,IMIE,NAZWISKO,NR_TEL,ID_UZYTKOWNIKA) values ('1','Piotr','Szmul','795374658','1');
Insert into C##WARSZTAT.KLIENCI (ID,IMIE,NAZWISKO,NR_TEL,ID_UZYTKOWNIKA) values ('2','Karolina','Kasprzyk','675843946','2');
REM INSERTING into C##WARSZTAT.KLIENCI_UZYTKOWNICY
SET DEFINE OFF;
Insert into C##WARSZTAT.KLIENCI_UZYTKOWNICY (ID,LOGIN,HASLO) values ('1','klient','klient');
Insert into C##WARSZTAT.KLIENCI_UZYTKOWNICY (ID,LOGIN,HASLO) values ('2','klient2','klient2');
REM INSERTING into C##WARSZTAT.PRACOWNICY
SET DEFINE OFF;
Insert into C##WARSZTAT.PRACOWNICY (ID,IMIE,NAZWISKO,NR_TEL,ADRES,ID_UZYTKOWNIKA) values ('1','Wojciech','Skrzypek','756473846','Rzeszow Podwislocze 12','1');
Insert into C##WARSZTAT.PRACOWNICY (ID,IMIE,NAZWISKO,NR_TEL,ADRES,ID_UZYTKOWNIKA) values ('2','Karolina','Szpila','657483759','Lezajsk Rynek 4','2');
REM INSERTING into C##WARSZTAT.PRACOWNICY_UZYTKOWNICY
SET DEFINE OFF;
Insert into C##WARSZTAT.PRACOWNICY_UZYTKOWNICY (ID,LOGIN,HASLO,ID_FUKCJI) values ('1','mechanik','mechanik','1');
Insert into C##WARSZTAT.PRACOWNICY_UZYTKOWNICY (ID,LOGIN,HASLO,ID_FUKCJI) values ('2','administrator','administrator','2');
REM INSERTING into C##WARSZTAT.PRZEGLADY
SET DEFINE OFF;
Insert into C##WARSZTAT.PRZEGLADY (ID,ID_SAMOCHODU,DATA,DATA_WAZNOSCI,ID_MECHANIKA,CZY_POZYTYWNY,UWAGI) values ('1','2',to_date('20/05/02','RR/MM/DD'),to_date('21/05/06','RR/MM/DD'),'1','1',null);
Insert into C##WARSZTAT.PRZEGLADY (ID,ID_SAMOCHODU,DATA,DATA_WAZNOSCI,ID_MECHANIKA,CZY_POZYTYWNY,UWAGI) values ('2','1',to_date('20/01/18','RR/MM/DD'),null,'1','0','Wyciek z amortyzatora');
Insert into C##WARSZTAT.PRZEGLADY (ID,ID_SAMOCHODU,DATA,DATA_WAZNOSCI,ID_MECHANIKA,CZY_POZYTYWNY,UWAGI) values ('3','2',to_date('44/04/04','RR/MM/DD'),null,null,null,null);
Insert into C##WARSZTAT.PRZEGLADY (ID,ID_SAMOCHODU,DATA,DATA_WAZNOSCI,ID_MECHANIKA,CZY_POZYTYWNY,UWAGI) values ('4','24',to_date('20/05/22','RR/MM/DD'),null,null,null,null);
REM INSERTING into C##WARSZTAT.SAMOCHODY
SET DEFINE OFF;
Insert into C##WARSZTAT.SAMOCHODY (ID,MARKA,MODEL,POJ_SILNIKA,ROK,ID_KLIENTA) values ('1','LEXUS','IS 200','1988','1998','1');
Insert into C##WARSZTAT.SAMOCHODY (ID,MARKA,MODEL,POJ_SILNIKA,ROK,ID_KLIENTA) values ('2','DODGE','VIPER','6198','2012','1');
Insert into C##WARSZTAT.SAMOCHODY (ID,MARKA,MODEL,POJ_SILNIKA,ROK,ID_KLIENTA) values ('23','LEXUS','LFA','4679','2016','1');
Insert into C##WARSZTAT.SAMOCHODY (ID,MARKA,MODEL,POJ_SILNIKA,ROK,ID_KLIENTA) values ('24','LEXUS','GS 430','g','2000','1');
Insert into C##WARSZTAT.SAMOCHODY (ID,MARKA,MODEL,POJ_SILNIKA,ROK,ID_KLIENTA) values ('22','CHEVROLET','CORVETTE','5420','2010','2');
Insert into C##WARSZTAT.SAMOCHODY (ID,MARKA,MODEL,POJ_SILNIKA,ROK,ID_KLIENTA) values ('43','TOYOTA','SUPRA','2980','1997','2');
Insert into C##WARSZTAT.SAMOCHODY (ID,MARKA,MODEL,POJ_SILNIKA,ROK,ID_KLIENTA) values ('25','LEXUS','IS F','4600','2019','1');
REM INSERTING into C##WARSZTAT.SAMOCHODY_USLUGI
SET DEFINE OFF;
Insert into C##WARSZTAT.SAMOCHODY_USLUGI (ID,ID_USLUGI,ID_SAMOCHODU,ID_MECHANIKA,DATA) values ('2','2','1','1',to_date('20/05/01','RR/MM/DD'));
Insert into C##WARSZTAT.SAMOCHODY_USLUGI (ID,ID_USLUGI,ID_SAMOCHODU,ID_MECHANIKA,DATA) values ('1','1','1','1',to_date('20/05/05','RR/MM/DD'));
Insert into C##WARSZTAT.SAMOCHODY_USLUGI (ID,ID_USLUGI,ID_SAMOCHODU,ID_MECHANIKA,DATA) values ('3','2','2','1',to_date('20/04/24','RR/MM/DD'));
Insert into C##WARSZTAT.SAMOCHODY_USLUGI (ID,ID_USLUGI,ID_SAMOCHODU,ID_MECHANIKA,DATA) values ('13','1','25',null,to_date('17/05/20','RR/MM/DD'));
Insert into C##WARSZTAT.SAMOCHODY_USLUGI (ID,ID_USLUGI,ID_SAMOCHODU,ID_MECHANIKA,DATA) values ('14','1','2',null,to_date('04/05/13','RR/MM/DD'));
REM INSERTING into C##WARSZTAT.USLUGI
SET DEFINE OFF;
Insert into C##WARSZTAT.USLUGI (ID,NAZWA,OPIS) values ('1','Wymiana 2 opon','Usluga obejmuje zdjecie kol z jednej osi, wymiane opon i ponowne zalozenie.');
Insert into C##WARSZTAT.USLUGI (ID,NAZWA,OPIS) values ('2','Wymiana oleju','Usluga obejmuje wymiane oleju z filtrem oleju.');
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

END edytuj_dane;

/
--------------------------------------------------------
--  DDL for Package KLIENT_REJESTRACJA
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE "C##WARSZTAT"."KLIENT_REJESTRACJA" AS 

  PROCEDURE REJESTRUJ_KLIENTA(K_IMIE IN KLIENCI.IMIE%TYPE, K_NAZWISKO IN KLIENCI.NAZWISKO%TYPE,  
    K_NR_TEL IN KLIENCI.NR_TEL%TYPE, K_ID_UZYTKOWNIKA IN KLIENCI.ID_UZYTKOWNIKA%TYPE);

END KLIENT_REJESTRACJA;

/
--------------------------------------------------------
--  DDL for Package LOGOWANIE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE "C##WARSZTAT"."LOGOWANIE" AS
    PROCEDURE sprawdz_dane (
        k_login  IN  klienci_uzytkownicy.login%TYPE,
        k_haslo  IN  klienci_uzytkownicy.haslo%TYPE
    );


END logowanie;

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
            d_uwagi_klienta,
            to_char(d_data, 'YYYY-MM-DD')
        );

        NULL;
    END dodaj_diagnoze;

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
            samochody.marka = s_marka,
            samochody.model = s_model,
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
            klienci.imie = k_imie,
            klienci.nazwisko = k_nazwisko,
            klienci.nr_tel = k_nr_tel
        WHERE
            klienci.id = k_id;

        NULL;
    END edytuj_dane_klienta;

END edytuj_dane;

/
--------------------------------------------------------
--  DDL for Package Body KLIENT_REJESTRACJA
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE BODY "C##WARSZTAT"."KLIENT_REJESTRACJA" AS

  PROCEDURE REJESTRUJ_KLIENTA(K_IMIE IN KLIENCI.IMIE%TYPE, K_NAZWISKO IN KLIENCI.NAZWISKO%TYPE,  
    K_NR_TEL IN KLIENCI.NR_TEL%TYPE, K_ID_UZYTKOWNIKA IN KLIENCI.ID_UZYTKOWNIKA%TYPE) AS
  BEGIN
    INSERT INTO KLIENCI (IMIE,NAZWISKO,NR_TEL,ID_UZYTKOWNIKA) VALUES (UPPER(K_IMIE), UPPER(K_NAZWISKO), K_NR_TEL, K_ID_UZYTKOWNIKA);
    NULL;
  END REJESTRUJ_KLIENTA;

END KLIENT_REJESTRACJA;

/
--------------------------------------------------------
--  DDL for Package Body LOGOWANIE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE BODY "C##WARSZTAT"."LOGOWANIE" AS
    PROCEDURE sprawdz_dane (
        k_login  IN  klienci_uzytkownicy.login%TYPE,
        k_haslo  IN  klienci_uzytkownicy.haslo%TYPE
    ) AS
   zmienna varchar2(1);
    BEGIN
        SELECT '1'
            into zmienna

        FROM
            klienci_uzytkownicy
        WHERE
                login = k_login
            AND haslo = k_haslo;

    EXCEPTION
        WHEN no_data_found THEN
            raise_application_error(-20000, 'Bledne dane!');
    END sprawdz_dane;


END logowanie;

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
--  Constraints for Table PRACOWNICY_UZYTKOWNICY
--------------------------------------------------------

  ALTER TABLE "C##WARSZTAT"."PRACOWNICY_UZYTKOWNICY" MODIFY ("ID_FUKCJI" NOT NULL ENABLE);
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
  ALTER TABLE "C##WARSZTAT"."KLIENCI" MODIFY ("ID_UZYTKOWNIKA" NOT NULL ENABLE);
  ALTER TABLE "C##WARSZTAT"."KLIENCI" ADD CONSTRAINT "KLIENCI_UK1" UNIQUE ("ID_UZYTKOWNIKA")
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

  ALTER TABLE "C##WARSZTAT"."PRACOWNICY_UZYTKOWNICY" ADD CONSTRAINT "PRACOWNICY_UZYTKOWNICY_FK1" FOREIGN KEY ("ID_FUKCJI")
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
