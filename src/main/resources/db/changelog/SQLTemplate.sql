/**
 * Author:  jsibona
 * Created: 10/08/2017
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
