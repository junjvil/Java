CREATE DATABASE bd_java_con1;
USE bd_java_con1;

CREATE TABLE tbl_pais(
	id_pais INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nombre_pais VARCHAR(35) NOT NULL,
	capital_pais VARCHAR(35) NOT NULL,
	poblacion_pais BIGINT
);
SELECT * FROM tbl_pais;

INSERT INTO	tbl_pais VALUES(NULL,'Antigua y Barbuda','Antigua y Barbuda',94731);
INSERT INTO	tbl_pais VALUES(NULL,'Estados Unidos','Washington D. C.',326625791);
INSERT INTO	tbl_pais VALUES(NULL,'Ecuador','Quito',16290913);
INSERT INTO	tbl_pais VALUES(NULL,'Guatemala','Guatemala',15125000);



UPDATE tbl_pais
SET nombre_pais='Argentina', capital_pais='Buenos Aires',poblacion_pais=0
WHERE id_pais=9;

DELETE FROM	tbl_pais WHERE	id_pais=1;

DROP DATABASE bd_java_con1;


