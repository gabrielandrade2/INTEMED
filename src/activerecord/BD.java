package activerecord;
import br.gpri.nlp.Tagger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import activerecord.Dicionario;
import com.mysql.jdbc.PreparedStatement;

public class BD extends ActiveRecord {
	
	public Login selectLogin(String usuario){
		Login Login = new Login();
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT idUsuario, usuario, senha from usuarios WHERE usuario = '"+usuario+"';");
		    ResultSet res = ps.executeQuery();
		    while(res.next()){
		    	Login.setId(res.getInt("idUsuario"));
		    	Login.setUsuario(res.getString("Usuario"));
		    	Login.setSenha(res.getString("Senha"));
		    }
		    
		    return Login;
		    
		}
		catch(SQLException e){
			e.printStackTrace();
		}
                
                catch(NullPointerException e){
			bdNaoExiste();
		}
		return Login;
			
	}
	
	public Stack<Arquivo> selectArquivos(int idUsuario){
		
		Stack<Arquivo> arquivosRecentes = new Stack<Arquivo>();
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT idArquivo, ordem,nomeArquivo, absolutePath from arquivos WHERE idUsuario = "+idUsuario+" ORDER BY ordem ASC;");
		    ResultSet res = ps.executeQuery();
		    while(res.next()){
		    	Arquivo a = new Arquivo();
		    	a.setId(res.getInt("idArquivo"));
		    	a.setNome(res.getString("nomeArquivo"));
		    	a.setCaminho(res.getString("absolutePath"));
		    	arquivosRecentes.push(a);
		    }
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return arquivosRecentes;
	}
	
	private void limpaArquivosUsuario(int idUsuario){
		try{
				PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE arquivos set ordem = null where idUsuario ="+idUsuario+";");
				ps.execute();
	    }
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public boolean insertArquivos(int idUsuario,Stack<Arquivo> arquivosRecentes){
		try{
			Arquivo a = arquivosRecentes.elementAt(0);
			PreparedStatement ps;
			ps = (PreparedStatement) con.prepareStatement("INSERT INTO arquivos values("+idUsuario+","+a.getId()+","+null+",'"+a.getCaminho()+"','"+a.getNome()+"');");
			ps.execute();
			atualizaArquivos(idUsuario, arquivosRecentes);
		    return false;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return true;
	}

	public boolean atualizaArquivos(int idUsuario,Stack<Arquivo> arquivosRecentes){
		limpaArquivosUsuario(idUsuario);
		try{
			for(int i=0; i<arquivosRecentes.size(); i++){
				Arquivo a = arquivosRecentes.elementAt(i);
				PreparedStatement ps;
				ps = (PreparedStatement) con.prepareStatement("UPDATE arquivos set ordem ="+i+" where idUsuario ="+idUsuario+" AND idArquivo="+a.getId()+";");
				ps.execute();
		    }
		    return false;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return true;
	}
	
	
	public int selectMaxIdArquivo(int idUsuario){
		int maxId = 0;
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT MAX(idArquivo)+1 FROM arquivos where idUsuario ="+idUsuario+";");
			ResultSet res = ps.executeQuery();
			while(res.next()){
				 maxId = res.getInt(1);
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		return maxId;
	}
	
	public List<Elemento> selectElemento(){
		List<Elemento> Lista = new ArrayList<Elemento>();
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM elementos;"); //Talvez separar por usuario
			ResultSet res = ps.executeQuery();
			while(res.next()){
				Elemento Elemento = new Elemento();
				Elemento.setId(res.getInt("idElemento"));
				Elemento.setNome(res.getString("nomeElemento"));
				Elemento.setDescricao(res.getString("descricaoElemento"));
				Lista.add(Elemento);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return Lista;
	}
	
	public List<Conjunto> selectConjunto(){
		List<Conjunto> Lista = new ArrayList<Conjunto>();
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM conjuntos;"); 
			ResultSet res = ps.executeQuery();
			while(res.next()){
				Conjunto Conjunto= new Conjunto();
				Conjunto.setId(res.getInt("idConjunto"));
				Conjunto.setNome(res.getString("nomeConjunto"));
				Lista.add(Conjunto);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return Lista;
	}
	
	public Regra selectRegra(int idUsuario, int idRegra){
		Regra r = new Regra();
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM regras WHERE (idUsuario="+idUsuario+" AND idRegra="+idRegra+");");
			ResultSet res = ps.executeQuery();
			while(res.next()){
				r.setId(idRegra);
				r.setPrevia(res.getString("previa"));
				r.setTexto(res.getString("texto"));
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		return r;
}
	
	public List<Regra> selectRegraCadastro(int idTexto, int idArquivo, int idUsuario){
		List<Regra> Lista = new ArrayList<Regra>();
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT idRegra,previa,texto FROM regras WHERE (idTexto="+idTexto+" AND idArquivo='"+idArquivo+"' AND idUsuario="+idUsuario+");");
			ResultSet res = ps.executeQuery();
			while(res.next()){
				Regra r = new Regra();
				r.setId(res.getInt("idRegra"));
				r.setPrevia(res.getString("previa"));
				r.setTexto(res.getString("texto"));
				Lista.add(r);
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		return Lista;
}
	
	public List<Regra> selectRegras(int idUsuario, int idConjunto, int idElemento, int idExecucao){ // Select das regras para fazer a execução
		List<Regra> Lista = new ArrayList<Regra>();
		PreparedStatement ps = null;
		try{
                    
                    //Não entendi o porque do count(*) a e do porque do produto cartesiano com a tabela termosregras **Gabriel
                    if(idExecucao == 0){
			if(idConjunto == 0 && idElemento == 0)
				ps = (PreparedStatement) con.prepareStatement("SELECT count(*) a, regras.idRegra,previa,texto,regras.idElemento,idConjunto FROM regras, termosregras WHERE (regras.idregra=termosregras.idregra and idUsuario="+idUsuario+") group by regras.idregra order by a desc;");
			else if(idConjunto == 0)
				ps = (PreparedStatement) con.prepareStatement("SELECT count(*) a, regras.idRegra,previa,texto,regras.idElemento,idConjunto FROM regras, termosregras WHERE (regras.idregra=termosregras.idregra and idUsuario="+idUsuario+" AND idElemento="+idElemento+") group by regras.idregra order by a desc;");
			else if(idElemento == 0)
				ps = (PreparedStatement) con.prepareStatement("SELECT count(*) a, regras.idRegra,previa,texto,regras.idElemento,idConjunto FROM regras, termosregras WHERE (regras.idregra=termosregras.idregra and idUsuario="+idUsuario+" AND idConjunto="+idConjunto+") group by regras.idregra order by a desc;");
			else
				ps = (PreparedStatement) con.prepareStatement("SELECT count(*) a, regras.idRegra,previa,texto,regras.idElemento,idConjunto FROM regras, termosregras WHERE (regras.idregra=termosregras.idregra and idUsuario="+idUsuario+" AND idElemento="+idElemento+" AND idConjunto="+idConjunto+") group by regras.idregra order by a desc;");
                    }
                    else
                       if(idConjunto == 0 && idElemento == 0)
				ps = (PreparedStatement) con.prepareStatement("SELECT count(*) a, regras.idRegra,previa,texto,regras.idElemento,idConjunto FROM regrasexecucao inner join regras on regrasexecucao.idRegra = regras.idRegra where idUsuario = "+idUsuario+" and idExecucao ="+idExecucao+" group by regras.idregra order by a desc;");
			else if(idConjunto == 0)
				ps = (PreparedStatement) con.prepareStatement("SELECT count(*) a, regras.idRegra,previa,texto,regras.idElemento,idConjunto FROM regrasexecucao inner join regras on regrasexecucao.idRegra = regras.idRegra where idUsuario = "+idUsuario+" and idExecucao ="+idExecucao+" and idElemento = "+idElemento+" group by regras.idregra order by a desc;");
			else if(idElemento == 0)
				ps = (PreparedStatement) con.prepareStatement("SELECT count(*) a, regras.idRegra,previa,texto,regras.idElemento,idConjunto FROM regrasexecucao inner join regras on regrasexecucao.idRegra = regras.idRegra where idUsuario = "+idUsuario+" and idExecucao ="+idExecucao+" and idConjunto = "+idConjunto+" group by regras.idregra order by a desc;");
			else
				ps = (PreparedStatement) con.prepareStatement("SELECT count(*) a, regras.idRegra,previa,texto,regras.idElemento,idConjunto FROM regrasexecucao inner join regras on regrasexecucao.idRegra = regras.idRegra where idUsuario = "+idUsuario+" and idExecucao ="+idExecucao+" and idConjunto = "+idConjunto+" and idElemento = "+idElemento+"group by regras.idregra order by a desc;");
                                        
			ResultSet res = ps.executeQuery();
			while(res.next()){
				Regra r = new Regra();
				r.setId(res.getInt("regras.idRegra"));
				r.setPrevia(res.getString("previa"));
				r.setTexto(res.getString("texto"));
				r.setElemento(res.getInt("regras.idElemento"));
				r.setConjunto(res.getInt("idConjunto"));
				Lista.add(r);
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		return Lista;
}
	
	public List<Subregra> selectSubRegras(Regra r){
		int idRegra = r.getId();
		List<Subregra> Lista = new ArrayList<Subregra>();
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM subregras WHERE idRegra="+idRegra+";");
			ResultSet res = ps.executeQuery();
			while(res.next()){
					Subregra s = new Subregra();
					s.setIdRegra(idRegra);
					s.setId(res.getInt("idSubregra"));
					s.setPrevia(res.getString("previa"));
					s.setTexto(res.getString("texto"));
					Lista.add(s);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return Lista;
	}
	
	
	public Subregra selectSubRegra(int idRegra, int idSubregra){
		Subregra s = new Subregra();
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT previa,texto FROM subregras WHERE idRegra="+idRegra+" AND idSubregra="+idSubregra+";");
			ResultSet res = ps.executeQuery();
			while(res.next()){
					s.setIdRegra(idRegra);
					s.setId(idSubregra);
					s.setPrevia(res.getString("previa"));
					s.setTexto(res.getString("texto"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return s;
	}
	
	
	public Regra selectTermoRegra(Regra r){
		List<Termo> Lista = new ArrayList<Termo>();
		int idRegra = r.getId();
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM termosregras WHERE idRegra="+idRegra+" order by idTermo;");
			ResultSet res = ps.executeQuery();
			while(res.next()){
				Termo t = new Termo();
				t.setIdRegra(idRegra);
				t.setIdTermo(res.getInt("idTermo"));
				t.setOrdem(res.getInt("ordem"));
				t.setTermo(res.getString("termo"));
				Lista.add(t);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		r.setTermos(Lista);
		return r;
	}
	
	public Subregra selectTermoSubregra(Subregra s){
		List<Termo> Lista = new ArrayList<Termo>();
		int idRegra = s.getIdRegra();
		int idSubregra = s.getId();
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM termossubregras WHERE idRegra="+idRegra+" AND idSubRegra="+idSubregra+";");
			ResultSet res = ps.executeQuery();
			while(res.next()){
				Termo t = new Termo();
				t.setIdRegra(idRegra);
				t.setIdSubregra(idSubregra);
				t.setIdTermo(res.getInt("idTermo"));
				t.setOrdem(res.getInt("ordem"));
				t.setTermo(res.getString("termo"));
				Lista.add(t);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		s.setTermos(Lista);
		return s;
	}
	
	public boolean insertRegra(int idUsuario, Regra r){
		boolean erro = true;
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO regras (idUsuario,idRegra,idConjunto,idElemento,previa,texto,idTexto,idArquivo) VALUES ("+idUsuario+","+r.getId()+","+r.getConjunto()+","+r.getElemento()+",'"+r.getPrevia()+"','"+r.getTexto()+"',"+r.getIdTexto()+",'"+r.getIdArquivo()+"');");		
			 erro = ps.execute();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		erro = insertTermosRegras(r.getTermos()); 
		return erro;
		
	}
	
	public boolean insertTermosRegras(List<Termo> termosregras){
		boolean erro = true;
		for(int i=0; i<termosregras.size(); i++){
			try{
				Termo t = termosregras.get(i);
				PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO termosregras VALUES ("+t.getIdRegra()+","+t.getIdTermo()+","+t.getOrdem()+",'"+t.getTermo()+"');");		
				 erro = ps.execute();
				 if(erro == true)
					 break;
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		 
		return erro;
	}
	
	public int selectMaxIdRegra(){
		int maxId = 1;
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT MAX(idRegra)+1 FROM regras;");
			ResultSet res = ps.executeQuery();
			while(res.next()){
				 maxId = res.getInt(1)+1;
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		return maxId;
	}
	
	public boolean insertSubRegra(Subregra s){
		boolean erro = true;
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO subregras (idRegra, idSubregra, previa, texto) VALUES ("+s.getIdRegra()+","+s.getId()+",'"+s.getPrevia()+"','"+s.getTexto()+"');");		
			 erro = ps.execute();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
			
		erro = insertTermosSubRegras(s.getTermos()); 
		return erro;
		
	}
	
	public boolean insertTermosSubRegras(List<Termo> termossubregras){
		boolean erro = true;
		for(int i=0; i<termossubregras.size(); i++){
			try{
				Termo t = termossubregras.get(i);
				PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO termossubregras VALUES ("+t.getIdRegra()+","+t.getIdSubregra()+","+t.getIdTermo()+","+t.getOrdem()+",'"+t.getTermo()+"');");		
				 erro = ps.execute();
				 if(erro == true)
					 break;
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		 
		return erro;
	}
	
	public int selectMaxIdSubRegra(int idRegra){
		int maxId = 1;
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT MAX(idSubRegra) FROM subregras WHERE idRegra = "+idRegra+";");
			ResultSet res = ps.executeQuery();
			while(res.next()){
				 maxId = res.getInt(1)+1;
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		return maxId;
	}
	
	public boolean insertUsuario(String usuario, String senha, String nome, String email){
		
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO usuarios (Usuario,Senha,Nome,Email) VALUES('"+usuario+"','"+senha+"','"+nome+"','"+email+"');");		
			boolean erro = ps.execute();
			return erro;}
		
		catch (SQLException e) {
			System.out.println("Erro ao efetuar Insert");
			e.printStackTrace();
                }
                catch(NullPointerException e){
			bdNaoExiste();
		}
                
		return false;
		}
        
        public boolean insertConjunto(String textoConjunto){
        
            try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO conjuntos (nomeConjunto) VALUES('"+textoConjunto+"');");		
			boolean erro = ps.execute();
			return erro;}
		
		catch (SQLException e) {
			System.out.println("Erro ao efetuar Insert");
			e.printStackTrace();}
		return false;
            
        }
        
	
	public String selectTexto(int idUsuario, int idArquivo, int idTexto){
		String texto = new String();
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT texto from textos WHERE idUsuario="+idUsuario+" AND idArquivo="+idArquivo+" AND idTexto="+idTexto+";");
			ResultSet res = ps.executeQuery();
			while(res.next()){
				 texto = res.getString("texto");
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
			texto="Erro Banco de Dados";
		}
		return texto;
	}
	
	public List<String> selectTextos(int idUsuario, int idArquivo){
		List<String> textos = new ArrayList<String>();
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT texto from textos WHERE idUsuario="+idUsuario+" AND idArquivo="+idArquivo+" ORDER BY idTexto;");
			ResultSet res = ps.executeQuery();
			while(res.next()){
				String texto;
				texto = res.getString("texto");
				textos.add(texto);
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return textos;
	}
	
	public int getNumTextos(int idUsuario, int idArquivo){
		int numTextos=0;
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT Count(*) from textos WHERE idUsuario="+idUsuario+" AND idArquivo="+idArquivo+";");
			ResultSet res = ps.executeQuery();
			while(res.next()){
				 numTextos = (res.getInt(1));
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		return numTextos;
	}
	
	public boolean importaTexto(int idUsuario, int idArquivo, int idTexto, String texto){
		boolean erro = true;
		if(!texto.equals("")){
			try{
				PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO textos VALUES ("+idUsuario+","+idArquivo+","+idTexto+",'"+texto+"');");		
				 erro = ps.execute();
				 erro = false;
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return erro;
	}
	
	public int selectIdArquivo(String caminhoArquivo){
		int id = -1;
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT idArquivo from arquivos where absolutePath='"+caminhoArquivo+"';");
			ResultSet res = ps.executeQuery();
			while(res.next()){
				 id = res.getInt("idArquivo");
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		return id;
	}
	
	private int countTextos(int idArquivo){
		int countTextos = 0;
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT Count(*) from textos where idArquivo="+idArquivo+";");
			ResultSet res = ps.executeQuery();
			while(res.next()){
				countTextos = res.getInt("Count(*)");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return countTextos;
	}
	

	
	public List<Resultados> selectResultados(int idExecucao, int idArquivo, int idUsuario){
		List<String> trechosDistintos = selectDistinctTrechoEncontrado(idExecucao, idArquivo, idUsuario);
		List<Resultados> lista = new ArrayList<Resultados>();
		
		List<String> textos = selectTextos(idUsuario, idArquivo);
		
		int idTexto =-1;
		int idTextoAnt=-1;
		boolean once = true;
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(
 "select exe.id, exe.idusuario,exe.idarquivo,exe.idarquivo,"
 + "res.idtexto,res.idexecucao,res.id,res.trechoencontrado,res.idregra,res.idsubregra, res.issubregra, "
 + "res.comentario, res.isEncontrado, reg.idusuario,reg.idregra,reg.idconjunto,reg.idelemento,reg.dataregra,reg.previa,reg.texto,"
 + "reg.idtexto,reg.idarquivo,sub.idregra,sub.idsubregra,sub.dataregra,sub.previa,sub.texto, txt.texto "
 + "from intemed.resultados res left outer join intemed.subregras sub on res.idsubregra=sub.idsubregra and res.idregra=sub.idregra,"
     + " intemed.regras reg, intemed.textos txt, intemed.execucoes exe "
     + "where res.idregra=reg.idregra and res.idtexto=txt.idtexto and exe.idarquivo=txt.idarquivo and "
     + "exe.idusuario=txt.idusuario and exe.id=res.idexecucao and exe.id="+idExecucao
     + " order by res.id;");
		ResultSet res = ps.executeQuery();
		Resultados ResultadoTexto = new Resultados();
				while(res.next()){
					if(once){
						idTexto = res.getInt("res.idTexto");
						once = false;
					}
					if(!(res.getInt("res.idTexto") == idTexto)){
						lista.add(ResultadoTexto);
						ResultadoTexto = new Resultados();
						idTexto = res.getInt("res.idTexto");
					}
					
					ResultadoTexto.setTexto(res.getString("txt.texto")); //Adiciona texto no objeto resultado
					ResultadoTexto.setIsEncontrado(res.getBoolean("res.isEncontrado")); //Verifica se é resultado encontrado ou não
					
                                            TrechoEncontrado t = new TrechoEncontrado();
                                            if(res.getInt("res.isSubregra") == 1){
                                                Subregra s = new Subregra();
                                                s.setIdRegra(res.getInt("res.idRegra"));
                                                s.setId(res.getInt("res.idSubregra"));
                                                s.setPrevia(res.getString("sub.previa"));
                                                s.setTexto(res.getString("sub.texto"));
                                                t.setSubregra(s);
                                                t.setIsSubregra(true);
                                            }
                                        Regra r = new Regra();
                                    r.setId(res.getInt("res.idRegra"));
                                    r.setPrevia(res.getString("reg.previa"));
                                    r.setTexto(res.getString("reg.texto"));
		
					t.setRegra(r);
					t.setTrechoEncontrado(res.getString("res.trechoEncontrado"));
					t.setidResultado(res.getInt("res.id"));
    //executar médoto passando a lista e o idtexto para que este método faça os edits e inserts
					int idTexto2=res.getInt("res.idTexto");
					if(idTextoAnt!=idTexto2)
					{
//						insereRapidMiner(trechosDistintos, idExecucao, idArquivo, idUsuario, idTexto2);
						idTextoAnt=idTexto2;
					}
					ResultadoTexto.addTrecho(t);
				}
				
			}
			
			catch(SQLException e){
				e.printStackTrace();
			}
			
		
		return lista;
	}

	
	
	public List<String> selectDistinctTrechoEncontrado(int idExecucao, int idArquivo, int idUsuario){
			System.gc();
                        List<String> lista = new ArrayList<String>();
			try{
				PreparedStatement psResultado = (PreparedStatement) con.prepareStatement(
				"SELECT count(*) a, trechoencontrado FROM intemed.resultados where idexecucao=" +idExecucao+
                                   " group by trechoencontrado having a>50  order by a;");
				ResultSet res = psResultado.executeQuery();
				while(res.next()){
					lista.add(res.getString("trechoEncontrado"));
					}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			
			
		
		return lista;
	}
	
	public List<String> selectDistinctTrechoEncontradoDeUmResultado(int idExecucao, int idArquivo, int idUsuario, int idTexto){
		List<String> lista = new ArrayList<String>();
		try{
			PreparedStatement psResultado = (PreparedStatement) con.prepareStatement(
			"SELECT distinct(trechoencontrado) FROM resultados WHERE idExecucao="+idExecucao+" and idTexto="+idTexto+";");
			ResultSet res = psResultado.executeQuery();
			while(res.next()){
				lista.add(res.getString("trechoEncontrado"));
				}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		
	
	return lista;
}

	public boolean insereRapidMiner(List<String> trechosDistintos,int idExecucao, int idArquivo, int idUsuario, int idTexto)
	{
		try{
			List<String> trechosDistintosDeUmResultado = 
					selectDistinctTrechoEncontradoDeUmResultado(idExecucao, idArquivo, idUsuario,idTexto);
			PreparedStatement psResultado = (PreparedStatement) con.prepareStatement(
"SELECT texto FROM textos WHERE idTexto="+idTexto+";");
			ResultSet res = psResultado.executeQuery();
			while(res.next()){
				String td="";

				Tagger tg=new Tagger(this);
				String textoAuxiliar=tg.sentencaRapidMiner(res.getString("texto"));
				
				for(int i=0;i<trechosDistintosDeUmResultado.size();i++)
				{
					td = trechosDistintosDeUmResultado.get(i);
					td=td.trim();
					textoAuxiliar=textoAuxiliar.replace(td + " ", td.replace(" ", "_")+"_SIM ");
				}
				for(int i=0;i<trechosDistintos.size();i++)
				{
					td = trechosDistintos.get(i);
					td=td.trim();
					if(!textoAuxiliar.contains(td.replace(" ", "_")))
					{
						textoAuxiliar=textoAuxiliar.concat(td.replace(" ", "_")+"_NAO ");
					}
				}
				PreparedStatement ps2 = null;
				ps2 = (PreparedStatement) con.prepareStatement(
				"INSERT into textosRapidMiner(idtexto,texto) values ("+idTexto+", '"+textoAuxiliar+"');");
				boolean erro = ps2.execute();
				erro = false;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return true;
	}

	public boolean insertResultados(Resultados ResultadoTexto, int idTexto, int idExecucao){
		
		List<TrechoEncontrado> encontrados = ResultadoTexto.getTrechos();
		boolean erro = true;
		
		for(int i=0; i<encontrados.size(); i++){
			TrechoEncontrado t = encontrados.get(i);
			String trecho = t.getTrechoEncontrado();
			
			try{
				PreparedStatement ps = null;
				if(t.isSubregra())
				{
						Subregra sr = t.getSubregra();
						int idSubregra = sr.getId();
						int idRegra = sr.getIdRegra();
						ps = (PreparedStatement) con.prepareStatement("INSERT into resultados(idTexto, idExecucao, trechoEncontrado, idRegra, idSubregra,isSubregra, isEncontrado) values ("+idTexto+","+idExecucao+",'"+trecho+"',"+idRegra+","+idSubregra+",1,1);");
				}
				else
				{
				if(t.hasRegra()){
					Regra r = t.getRegra();
					int idRegra = r.getId();
					ps = (PreparedStatement) con.prepareStatement("INSERT into resultados(idTexto, idExecucao, trechoEncontrado, idRegra,isSubregra, isEncontrado) values ("+idTexto+","+idExecucao+",'"+trecho+"',"+idRegra+",0,1);");
				}
				
				else
					ps = (PreparedStatement) con.prepareStatement("INSERT into resultados(idTexto, idExecucao, trechoEncontrado, isEncontrado) values ("+idTexto+","+idExecucao+",'Nada Encontrado',0);");
				}
				 erro = ps.execute();
				 erro = false;
				}
			catch(SQLException e){
				e.printStackTrace();
				erro = true;
			}
			
		}
		return erro;
	}
	
	
	public int insertExecucao(int idUsuario, int idArquivo, String descricao){
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT into execucoes(idUsuario,idArquivo,descricao) values("+idUsuario+","+idArquivo+",'"+descricao+"');");
			ps.execute();
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Falha ao inserir execução");
		}
		int id = -1;
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("Select MAX(id) from execucoes;");
			ResultSet res = ps.executeQuery();
			while(res.next())
				 id = res.getInt(1);
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Erro ao recuperar id execução");
		}
		return id;
	}
        
        public boolean removeExecucao(int idExecucao){
            boolean erro = false;
            try{
                        PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE from resultados where idExecucao="+idExecucao+";");
                        ps.execute();
                        System.out.println("Resultados removidos com sucesso");
                        
                        ps = (PreparedStatement) con.prepareStatement("DELETE from execucoes where idExecucao="+idExecucao+";");
			ps.execute();
                        System.out.println("Execução removida com sucesso");
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Falha ao remover execução");
                        erro = true;
		}
		return erro;
        }
	
	public boolean insertRegrasExecucao(int idExecucao, List<Regra> regrasSelecionadas){
		boolean erro = false;
		for(int i=0; i< regrasSelecionadas.size(); i++){
			Regra r = regrasSelecionadas.get(i);
			int idRegra = r.getId();
			try{
				PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT into regrasexecucao values("+idExecucao+","+idRegra+");");
				ps.execute();
			}
			catch(SQLException e){
				e.printStackTrace();
				System.out.println("Falha ao armazenar regras da execucao: "+i);
				erro = true;
			}	
		}
		return erro;
	}
	
        public List<Regra> selectRegrasExecucao(int idExecucao){
                List<Regra> listaRegras = new ArrayList<Regra>();
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT previa,texto FROM regrasexecucao INNER JOIN regras ON regrasexecucao.idRegra = regras. idRegra WHERE idExecucao="+idExecucao+";");
			ResultSet res = ps.executeQuery();
			while(res.next()){
                                Regra r = new Regra();
                                r.setPrevia(res.getString("previa"));
				r.setTexto(res.getString("texto"));
				listaRegras.add(r);
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
                        return null;
		}
                return listaRegras;
        }
	
	private int selectMaxIdResultados(int idUsuario, int idArquivo, int idTexto){
		int maxId = 0;
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT MAX(id)+1 from resultados WHERE idUsuario="+idUsuario+" AND idArquivo="+idArquivo+" and idTexto="+idTexto+";");
			ResultSet res = ps.executeQuery();
			while(res.next()){
				 maxId = res.getInt(1);
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		return maxId;
	}
	
	public List<Execucao> selectExecucoes(int idUsuario){
		List<Execucao> execucoes = new ArrayList<Execucao>();
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT id,dataExecucao,nomeArquivo,execucoes.idArquivo,execucoes.descricao from execucoes JOIN arquivos ON execucoes.idArquivo = arquivos.idArquivo WHERE execucoes.idUsuario="+idUsuario+" ORDER BY dataExecucao DESC;");
			ResultSet res = ps.executeQuery();
			while(res.next()){
				Execucao e = new Execucao();
				e.setId(res.getInt("id"));
				e.setData(res.getString("dataExecucao"));
				e.setArquivo(res.getString("nomeArquivo"));
				e.setIdArquivo(res.getInt("idArquivo"));
                                e.setDescricao(res.getString("descricao")); //Inserir no BD alter table execucoes add column descricao text;
				execucoes.add(e);
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
	
		return execucoes;
	}
	
	public List<Execucao> selectExecucoes(int idUsuario, int idArquivo){
	List<Execucao> execucoes = new ArrayList<Execucao>();
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT id,dataExecucao,nomeArquivo,execucoes.idArquivo,execucoes.descricao from execucoes JOIN arquivos ON execucoes.idArquivo = arquivos.idArquivo WHERE execucoes.idUsuario="+idUsuario+" AND execucoes.idArquivo="+idArquivo+" ORDER BY dataExecucao DESC;");
			ResultSet res = ps.executeQuery();
			while(res.next()){
				Execucao e = new Execucao();
				e.setId(res.getInt("id"));
                                e.setIdArquivo(res.getInt("idArquivo"));
				e.setData(res.getString("dataExecucao"));
				e.setArquivo(res.getString("nomeArquivo"));
				e.setDescricao(res.getString("descricao"));  //Inserir no BD alter table execucoes add column descricao text;
                                
				execucoes.add(e);
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
	
		return execucoes;
	}
	
	public List<Acronimo> selectAcronimos(){
		List<Acronimo> acronimos = new ArrayList<Acronimo>();
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * from acronimos");
			ResultSet res = ps.executeQuery();
			while(res.next()){
				Acronimo a = new Acronimo();
				a.setId(res.getInt("id"));
				a.setAcronimo(res.getString("acronimo"));
				a.setExpansao(res.getString("expansao"));
				acronimos.add(a);
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
	
		return acronimos;
	}
	
	public List<String> selectFrasesNegativas(){
		List<String> frasesNegativas = new ArrayList<String>();
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * from frasesnegativas");
			ResultSet res = ps.executeQuery();
			while(res.next()){
				frasesNegativas.add(res.getString("frase"));
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
	
		return frasesNegativas;
	}
	
	
	public boolean insertComentario(int idResultado, String comentario){
		boolean erro = true;
				try{
					PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE resultados set comentario='"+comentario+"' where id="+idResultado+";");		
					 erro = ps.execute();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
					 
				return erro;
	}
	
	public String selectComentario(int idResultado){
		String comentario = new String();
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT comentario from resultados WHERE id="+idResultado+";");
			ResultSet res = ps.executeQuery();
			while(res.next()){
				 comentario = res.getString("comentario");
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
			comentario="Erro Banco de Dados";
		}
		return comentario;
	}
	
	public int selectidSR(int idResultado){
		int idSubregra=0;
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT idSubregra from resultados WHERE id="+idResultado+";");
			ResultSet res = ps.executeQuery();
			while(res.next()){
				idSubregra = res.getInt("idSubregra");
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
			idSubregra=0;
		}
		return idSubregra;
	}
        
        	
	public Dicionario selectTabelaMT(){
		Dicionario tabelamt = new Dicionario();
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * from tabelamt");
			ResultSet res = ps.executeQuery();
			while(res.next()){
				
                            tabelamt.addpalavra(res.getString("palavra"));
                            tabelamt.addMT(res.getString("mt"));
		
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
	
		return tabelamt;
	}
        
        	private void bdNaoExiste(){
		System.out.println("Banco de Dados inexistente!");
		System.out.println("NullPointerException");
	}
                
          public boolean trocaConjunto(int idRegra, int idUsuario, int idConjunto){
                    
		try{
			
				PreparedStatement ps;
				ps = (PreparedStatement) con.prepareStatement("UPDATE regras set idConjunto ="+idConjunto+" where idUsuario ="+idUsuario+" AND idRegra="+idRegra+";");
				ps.execute();
		    
		    return false;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return true;
	}
          
          

}
