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
        /*if(num < 20){
			Unidade unidad = new Unidade();
			unidad.setUnidadeExtenso(num);
			resultado = unidad.getUnidade();
		}else if(num < 100){
			Dezena dezes = new Dezena();
			dezes.setDezenaExtenso(num);
			resultado = dezes.getDezena();
		}else if(num < 1000){
			Centena cents = new Centena();
			cents.setCentenaExtenso(num);
			resultado = cents.getCentena();
		}else{
		}*/
		Milhar milh = new Milhar();
		milh.setMilharExtenso(num);
		resultado = milh.getMilhar();
        this.setNumeroExtenso(resultado);
    }
	public void setFormatExtenso(String value){
		formatacao = new Caracteres(value);
		this.setNumeroExtenso(formatacao.getValor());
	}


}
