public class Entrada extends Calcular {

    String n1 = "";
    String n2 = "";

    String operador;
    boolean opAtivado = false;

    public void addN1(String value){
        this.n1 += value;
    }
    public void addN2(String value){
        this.n2 += value;
    }
    public Double getN1(){
        return Double.parseDouble(this.n1);
    }
    public Double getN2(){
        return Double.parseDouble(this.n2);
    }
    public void ClearN(){
        this.n1 = "";
        this.n2 = "";
    }

    public void setOperador(String value){
        this.operador = value;
    }
    public String getOperador(){
        return this.operador;
    }

    public void setOp(){
        this.opAtivado = !this.opAtivado;
    }
    public void setForceOp(){
        this.opAtivado = false;
    }

    public boolean getOpAtiv(){
        return this.opAtivado;
    }

    

}