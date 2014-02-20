use intemed;

alter table resultados add column posInicial INT;
alter table resultados add column posFinal INT;
ALTER TABLE `intemed`.`resultados` CHANGE COLUMN `isSubregra` `isSubregra` TINYINT(1) NULL DEFAULT 0  , CHANGE COLUMN `isEncontrado` `isEncontrado` INT(11) NULL DEFAULT 0  , CHANGE COLUMN `isFalsoNegativo` `isFalsoNegativo` INT(11) NULL DEFAULT 0  , CHANGE COLUMN `posInicial` `posInicial` INT(11) NULL DEFAULT -1  , CHANGE COLUMN `posFinal` `posFinal` INT(11) NULL DEFAULT -1  ;
ALTER TABLE `intemed`.`elementos` ADD COLUMN `corElemento` VARCHAR(20) NULL DEFAULT 'black'  AFTER `descricaoElemento` ;

