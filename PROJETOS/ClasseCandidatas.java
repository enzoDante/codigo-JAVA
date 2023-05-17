public class ClasseCandidatas{
	private String nome;
	private Float simpatia;
	private Float elegancia;
	private Float beleza;

	public ClasseCandidatas(String nome, Float simpatia, Float elegancia, Float beleza){
		this.setNome(nome);
		this.setSimpatia(simpatia);
		this.setElegancia(elegancia);
		this.setSimpatia(beleza);
	}

	public void setNome(String value){
		this.nome = value;
	}
	public void setSimpatia(Float value){
		this.simpatia = value;
	}
	public void setElegancia(Float value){
		this.elegancia = value;
	}
	public void setBeleza(Float value){
		this.beleza = value;
	}

	public String getNome(){
		return this.nome;
	}
	public Float getSimpatia(){
		return this.simpatia;
	}
	public Float getElegancia(){
		return this.elegancia;
	}
	public Float getBeleza(){
		return this.beleza;
	}
}