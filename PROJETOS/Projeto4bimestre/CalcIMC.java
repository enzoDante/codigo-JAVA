public class CalcIMC {
    private double IMC;
    private String imcDesc;


    public void setIMC(double massa, double altura){
        this.IMC = massa / (altura * altura);
        this.setIMCDesc(this.getIMC());
    }
    
    public void setIMCDesc(double imc){
        if(imc < 18.5)
            this.imcDesc = "Magreza";
        else if(imc < 25)
            this.imcDesc = "Saudavel";
        else if(imc < 30)
            this.imcDesc = "Sobrepeso";
        else if(imc < 35)
            this.imcDesc = "Obesidade grau I";
        else if(imc < 40)
            this.imcDesc = "Obesidade grau II";
        else
            this.imcDesc = "Obesidade grau III";
    }

    public double getIMC(){
        return this.IMC;
    }
    public String getIMCDesc(){
        return this.imcDesc;
    }
}
