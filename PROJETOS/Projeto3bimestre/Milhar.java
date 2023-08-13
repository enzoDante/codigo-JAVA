public class Milhar {
    private String milhar = "";
    private String[] Milhares = {"", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove"};
    private Dezena deze;

    public Milhar(int num){
        //System.out.println("teste  "+ setMilhares(num));
        setMilhar(getMilhares(num));
    }
    public String getMilhares(int num){
        deze = new Dezena(num%1000);

        return this.Milhares[(int)num/1000]+" mil" + (num%1000 != 0 && (num%1000 > 99 || num%1000 > 19)? " e ": "")+ deze.getDezena();
    }
    public void setMilhar(String value){
        this.milhar = value;
    }
    public String getMilhar(){
        return this.milhar;
    }
}
