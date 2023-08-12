public class Centena extends Dezena {
    private String centena = "";
    private String[] centenas = {"", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"};

    public void setCentena(String value){
        this.centena = value;
    }
    public String getCentena(){
        return this.centena;
    }

}
