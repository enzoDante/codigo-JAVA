import DadosAlunoPac.Aluno;
import java.util.ArrayList;
/**
 * Escreva a descrição da classe Lista aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ListaArray implements IArmazenador {

    private ArrayList <Aluno> lista;

    public ListaArray(){
        this.lista = new ArrayList<>();
    }

    /**
     * getLista
     * 
     * @return the vet
     */
    private ArrayList <Aluno> getLista() {
        return lista;
    }

    /**
     * getQtd
     * 
     * @return the qtd
     */
    public int getQtd() {
        return lista.size();
    }

    /**
     * setLista
     * 
     * @param vet the vet to set
     */
    private void setLista(ArrayList <Aluno>lista) {
        this.lista = lista;
    }

    /**
     * adicionar
     *
     * @param obj Um parâmetro
     */
    public void adicionar(Aluno obj){
        lista.add(obj);
    }

    /**
     * remover
     *
     * @param i Um parâmetro
     */
    public Aluno remover(int i) {
        // Object ret = null;

        if (buscar(i) != null){
            //ret = lista.get(i);
            return lista.remove(i);
        }
        return null;
    }

    /**
     * buscar
     *
     * @param i Um parâmetro
     * @return O valor de retorno
     */
    public Aluno buscar (int i){
        
        if(!lista.isEmpty()&& i >= 0 && i < lista.size()){
            return lista.get(i);
        }
        return null;
    }

    public Aluno buscarPorRA(String ra){
        for (Aluno aluno : lista) {
            if(aluno.getRa().equals(ra))
                return aluno;
        }
        return null;
    }

    /**
     * estaVazia
     *
     * @return O valor de retorno
     */
    public boolean estaVazia(){
        return (lista.isEmpty());
    }

    /**
     * toString
     *
     * @return O valor de retorno
     */
    public String toString(){
        String s = "[ ";
        for (int i = 0; i < lista.size(); i++){
            s += lista.get(i).toString() + " ";
        }
        s = s + "]";
        return s;
    }
}

