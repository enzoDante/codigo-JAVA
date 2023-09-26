public class Ex4_metodo {
    private String texto = "";
    public String NumerRomano(int num){
        int ind = num < 4 ? 0 : (num==4? 3 : (num >= 5 && num < 9? 4:(num==9? 8: 9)));
        setTexto("IIIIVIIIIX".substring(ind, (num == 4 || num == 9? 1 : 0)+ num));
        //System.out.println(a);
        return getTexto();        

    }
    public void setTexto(String value){
        this.texto = value;
    }
    public String getTexto(){
        return this.texto;
    }
}
