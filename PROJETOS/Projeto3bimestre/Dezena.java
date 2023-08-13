public class Dezena {//extends Unidade
    private String dezena = "";
    private String[] dezenas = {"", "", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"};
    private Unidade uni;
    private Centena cent;
    private Milhar milh;

    public Dezena(int num){//int num
        //super(num);
        if(num < 100){
            //System.out.println(this.getDezenas(num) + "asdsadsadasdasd");
            this.setDezena(this.getDezenas(num));
        }
        else if(num < 1000){
            cent = new Centena(num);
            this.setDezena(cent.getCentena());
        }else{
            milh = new Milhar(num);
            this.setDezena(milh.getMilhar());
        }
        //System.out.println("teste "+num);//+num
    }
    public String getDezenas(int num){
        //int n = num-(((int)num/10)*10);
        uni = new Unidade(num%10);
        return this.dezenas[(int)num/10] + (num%10 != 0 ? " e "+uni.getUnidade(): "");
    }
    public void setDezena(String value){
        this.dezena = value;
    }
    public String getDezena(){
        return this.dezena;
    }
}
