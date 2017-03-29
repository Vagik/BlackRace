DROP TABLE "SYSTEM"."GAME_USERS";

CREATE TABLE "SYSTEM"."GAME_USERS"
   (	"USER_ID" NUMBER NOT NULL ENABLE, 
	"USER_NAME" VARCHAR2(30 BYTE) NOT NULL ENABLE, 
	"USER_PASSWORD" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"USER_SCORE" NUMBER DEFAULT 0, 
	 CONSTRAINT "GAME_USERS_PK" PRIMARY KEY ("USER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
