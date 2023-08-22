public class Unidade {
    private String unidade = "";
    private String[] Unidades = {"zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove", "dez", "onze", "doze", "treze", "catorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"};

    public Unidade(){//int num
        //if(num < 20)
            //this.setUnidade(this.UnidadeExtenso(num));
    }
    //aq===================================
    public void setUnidadeExtenso(int value){
        this.unidade = this.Unidades[value];
    }

    public String UnidadeExtenso(int num){

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
