use intemed;
alter table resultados add column isFalsoNegativo boolean;
update resultados set isFalsoNegativo=0;