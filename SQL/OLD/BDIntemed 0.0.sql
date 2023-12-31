SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `intemed` DEFAULT CHARACTER SET utf8 ;
USE `intemed` ;

-- -----------------------------------------------------
-- Table `intemed`.`acronimos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `intemed`.`acronimos` ;

CREATE TABLE IF NOT EXISTS `intemed`.`acronimos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `acronimo` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NULL DEFAULT NULL,
  `expansao` VARCHAR(1000) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `acronimo` (`acronimo` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 785
DEFAULT CHARACTER SET = utf8;


Insert into acronimos(acronimo,expansao) values(" AAS "," ácido acetil salicílico ");
Insert into acronimos(acronimo,expansao) values(" ACTP "," angioplastia coronária transluminal percutânea ");
Insert into acronimos(acronimo,expansao) values(" HCPA "," Hospital de Clínicas de Porto Alegre ");
Insert into acronimos(acronimo,expansao) values(" HAS "," hipertensão arterial sistêmica ");
Insert into acronimos(acronimo,expansao) values(" VO "," via oral ");
Insert into acronimos(acronimo,expansao) values(" ICC "," insuficiência cardíaca congestiva ");
Insert into acronimos(acronimo,expansao) values(" FE "," fração de ejeção ");
Insert into acronimos(acronimo,expansao) values(" ECG "," eletrocardiograma ");
Insert into acronimos(acronimo,expansao) values(" VE "," ventrículo esquerdo ");
Insert into acronimos(acronimo,expansao) values(" IAM "," infarto agudo do miocárdio ");
Insert into acronimos(acronimo,expansao) values(" CD "," coronária direita ");
Insert into acronimos(acronimo,expansao) values(" DAE "," dimensão do átrio esquerdo ");
Insert into acronimos(acronimo,expansao) values(" DA "," artéria descendente anterior ");
Insert into acronimos(acronimo,expansao) values(" TC "," tomografia computadorizada ");
Insert into acronimos(acronimo,expansao) values(" CAT "," avaliação crítica tópica ");
Insert into acronimos(acronimo,expansao) values(" mg/d "," miligrama/decilitro ");
Insert into acronimos(acronimo,expansao) values(" CTI "," Centro de Terapia Intensiva ");
Insert into acronimos(acronimo,expansao) values(" DM "," diabetes melitus ");
Insert into acronimos(acronimo,expansao) values(" CRM "," cardio-ressonância magnética ");
Insert into acronimos(acronimo,expansao) values(" AE "," átrio esquerdo ");
Insert into acronimos(acronimo,expansao) values(" RN "," recém-nato ");
Insert into acronimos(acronimo,expansao) values(" STENT "," stent ");
Insert into acronimos(acronimo,expansao) values(" IG "," imunoglobulina ");
Insert into acronimos(acronimo,expansao) values(" IRC "," insuficiência renal crônica ");
Insert into acronimos(acronimo,expansao) values(" TIMI "," medida do fluxo coronário e microvascular ");
Insert into acronimos(acronimo,expansao) values(" APGAR "," Apgar ");
Insert into acronimos(acronimo,expansao) values(" NR "," não-reagente ");
Insert into acronimos(acronimo,expansao) values(" AVC "," acidente vascular cerebral ");
Insert into acronimos(acronimo,expansao) values(" ACD "," artéria coronária direita ");
Insert into acronimos(acronimo,expansao) values(" CX "," artéria circunflexa ");
Insert into acronimos(acronimo,expansao) values(" RX "," raio X ");
Insert into acronimos(acronimo,expansao) values(" DPOC "," doença pulmonar obstrutiva crônica ");
Insert into acronimos(acronimo,expansao) values(" PSAP "," pressão sistólica da artéria pulmonar ");
Insert into acronimos(acronimo,expansao) values(" PCR "," parada cárdio-respiratória ");
Insert into acronimos(acronimo,expansao) values(" ECO "," ecocardiograma ");
Insert into acronimos(acronimo,expansao) values(" VD "," ventrículo direito ");
Insert into acronimos(acronimo,expansao) values(" IC "," insuficiência cardíaca ");
Insert into acronimos(acronimo,expansao) values(" EV "," endovenosa ");
Insert into acronimos(acronimo,expansao) values(" O2 "," oxigênio ");
Insert into acronimos(acronimo,expansao) values(" FC "," função cardíaca ");
Insert into acronimos(acronimo,expansao) values(" NPH "," protamina neutra Hagedorn ");
Insert into acronimos(acronimo,expansao) values(" HCTZ "," hidroclortiazida ");
Insert into acronimos(acronimo,expansao) values(" FO "," ferida operatória ");
Insert into acronimos(acronimo,expansao) values(" INR "," razão normalizada internacional ");
Insert into acronimos(acronimo,expansao) values(" BID "," duas vezes ao dia ");
Insert into acronimos(acronimo,expansao) values(" PA "," pressão arterial ");
Insert into acronimos(acronimo,expansao) values(" SCA "," síndrome coronariana aguda ");
Insert into acronimos(acronimo,expansao) values(" VDRL "," laboratório de pesquisa de doenças venéreas ");
Insert into acronimos(acronimo,expansao) values(" ADA "," artéria descendente anterior ");
Insert into acronimos(acronimo,expansao) values(" ACFA "," fibrilação atrial crônica ");
Insert into acronimos(acronimo,expansao) values(" SL "," sublingual ");
Insert into acronimos(acronimo,expansao) values(" CI "," cardiopatia isquêmica ");
Insert into acronimos(acronimo,expansao) values(" MP "," marca-passo ");
Insert into acronimos(acronimo,expansao) values(" ITU "," infecção do trato urinário ");
Insert into acronimos(acronimo,expansao) values(" BCP "," broncopneumonia ");
Insert into acronimos(acronimo,expansao) values(" DM2 "," diabetes melitus tipo 2 ");
Insert into acronimos(acronimo,expansao) values(" UI "," unidades internacionais ");
Insert into acronimos(acronimo,expansao) values(" ATB "," antibiótico ");
Insert into acronimos(acronimo,expansao) values(" TS "," tipo sangüíneo ");
Insert into acronimos(acronimo,expansao) values(" TID "," dilatação isquêmica transitória ");
Insert into acronimos(acronimo,expansao) values(" FA "," fibrilação atrial ");
Insert into acronimos(acronimo,expansao) values(" TCE "," tronco de coronária esquerda ");
Insert into acronimos(acronimo,expansao) values(" II "," 2 ");
Insert into acronimos(acronimo,expansao) values(" IM "," insuficiência mitral ");
Insert into acronimos(acronimo,expansao) values(" PS "," pronto socorro ");
Insert into acronimos(acronimo,expansao) values(" HIV "," vírus da imunodeficiência humana ");
Insert into acronimos(acronimo,expansao) values(" mmHg "," milímetro de mercúrio ");
Insert into acronimos(acronimo,expansao) values(" HCV "," vírus da hepatite C ");
Insert into acronimos(acronimo,expansao) values(" AP "," ausculta pulmonar ");
Insert into acronimos(acronimo,expansao) values(" IgG "," imunoglobulina G ");
Insert into acronimos(acronimo,expansao) values(" MIE "," membro inferior esquerdo ");
Insert into acronimos(acronimo,expansao) values(" PP "," parto prematuro ");
Insert into acronimos(acronimo,expansao) values(" TP "," trabalho de parto ");
Insert into acronimos(acronimo,expansao) values(" AC "," ausculta cardíaca ");
Insert into acronimos(acronimo,expansao) values(" HMG "," hemograma ");
Insert into acronimos(acronimo,expansao) values(" ACX "," artéria coronariana circunflexa ");
Insert into acronimos(acronimo,expansao) values(" EQU "," exame qualitativo de urina ");
Insert into acronimos(acronimo,expansao) values(" UTI "," Unidade de Terapia Intensiva ");
Insert into acronimos(acronimo,expansao) values(" IR "," insuficiência renal ");
Insert into acronimos(acronimo,expansao) values(" SV "," supraventricular ");
Insert into acronimos(acronimo,expansao) values(" DP "," doença periapical ");
Insert into acronimos(acronimo,expansao) values(" III "," 3 ");
Insert into acronimos(acronimo,expansao) values(" IV "," 4 ");
Insert into acronimos(acronimo,expansao) values(" MID "," membro inferior direito ");
Insert into acronimos(acronimo,expansao) values(" RNM "," ressonância nuclear magnética ");
Insert into acronimos(acronimo,expansao) values(" RN1 "," recém-nato 1 ");
Insert into acronimos(acronimo,expansao) values(" TSH "," hormônio tíreo-estimulante ");
Insert into acronimos(acronimo,expansao) values(" CDI "," cardioversor-desfibrilador implantável ");
Insert into acronimos(acronimo,expansao) values(" VM "," ventilação mecânica ");
Insert into acronimos(acronimo,expansao) values(" BRE "," bloqueio de ramo esquerdo ");
Insert into acronimos(acronimo,expansao) values(" IGG "," imunoglobulina G ");
Insert into acronimos(acronimo,expansao) values(" EDA "," endoscopia digestiva alta ");
Insert into acronimos(acronimo,expansao) values(" IT "," transição interna ");
Insert into acronimos(acronimo,expansao) values(" BAV "," bloqueio atrioventricular ");
Insert into acronimos(acronimo,expansao) values(" CHAD "," concentrado de hemácias adulto ");
Insert into acronimos(acronimo,expansao) values(" IgM "," imunoglobulina M ");
Insert into acronimos(acronimo,expansao) values(" DD "," diâmetro diastólico ");
Insert into acronimos(acronimo,expansao) values(" DS "," diâmetro sistólico ");
Insert into acronimos(acronimo,expansao) values(" HPS "," Hospital de Pronto Socorro ");
Insert into acronimos(acronimo,expansao) values(" CK "," creatinoquinase ");
Insert into acronimos(acronimo,expansao) values(" MEI "," medicina interna ");
Insert into acronimos(acronimo,expansao) values(" PC "," parada cardíaca ");
Insert into acronimos(acronimo,expansao) values(" MG "," miligrama ");
Insert into acronimos(acronimo,expansao) values(" TOXO "," toxoplamose ");
Insert into acronimos(acronimo,expansao) values(" ADAE "," átrio direito átrio esquerdo ");
Insert into acronimos(acronimo,expansao) values(" IGM "," imunoglobulina M ");
Insert into acronimos(acronimo,expansao) values(" SC "," subcutâneo ");
Insert into acronimos(acronimo,expansao) values(" CA "," câncer ");
Insert into acronimos(acronimo,expansao) values(" AV "," átrio ventricular ");
Insert into acronimos(acronimo,expansao) values(" BAAR "," bacilo álcool ácido resistente ");
Insert into acronimos(acronimo,expansao) values(" BT "," bilirrubina total ");
Insert into acronimos(acronimo,expansao) values(" EGD "," esofagogastroduodenoscopia ");
Insert into acronimos(acronimo,expansao) values(" TV "," taquicardias ventriculares ");
Insert into acronimos(acronimo,expansao) values(" QT "," quimioterapia ");
Insert into acronimos(acronimo,expansao) values(" TEP "," tromboembolismo pulmonar ");
Insert into acronimos(acronimo,expansao) values(" TVP "," trombose venosa profunda ");
Insert into acronimos(acronimo,expansao) values(" TA "," artéria transversa ");
Insert into acronimos(acronimo,expansao) values(" CO "," monóxido de carbono ");
Insert into acronimos(acronimo,expansao) values(" CP "," comprimido ");
Insert into acronimos(acronimo,expansao) values(" EHCPA "," serviço de emergências do Hospital de Clínicas de Porto Alegre ");
Insert into acronimos(acronimo,expansao) values(" EPED "," especialidades pediátricas ");
Insert into acronimos(acronimo,expansao) values(" HBsAg "," antígeno de superfície do vírus da hepatite B ");
Insert into acronimos(acronimo,expansao) values(" BD "," morte cerebral ");
Insert into acronimos(acronimo,expansao) values(" SSST "," sem supradesnível do segmento ST ");
Insert into acronimos(acronimo,expansao) values(" DDVE "," diâmetro diastólico do ventrículo esquerdo ");
Insert into acronimos(acronimo,expansao) values(" DCE "," depuração de creatinina endógena ");
Insert into acronimos(acronimo,expansao) values(" MsIs "," membros inferiores ");
Insert into acronimos(acronimo,expansao) values(" SF "," soro fisiológico ");
Insert into acronimos(acronimo,expansao) values(" VP "," vasopressina ");
Insert into acronimos(acronimo,expansao) values(" CPAP "," pressão positiva contínua em vias aéreas ");
Insert into acronimos(acronimo,expansao) values(" HD "," hemodiálise ");
Insert into acronimos(acronimo,expansao) values(" ITB "," índice tornozelo/braço ");
Insert into acronimos(acronimo,expansao) values(" IRA "," insuficiência renal aguda ");
Insert into acronimos(acronimo,expansao) values(" TTO "," tratamento ");
Insert into acronimos(acronimo,expansao) values(" DSVE "," diâmetro sistólico do ventrículo esquerdo ");
Insert into acronimos(acronimo,expansao) values(" IECA "," inibidor da enzima conversora de angiotensina ");
Insert into acronimos(acronimo,expansao) values(" VEF1 "," volume expiratório forçado 1 ");
Insert into acronimos(acronimo,expansao) values(" BAVT "," bloqueio atrioventricular total ");
Insert into acronimos(acronimo,expansao) values(" CF "," colo femoral ");
Insert into acronimos(acronimo,expansao) values(" DVO "," distúrbio ventilatório obstrutivo ");
Insert into acronimos(acronimo,expansao) values(" RTU "," ressecção transuretral ");
Insert into acronimos(acronimo,expansao) values(" EAP "," edema agudo de pulmão ");
Insert into acronimos(acronimo,expansao) values(" ICT "," índice cardiotorácico ");
Insert into acronimos(acronimo,expansao) values(" MSE "," membro superior esquerdo ");
Insert into acronimos(acronimo,expansao) values(" ACx "," artéria circunflexa A ");
Insert into acronimos(acronimo,expansao) values(" AVE "," acidente vascular encefálico ");
Insert into acronimos(acronimo,expansao) values(" HMC "," hemocultura ");
Insert into acronimos(acronimo,expansao) values(" TB "," tuberculose ");
Insert into acronimos(acronimo,expansao) values(" B2 "," ausculta cardíaca ");
Insert into acronimos(acronimo,expansao) values(" FR "," freqüência respiratória ");
Insert into acronimos(acronimo,expansao) values(" TE "," teste ergométrico ");
Insert into acronimos(acronimo,expansao) values(" ATC "," angioplastia transluminal coronária ");
Insert into acronimos(acronimo,expansao) values(" IGO "," índice do grau de obesidade ");
Insert into acronimos(acronimo,expansao) values(" NPT "," nutrição parenteral total ");
Insert into acronimos(acronimo,expansao) values(" CD4 "," grupo de diferenciação 4 ");
Insert into acronimos(acronimo,expansao) values(" CMV "," citomegalovírus ");
Insert into acronimos(acronimo,expansao) values(" EEG "," eletroencefalograma ");
Insert into acronimos(acronimo,expansao) values(" FV "," fibrilação ventricular ");
Insert into acronimos(acronimo,expansao) values(" RV "," remodelamento ventricular ");
Insert into acronimos(acronimo,expansao) values(" VI "," 6 ");
Insert into acronimos(acronimo,expansao) values(" AJ "," antes do jantar ");
Insert into acronimos(acronimo,expansao) values(" HbsAg "," antígeno de superfície da hepatite B ");
Insert into acronimos(acronimo,expansao) values(" PL "," punção lombar ");
Insert into acronimos(acronimo,expansao) values(" PSA "," antígeno específico da próstata ");
Insert into acronimos(acronimo,expansao) values(" RHZ "," rifampicina, isoniazida e pirazinamida ");
Insert into acronimos(acronimo,expansao) values(" TT "," transtorácico ");
Insert into acronimos(acronimo,expansao) values(" CK-MB "," fração MB da creatinofosfoquinase ");
Insert into acronimos(acronimo,expansao) values(" MSD "," membro superior direito ");
Insert into acronimos(acronimo,expansao) values(" T4 "," tiroxina ");
Insert into acronimos(acronimo,expansao) values(" UTIP "," Unidade de Terapia Intensiva Pediátrica ");
Insert into acronimos(acronimo,expansao) values(" AA "," após almoço ");
Insert into acronimos(acronimo,expansao) values(" ACO "," anticoagulante oral ");
Insert into acronimos(acronimo,expansao) values(" LDH "," desidrogenase láctica ");
Insert into acronimos(acronimo,expansao) values(" MM "," mieloma múltiplo ");
Insert into acronimos(acronimo,expansao) values(" NPO "," nada por via oral ");
Insert into acronimos(acronimo,expansao) values(" TGO "," transaminase glutâmica oxalacética ");
Insert into acronimos(acronimo,expansao) values(" ECGs "," eletrocardiogramas ");
Insert into acronimos(acronimo,expansao) values(" HVE "," hipertrofia ventricular esquerda ");
Insert into acronimos(acronimo,expansao) values(" METS "," equivalente metabólico ");
Insert into acronimos(acronimo,expansao) values(" PBF "," perfil biofísico fetal ");
Insert into acronimos(acronimo,expansao) values(" SNE "," sonda nasoenteral ");
Insert into acronimos(acronimo,expansao) values(" CVF "," capacidade vital forçada ");
Insert into acronimos(acronimo,expansao) values(" DDD "," DDD ");
Insert into acronimos(acronimo,expansao) values(" HGT "," hemoglicoteste ");
Insert into acronimos(acronimo,expansao) values(" ILA "," índice de líquido amniótico ");
Insert into acronimos(acronimo,expansao) values(" OK "," ok ");
Insert into acronimos(acronimo,expansao) values(" SVD "," sobrecarga ventricular direita ");
Insert into acronimos(acronimo,expansao) values(" AIT "," ataque isquêmico transitório ");
Insert into acronimos(acronimo,expansao) values(" HGTs "," hemoglicotestes ");
Insert into acronimos(acronimo,expansao) values(" MMII "," membros inferiores ");
Insert into acronimos(acronimo,expansao) values(" MgCx "," ramo marginal da artéria circunflexa ");
Insert into acronimos(acronimo,expansao) values(" PAM "," pressão arterial média ");
Insert into acronimos(acronimo,expansao) values(" PO "," pós-operatório ");
Insert into acronimos(acronimo,expansao) values(" TET "," tubo endotraqueal ");
Insert into acronimos(acronimo,expansao) values(" HAP "," hipertensão arterial pulmonar ");
Insert into acronimos(acronimo,expansao) values(" MTX "," metotrexato ");
Insert into acronimos(acronimo,expansao) values(" PMT "," prematuro ");
Insert into acronimos(acronimo,expansao) values(" PPL "," pressão pleural ");
Insert into acronimos(acronimo,expansao) values(" PUC "," Pontifícia Universidade Católica ");
Insert into acronimos(acronimo,expansao) values(" RDT "," radioterapia ");
Insert into acronimos(acronimo,expansao) values(" SIDA "," síndrome da imunodeficiência adquirida ");
Insert into acronimos(acronimo,expansao) values(" SN "," sistema nervoso ");
Insert into acronimos(acronimo,expansao) values(" VSG "," velocidade de sedimentação globular ");
Insert into acronimos(acronimo,expansao) values(" VSR "," vírus sincicial respiratório ");
Insert into acronimos(acronimo,expansao) values(" BR "," bloqueio de ramo ");
Insert into acronimos(acronimo,expansao) values(" CE "," coronária esquerda ");
Insert into acronimos(acronimo,expansao) values(" DN "," data do nascimento ");
Insert into acronimos(acronimo,expansao) values(" ECA "," enzima conversora de angotensina ");
Insert into acronimos(acronimo,expansao) values(" EEF "," escala de expressões faciais ");
Insert into acronimos(acronimo,expansao) values(" FNB "," fenobarbital ");
Insert into acronimos(acronimo,expansao) values(" NS "," não significativo ");
Insert into acronimos(acronimo,expansao) values(" NTG "," nitroglicerina ");
Insert into acronimos(acronimo,expansao) values(" PROX "," próximo ");
Insert into acronimos(acronimo,expansao) values(" SST "," supradesnível do segmento ST ");
Insert into acronimos(acronimo,expansao) values(" TGP "," transaminase glutâmico-pirúvica ");
Insert into acronimos(acronimo,expansao) values(" TIG "," imunoglobulina antitetânica humana ");
Insert into acronimos(acronimo,expansao) values(" AINE "," antiinflamatório não-esteroidal ");
Insert into acronimos(acronimo,expansao) values(" CN "," catéter nasal ");
Insert into acronimos(acronimo,expansao) values(" CPRE "," colangiopancreatografia retrógrada endoscópica ");
Insert into acronimos(acronimo,expansao) values(" HDA "," hemorragia digestiva alta ");
Insert into acronimos(acronimo,expansao) values(" LCR "," licor ");
Insert into acronimos(acronimo,expansao) values(" Mg-Cx "," ramo marginal da artéria circunflexa ");
Insert into acronimos(acronimo,expansao) values(" PBE "," peritonite bacteriana espontânea ");
Insert into acronimos(acronimo,expansao) values(" PN "," pneumonia ");
Insert into acronimos(acronimo,expansao) values(" BCF "," batimentos cardíacos fetais ");
Insert into acronimos(acronimo,expansao) values(" CV "," carga viral ");
Insert into acronimos(acronimo,expansao) values(" HB "," hemoglobina ");
Insert into acronimos(acronimo,expansao) values(" IAo "," insuficiência aórtica ");
Insert into acronimos(acronimo,expansao) values(" LSD "," lobo superior direito ");
Insert into acronimos(acronimo,expansao) values(" RxTx "," raio X de tórax ");
Insert into acronimos(acronimo,expansao) values(" SAMU "," Serviço de Atendimento Médico de Urgência ");
Insert into acronimos(acronimo,expansao) values(" x/dia "," vezes ao dia ");
Insert into acronimos(acronimo,expansao) values(" AD "," átrio direito ");
Insert into acronimos(acronimo,expansao) values(" ARV "," anti-retro viral ");
Insert into acronimos(acronimo,expansao) values(" AVCs "," acidentes vasculares cerebrais ");
Insert into acronimos(acronimo,expansao) values(" CCA "," cardiopatias congênitas em adultos ");
Insert into acronimos(acronimo,expansao) values(" CEA "," antígeno carcinoembrionário ");
Insert into acronimos(acronimo,expansao) values(" CIV "," comunicação interventricular ");
Insert into acronimos(acronimo,expansao) values(" DRGE "," doença do refluxo gastresofágico ");
Insert into acronimos(acronimo,expansao) values(" GGT "," gama GT ");
Insert into acronimos(acronimo,expansao) values(" HBSAG "," antígeno de superfície para hepatite B ");
Insert into acronimos(acronimo,expansao) values(" HF "," história familiar ");
Insert into acronimos(acronimo,expansao) values(" I-ECA "," inibidor da enzima conversora de angiotensina ");
Insert into acronimos(acronimo,expansao) values(" IAMs "," infarto agudo do miocárdio ");
Insert into acronimos(acronimo,expansao) values(" IVC "," insuficiência venosa crônica ");
Insert into acronimos(acronimo,expansao) values(" MgCX "," ramo moarginal da artéria circunflexa ");
Insert into acronimos(acronimo,expansao) values(" SNG "," sonda nasogástrica ");
Insert into acronimos(acronimo,expansao) values(" TBC "," tuberculose ");
Insert into acronimos(acronimo,expansao) values(" VO2 "," volume de oxigênio ");
Insert into acronimos(acronimo,expansao) values(" B12 "," B12 ");
Insert into acronimos(acronimo,expansao) values(" BRD "," bloqueio de ramo direito ");
Insert into acronimos(acronimo,expansao) values(" EA "," emergência ambulatorial ");
Insert into acronimos(acronimo,expansao) values(" FAN "," fator anti-nuclear ");
Insert into acronimos(acronimo,expansao) values(" FAV "," favorável ");
Insert into acronimos(acronimo,expansao) values(" HNSC "," Hospital Nossa Senhora da Conceição ");
Insert into acronimos(acronimo,expansao) values(" MAP "," pressão média de vias aéreas ");
Insert into acronimos(acronimo,expansao) values(" NEG "," negativo ");
Insert into acronimos(acronimo,expansao) values(" OMA "," otite média aguda ");
Insert into acronimos(acronimo,expansao) values(" QMT "," quimioterapia ");
Insert into acronimos(acronimo,expansao) values(" S-PP "," sistólico - parede posterior ");
Insert into acronimos(acronimo,expansao) values(" TX "," tórax ");
Insert into acronimos(acronimo,expansao) values(" VCI "," veia cava inferior ");
Insert into acronimos(acronimo,expansao) values(" VCM "," volume corpuscular médio ");
Insert into acronimos(acronimo,expansao) values(" C3 "," complemento 3 ");
Insert into acronimos(acronimo,expansao) values(" CIG "," cigarro ");
Insert into acronimos(acronimo,expansao) values(" CPER "," colangiopancreatografia endoscópica retrógrada ");
Insert into acronimos(acronimo,expansao) values(" DIPI "," dipiridamol ");
Insert into acronimos(acronimo,expansao) values(" EX "," ex ");
Insert into acronimos(acronimo,expansao) values(" HPB "," hiperplasia prostática benigna ");
Insert into acronimos(acronimo,expansao) values(" IVUS "," ultra-sonografia intravascular ");
Insert into acronimos(acronimo,expansao) values(" NBZ "," nebulização ");
Insert into acronimos(acronimo,expansao) values(" PIG "," pequeno para idade gestacional ");
Insert into acronimos(acronimo,expansao) values(" RM "," ressonância magnética ");
Insert into acronimos(acronimo,expansao) values(" TCC "," tomografia computadorizada cardiovascular ");
Insert into acronimos(acronimo,expansao) values(" TSM "," tipo sangüíneo da mãe ");
Insert into acronimos(acronimo,expansao) values(" VLP "," videolaparoscopia ");
Insert into acronimos(acronimo,expansao) values(" AIG "," adequado para a idade gestacional ");
Insert into acronimos(acronimo,expansao) values(" AINES "," antiinflamatórios não-esteroidais ");
Insert into acronimos(acronimo,expansao) values(" CAPS "," Centro de Atendimento Psicoprofissionalizante ");
Insert into acronimos(acronimo,expansao) values(" CEC "," circulação extracorpórea ");
Insert into acronimos(acronimo,expansao) values(" CIPED "," Centro de Investigação de Doenças Pediátricas ");
Insert into acronimos(acronimo,expansao) values(" CT "," centro de tratamento ");
Insert into acronimos(acronimo,expansao) values(" DG "," ramo diagonal ");
Insert into acronimos(acronimo,expansao) values(" Dg "," ramo diagonal ");
Insert into acronimos(acronimo,expansao) values(" DPCD "," diálise peritoneal continuada ");
Insert into acronimos(acronimo,expansao) values(" ESV "," extra-sístoles ventriculares ");
Insert into acronimos(acronimo,expansao) values(" IMi "," infarto do miocárdio ");
Insert into acronimos(acronimo,expansao) values(" IVAS "," infecções das vias aéreas superiores ");
Insert into acronimos(acronimo,expansao) values(" PEG "," pré-eclâmpsia grave ");
Insert into acronimos(acronimo,expansao) values(" R1 "," residente 1 ");
Insert into acronimos(acronimo,expansao) values(" RG "," regime geral ");
Insert into acronimos(acronimo,expansao) values(" RxT "," raio X de tórax ");
Insert into acronimos(acronimo,expansao) values(" VD-AD "," ventrículo direito - átrio direito ");
Insert into acronimos(acronimo,expansao) values(" VEF "," volume expiratório forçado ");
Insert into acronimos(acronimo,expansao) values(" mL "," mililitro ");
Insert into acronimos(acronimo,expansao) values(" ABD "," detecção automática de fronteira ");
Insert into acronimos(acronimo,expansao) values(" ACTH "," hormônio adrenocorticotrófico ");
Insert into acronimos(acronimo,expansao) values(" AMO "," alteração de medula óssea ");
Insert into acronimos(acronimo,expansao) values(" BB "," beta-bloqueador ");
Insert into acronimos(acronimo,expansao) values(" BI "," duas ");
Insert into acronimos(acronimo,expansao) values(" BIA "," balão intra-aórtico ");
Insert into acronimos(acronimo,expansao) values(" BX "," biópsia ");
Insert into acronimos(acronimo,expansao) values(" C4 "," complemento 4 ");
Insert into acronimos(acronimo,expansao) values(" CEN "," catéter endonasal ");
Insert into acronimos(acronimo,expansao) values(" CKMB "," fração MB da creatinofosfoquinase ");
Insert into acronimos(acronimo,expansao) values(" DI "," dois ");
Insert into acronimos(acronimo,expansao) values(" DIP "," dipiridamol ");
Insert into acronimos(acronimo,expansao) values(" HP "," Helicobacter pylori ");
Insert into acronimos(acronimo,expansao) values(" LID "," lobo inferior direito ");
Insert into acronimos(acronimo,expansao) values(" MV "," murmúrio vesicular ");
Insert into acronimos(acronimo,expansao) values(" REED "," radiograma de esôfago, estômago e duodeno ");
Insert into acronimos(acronimo,expansao) values(" RNI "," razão normalizada internacional ");
Insert into acronimos(acronimo,expansao) values(" STK "," streptoquinase ");
Insert into acronimos(acronimo,expansao) values(" TPP "," trabalho de parto prematuro ");
Insert into acronimos(acronimo,expansao) values(" VPA "," valproato de sódio ");
Insert into acronimos(acronimo,expansao) values(" mCi "," milicurie ");
Insert into acronimos(acronimo,expansao) values(" mg/dl "," miligrama/decilitro ");
Insert into acronimos(acronimo,expansao) values(" AIH "," Autorização de Internação Hospitalar ");
Insert into acronimos(acronimo,expansao) values(" BEG "," bom estado geral ");
Insert into acronimos(acronimo,expansao) values(" CBZ "," carbamazepina ");
Insert into acronimos(acronimo,expansao) values(" CHILD "," Child ");
Insert into acronimos(acronimo,expansao) values(" CIA "," comunicação interatrial ");
Insert into acronimos(acronimo,expansao) values(" D3 "," dia 3 ");
Insert into acronimos(acronimo,expansao) values(" DNA "," ácido desoxirribonucléico ");
Insert into acronimos(acronimo,expansao) values(" ENMG "," eletroneuromiografia ");
Insert into acronimos(acronimo,expansao) values(" ESQ "," esquerdo ");
Insert into acronimos(acronimo,expansao) values(" ESSV "," extra-sístoles supraventriculares ");
Insert into acronimos(acronimo,expansao) values(" FBC "," freqüência do batimento ciliar ");
Insert into acronimos(acronimo,expansao) values(" FS "," freqüência sinusal ");
Insert into acronimos(acronimo,expansao) values(" HT "," hematócrito ");
Insert into acronimos(acronimo,expansao) values(" ITUs "," infecções do trato urinário ");
Insert into acronimos(acronimo,expansao) values(" ITr "," insuficiência tricúspide ");
Insert into acronimos(acronimo,expansao) values(" LT "," leucograma total ");
Insert into acronimos(acronimo,expansao) values(" PTU "," propiltiouracil ");
Insert into acronimos(acronimo,expansao) values(" QD "," quantidade diária ");
Insert into acronimos(acronimo,expansao) values(" QN "," quando necessário ");
Insert into acronimos(acronimo,expansao) values(" R2 "," residente 2 ");
Insert into acronimos(acronimo,expansao) values(" RS "," ritmo sinusal ");
Insert into acronimos(acronimo,expansao) values(" RXT "," raio X de tórax ");
Insert into acronimos(acronimo,expansao) values(" SNC "," sistema nervoso central ");
Insert into acronimos(acronimo,expansao) values(" SO "," sala de observação ");
Insert into acronimos(acronimo,expansao) values(" SVE "," sobrecarga ventricular esquerda ");
Insert into acronimos(acronimo,expansao) values(" VD/AD "," ventrículo direito / átrio direito ");
Insert into acronimos(acronimo,expansao) values(" VPP "," ventilação com pressão positiva ");
Insert into acronimos(acronimo,expansao) values(" s/pp "," sistólico / parede posterior ");
Insert into acronimos(acronimo,expansao) values(" AAA "," aneurisma da aorta abdominal ");
Insert into acronimos(acronimo,expansao) values(" AB "," AB ");
Insert into acronimos(acronimo,expansao) values(" AITs "," ataques isquêmicos transitórios ");
Insert into acronimos(acronimo,expansao) values(" AMBU "," ambulatório ");
Insert into acronimos(acronimo,expansao) values(" BQLT "," bronquiolite ");
Insert into acronimos(acronimo,expansao) values(" CO2 "," dióxido de carbono ");
Insert into acronimos(acronimo,expansao) values(" CTC "," corticóide ");
Insert into acronimos(acronimo,expansao) values(" DPN "," dispnéia paroxística noturna ");
Insert into acronimos(acronimo,expansao) values(" DR "," doutor ");
Insert into acronimos(acronimo,expansao) values(" GH "," hormônio do crescimento ");
Insert into acronimos(acronimo,expansao) values(" hdl "," lipoproteínas de alta densidade ");
Insert into acronimos(acronimo,expansao) values(" ICE "," insuficiência congestiva esquerda ");
Insert into acronimos(acronimo,expansao) values(" IFI "," imunofluorescência indireta ");
Insert into acronimos(acronimo,expansao) values(" KG "," quilograma ");
Insert into acronimos(acronimo,expansao) values(" LBA "," lavado brônquico alveolar ");
Insert into acronimos(acronimo,expansao) values(" LDL "," lipoproteínas de baixa densidade ");
Insert into acronimos(acronimo,expansao) values(" M0 "," medula óssea ");
Insert into acronimos(acronimo,expansao) values(" PAS "," pressão arterial sistêmica ");
Insert into acronimos(acronimo,expansao) values(" PFH "," prova de função hepática ");
Insert into acronimos(acronimo,expansao) values(" PSP "," punção suprapúbica ");
Insert into acronimos(acronimo,expansao) values(" PT "," perímetro ");
Insert into acronimos(acronimo,expansao) values(" QI "," quociente de inteligência ");
Insert into acronimos(acronimo,expansao) values(" RMN "," ressonância magnética ");
Insert into acronimos(acronimo,expansao) values(" SG "," assobrevida global ");
Insert into acronimos(acronimo,expansao) values(" SVs "," sinais vitais ");
Insert into acronimos(acronimo,expansao) values(" T1 "," tempo 1 ");
Insert into acronimos(acronimo,expansao) values(" i-ECA "," inibidores da enzima conversora de angiotensina ");
Insert into acronimos(acronimo,expansao) values(" iECA "," inibidores da enzima conversora de angiotensina ");
Insert into acronimos(acronimo,expansao) values(" mcg/d "," microgramas/decilitro ");
Insert into acronimos(acronimo,expansao) values(" ACM "," artéria cerebral média ");
Insert into acronimos(acronimo,expansao) values(" ACTPs "," angioplastias coronarianas transluminais percutâneas ");
Insert into acronimos(acronimo,expansao) values(" AESP "," atividade elétrica sem pulso ");
Insert into acronimos(acronimo,expansao) values(" AIRV "," alterações inespecíficas da repolarização ventricular ");
Insert into acronimos(acronimo,expansao) values(" ANTI "," anti ");
Insert into acronimos(acronimo,expansao) values(" AVCi "," acidente vascular cerebral isquêmico ");
Insert into acronimos(acronimo,expansao) values(" AVEi "," acidente vascular encefálico isquêmico ");
Insert into acronimos(acronimo,expansao) values(" AZT "," zidovudina ");
Insert into acronimos(acronimo,expansao) values(" B6 "," B6 ");
Insert into acronimos(acronimo,expansao) values(" BQTE "," bronquite ");
Insert into acronimos(acronimo,expansao) values(" CCT "," carcinoma de células transicionais ");
Insert into acronimos(acronimo,expansao) values(" DM1 "," diabetes melitus tipo I ");
Insert into acronimos(acronimo,expansao) values(" EBV "," Epstein-Barr vírus ");
Insert into acronimos(acronimo,expansao) values(" EGDA "," anastomose esofagogastroduodenal ");
Insert into acronimos(acronimo,expansao) values(" FAF "," arma de fogo ");
Insert into acronimos(acronimo,expansao) values(" HBV "," vírus da hepatite B ");
Insert into acronimos(acronimo,expansao) values(" HCG "," hormônio da gonadotrofina coriônica ");
Insert into acronimos(acronimo,expansao) values(" HMV "," Hospital Moinhos de Vento ");
Insert into acronimos(acronimo,expansao) values(" HSL "," Hospital São Lucas ");
Insert into acronimos(acronimo,expansao) values(" IMC "," índice de massa corporal ");
Insert into acronimos(acronimo,expansao) values(" LH "," hormônio luteinizante ");
Insert into acronimos(acronimo,expansao) values(" LIE "," lobo inferior esquerdo ");
Insert into acronimos(acronimo,expansao) values(" MAM "," artéria mamária ");
Insert into acronimos(acronimo,expansao) values(" MED "," médio ");
Insert into acronimos(acronimo,expansao) values(" METs "," equivalentes metabólicos ");
Insert into acronimos(acronimo,expansao) values(" MGCX "," ramo marginal da artéria circunflexa ");
Insert into acronimos(acronimo,expansao) values(" OAA "," obstrução arterial aguda ");
Insert into acronimos(acronimo,expansao) values(" P/C "," polifenol/carboidrato ");
Insert into acronimos(acronimo,expansao) values(" PAAF "," punção aspirativa por agulha fina ");
Insert into acronimos(acronimo,expansao) values(" PCRs "," paradas cardio-respiratórias ");
Insert into acronimos(acronimo,expansao) values(" PNA "," pielonefrite aguda ");
Insert into acronimos(acronimo,expansao) values(" R-x "," raio X ");
Insert into acronimos(acronimo,expansao) values(" SIADH "," síndrome de secreção inapropriada de hormônio anti-diurético ");
Insert into acronimos(acronimo,expansao) values(" SK "," estreptoquinase ");
Insert into acronimos(acronimo,expansao) values(" SOP "," síndrome do ovário policístico ");
Insert into acronimos(acronimo,expansao) values(" SUS "," Sistema Único de Saúde ");
Insert into acronimos(acronimo,expansao) values(" TGI "," trato gastrointestinal ");
Insert into acronimos(acronimo,expansao) values(" TMO "," transplante de medula óssea ");
Insert into acronimos(acronimo,expansao) values(" TPO "," tireoperoxidase ");
Insert into acronimos(acronimo,expansao) values(" TVNS "," taquicardia ventricular não sustentada ");
Insert into acronimos(acronimo,expansao) values(" VD>AD "," ventrículo direito > átrio direito ");
Insert into acronimos(acronimo,expansao) values(" cm2 "," centímetro quadrado ");
Insert into acronimos(acronimo,expansao) values(" o2 "," oxigênio ");
Insert into acronimos(acronimo,expansao) values(" ACV "," aparelho cardiovascular ");
Insert into acronimos(acronimo,expansao) values(" AMPI "," ampicilina ");
Insert into acronimos(acronimo,expansao) values(" BMO "," biópsia de medula óssea ");
Insert into acronimos(acronimo,expansao) values(" CIE "," carótida interna esquerda ");
Insert into acronimos(acronimo,expansao) values(" CM "," centímetro ");
Insert into acronimos(acronimo,expansao) values(" CPAPn "," pressão positiva contínua em vias aéreas nasal ");
Insert into acronimos(acronimo,expansao) values(" CR "," creatinina ");
Insert into acronimos(acronimo,expansao) values(" DMG "," diabetes melitus gestacional ");
Insert into acronimos(acronimo,expansao) values(" DMSA "," ácido dimercaptosuccínico ");
Insert into acronimos(acronimo,expansao) values(" DRA "," doutora ");
Insert into acronimos(acronimo,expansao) values(" DV "," densitovolumetria ");
Insert into acronimos(acronimo,expansao) values(" DVP "," derivação ventrículo peritoneal ");
Insert into acronimos(acronimo,expansao) values(" EMG "," emergência ");
Insert into acronimos(acronimo,expansao) values(" FEVE "," fração de ejeção do ventrículo esquerdo ");
Insert into acronimos(acronimo,expansao) values(" FK "," trakolimus ");
Insert into acronimos(acronimo,expansao) values(" FiO2 "," fração de oxigênio inspirado ");
Insert into acronimos(acronimo,expansao) values(" GA "," gasometria ");
Insert into acronimos(acronimo,expansao) values(" HCO3 "," bicarbonato ");
Insert into acronimos(acronimo,expansao) values(" HPIV "," hemorragia peri-intraventricular ");
Insert into acronimos(acronimo,expansao) values(" HS "," horas ");
Insert into acronimos(acronimo,expansao) values(" HTLV "," vírus T-linfotrópico humano ");
Insert into acronimos(acronimo,expansao) values(" ISQ "," isquêmico ");
Insert into acronimos(acronimo,expansao) values(" KTTP "," tempo de tromboplastina parcialmente ativada ");
Insert into acronimos(acronimo,expansao) values(" LMA "," leucemia mielóide aguda ");
Insert into acronimos(acronimo,expansao) values(" LOC "," lúcido, orientado e consciente ");
Insert into acronimos(acronimo,expansao) values(" LSE "," lobo superior esquerdo ");
Insert into acronimos(acronimo,expansao) values(" MA "," meningites assépticas ");
Insert into acronimos(acronimo,expansao) values(" MAC "," ambulatório de cardiologia ");
Insert into acronimos(acronimo,expansao) values(" MM-DA "," mamária - descendente anterior ");
Insert into acronimos(acronimo,expansao) values(" MMIIs "," membros inferiores ");
Insert into acronimos(acronimo,expansao) values(" MO "," medula óssea ");
Insert into acronimos(acronimo,expansao) values(" MT "," metiltestosterona ");
Insert into acronimos(acronimo,expansao) values(" MTD "," dose máxima tolerada ");
Insert into acronimos(acronimo,expansao) values(" NEO "," neonatal ");
Insert into acronimos(acronimo,expansao) values(" NEURO "," neurologia ");
Insert into acronimos(acronimo,expansao) values(" NPS "," nitroprussiato de sódio ");
Insert into acronimos(acronimo,expansao) values(" ORL "," otorrinolaringologia ");
Insert into acronimos(acronimo,expansao) values(" PLAQ "," plaquetas ");
Insert into acronimos(acronimo,expansao) values(" PPNL "," propranolol ");
Insert into acronimos(acronimo,expansao) values(" PTH "," paratormônio ");
Insert into acronimos(acronimo,expansao) values(" PVC "," pressão venosa central ");
Insert into acronimos(acronimo,expansao) values(" PaO2 "," pressão arterial de oxigênio ");
Insert into acronimos(acronimo,expansao) values(" RA "," rêmora atrial ");
Insert into acronimos(acronimo,expansao) values(" RDW "," amplitude de distribuição eritrocitária ");
Insert into acronimos(acronimo,expansao) values(" RH "," rifampicina e isoniazida ");
Insert into acronimos(acronimo,expansao) values(" RxABD "," raio X abdominal ");
Insert into acronimos(acronimo,expansao) values(" SFA "," sofrimento fetal agudo ");
Insert into acronimos(acronimo,expansao) values(" SM "," silagem de milho ");
Insert into acronimos(acronimo,expansao) values(" SPA "," Serviço de Pronto Atendimento ");
Insert into acronimos(acronimo,expansao) values(" SpO2 "," saturação percutânea de oxigênio ");
Insert into acronimos(acronimo,expansao) values(" TAB "," transtorno afetivo bipolar ");
Insert into acronimos(acronimo,expansao) values(" TAP "," tempo de atividade de protrombina ");
Insert into acronimos(acronimo,expansao) values(" TARV "," terapia antiretroviral ");
Insert into acronimos(acronimo,expansao) values(" TG "," triglicerídeos ");
Insert into acronimos(acronimo,expansao) values(" TILT "," teste de inclinação ortostática ");
Insert into acronimos(acronimo,expansao) values(" UCA "," cultura de urina ");
Insert into acronimos(acronimo,expansao) values(" UCI "," unidade de cuidados intermediários ");
Insert into acronimos(acronimo,expansao) values(" URC "," urocultura ");
Insert into acronimos(acronimo,expansao) values(" US "," ultra-sonografia ");
Insert into acronimos(acronimo,expansao) values(" UTIN "," Unidade de Terapia Intensiva Neonatal ");
Insert into acronimos(acronimo,expansao) values(" VD28 "," ventrículo direito 28 ");
Insert into acronimos(acronimo,expansao) values(" pH "," potencial hidrogeniônico ");
Insert into acronimos(acronimo,expansao) values(" A2 "," amostra 2 ");
Insert into acronimos(acronimo,expansao) values(" ADC "," coeficiente de difusão aparente ");
Insert into acronimos(acronimo,expansao) values(" AMgCx "," ramo marginal da artéria circunflexa ");
Insert into acronimos(acronimo,expansao) values(" ANCA "," anticorpo anticitoplasma de neutrófilo ");
Insert into acronimos(acronimo,expansao) values(" ARVŽs "," antiretrovirais ");
Insert into acronimos(acronimo,expansao) values(" BFM "," Berlin-Frankfurt-Münster ");
Insert into acronimos(acronimo,expansao) values(" BQLTE "," bronquiolite ");
Insert into acronimos(acronimo,expansao) values(" CAPD "," diálise peritoneal ambulatorial crônica ");
Insert into acronimos(acronimo,expansao) values(" CC "," cardiopatias congênitas ");
Insert into acronimos(acronimo,expansao) values(" CHC "," carcinoma hepatocelular ");
Insert into acronimos(acronimo,expansao) values(" CPT "," capacidade pulmonar total ");
Insert into acronimos(acronimo,expansao) values(" CREAT "," creatinina ");
Insert into acronimos(acronimo,expansao) values(" CTICC "," Centro de Tratamento Intensivo Clínico-cirúrgico ");
Insert into acronimos(acronimo,expansao) values(" DAOP "," doença arterial obstrutiva periférica ");
Insert into acronimos(acronimo,expansao) values(" DBPOC "," doença broncopulmonar obstrutiva crônica ");
Insert into acronimos(acronimo,expansao) values(" DC "," doença celíaca ");
Insert into acronimos(acronimo,expansao) values(" DDI "," DDI ");
Insert into acronimos(acronimo,expansao) values(" DMO "," densidade mineral óssea ");
Insert into acronimos(acronimo,expansao) values(" DRC "," doença renal crônica ");
Insert into acronimos(acronimo,expansao) values(" DX "," diagnóstico ");
Insert into acronimos(acronimo,expansao) values(" EF "," exame físico ");
Insert into acronimos(acronimo,expansao) values(" EFZ "," efavirenz ");
Insert into acronimos(acronimo,expansao) values(" ELLA "," endoprótese arterial de perna esquerda ");
Insert into acronimos(acronimo,expansao) values(" EPF "," exame parasitológico de fezes ");
Insert into acronimos(acronimo,expansao) values(" EPO "," eritropoetina ");
Insert into acronimos(acronimo,expansao) values(" EQ "," esquema quimioterápico ");
Insert into acronimos(acronimo,expansao) values(" ESBL "," produtoras de beta-lactamase com espectro estendido ");
Insert into acronimos(acronimo,expansao) values(" FOP "," forame oval patente ");
Insert into acronimos(acronimo,expansao) values(" FSH "," hormônio folículo estimulante ");
Insert into acronimos(acronimo,expansao) values(" G3 "," gestação 3 ");
Insert into acronimos(acronimo,expansao) values(" HELLP "," anemia hemolítica, níveis elevados de enzimas hepáticas e contagem baixa de plaquetas ");
Insert into acronimos(acronimo,expansao) values(" HMP "," história médica pregressa ");
Insert into acronimos(acronimo,expansao) values(" IAO "," insuficiência aórtica ");
Insert into acronimos(acronimo,expansao) values(" ICP "," intervenção coronária percutânea ");
Insert into acronimos(acronimo,expansao) values(" IGP "," idade gestacional no parto ");
Insert into acronimos(acronimo,expansao) values(" IN "," intranasais ");
Insert into acronimos(acronimo,expansao) values(" JUP "," junção uretero-piélica ");
Insert into acronimos(acronimo,expansao) values(" L1 "," lombar 1 ");
Insert into acronimos(acronimo,expansao) values(" LM "," lobo médio ");
Insert into acronimos(acronimo,expansao) values(" LV "," leite de vaca ");
Insert into acronimos(acronimo,expansao) values(" MI "," membro inferior ");
Insert into acronimos(acronimo,expansao) values(" MIBI "," metoxi-isobutil-isonitrila ");
Insert into acronimos(acronimo,expansao) values(" MIŽs "," membros inferiores ");
Insert into acronimos(acronimo,expansao) values(" MRSA "," Staphylococcus aureus resistente à meticilina ");
Insert into acronimos(acronimo,expansao) values(" MTZ "," mirtazapina ");
Insert into acronimos(acronimo,expansao) values(" MsIS "," membros inferiores ");
Insert into acronimos(acronimo,expansao) values(" NC "," nervo craniano ");
Insert into acronimos(acronimo,expansao) values(" OBS "," observação ");
Insert into acronimos(acronimo,expansao) values(" OD "," olho direito ");
Insert into acronimos(acronimo,expansao) values(" OE "," olho esquerdo ");
Insert into acronimos(acronimo,expansao) values(" PCO2 "," pressão de dióxido de carbono ");
Insert into acronimos(acronimo,expansao) values(" PCP "," pressão capilar pulmonar ");
Insert into acronimos(acronimo,expansao) values(" PCT "," paciente ");
Insert into acronimos(acronimo,expansao) values(" PMAP "," pressão média da artéria pulmonar ");
Insert into acronimos(acronimo,expansao) values(" PNE "," portador de necessidades especiais ");
Insert into acronimos(acronimo,expansao) values(" PNTx "," pneumotórax ");
Insert into acronimos(acronimo,expansao) values(" POA "," Porto Alegre ");
Insert into acronimos(acronimo,expansao) values(" PPD "," derivado protéico purificado ");
Insert into acronimos(acronimo,expansao) values(" PV "," parto vaginal ");
Insert into acronimos(acronimo,expansao) values(" QID "," quadrante inferior direito ");
Insert into acronimos(acronimo,expansao) values(" R-X "," raio X ");
Insert into acronimos(acronimo,expansao) values(" RBV "," ribavirina ");
Insert into acronimos(acronimo,expansao) values(" RC "," risco cardiovascular ");
Insert into acronimos(acronimo,expansao) values(" RCP "," reanimação cardiopulmonar ");
Insert into acronimos(acronimo,expansao) values(" RD "," retinopatia diabética ");
Insert into acronimos(acronimo,expansao) values(" REAG "," reagente ");
Insert into acronimos(acronimo,expansao) values(" RGE "," refluxo gastresofágico ");
Insert into acronimos(acronimo,expansao) values(" RHA "," ruídos hidroaéreos ");
Insert into acronimos(acronimo,expansao) values(" RN2 "," recém-nato 2 ");
Insert into acronimos(acronimo,expansao) values(" RPD "," retinopatia diabética proliferativa ");
Insert into acronimos(acronimo,expansao) values(" RXTX "," raio X de tórax ");
Insert into acronimos(acronimo,expansao) values(" S/N "," se necessário ");
Insert into acronimos(acronimo,expansao) values(" SMC "," serviço médico de cirurgia ");
Insert into acronimos(acronimo,expansao) values(" SMO "," serviço médico de oncologia ");
Insert into acronimos(acronimo,expansao) values(" SR "," senhor ");
Insert into acronimos(acronimo,expansao) values(" SVA "," sonda uretral plástica ");
Insert into acronimos(acronimo,expansao) values(" TCEC "," tempo de circulação extracorpórea ");
Insert into acronimos(acronimo,expansao) values(" TIFF "," Tiffeneau ");
Insert into acronimos(acronimo,expansao) values(" TOT "," tubo orotraqueal ");
Insert into acronimos(acronimo,expansao) values(" TSRN "," tipo sangüíneo do recém-nato ");
Insert into acronimos(acronimo,expansao) values(" UBS "," Unidade Básica de Saúde ");
Insert into acronimos(acronimo,expansao) values(" VA "," vias aéreas ");
Insert into acronimos(acronimo,expansao) values(" VAD "," vincristina, adriblastina e dexametasona ");
Insert into acronimos(acronimo,expansao) values(" VB "," vesícula biliar ");
Insert into acronimos(acronimo,expansao) values(" VCR "," vincristina ");
Insert into acronimos(acronimo,expansao) values(" VED "," diâmetro diastólico ");
Insert into acronimos(acronimo,expansao) values(" VEDF "," ventrículo esquerdo diástole final ");
Insert into acronimos(acronimo,expansao) values(" VES "," diâmetro sistólico ");
Insert into acronimos(acronimo,expansao) values(" VESF "," ventrículo esquerdo sístole final ");
Insert into acronimos(acronimo,expansao) values(" VSVE "," via de saída do ventrículo esquerdo ");
Insert into acronimos(acronimo,expansao) values(" h/h "," de hora em hora ");
Insert into acronimos(acronimo,expansao) values(" A2RV "," alteração de repolarização ventricular ");
Insert into acronimos(acronimo,expansao) values(" AA2 "," aminoácidos ");
Insert into acronimos(acronimo,expansao) values(" ACE "," artéria coronária esquerda ");
Insert into acronimos(acronimo,expansao) values(" ADS "," amniocentese descompressiva seriada ");
Insert into acronimos(acronimo,expansao) values(" AI "," angina instável ");
Insert into acronimos(acronimo,expansao) values(" AINEs "," antiinflamatórios não-esteroidais ");
Insert into acronimos(acronimo,expansao) values(" ANGIO "," angiografia ");
Insert into acronimos(acronimo,expansao) values(" ARA "," antagonistas dos receptores da angiotensina ");
Insert into acronimos(acronimo,expansao) values(" ART "," artéria ");
Insert into acronimos(acronimo,expansao) values(" AVEs "," acidente vascular encefálico ");
Insert into acronimos(acronimo,expansao) values(" AVF "," ante-verso-flexão ");
Insert into acronimos(acronimo,expansao) values(" B1 "," B1 ");
Insert into acronimos(acronimo,expansao) values(" B3 "," terceira bulha ");
Insert into acronimos(acronimo,expansao) values(" B4 "," quarta bulha ");
Insert into acronimos(acronimo,expansao) values(" BBloq "," beta-bloqueadores ");
Insert into acronimos(acronimo,expansao) values(" BC "," bloco cirúrgico ");
Insert into acronimos(acronimo,expansao) values(" BCG "," bacilo de Calmette-Guérin ");
Insert into acronimos(acronimo,expansao) values(" BCPs "," broncopneumonias ");
Insert into acronimos(acronimo,expansao) values(" BDAS "," bloqueios divisionais ântero-superiores ");
Insert into acronimos(acronimo,expansao) values(" BIPAP "," pressão positiva em vias aéreas com dois níveis ");
Insert into acronimos(acronimo,expansao) values(" BNF "," bulhas normofonéticos ");
Insert into acronimos(acronimo,expansao) values(" BT:41 "," bilirrubina total ");
Insert into acronimos(acronimo,expansao) values(" BZD "," benzodiazepínicos ");
Insert into acronimos(acronimo,expansao) values(" BiPAP "," pressão positiva em vias aéreas com dois níveis ");
Insert into acronimos(acronimo,expansao) values(" C1 "," cesariana 1 ");
Insert into acronimos(acronimo,expansao) values(" CAt "," avaliação crítica tópica ");
Insert into acronimos(acronimo,expansao) values(" CD34 "," grupo de diferenciação 34 ");
Insert into acronimos(acronimo,expansao) values(" CHAd "," concentrado de hemácias adulto ");
Insert into acronimos(acronimo,expansao) values(" CIC "," cirurgia cardíaca ");
Insert into acronimos(acronimo,expansao) values(" CID "," Classificação Internacional de Doenças ");
Insert into acronimos(acronimo,expansao) values(" CIP "," carcinoma incidental da próstata ");
Insert into acronimos(acronimo,expansao) values(" CTi "," centro de terapia intensiva ");
Insert into acronimos(acronimo,expansao) values(" CVE "," cardioversão elétrica ");
Insert into acronimos(acronimo,expansao) values(" CVM "," contração voluntária máxima ");
Insert into acronimos(acronimo,expansao) values(" Ca2 "," cálcio ");
Insert into acronimos(acronimo,expansao) values(" CaT "," avaliação crítica tópica ");
Insert into acronimos(acronimo,expansao) values(" D14 "," dia 14 ");
Insert into acronimos(acronimo,expansao) values(" D4 "," dia 4 ");
Insert into acronimos(acronimo,expansao) values(" DA/Dg "," descendente anterior / primeira diagonal ");
Insert into acronimos(acronimo,expansao) values(" DBP "," diâmetro biparietal ");
Insert into acronimos(acronimo,expansao) values(" DHEA "," deidroepiandrosterona ");
Insert into acronimos(acronimo,expansao) values(" DIU "," dispositivo intra-uterino ");
Insert into acronimos(acronimo,expansao) values(" DM-2 "," diabete melitus tipo 2 ");
Insert into acronimos(acronimo,expansao) values(" DMII "," diabete melitus tipo 2 ");
Insert into acronimos(acronimo,expansao) values(" DP-CD "," diagonal posterior - coronária direita ");
Insert into acronimos(acronimo,expansao) values(" DPP "," descolamento prematuro de placenta ");
Insert into acronimos(acronimo,expansao) values(" DPT "," espessamento peritoneal difuso ");
Insert into acronimos(acronimo,expansao) values(" DTS "," dose total semanal ");
Insert into acronimos(acronimo,expansao) values(" DVR "," distúrbio ventilatório restritivo ");
Insert into acronimos(acronimo,expansao) values(" Dg-DA "," primeira diagonal / descendente anterior ");
Insert into acronimos(acronimo,expansao) values(" Dg1 "," primeira diagonal 1 ");
Insert into acronimos(acronimo,expansao) values(" Dm2 "," diabete melitus tipo 2 ");
Insert into acronimos(acronimo,expansao) values(" E-D "," esquerda-direita ");
Insert into acronimos(acronimo,expansao) values(" ECGŽs "," ecografias ");
Insert into acronimos(acronimo,expansao) values(" ECT "," eletroconvulsoterapia ");
Insert into acronimos(acronimo,expansao) values(" EDSS "," escala ampliada do estado de incapacidade ");
Insert into acronimos(acronimo,expansao) values(" EFV "," efavirenz ");
Insert into acronimos(acronimo,expansao) values(" EME "," emergência ");
Insert into acronimos(acronimo,expansao) values(" EMEP "," emergência pediátrica ");
Insert into acronimos(acronimo,expansao) values(" EP "," epitélio pigmentado ");
Insert into acronimos(acronimo,expansao) values(" FCmáx "," função cardíaca máxima ");
Insert into acronimos(acronimo,expansao) values(" FEJ "," fração de ejeção ");
Insert into acronimos(acronimo,expansao) values(" FEM "," feminino ");
Insert into acronimos(acronimo,expansao) values(" FEV "," fevereiro ");
Insert into acronimos(acronimo,expansao) values(" FEj "," fração de ejeção ");
Insert into acronimos(acronimo,expansao) values(" FH "," formação do hipocampo ");
Insert into acronimos(acronimo,expansao) values(" FID "," fossa ilíaca direita ");
Insert into acronimos(acronimo,expansao) values(" FSV "," fundo de saco vaginal ");
Insert into acronimos(acronimo,expansao) values(" G4 "," gestação 4 ");
Insert into acronimos(acronimo,expansao) values(" G6PD "," glicose-6-fosfato dehidrogenase ");
Insert into acronimos(acronimo,expansao) values(" GI "," gastro intestinal ");
Insert into acronimos(acronimo,expansao) values(" GNMP "," glomerulonefrite membrano-proliferativa ");
Insert into acronimos(acronimo,expansao) values(" GRAFT "," Graft ");
Insert into acronimos(acronimo,expansao) values(" GRAM "," gram ");
Insert into acronimos(acronimo,expansao) values(" GT "," glutariltransferase ");
Insert into acronimos(acronimo,expansao) values(" GTS "," gotas ");
Insert into acronimos(acronimo,expansao) values(" HAS,e "," hipertensão arterial sistêmica ");
Insert into acronimos(acronimo,expansao) values(" HBAE "," hemibloqueio anterior esquerdo ");
Insert into acronimos(acronimo,expansao) values(" HBP "," hiperplasia benigna da próstata ");
Insert into acronimos(acronimo,expansao) values(" HBs "," vírus da hepatite B ");
Insert into acronimos(acronimo,expansao) values(" HCSA "," Hospital da Criança Santo Antônio ");
Insert into acronimos(acronimo,expansao) values(" HIC "," hemorragia intracraniana ");
Insert into acronimos(acronimo,expansao) values(" HM "," hipertermia maligna ");
Insert into acronimos(acronimo,expansao) values(" HMCs "," hemoculturas ");
Insert into acronimos(acronimo,expansao) values(" HNF "," heparina não-fracionada ");
Insert into acronimos(acronimo,expansao) values(" HTC "," hematócrito ");
Insert into acronimos(acronimo,expansao) values(" HX "," histórico ");
Insert into acronimos(acronimo,expansao) values(" Ht/Hb "," hematócrito/hemoglobina ");
Insert into acronimos(acronimo,expansao) values(" IA "," infarto agudo ");
Insert into acronimos(acronimo,expansao) values(" IAM's "," infartos agudos do miocárdio ");
Insert into acronimos(acronimo,expansao) values(" IF "," forma indeterminada ");
Insert into acronimos(acronimo,expansao) values(" IFN "," interferon alfa-recombinante ");
Insert into acronimos(acronimo,expansao) values(" IMT "," calibre intermediário da carótida ");
Insert into acronimos(acronimo,expansao) values(" IOT "," intubação orotraqueal ");
Insert into acronimos(acronimo,expansao) values(" IPC "," índice de potencial de contaminação ");
Insert into acronimos(acronimo,expansao) values(" ISHAK "," Ishak ");
Insert into acronimos(acronimo,expansao) values(" ISRS "," inibidor seletivo da recaptação de serotonina ");
Insert into acronimos(acronimo,expansao) values(" ITC "," insuficiência tricúspide ");
Insert into acronimos(acronimo,expansao) values(" IVa "," veia interventricular anterior ");
Insert into acronimos(acronimo,expansao) values(" IX "," 9 ");
Insert into acronimos(acronimo,expansao) values(" K2 "," potássio ");
Insert into acronimos(acronimo,expansao) values(" L2-L3 "," lombar 2 - lombar 3 ");
Insert into acronimos(acronimo,expansao) values(" L3 "," lombar 3 ");
Insert into acronimos(acronimo,expansao) values(" L4 "," lombar 4 ");
Insert into acronimos(acronimo,expansao) values(" L4-L5 "," lombar 4 - lombar 5 ");
Insert into acronimos(acronimo,expansao) values(" L5-S1 "," lombar 5 - sacro 1 ");
Insert into acronimos(acronimo,expansao) values(" LE "," laparotomia exploradora ");
Insert into acronimos(acronimo,expansao) values(" LFN "," linfonodos ");
Insert into acronimos(acronimo,expansao) values(" LI "," liquido intersticial ");
Insert into acronimos(acronimo,expansao) values(" LLA "," leucemia linfocítica aguda ");
Insert into acronimos(acronimo,expansao) values(" LLC "," leucemia linfocítica crônica ");
Insert into acronimos(acronimo,expansao) values(" LMC "," leucemia mielóide crônica ");
Insert into acronimos(acronimo,expansao) values(" LN "," linfonodo ");
Insert into acronimos(acronimo,expansao) values(" LNH "," linfoma não-Hodgkin ");
Insert into acronimos(acronimo,expansao) values(" LQR "," líquor ");
Insert into acronimos(acronimo,expansao) values(" LUTS "," sintomas do trato urinário inferior ");
Insert into acronimos(acronimo,expansao) values(" MELD "," modelo para doença hepática terminal ");
Insert into acronimos(acronimo,expansao) values(" MF "," microorganismos filamentosos ");
Insert into acronimos(acronimo,expansao) values(" MGCx "," ramo marginal da artéria circunflexa ");
Insert into acronimos(acronimo,expansao) values(" MGLIS "," artéria coronária marginal localizada intrastent ");
Insert into acronimos(acronimo,expansao) values(" MMG "," mamografia ");
Insert into acronimos(acronimo,expansao) values(" MMSS "," membros superiores ");
Insert into acronimos(acronimo,expansao) values(" MSS "," membros superiores ");
Insert into acronimos(acronimo,expansao) values(" MSSA "," Staphylococcus aureus sensível à meticilin ");
Insert into acronimos(acronimo,expansao) values(" MSs "," membros superiores ");
Insert into acronimos(acronimo,expansao) values(" Mg1 "," primeira marginal ");
Insert into acronimos(acronimo,expansao) values(" MsSs "," membros superiores ");
Insert into acronimos(acronimo,expansao) values(" NAC "," neuropatia autonômica cardiovascular ");
Insert into acronimos(acronimo,expansao) values(" NAN "," leite NAN ");
Insert into acronimos(acronimo,expansao) values(" ND "," nefropatia diabética ");
Insert into acronimos(acronimo,expansao) values(" NOV "," novembro ");
Insert into acronimos(acronimo,expansao) values(" NYHA "," Associação do Coração de Nova York ");
Insert into acronimos(acronimo,expansao) values(" Na3 "," potássio ");
Insert into acronimos(acronimo,expansao) values(" OEA "," otoemisiones acústicas ");
Insert into acronimos(acronimo,expansao) values(" OFT "," oftalmologia ");
Insert into acronimos(acronimo,expansao) values(" OUT "," outubro ");
Insert into acronimos(acronimo,expansao) values(" P4 "," parto 4 ");
Insert into acronimos(acronimo,expansao) values(" PAAf "," punção aspirativa por agulha fina ");
Insert into acronimos(acronimo,expansao) values(" PAC "," pneumonia adquirida na comunidade ");
Insert into acronimos(acronimo,expansao) values(" PASP "," pressão sistólica da artéria pulmonar ");
Insert into acronimos(acronimo,expansao) values(" PAVM "," pneumonia associada à ventilação mecânica ");
Insert into acronimos(acronimo,expansao) values(" PFE "," peso fetal estimado ");
Insert into acronimos(acronimo,expansao) values(" PICC "," catéter central de inserção periférica ");
Insert into acronimos(acronimo,expansao) values(" PNI "," psiconeuroimunologia ");
Insert into acronimos(acronimo,expansao) values(" PNM "," pneumonia ");
Insert into acronimos(acronimo,expansao) values(" PNP "," polineuropatia ");
Insert into acronimos(acronimo,expansao) values(" PO2 "," pressão parcial do oxigênio ");
Insert into acronimos(acronimo,expansao) values(" POP "," procedimento operacional padrão ");
Insert into acronimos(acronimo,expansao) values(" PS-MG "," Pronto Socorro de Minas Gerais ");
Insert into acronimos(acronimo,expansao) values(" PSG "," polissonografia ");
Insert into acronimos(acronimo,expansao) values(" PUCRS "," Pontifícia Universidade Católica do Rio Grande do Sul ");
Insert into acronimos(acronimo,expansao) values(" PVM "," prolapso da valva mitral ");
Insert into acronimos(acronimo,expansao) values(" R3 "," residente 3 ");
Insert into acronimos(acronimo,expansao) values(" RCR "," ressuscitação cardio-respiratória ");
Insert into acronimos(acronimo,expansao) values(" RCT "," rastreamento corporal total com radioiodo ");
Insert into acronimos(acronimo,expansao) values(" RDNPM "," retardo do desenvolvimento neuropsicomotor ");
Insert into acronimos(acronimo,expansao) values(" RDP "," retinopatia diabética proliferativa ");
Insert into acronimos(acronimo,expansao) values(" RE "," retículo esquerdo ");
Insert into acronimos(acronimo,expansao) values(" RHJ "," refluxo hepato-jugular ");
Insert into acronimos(acronimo,expansao) values(" RR "," risco relativo ");
Insert into acronimos(acronimo,expansao) values(" RT "," radioterapia ");
Insert into acronimos(acronimo,expansao) values(" RTX "," neurotoxina resiniferatoxina ");
Insert into acronimos(acronimo,expansao) values(" RUB "," rubéola ");
Insert into acronimos(acronimo,expansao) values(" S1 "," sacro 1 ");
Insert into acronimos(acronimo,expansao) values(" SAD "," sobrecarga atrial direita ");
Insert into acronimos(acronimo,expansao) values(" SAE "," sobrecarga atrial esquerda ");
Insert into acronimos(acronimo,expansao) values(" SCD "," seio coronário distal ");
Insert into acronimos(acronimo,expansao) values(" SMD "," síndrome mielodisplásica ");
Insert into acronimos(acronimo,expansao) values(" SOG "," sonda orogástrica ");
Insert into acronimos(acronimo,expansao) values(" SP "," sala de politraumatizados ");
Insert into acronimos(acronimo,expansao) values(" SPECT "," spect cardíaco ");
Insert into acronimos(acronimo,expansao) values(" SULFA "," sulfametoxazol ");
Insert into acronimos(acronimo,expansao) values(" T2 "," segunda torácica ");
Insert into acronimos(acronimo,expansao) values(" T12 "," torácica 12 ");
Insert into acronimos(acronimo,expansao) values(" T4L "," tetraiodotironina ");
Insert into acronimos(acronimo,expansao) values(" T:0,7 "," troponina 0 ");
Insert into acronimos(acronimo,expansao) values(" T:2,1 "," troponina 2 ");
Insert into acronimos(acronimo,expansao) values(" THB "," transtorno de humor bipolar ");
Insert into acronimos(acronimo,expansao) values(" TIG5 "," taxa de infusão de glicose ");
Insert into acronimos(acronimo,expansao) values(" TISQ "," tempo de isquemia ");
Insert into acronimos(acronimo,expansao) values(" TJV "," transfusão intravascular ");
Insert into acronimos(acronimo,expansao) values(" TMP "," trimetoprim ");
Insert into acronimos(acronimo,expansao) values(" TRAM "," retalho miocutâneo transverso abdominal ");
Insert into acronimos(acronimo,expansao) values(" TSC "," tiragem subcostal ");
Insert into acronimos(acronimo,expansao) values(" TSE "," spin-eco turbo ");
Insert into acronimos(acronimo,expansao) values(" TSH:5 "," hormônio tíreo-estimulante 5 ");
Insert into acronimos(acronimo,expansao) values(" TTG "," teste de tolerância a glicose ");
Insert into acronimos(acronimo,expansao) values(" TU "," trato urinário ");
Insert into acronimos(acronimo,expansao) values(" TVS "," taquicardias ventriculares monomórficas sustentadas ");
Insert into acronimos(acronimo,expansao) values(" TnT "," troponina ");
Insert into acronimos(acronimo,expansao) values(" TxH "," transplante hepático ");
Insert into acronimos(acronimo,expansao) values(" UCC "," Unidade de Cardiopatias Congênitas ");
Insert into acronimos(acronimo,expansao) values(" UFC "," unidades formadoras de colônia ");
Insert into acronimos(acronimo,expansao) values(" UR "," uréia ");
Insert into acronimos(acronimo,expansao) values(" URO "," urocultura ");
Insert into acronimos(acronimo,expansao) values(" VA-AD "," valvula anterior do átrio direito ");
Insert into acronimos(acronimo,expansao) values(" VANCO "," vancomicina ");
Insert into acronimos(acronimo,expansao) values(" VAS "," vias aéreas superiores ");
Insert into acronimos(acronimo,expansao) values(" VD17 "," ventrículo direito 17 ");
Insert into acronimos(acronimo,expansao) values(" VEd "," diástole do ventrículo esquerdo ");
Insert into acronimos(acronimo,expansao) values(" VEs "," sístole do ventrículo esquerdo ");
Insert into acronimos(acronimo,expansao) values(" VMA "," ácido vanilmandélico ");
Insert into acronimos(acronimo,expansao) values(" VR "," via retal ");
Insert into acronimos(acronimo,expansao) values(" Vo2 "," volume de oxigênio ");
Insert into acronimos(acronimo,expansao) values(" XII "," 12 ");
Insert into acronimos(acronimo,expansao) values(" b2 "," beta 2 ");
Insert into acronimos(acronimo,expansao) values(" g/dia "," grama/dia ");
Insert into acronimos(acronimo,expansao) values(" mVE "," massa ventricular esquerda ");
Insert into acronimos(acronimo,expansao) values(" mnmHg "," milímetros de mercúrio ");
Insert into acronimos(acronimo,expansao) values(" pCO2 "," pressão de dióxido de carbono ");
Insert into acronimos(acronimo,expansao) values(" r-x "," raio X ");
Insert into acronimos(acronimo,expansao) values(" s/n "," se necessário ");
Insert into acronimos(acronimo,expansao) values(" satO2 "," saturação de oxigênio ");
Insert into acronimos(acronimo,expansao) values(" vO "," via oral ");

-- -----------------------------------------------------
-- Table `intemed`.`usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `intemed`.`usuarios` ;

CREATE TABLE IF NOT EXISTS `intemed`.`usuarios` (
  `idUsuario` INT(10) NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(20) NOT NULL,
  `senha` VARCHAR(10) NULL DEFAULT NULL,
  `nome` VARCHAR(50) NULL DEFAULT NULL,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `usuario` (`usuario` ASC),
  UNIQUE INDEX `email` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

INSERT INTO `intemed`.`usuarios` VALUES (1,'root','root','root','root');


-- -----------------------------------------------------
-- Table `intemed`.`arquivos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `intemed`.`arquivos` ;

CREATE TABLE IF NOT EXISTS `intemed`.`arquivos` (
  `idUsuario` INT(11) NOT NULL,
  `idArquivo` INT(11) NOT NULL,
  `ordem` INT(11) NULL DEFAULT NULL,
  `absolutePath` VARCHAR(1000) NULL DEFAULT NULL,
  `nomeArquivo` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`idUsuario`, `idArquivo`),
  INDEX `arquivo` (`idArquivo` ASC),
  INDEX `idArquivo` (`idArquivo` ASC),
  CONSTRAINT `arquivos_ibfk_1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `intemed`.`usuarios` (`idUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `intemed`.`conjuntos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `intemed`.`conjuntos` ;

CREATE TABLE IF NOT EXISTS `intemed`.`conjuntos` (
  `idConjunto` INT(11) NOT NULL AUTO_INCREMENT,
  `nomeConjunto` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`idConjunto`),
  UNIQUE INDEX `nomeConjunto` (`nomeConjunto` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;

INSERT INTO `intemed`.`conjuntos` VALUES (1,'Teste');


-- -----------------------------------------------------
-- Table `intemed`.`elementos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `intemed`.`elementos` ;

CREATE TABLE IF NOT EXISTS `intemed`.`elementos` (
  `idElemento` INT(11) NOT NULL AUTO_INCREMENT,
  `nomeElemento` VARCHAR(100) NULL DEFAULT NULL,
  `descricaoElemento` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`idElemento`),
  UNIQUE INDEX `nomeElemento` (`nomeElemento` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


INSERT INTO `intemed`.`elementos` VALUES (1,'Paciente','Informações sobre o Paciente');

-- -----------------------------------------------------
-- Table `intemed`.`textos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `intemed`.`textos` ;

CREATE TABLE IF NOT EXISTS `intemed`.`textos` (
  `idUsuario` INT(11) NOT NULL DEFAULT '0',
  `idArquivo` INT(11) NOT NULL DEFAULT '0',
  `idTexto` INT(11) NOT NULL DEFAULT '0',
  `texto` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`idUsuario`, `idArquivo`, `idTexto`),
  INDEX `idArquivo` (`idArquivo` ASC),
  INDEX `texto` (`idTexto` ASC),
  CONSTRAINT `textos_ibfk_1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `intemed`.`usuarios` (`idUsuario`),
  CONSTRAINT `textos_ibfk_2`
    FOREIGN KEY (`idArquivo`)
    REFERENCES `intemed`.`arquivos` (`idArquivo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `intemed`.`execucoes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `intemed`.`execucoes` ;

CREATE TABLE IF NOT EXISTS `intemed`.`execucoes` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` INT(11) NULL DEFAULT NULL,
  `idArquivo` INT(11) NULL DEFAULT NULL,
  `dataExecucao` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `descricao` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idUsuario` (`idUsuario` ASC),
  INDEX `idArquivo` (`idArquivo` ASC),
  CONSTRAINT `execucoes_ibfk_1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `intemed`.`textos` (`idUsuario`),
  CONSTRAINT `execucoes_ibfk_2`
    FOREIGN KEY (`idArquivo`)
    REFERENCES `intemed`.`textos` (`idArquivo`))
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `intemed`.`frasesnegativas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `intemed`.`frasesnegativas` ;

CREATE TABLE IF NOT EXISTS `intemed`.`frasesnegativas` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `frase` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;

insert into frasesnegativas(frase) values('sem sinal');
insert into frasesnegativas(frase) values('sem sinais');
insert into frasesnegativas(frase) values('dentro da normalidade');
insert into frasesnegativas(frase) values('sem alterações');
insert into frasesnegativas(frase) values('não apresenta');
insert into frasesnegativas(frase) values('sem dilatação');


-- -----------------------------------------------------
-- Table `intemed`.`regras`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `intemed`.`regras` ;

CREATE TABLE IF NOT EXISTS `intemed`.`regras` (
  `idUsuario` INT(11) NULL DEFAULT NULL,
  `idRegra` INT(11) NOT NULL DEFAULT '0',
  `idConjunto` INT(11) NULL DEFAULT NULL,
  `idElemento` INT(11) NULL DEFAULT NULL,
  `dataRegra` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `previa` VARCHAR(100) NULL DEFAULT NULL,
  `texto` VARCHAR(100) NULL DEFAULT NULL,
  `idTexto` INT(11) NULL DEFAULT NULL,
  `idArquivo` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idRegra`),
  INDEX `idUsuario` (`idUsuario` ASC),
  INDEX `idConjunto` (`idConjunto` ASC),
  INDEX `idElemento` (`idElemento` ASC),
  INDEX `idArquivo` (`idArquivo` ASC),
  INDEX `idRegra` (`idRegra` ASC),
  CONSTRAINT `regras_ibfk_1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `intemed`.`usuarios` (`idUsuario`),
  CONSTRAINT `regras_ibfk_2`
    FOREIGN KEY (`idConjunto`)
    REFERENCES `intemed`.`conjuntos` (`idConjunto`),
  CONSTRAINT `regras_ibfk_3`
    FOREIGN KEY (`idElemento`)
    REFERENCES `intemed`.`elementos` (`idElemento`),
  CONSTRAINT `regras_ibfk_4`
    FOREIGN KEY (`idArquivo`)
    REFERENCES `intemed`.`arquivos` (`idArquivo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `intemed`.`regrasexecucao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `intemed`.`regrasexecucao` ;

CREATE TABLE IF NOT EXISTS `intemed`.`regrasexecucao` (
  `idExecucao` INT(11) NOT NULL DEFAULT '0',
  `idRegra` INT(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idExecucao`, `idRegra`),
  INDEX `idRegra` (`idRegra` ASC),
  CONSTRAINT `regrasexecucao_ibfk_1`
    FOREIGN KEY (`idExecucao`)
    REFERENCES `intemed`.`execucoes` (`id`),
  CONSTRAINT `regrasexecucao_ibfk_2`
    FOREIGN KEY (`idRegra`)
    REFERENCES `intemed`.`regras` (`idRegra`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `intemed`.`subregras`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `intemed`.`subregras` ;

CREATE TABLE IF NOT EXISTS `intemed`.`subregras` (
  `idRegra` INT(11) NOT NULL DEFAULT '0',
  `idSubregra` INT(11) NOT NULL DEFAULT '0',
  `dataRegra` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `previa` VARCHAR(100) NULL DEFAULT NULL,
  `texto` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`idRegra`, `idSubregra`),
  INDEX `idSubregra` (`idSubregra` ASC),
  CONSTRAINT `subregras_ibfk_1`
    FOREIGN KEY (`idRegra`)
    REFERENCES `intemed`.`regras` (`idRegra`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `intemed`.`resultados`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `intemed`.`resultados` ;

CREATE TABLE IF NOT EXISTS `intemed`.`resultados` (
  `idTexto` INT(11) NULL DEFAULT NULL,
  `idExecucao` INT(11) NULL DEFAULT NULL,
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `trechoEncontrado` TEXT NULL DEFAULT NULL,
  `idRegra` INT(11) NULL DEFAULT NULL,
  `idSubregra` INT(11) NULL DEFAULT NULL,
  `isSubregra` TINYINT(1) NULL DEFAULT NULL,
  `comentario` TEXT NULL DEFAULT NULL,
  `isEncontrado` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idTexto` (`idTexto` ASC),
  INDEX `idExecucao` (`idExecucao` ASC),
  INDEX `idRegra` (`idRegra` ASC),
  INDEX `idSubregra` (`idSubregra` ASC),
  CONSTRAINT `resultados_ibfk_1`
    FOREIGN KEY (`idTexto`)
    REFERENCES `intemed`.`textos` (`idTexto`),
  CONSTRAINT `resultados_ibfk_2`
    FOREIGN KEY (`idExecucao`)
    REFERENCES `intemed`.`execucoes` (`id`),
  CONSTRAINT `resultados_ibfk_3`
    FOREIGN KEY (`idRegra`)
    REFERENCES `intemed`.`regras` (`idRegra`),
  CONSTRAINT `resultados_ibfk_4`
    FOREIGN KEY (`idSubregra`)
    REFERENCES `intemed`.`subregras` (`idSubregra`))
ENGINE = InnoDB
AUTO_INCREMENT = 4402
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `intemed`.`tabelamt`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `intemed`.`tabelamt` ;

CREATE TABLE IF NOT EXISTS `intemed`.`tabelamt` (
  `palavra` VARCHAR(25) NOT NULL DEFAULT '',
  `mt` VARCHAR(25) NOT NULL DEFAULT '',
  PRIMARY KEY (`palavra`, `mt`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `intemed`.`termosregras`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `intemed`.`termosregras` ;

CREATE TABLE IF NOT EXISTS `intemed`.`termosregras` (
  `idRegra` INT(11) NOT NULL DEFAULT '0',
  `idTermo` INT(11) NOT NULL DEFAULT '0',
  `ordem` INT(11) NULL DEFAULT NULL,
  `termo` VARCHAR(60) NULL DEFAULT NULL,
  PRIMARY KEY (`idRegra`, `idTermo`),
  CONSTRAINT `termosregras_ibfk_1`
    FOREIGN KEY (`idRegra`)
    REFERENCES `intemed`.`regras` (`idRegra`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `intemed`.`termossubregras`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `intemed`.`termossubregras` ;

CREATE TABLE IF NOT EXISTS `intemed`.`termossubregras` (
  `idRegra` INT(11) NOT NULL DEFAULT '0',
  `idSubRegra` INT(11) NOT NULL DEFAULT '0',
  `idTermo` INT(11) NOT NULL DEFAULT '0',
  `ordem` INT(11) NULL DEFAULT NULL,
  `termo` VARCHAR(60) NULL DEFAULT NULL,
  PRIMARY KEY (`idRegra`, `idSubRegra`, `idTermo`),
  CONSTRAINT `termossubregras_ibfk_1`
    FOREIGN KEY (`idRegra` , `idSubRegra`)
    REFERENCES `intemed`.`subregras` (`idRegra` , `idSubregra`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `intemed`.`textorapidminer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `intemed`.`textorapidminer` ;

CREATE TABLE IF NOT EXISTS `intemed`.`textorapidminer` (
  `datahora` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `texto` TEXT NULL DEFAULT NULL,
  `idTexto` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`datahora`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
