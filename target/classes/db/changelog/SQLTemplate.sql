/**
 * Author:  jsibona
 * Created: 10/08/2017
 */
/* PostgreSQL
CREATE TABLE COMPANY
(
   ID            SERIAL PRIMARY KEY,
   NAME          TEXT      NOT NULL,
   AGE           INT       NOT NULL,
   ADDRESS       CHAR(50),
   SALARY        REAL
);
*/
/*
CREATE TABLE "public".client 
(
    id          INTEGER NOT NULL PRIMARY KEY,
    name        VARCHAR(100) DEFAULT(''),
    lastName    VARCHAR(100) DEFAULT(''),
    address     VARCHAR(100) DEFAULT(''),
    phone       VARCHAR(100) DEFAULT(''),
    email       VARCHAR(100) DEFAULT('')
);
*/
CREATE TABLE "public".client 
(
    id          SERIAL NOT NULL PRIMARY KEY,
    name        VARCHAR(100) DEFAULT(''),
    lastName    VARCHAR(100) DEFAULT(''),
    address     VARCHAR(100) DEFAULT(''),
    phone       VARCHAR(100) DEFAULT(''),
    email       VARCHAR(100) DEFAULT('')
);


CREATE TABLE "public".product 
(
    id          SERIAL NOT NULL PRIMARY KEY,
    name        VARCHAR(100) DEFAULT(''),
    price       FLOAT,
    quantity    INT
);
