/*
 Navicat Premium Data Transfer

 Source Server         : 10th-KSHRD-Registration
 Source Server Type    : PostgreSQL
 Source Server Version : 140003
 Source Host           : localhost:5432
 Source Catalog        : 10th-kshrd-registration
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 140003
 File Encoding         : 65001

 Date: 23/06/2022 18:18:54
*/


-- ----------------------------
-- Sequence structure for app_user_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."app_user_id_seq";
CREATE SEQUENCE "public"."app_user_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."app_user_id_seq" OWNER TO "postgres";

-- ----------------------------
-- Sequence structure for app_user_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."app_user_id_seq1";
CREATE SEQUENCE "public"."app_user_id_seq1" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."app_user_id_seq1" OWNER TO "postgres";

-- ----------------------------
-- Sequence structure for education_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."education_id_seq";
CREATE SEQUENCE "public"."education_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."education_id_seq" OWNER TO "postgres";

-- ----------------------------
-- Sequence structure for education_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."education_id_seq1";
CREATE SEQUENCE "public"."education_id_seq1" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."education_id_seq1" OWNER TO "postgres";

-- ----------------------------
-- Sequence structure for exam_result_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."exam_result_id_seq";
CREATE SEQUENCE "public"."exam_result_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."exam_result_id_seq" OWNER TO "postgres";

-- ----------------------------
-- Sequence structure for exam_result_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."exam_result_id_seq1";
CREATE SEQUENCE "public"."exam_result_id_seq1" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."exam_result_id_seq1" OWNER TO "postgres";

-- ----------------------------
-- Sequence structure for generation_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."generation_id_seq";
CREATE SEQUENCE "public"."generation_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."generation_id_seq" OWNER TO "postgres";

-- ----------------------------
-- Sequence structure for generation_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."generation_id_seq1";
CREATE SEQUENCE "public"."generation_id_seq1" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."generation_id_seq1" OWNER TO "postgres";

-- ----------------------------
-- Sequence structure for information_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."information_id_seq";
CREATE SEQUENCE "public"."information_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."information_id_seq" OWNER TO "postgres";

-- ----------------------------
-- Sequence structure for information_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."information_id_seq1";
CREATE SEQUENCE "public"."information_id_seq1" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."information_id_seq1" OWNER TO "postgres";

-- ----------------------------
-- Sequence structure for province_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."province_id_seq";
CREATE SEQUENCE "public"."province_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."province_id_seq" OWNER TO "postgres";

-- ----------------------------
-- Sequence structure for province_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."province_id_seq1";
CREATE SEQUENCE "public"."province_id_seq1" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."province_id_seq1" OWNER TO "postgres";

-- ----------------------------
-- Sequence structure for relative_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."relative_id_seq";
CREATE SEQUENCE "public"."relative_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."relative_id_seq" OWNER TO "postgres";

-- ----------------------------
-- Sequence structure for relative_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."relative_id_seq1";
CREATE SEQUENCE "public"."relative_id_seq1" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."relative_id_seq1" OWNER TO "postgres";

-- ----------------------------
-- Sequence structure for role_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."role_id_seq";
CREATE SEQUENCE "public"."role_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."role_id_seq" OWNER TO "postgres";

-- ----------------------------
-- Sequence structure for role_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."role_id_seq1";
CREATE SEQUENCE "public"."role_id_seq1" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."role_id_seq1" OWNER TO "postgres";

-- ----------------------------
-- Sequence structure for university_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."university_id_seq";
CREATE SEQUENCE "public"."university_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."university_id_seq" OWNER TO "postgres";

-- ----------------------------
-- Sequence structure for university_id_seq1
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."university_id_seq1";
CREATE SEQUENCE "public"."university_id_seq1" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."university_id_seq1" OWNER TO "postgres";

