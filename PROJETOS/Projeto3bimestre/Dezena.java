public class Dezena {//extends Unidade
    private String dezena = "";
    private String[] dezenas = {"", "", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "oitenta", "noventa"};
    private Unidade uni;

    public Dezena(int num){//int num
        //super(num);
        //if(num < 100)

        //System.out.println("teste "+num);//+num
    }
    public String getDezenas(int num){
        int n = num-(((int)num/10)*10);
        uni = new Unidade(n);
        return this.dezenas[(int)num/10] + (n != 0 ? " e "+uni.getUnidade(): "");
    }
    public void setDezena(String value){
        this.dezena = value;
    }
    public String getDezena(){
        return this.dezena;
    }
}
