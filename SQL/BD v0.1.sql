
ALTER TABLE `intemed`.`resultados` 
ADD COLUMN   `termoAnterior` varchar(45) DEFAULT NULL,
ADD COLUMN   `palavraAnterior` varchar(45) DEFAULT NULL,
ADD COLUMN   `termoPosterior` varchar(45) DEFAULT NULL,
ADD COLUMN   `palavraPosterior` varchar(45) DEFAULT NULL;;
