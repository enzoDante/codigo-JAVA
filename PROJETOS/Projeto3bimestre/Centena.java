public class Centena extends Dezena {// extends Dezena
    private String centena = "";
    private String[] centenas = {"", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"};

    /*public Centena(){
        super();
        //super(num%100);
        //this.setCentena(this.getCentenas(num));
    }*/

    public void setCentenaExtenso(int value){
        this.centena = this.getCentenas(value);
    }
    public String getCentenas(int num){
        if(num%100 != 0)
            this.setDezenaExtenso(num%100);

        return this.centenas[(int)num/100] + ((num%100 != 0 && num >= 100) ? " e ": "")+ this.getDezena();
        //deze = new Dezena(num%100);                num%100 >= 10
        //return this.centenas[(int)num/100] + ((num%100 != 0 && num%100 > 19) ? " e ": "")+ this.getDezenas(num%100);
    }

    public void setCentena(String value){
        this.centena = value;
    }
    public String getCentena(){
        return this.centena;
    }

}
