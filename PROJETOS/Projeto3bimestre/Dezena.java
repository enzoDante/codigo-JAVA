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
        String resu = "";
        this.dezena = this.getDezenas(value);
        //resu = this.UnidadeExtenso(value);
    }
    public String getDezenas(int num){
        //int n = num-(((int)num/10)*10);
        //uni = new Unidade(num%10);
        int verificar = 0;
        if(num < 20)
            verificar = num;
        else
            verificar = num%10;
        //if(num < 20)//num%10 != 0 && 
        this.setUnidadeExtenso(verificar);

        return this.dezenas[(int)num/10] + (num%10 != 0 || num == 10? " e "+this.getUnidade(): "");
    }
    public void setDezena(String value){
        this.dezena = value;
    }
    public String getDezena(){
        return this.dezena;
    }
}
