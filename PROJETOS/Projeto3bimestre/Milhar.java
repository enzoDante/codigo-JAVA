public class Milhar extends Dezena {
    private String milhar = "";
    private String[] Milhares = {"", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove"};
    private String CentsDezes = "";

    public Milhar(){
        super();//num%1000
        //setMilhar(getMilhares(num));
    }
    public void setMilharExtenso(int value){
        this.milhar = this.getMilhares(value);
    }
    public String getMilhares(int num){
        //deze = new Dezena(num%1000);
        Centena cents = new Centena();
        if(num%1000 != 0 && num%1000 > 99){
            cents.setCentenaExtenso(num%1000);
            setCentsDezes(cents.getCentena());
        }else{
            this.setDezenaExtenso(num%1000);
            this.setCentsDezes(this.getDezena());
        }
        

        return this.Milhares[(int)num/1000]+" mil" + (num%1000 != 0 && (num%1000 > 99 || num%1000 > 19)? " e ": "")+ this.getCentsDezes();
        //return this.Milhares[(int)num/1000]+" mil" + (num%1000 != 0 && (num%1000 > 99 || num%1000 > 19)? " e ": "")+ deze.getDezena();
    }
    public void setCentsDezes(String value){
        this.CentsDezes = value;
    }
    public String getCentsDezes(){
        return this.CentsDezes;
    }


    public void setMilhar(String value){
        this.milhar = value;
    }
    public String getMilhar(){
        return this.milhar;
    }
}
