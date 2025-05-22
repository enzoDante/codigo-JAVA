public class Jogo extends Campo {
    private boolean inicioJogo = false;

    public Jogo(int value){
        super(value);

    }

    public boolean verificarInicio(){
        return this.inicioJogo;
    }
    public void setInicio(){
        this.inicioJogo = true;
    }

    
    
}
