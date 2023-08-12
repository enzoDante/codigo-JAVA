public class Centena {// extends Dezena
    private String centena = "";
    private String[] centenas = {"", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"};
    private Dezena deze;

    public Centena(int num){
        System.out.println(getCentenas(num));
    }

    public String getCentenas(int num){

        deze = new Dezena(num%100);
        return this.centenas[(int)num/100] + ((num%100 != 0 && num%100 > 19) ? " e ": "")+ deze.getDezenas(num%100);
    }

    public void setCentena(String value){
        this.centena = value;
    }
    public String getCentena(){
        return this.centena;
    }

}
