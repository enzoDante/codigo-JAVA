import java.util.Scanner;

public class ClasseOpcoes{
	private int contCandidatas = 0;
	private ClasseCandidatas[] candidatas = new ClasseCandidatas[1000]; //1

	public void InserirCandidata(String nome, Float simpatia, Float elegancia, Float beleza){

		setCandidatas(getContCandidatas(), nome, simpatia, elegancia, beleza);
		setContCandidatas(getContCandidatas()+1);		
	}	

	public void setCandidatas(int i, String nome, Float simpatia, Float elegancia, Float beleza){
		this.candidatas[i] = new ClasseCandidatas(nome, simpatia, elegancia, beleza);
	}
	// public void setCandidatasLength(int l){
	// 	this.candidatas = new ClasseCandidatas[l];
	// }
	public void setContCandidatas(int value){
		this.contCandidatas = value;
	}
	public void setCandidataNome(int i, String nome){
		this.candidatas[i].setNome(nome);
	}
	public void setCandidataSimpatia(int i, Float simpatia){
		this.candidatas[i].setSimpatia(simpatia);
		this.candidatas[i].calcularNota();
	}
	public void setCandidataElegancia(int i, Float elegancia){
		this.candidatas[i].setElegancia(elegancia);
		this.candidatas[i].calcularNota();
	}
	public void setCandidataBeleza(int i, Float beleza){
		this.candidatas[i].setBeleza(beleza);
		this.candidatas[i].calcularNota();
	}

	public void removerCandidata(int i){
		for(int l = i; l < this.getContCandidatas(); l++){
			this.candidatas[l] = getCandidata(l + 1);
		}
		setContCandidatas(getContCandidatas()-1);
	}
	public void classificarCandidatas(){
		for(int i = 0; i < this.getContCandidatas(); i++){
			for(int l = 0; l < this.getContCandidatas()-1; l++){
				if(this.getCandidataNota(l) < this.getCandidataNota(l+1)){
					ClasseCandidatas aux = getCandidata(l);
					this.candidatas[l] = getCandidata(l + 1);
					this.candidatas[l+1] = aux;
				}
			}
		}
	}
	public void relatar(){
		this.classificarCandidatas();
		int colocacao =  1;
		for(int i = 0; i < this.getContCandidatas(); i++){

			if(i > 0){
				Float nt2 = this.getCandidataNota(i-1) - this.getCandidataNota(i);
				
				if(nt2 != 0){
					colocacao++;
				}
			}
			System.out.printf("[%dº] - nota: [%1.1f] Candidata: %s\n", colocacao, this.getCandidataNota(i), this.getCandidataNome(i));
			System.out.printf("Simpatia[%1.1f] Elegancia[%1.1f] Beleza[%1.1f]\n\n", this.getCandidataSimpatia(i), this.getCandidataElegancia(i), this.getCandidataBeleza(i));
		}
		System.out.println("");
	}
	
	//===============GET=========================
	public ClasseCandidatas getCandidata(int consulta){
		return this.candidatas[consulta];
	}
	public void getCandidatasNome(){
		//String[] nomesC = new String[getContCandidatas()];
		for(int i = 0; i <= this.getContCandidatas()-1; i++){
			//nomesC[i] = this.getCandidataNome(i);
			System.out.printf("[%d] - %s\n", i, this.getCandidataNome(i));
		}
	}
	public String getCandidataNome(int i){
		return this.candidatas[i].getNome();
	}
	public Float getCandidataSimpatia(int i){
		return this.candidatas[i].getSimpatia();
	}
	public Float getCandidataElegancia(int i){
		return this.candidatas[i].getElegancia();
	}
	public Float getCandidataBeleza(int i){
		return this.candidatas[i].getBeleza();
	}
	public Float getCandidataNota(int i){
		return this.candidatas[i].getNota();
	}

	public int getContCandidatas(){
		//total de candidatas
		return this.contCandidatas;
	}
}