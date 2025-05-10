import DadosAlunoPac.Aluno;
/**
 * "simula" um array dinamico.
 * 
 * @author Julio Arakaki
 * @version 12/04/2023
 */
public class VetDin implements IArmazenador {

    // Atributos
    // array para armazenar qquer objeto
    private Aluno[] array; 
    // quantidade de objetos no vetor
    private int qtd;

    /**
     * VetDin Construtor - inicia um array e seta a quantidade
     *
     */
    public VetDin(){
        this.array = null;
        this.qtd = 0;
    }

    /**
     * retorna array de Object
     * 
     * @return vetor de Object
     */
    private Aluno[] getArray() {
        return array;
    }

    /**
     * Retorna a quntidade
     * 
     * @return int, quantidade de elementos no array
     */
    public int getQtd() {
        return qtd;
    }

    /**
     * @param vet the vet to set
     */
    private void setArray(Aluno[] array) {
        this.array = array;
    }

    /**
     * @param qtd the qtd to set
     */
    private void setQtd(int qtd) {
        this.qtd = qtd;
    }

    /**
     * Método adicionar
     *
     * @param obj Um parâmetro
     */
    public void adicionar(Aluno obj){
        if (array == null){ // se for o primeiro elemento          
            // setArray(new Object[1]);
            array = new Aluno[1];
            array[0] = obj; 
            // setQtd(getQtd()+1);
        }
        else { // outros elementos
            // cria vetor auxiliar com mais um elemento
            Aluno aux[] = new Aluno[array.length+1];

            // copia todos elementos de vet para aux
            copiar(array, aux);

            // insere elemento novo
            aux[aux.length-1] = obj;

            // Transforma vetor auxiliar no atual
            // setArray(aux);
            array = aux;

            // incrementa contador de elementos    
            // setQtd(getQtd()+1);

        }
        qtd++;
    }

    /**
     * Método remover
     *
     * @param i Um parâmetro
     */
    public Aluno remover(int i) {
        // Object ret = null;
        if(buscar(i) != null){
            // ret = array[i];
            Aluno removido = array[i];
            // Libera elemento da sua posicao
            array[i] = null;

            if(qtd > 1){
                // cria vetor auxiliar com mes um elemento
                Aluno aux[] = new Aluno[array.length-1];

                // copia todos elementos de vet para aux
                copiar(array, aux);

                // Transforma vetor auxiliar no atual
                array = aux;
                // decrementa contador de elementos    
                // setQtd(getQtd() - 1);
            } else {
                // acabou os elementos
                // setArray(null);
                // decrementa contador de elementos    
                // setQtd(0);
                array = null;

            }
            qtd--;
            return removido;
        }
        return null;
    }

    /**
     * Método buscar
     *
     * @param i Um parâmetro
     * @return O valor de retorno
     */
    public Aluno buscar (int i){
        if(array != null && i >= 0 && i < qtd) {
            return array[i];
        }
        return null;
    }

    public Aluno buscarPorRA(String ra){
        if(array != null){
            for(int i = 0; i < qtd; i++){
                if(array[i] != null && array[i].getRa().equals(ra))
                    return array[i];
            }
        }
        return null;
    }

    /**
     * Método vazia
     *
     * @return O valor de retorno
     */
    public boolean estaVazia(){
        return (qtd==0 && array == null);
    }

    /**
     * Método copiar
     *
     * @param origem Um parâmetro
     * @param destino Um parâmetro
     */
    private void copiar(Aluno origem[], Aluno destino[]){
        // copia todos
        int k = 0;
        for (Aluno aluno : destino) {
            if(aluno != null)
                destino[k++] = aluno;
        }      
    }

    /**
     * Método toString
     *
     * @return O valor de retorno
     */
    public String toString(){
        String s = "[ ";
        if(array != null){
            for (int i = 0; i < array.length; i++){
                s += array[i].toString() + " ";
            }
        }
        s = s + "]";
        return s;
    }
}
