public class Dezena extends Unidade {//extends Unidade
    private String dezena = "";
    private String[] dezenas = {"", "", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"};

    // public Dezena(){//int num
    //     super();
    //     //super(num%10);
    //     //if(num < 100)
    //         //this.setDezena(this.getDezenas(num));
            
    //     /*
    //     else if(num < 1000){
    //         cent = new Centena(num);
    //         this.setDezena(cent.getCentena());
    //     }else{
    //         milh = new Milhar(num);
    //         this.setDezena(milh.getMilhar());
    //     }*/
    // }
    public void setDezenaExtenso(int value){
        this.dezena = this.getDezenas(value);
    }
    public String getDezenas(int num){
        //int n = num-(((int)num/10)*10);
        //uni = new Unidade(num%10);
        if(num%10 != 0)
            this.setUnidadeExtenso(num%10);

        return this.dezenas[(int)num/10] + (num%10 != 0 ? " e "+this.getUnidade(): "");
    }
    public void setDezena(String value){
        this.dezena = value;
    }
    public String getDezena(){
        return this.dezena;
    }
}
