/**
 * Author:  jsibona
 * Created: 10/08/2017
SELECT * FROM "public".record LIMIT 100;
SELECT * FROM "public".databasechangelog LIMIT 100;
SELECT * FROM "public".databasechangeloglock LIMIT 100;
SELECT * FROM "public".client LIMIT 100;
SELECT * FROM "public".product LIMIT 100;
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