-- ----------------------------
-- Table structure for app_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."app_user";
CREATE TABLE "public"."app_user" (
  "id" int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1
),
  "fullname" varchar(255) COLLATE "pg_catalog"."default",
  "email" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "password" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "national_card" varchar(255) COLLATE "pg_catalog"."default",
  "pob_id" int4,
  "phone" varchar(255) COLLATE "pg_catalog"."default",
  "emergency_phone" varchar(255) COLLATE "pg_catalog"."default",
  "education_id" int4,
  "gender" varchar(255) COLLATE "pg_catalog"."default",
  "dob" timestamp(6),
  "address_id" int4,
  "relative_id" int4,
  "university_id" int4,
  "reference_url" varchar(255) COLLATE "pg_catalog"."default",
  "create_date" timestamp(6) DEFAULT now(),
  "status" bool DEFAULT false,
  "photo_url" varchar(255) COLLATE "pg_catalog"."default",
  "generation_id" int4,
  "token" varchar(255) COLLATE "pg_catalog"."default",
  "is_donated" bool DEFAULT false
)
;
ALTER TABLE "public"."app_user" OWNER TO "postgres";

-- ----------------------------
-- Records of app_user
-- ----------------------------
BEGIN;
INSERT INTO "public"."app_user" ("id", "fullname", "email", "password", "national_card", "pob_id", "phone", "emergency_phone", "education_id", "gender", "dob", "address_id", "relative_id", "university_id", "reference_url", "create_date", "status", "photo_url", "generation_id", "token", "is_donated") VALUES (1, NULL, 'bravo@gmail.com', '$2a$10$mPz6.Nyg/tooOvmzumWux.71csP00qtgvOhvdYJMpLxelyRlvsd72', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-06-14 13:01:17.549564', 'f', NULL, NULL, 'c84faffc-6e90-49dd-bb76-a0f01c9527d7', 'f');
INSERT INTO "public"."app_user" ("id", "fullname", "email", "password", "national_card", "pob_id", "phone", "emergency_phone", "education_id", "gender", "dob", "address_id", "relative_id", "university_id", "reference_url", "create_date", "status", "photo_url", "generation_id", "token", "is_donated") VALUES (3, NULL, 'seng@gmail.com', '$2a$10$JMSx5IOgQmSu9mBMFhy44OT5MSB.wyHTTSRyevgwmrU9oaTRKMfv.', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-06-14 19:42:37.177746', 'f', NULL, NULL, '3f631085-abed-4741-ac34-dd2c7f90269a', 'f');
INSERT INTO "public"."app_user" ("id", "fullname", "email", "password", "national_card", "pob_id", "phone", "emergency_phone", "education_id", "gender", "dob", "address_id", "relative_id", "university_id", "reference_url", "create_date", "status", "photo_url", "generation_id", "token", "is_donated") VALUES (4, NULL, 'admin@gmail.com', '$2a$10$h3DTDlxXYl3m8kqCCONmdOCg1yBIURmapU8LmKZshXY283IOFzCJC', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-06-14 23:41:49.26335', 'f', NULL, NULL, 'b3dc850c-acc8-4557-988c-00eaede34665', 'f');
INSERT INTO "public"."app_user" ("id", "fullname", "email", "password", "national_card", "pob_id", "phone", "emergency_phone", "education_id", "gender", "dob", "address_id", "relative_id", "university_id", "reference_url", "create_date", "status", "photo_url", "generation_id", "token", "is_donated") VALUES (2, 'Leang Seng', 'leangsengk90@gmail.com', '$2a$10$GDMV55cIe9H88Ba7yvyeme7Ndt35eRffFOLmzVMHUAXJ7woRjhbfK', '3333', 1, '968693877', '968693877', 1, 'FEMALE', '2022-06-04 10:42:50', 1, 1, 1, 'http://localhost:8080/images/767da3d0-f66e-4e7b-a8be-5c64b8270066.jpeg', '2022-06-21 10:44:16.149', 't', 'http://localhost:8080/images/c828b8d9-729b-4912-b265-d4958db66b74.jpg', 1, 'a4a6fb16-c860-4918-af08-3aa8d7314efe', 'f');
INSERT INTO "public"."app_user" ("id", "fullname", "email", "password", "national_card", "pob_id", "phone", "emergency_phone", "education_id", "gender", "dob", "address_id", "relative_id", "university_id", "reference_url", "create_date", "status", "photo_url", "generation_id", "token", "is_donated") VALUES (5, NULL, 'leang@gmail.com', '$2a$10$m.dFnS0M18m634jkpOox2O.Li4Dke7sOb6jHo5CkRIv6qrO9nx/ZW', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-06-20 10:57:53.734877', 'f', NULL, NULL, '246d9008-d9dd-4ba6-a1b1-32590d882b59', 'f');
COMMIT;

-- ----------------------------
-- Table structure for education
-- ----------------------------
DROP TABLE IF EXISTS "public"."education";
CREATE TABLE "public"."education" (
  "id" int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1
),
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "status" bool DEFAULT true
)
;
ALTER TABLE "public"."education" OWNER TO "postgres";

-- ----------------------------
-- Records of education
-- ----------------------------
BEGIN;
INSERT INTO "public"."education" ("id", "description", "status") VALUES (1, 'YEAR 3 SEMESTER 1', 't');
INSERT INTO "public"."education" ("id", "description", "status") VALUES (2, 'YEAR 3 SEMESTER 2', 't');
INSERT INTO "public"."education" ("id", "description", "status") VALUES (3, 'YEAR 4 SEMESTER 1', 't');
INSERT INTO "public"."education" ("id", "description", "status") VALUES (4, 'YEAR 4 SEMESTER 2', 't');
INSERT INTO "public"."education" ("id", "description", "status") VALUES (5, 'GRADUATED', 't');
COMMIT;

-- ----------------------------
-- Table structure for exam_result
-- ----------------------------
DROP TABLE IF EXISTS "public"."exam_result";
CREATE TABLE "public"."exam_result" (
  "id" int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1
),
  "title" varchar(255) COLLATE "pg_catalog"."default",
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "create_date" timestamp(6) DEFAULT now(),
  "result_url" varchar[] COLLATE "pg_catalog"."default",
  "status" bool DEFAULT true,
  "generation_id" int4,
  "user_id" int4
)
;
ALTER TABLE "public"."exam_result" OWNER TO "postgres";

-- ----------------------------
-- Records of exam_result
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for generation
-- ----------------------------
DROP TABLE IF EXISTS "public"."generation";
CREATE TABLE "public"."generation" (
  "id" int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1
),
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "status" bool DEFAULT false,
  "start_date" timestamp(6),
  "end_date" timestamp(6),
  "delay_day" int4 DEFAULT 0,
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "exam_url" varchar[] COLLATE "pg_catalog"."default",
  "timeline_url" varchar(255) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."generation" OWNER TO "postgres";

-- ----------------------------
-- Records of generation
-- ----------------------------
BEGIN;
INSERT INTO "public"."generation" ("id", "name", "status", "start_date", "end_date", "delay_day", "description", "exam_url", "timeline_url") VALUES (1, '11', 'f', NULL, NULL, 0, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for information
-- ----------------------------
DROP TABLE IF EXISTS "public"."information";
CREATE TABLE "public"."information" (
  "id" int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1
),
  "title" varchar(255) COLLATE "pg_catalog"."default",
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "post_url" varchar[] COLLATE "pg_catalog"."default",
  "create_date" timestamp(6) DEFAULT now(),
  "status" bool DEFAULT true,
  "user_id" int4,
  "generation_id" int4
)
;
ALTER TABLE "public"."information" OWNER TO "postgres";

-- ----------------------------
-- Records of information
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS "public"."province";
CREATE TABLE "public"."province" (
  "id" int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1
),
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "status" bool DEFAULT true
)
;
ALTER TABLE "public"."province" OWNER TO "postgres";

-- ----------------------------
-- Records of province
-- ----------------------------
BEGIN;
INSERT INTO "public"."province" ("id", "name", "status") VALUES (1, 'PHNOM PENH', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (2, 'KAMPONG CHAM', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (3, 'SIEM REAP', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (4, 'BANTEAY MEANCHEY', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (5, 'BATTAMBANG', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (6, 'KAMPONG CHHNANG', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (7, 'KAMPONG SPEU', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (8, 'KAMPONG THOM', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (9, 'KAMPOT', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (10, 'KANDAL', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (11, 'KOH KONG', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (12, 'KEP', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (13, 'KRATIE', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (14, 'MONDULKIRI', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (15, 'ODDAR MEANCHEY', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (16, 'PAILIN', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (17, 'PREAH SIHANOUK', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (18, 'PREAH VIHEAR', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (19, 'PURSAT', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (20, 'PREY VENG', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (21, 'RATANAKIRI', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (22, 'STUNG TRENG', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (23, 'SVAY RIENG', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (24, 'TAKEO', 't');
INSERT INTO "public"."province" ("id", "name", "status") VALUES (25, 'TBOUNG KHMUM', 't');
COMMIT;

-- ----------------------------
-- Table structure for relative
-- ----------------------------
DROP TABLE IF EXISTS "public"."relative";
CREATE TABLE "public"."relative" (
  "id" int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1
),
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "status" bool DEFAULT true
)
;
ALTER TABLE "public"."relative" OWNER TO "postgres";

-- ----------------------------
-- Records of relative
-- ----------------------------
BEGIN;
INSERT INTO "public"."relative" ("id", "description", "status") VALUES (1, 'MOTHER', 't');
INSERT INTO "public"."relative" ("id", "description", "status") VALUES (2, 'FATHER', 't');
INSERT INTO "public"."relative" ("id", "description", "status") VALUES (3, 'BROTHER', 't');
INSERT INTO "public"."relative" ("id", "description", "status") VALUES (4, 'SISTER', 't');
INSERT INTO "public"."relative" ("id", "description", "status") VALUES (5, 'UNCLE', 't');
INSERT INTO "public"."relative" ("id", "description", "status") VALUES (6, 'AUNT', 't');
INSERT INTO "public"."relative" ("id", "description", "status") VALUES (7, 'OTHER', 't');
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS "public"."role";
CREATE TABLE "public"."role" (
  "id" int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1
),
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "status" bool DEFAULT true
)
;
ALTER TABLE "public"."role" OWNER TO "postgres";

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO "public"."role" ("id", "name", "status") VALUES (1, 'ADMIN', 't');
INSERT INTO "public"."role" ("id", "name", "status") VALUES (2, 'USER', 't');
COMMIT;

-- ----------------------------
-- Table structure for university
-- ----------------------------
DROP TABLE IF EXISTS "public"."university";
CREATE TABLE "public"."university" (
  "id" int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1
),
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "status" bool DEFAULT true,
  "abbreviation" varchar(255) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."university" OWNER TO "postgres";

-- ----------------------------
-- Records of university
-- ----------------------------
BEGIN;
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (1, NULL, 't', 'RUPP');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (2, NULL, 't', 'SETEC');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (3, NULL, 't', 'BBU');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (4, NULL, 't', 'PUC');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (5, NULL, 't', 'PPIU');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (6, NULL, 't', 'NU');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (7, NULL, 't', 'UBB');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (8, NULL, 't', 'AEU');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (9, NULL, 't', 'UME');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (10, NULL, 't', 'RAC');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (11, NULL, 't', 'CARDI');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (12, NULL, 't', 'ITC');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (13, NULL, 't', 'CSUK');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (14, NULL, 't', 'NIE');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (15, NULL, 't', 'NTTI');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (16, NULL, 't', 'PNCA');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (17, NULL, 't', 'RUA');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (18, NULL, 't', 'RUFA');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (19, NULL, 't', 'RULE');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (20, NULL, 't', 'SRU');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (21, NULL, 't', 'UHS');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (22, NULL, 't', 'IIC');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (23, NULL, 't', 'UC');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (24, NULL, 't', 'UP');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (25, NULL, 't', 'PPIT');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (26, NULL, 't', 'CamEd');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (27, NULL, 't', 'SPI');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (28, NULL, 't', 'BELTEI');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (29, NULL, 't', 'CMU');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (30, NULL, 't', 'AUPP');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (31, NULL, 't', 'ZAMAN');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (32, NULL, 't', 'CUS');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (33, NULL, 't', 'NUM');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (34, NULL, 't', 'PCU');
INSERT INTO "public"."university" ("id", "name", "status", "abbreviation") VALUES (35, NULL, 't', 'OTHER');
COMMIT;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_role";
CREATE TABLE "public"."user_role" (
  "user_id" int4 NOT NULL,
  "role_id" int4 NOT NULL
)
;
ALTER TABLE "public"."user_role" OWNER TO "postgres";

-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN;
INSERT INTO "public"."user_role" ("user_id", "role_id") VALUES (1, 2);
INSERT INTO "public"."user_role" ("user_id", "role_id") VALUES (2, 2);
INSERT INTO "public"."user_role" ("user_id", "role_id") VALUES (3, 2);
INSERT INTO "public"."user_role" ("user_id", "role_id") VALUES (4, 2);
INSERT INTO "public"."user_role" ("user_id", "role_id") VALUES (5, 2);
INSERT INTO "public"."user_role" ("user_id", "role_id") VALUES (2, 1);
COMMIT;

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."app_user_id_seq"
OWNED BY "public"."app_user"."id";
SELECT setval('"public"."app_user_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."app_user_id_seq1"
OWNED BY "public"."app_user"."id";
SELECT setval('"public"."app_user_id_seq1"', 5, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."education_id_seq"
OWNED BY "public"."education"."id";
SELECT setval('"public"."education_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."education_id_seq1"
OWNED BY "public"."education"."id";
SELECT setval('"public"."education_id_seq1"', 5, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."exam_result_id_seq"
OWNED BY "public"."exam_result"."id";
SELECT setval('"public"."exam_result_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."exam_result_id_seq1"
OWNED BY "public"."exam_result"."id";
SELECT setval('"public"."exam_result_id_seq1"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."generation_id_seq"
OWNED BY "public"."generation"."id";
SELECT setval('"public"."generation_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."generation_id_seq1"
OWNED BY "public"."generation"."id";
SELECT setval('"public"."generation_id_seq1"', 1, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."information_id_seq"
OWNED BY "public"."information"."id";
SELECT setval('"public"."information_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."information_id_seq1"
OWNED BY "public"."information"."id";
SELECT setval('"public"."information_id_seq1"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."province_id_seq"
OWNED BY "public"."province"."id";
SELECT setval('"public"."province_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."province_id_seq1"
OWNED BY "public"."province"."id";
SELECT setval('"public"."province_id_seq1"', 25, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."relative_id_seq"
OWNED BY "public"."relative"."id";
SELECT setval('"public"."relative_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."relative_id_seq1"
OWNED BY "public"."relative"."id";
SELECT setval('"public"."relative_id_seq1"', 7, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."role_id_seq"
OWNED BY "public"."role"."id";
SELECT setval('"public"."role_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."role_id_seq1"
OWNED BY "public"."role"."id";
SELECT setval('"public"."role_id_seq1"', 2, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."university_id_seq"
OWNED BY "public"."university"."id";
SELECT setval('"public"."university_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."university_id_seq1"
OWNED BY "public"."university"."id";
SELECT setval('"public"."university_id_seq1"', 35, true);

-- ----------------------------
-- Auto increment value for app_user
-- ----------------------------
SELECT setval('"public"."app_user_id_seq1"', 5, true);

-- ----------------------------
-- Uniques structure for table app_user
-- ----------------------------
ALTER TABLE "public"."app_user" ADD CONSTRAINT "email_unique" UNIQUE ("email");

-- ----------------------------
-- Primary Key structure for table app_user
-- ----------------------------
ALTER TABLE "public"."app_user" ADD CONSTRAINT "app_user_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Auto increment value for education
-- ----------------------------
SELECT setval('"public"."education_id_seq1"', 5, true);

-- ----------------------------
-- Primary Key structure for table education
-- ----------------------------
ALTER TABLE "public"."education" ADD CONSTRAINT "description_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Auto increment value for exam_result
-- ----------------------------
SELECT setval('"public"."exam_result_id_seq1"', 1, false);

-- ----------------------------
-- Primary Key structure for table exam_result
-- ----------------------------
ALTER TABLE "public"."exam_result" ADD CONSTRAINT "exam_result_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Auto increment value for generation
-- ----------------------------
SELECT setval('"public"."generation_id_seq1"', 1, true);

-- ----------------------------
-- Primary Key structure for table generation
-- ----------------------------
ALTER TABLE "public"."generation" ADD CONSTRAINT "generation_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Auto increment value for information
-- ----------------------------
SELECT setval('"public"."information_id_seq1"', 1, false);

-- ----------------------------
-- Primary Key structure for table information
-- ----------------------------
ALTER TABLE "public"."information" ADD CONSTRAINT "information_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Auto increment value for province
-- ----------------------------
SELECT setval('"public"."province_id_seq1"', 25, true);

-- ----------------------------
-- Primary Key structure for table province
-- ----------------------------
ALTER TABLE "public"."province" ADD CONSTRAINT "province_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Auto increment value for relative
-- ----------------------------
SELECT setval('"public"."relative_id_seq1"', 7, true);

-- ----------------------------
-- Primary Key structure for table relative
-- ----------------------------
ALTER TABLE "public"."relative" ADD CONSTRAINT "relative_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Auto increment value for role
-- ----------------------------
SELECT setval('"public"."role_id_seq1"', 2, true);

-- ----------------------------
-- Primary Key structure for table role
-- ----------------------------
ALTER TABLE "public"."role" ADD CONSTRAINT "role_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Auto increment value for university
-- ----------------------------
SELECT setval('"public"."university_id_seq1"', 35, true);

-- ----------------------------
-- Primary Key structure for table university
-- ----------------------------
ALTER TABLE "public"."university" ADD CONSTRAINT "university_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table user_role
-- ----------------------------
ALTER TABLE "public"."user_role" ADD CONSTRAINT "user_role_pkey" PRIMARY KEY ("user_id", "role_id");

-- ----------------------------
-- Foreign Keys structure for table app_user
-- ----------------------------
ALTER TABLE "public"."app_user" ADD CONSTRAINT "address_user_fk" FOREIGN KEY ("address_id") REFERENCES "public"."province" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "public"."app_user" ADD CONSTRAINT "education_user_fk" FOREIGN KEY ("education_id") REFERENCES "public"."education" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "public"."app_user" ADD CONSTRAINT "generation_user_fk" FOREIGN KEY ("generation_id") REFERENCES "public"."generation" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "public"."app_user" ADD CONSTRAINT "pob_user_fk" FOREIGN KEY ("pob_id") REFERENCES "public"."province" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "public"."app_user" ADD CONSTRAINT "relatiive_user_fk" FOREIGN KEY ("relative_id") REFERENCES "public"."relative" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "public"."app_user" ADD CONSTRAINT "university_user_fk" FOREIGN KEY ("university_id") REFERENCES "public"."university" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table exam_result
-- ----------------------------
ALTER TABLE "public"."exam_result" ADD CONSTRAINT "result_gen_fk" FOREIGN KEY ("generation_id") REFERENCES "public"."generation" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "public"."exam_result" ADD CONSTRAINT "result_user_fk" FOREIGN KEY ("user_id") REFERENCES "public"."app_user" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table information
-- ----------------------------
ALTER TABLE "public"."information" ADD CONSTRAINT "gen_info_fk" FOREIGN KEY ("generation_id") REFERENCES "public"."generation" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "public"."information" ADD CONSTRAINT "user_info_fk" FOREIGN KEY ("user_id") REFERENCES "public"."app_user" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table user_role
-- ----------------------------
ALTER TABLE "public"."user_role" ADD CONSTRAINT "role_fk" FOREIGN KEY ("role_id") REFERENCES "public"."role" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "public"."user_role" ADD CONSTRAINT "user_fk" FOREIGN KEY ("user_id") REFERENCES "public"."app_user" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
