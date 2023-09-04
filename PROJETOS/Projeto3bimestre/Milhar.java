public class Milhar extends Centena {
    private String milhar = "";
    //private String[] Milhares = {"", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove"};
    
    public void setMilharExtenso(int value){
        this.milhar = this.getMilhares(value);
    }
    public String getMilhares(int num){
        //deze = new Dezena(num%1000);
        //Centena cents = new Centena();
        //if(num%1000 != 0 && num%1000 > 99){
            this.setCentenaExtenso(num%1000);
            //this.setCentsDezes(this.getCentena());
        // }else{
        //     this.setDezenaExtenso(num%1000);
        //     this.setCentsDezes(this.getDezena());
        // }
        String MilharUnidade = this.UnidadeExtenso((int)num/1000);

        return (num>=1000? MilharUnidade+" mil" :"")+(num>=1000 && num%1000 != 0? " e ": "") + this.getCentena();
        //                                                                      && (num%1000 > 99)
        //return (num>=1000? MilharUnidade+" mil" :"")+ (num%1000 != 0 && (num%1000 > 99)? " e ": "")+ this.getCentena();
        //return this.Milhares[(int)num/1000]+" mil" + (num%1000 != 0 && (num%1000 > 99 || num%1000 > 19)? " e ": "")+ deze.getDezena();
    }


    public void setMilhar(String value){
        this.milhar = value;
    }
    public String getMilhar(){
        return this.milhar;
    }
}
