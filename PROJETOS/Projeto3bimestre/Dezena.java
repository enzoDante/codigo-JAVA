public class Dezena extends Unidade {
    private String dezena = "";
    private String[] dezenas = {"", "", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "oitenta", "noventa"};

    public Dezena(int num){
        System.out.println("teste "+num);
    }
    public void setDezena(String value){
        this.dezena = value;
    }
    public String getDezena(){
        return this.dezena;
    }
}
