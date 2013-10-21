 insert into intemed.textosRapidM (texto) select
replace(replace(replace(replace(replace(
replace(replace(replace(replace(replace(
replace(replace(replace(replace(replace(
replace(replace(replace(replace(replace(
replace(replace(replace(replace(replace(
replace(replace(replace(replace(replace(
replace(replace(replace(replace(replace(
replace(replace(replace(replace(replace(
replace(replace(replace(replace(replace(
replace(replace(replace(replace(replace(
replace(replace(replace(replace(replace(
lower(texto),"á","a"),"ç","c"),"õ","o"),"à",""),"ã","a"), 
      "â","a"),"ó","o"),"ô","o"),"í","i"),"ú","u"), 
      " com "," ")," a "," ")," em "," ")," os "," ")," as "," "), 
      " o "," ")," a "," ")," e "," ")," outra "," ")," é "," "), 
      " este "," ")," seu "," ")," ao "," "),"("," "),")"," "), 
      " notando-se "," ")," causando "," ")," sobre "," ")," cerca "," ")," apos "," "), 
      " dentro "," ")," nota-se "," ")," imagens "," ")," sugestivas "," ")," ou "," "), 
      "."," ")," observa-se "," ")," observa se "," ")," notando-se "," ")," notando se "," "), 
      " por "," ")," se "," ")," que "," ")," nota se "," ")," notando se "," "), 
      "."," ")," observa-se "," ")," observa se "," ")," notando-se "," ")," notando se "," "), 
      "é","e"),"ü","u")," vista "," ")," de "," "),"ê","e") 

FROM intemed.textosRapidMiner;