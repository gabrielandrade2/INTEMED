/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package activerecord;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author sikeira
 */
public class Dicionario {
 
    private List<String> palavra;
    private List<String> mt;
    public Dicionario()
    {
        this.palavra = new ArrayList<String>();
        this.mt = new ArrayList<String>();

    }
    public String getpalavra(int i){
        return palavra.get(i);
}
    public void addpalavra(String p){
        this.palavra.add(p);
       
}
    public String getMT(int i){
        return mt.get(i);
    }
    public void addMT(String t){
        this.mt.add(t);
    }
    public int tamanhoLista(){
      return this.palavra.size();
    }
}
