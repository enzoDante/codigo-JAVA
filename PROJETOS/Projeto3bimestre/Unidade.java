public class Unidade {
    private String unidade = "";
    private String[] Unidades = {"zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove", "dez", "onze", "doze", "treze", "catorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"};
    //private Dezena dezes = new Dezena();
    private Dezena dezes;

    public Unidade(int num){
        if(num < 20)
            this.setUnidade(this.UnidadeExtenso(num));
        else
            this.dezes = new Dezena(num);
    }
    public String UnidadeExtenso(int num){
        /*for(int i = 0; i < this.Unidades.length(); i++){
            System.out.println(Unidades[i]);
        }*/
        return this.Unidades[num];
    }

    public void setUnidade(String value){
        this.unidade = value;
    }
    public String getUnidade(){
        return this.unidade;
    }
    public void getExtenso(){
        System.out.println(this.getUnidade());
    }
}
