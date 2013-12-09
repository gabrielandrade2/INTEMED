USE intemed;

ALTER TABLE `intemed`.`resultados` 
ADD COLUMN   `termoAnterior` varchar(45) DEFAULT NULL,
ADD COLUMN   `palavraAnterior` varchar(45) DEFAULT NULL,
ADD COLUMN   `termoPosterior` varchar(45) DEFAULT NULL,
ADD COLUMN   `palavraPosterior` varchar(45) DEFAULT NULL;

ALTER TABLE `intemed`.`subregras` 
ADD COLUMN `positivaNegativaNeutra` INT NULL AFTER `texto`;

ALTER TABLE `intemed`.`subregras` 
ADD COLUMN `distanciaRegra` INT(11) NULL AFTER `positivaNegativaNeutra`;

ALTER TABLE `intemed`.`termosregras` 
ADD COLUMN `classifMorfolPalavraRaiz` INT(11) NULL AFTER `termo`;

ALTER TABLE `intemed`.`termossubregras` 
ADD COLUMN `classifMorfolPalavraRaiz` INT(11) NULL AFTER `termo`;
