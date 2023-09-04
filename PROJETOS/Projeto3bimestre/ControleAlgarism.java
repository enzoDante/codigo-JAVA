public class ControleAlgarism {
    private String numeroExtenso = "";
	private Caracteres formatacao;

    public ControleAlgarism(int num){
        this.setExtenso(num);
    }
    public void setNumeroExtenso(String value){
        this.numeroExtenso = value;
    }
    public String getNumerExtenso(){
        return this.numeroExtenso;
    }
    public void setExtenso(int num){
        String resultado = "";
		
		Milhar milh = new Milhar();
		milh.setMilharExtenso(num);
		resultado = milh.getMilhar();
        //this.setNumeroExtenso(resultado);
		this.setFormatExtenso(resultado);
    }
	public void setFormatExtenso(String value){
		formatacao = new Caracteres(value);
		this.setNumeroExtenso(formatacao.getValor());
	}


}
