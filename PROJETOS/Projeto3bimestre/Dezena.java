public class Dezena extends Unidade {
    private String dezena = "";
    private String[] dezenasDez = {"dez", "onze", "doze", "treze", "catorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"};
    private String[] dezenas = {"", "", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"};

    public void setDezenaExtenso(int value){
        String resu = "";
        this.dezena = this.getDezenas(value);
    }
    public String getDezenas(int num){
        //int n = num-(((int)num/10)*10);
        //uni = new Unidade(num%10);
        int verificar = 0;
        if(num < 10)
            verificar = num;
        else
            verificar = num%10;
            
        this.setUnidadeExtenso(verificar);

        String Dezena = num >= 20? this.dezenas[(int)num/10] : num>=10 ? this.dezenasDez[num%10] : "";

        return Dezena + (num%10 != 0 && num > 20? " e ": "")+((num > 20 && num%10 != 0) || num < 10?this.getUnidade(): "");
    }
    public void setDezena(String value){
        this.dezena = value;
    }
    public String getDezena(){
        return this.dezena;
    }
}
