public class Milhar extends Centena {
    private String milhar = "";
    
    public void setMilharExtenso(int value){
        this.milhar = this.getMilhares(value);
    }
    public String getMilhares(int num){
        this.setCentenaExtenso(num%1000);
        String MilharUnidade = this.UnidadeExtenso((int)num/1000);

        return (num>=1000? MilharUnidade+" mil" :"")+(num>=1000 && num%1000 != 0? " e ": "") + this.getCentena();
    }


    public void setMilhar(String value){
        this.milhar = value;
    }
    public String getMilhar(){
        return this.milhar;
    }
}
