public class Centena extends Dezena {
    private String centena = "";
    private String[] centenas = {"", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"};

    public void setCentenaExtenso(int value){
        this.centena = this.getCentenas(value);
    }
    public String getCentenas(int num){
        if(num%100 != 0)
            this.setDezenaExtenso(num%100);

        return this.centenas[(int)num/100] + ((num%100 != 0 && num >= 100) ? " e ": "")+ this.getDezena();
    }

    public void setCentena(String value){
        this.centena = value;
    }
    public String getCentena(){
        return this.centena;
    }

}
