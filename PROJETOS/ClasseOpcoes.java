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
		//ClasseCandidatas candidata = this.getCandidata(i);
		this.candidatas[i].setNome(nome);
	}
	public void setCandidataSimpatia(int i, Float simpatia){
		this.candidatas[i].setSimpatia(simpatia);
	}
	public void setCandidataElegancia(int i, Float elegancia){
		this.candidatas[i].setElegancia(elegancia);
	}
	public void setCandidataBeleza(int i, Float beleza){
		this.candidatas[i].setBeleza(beleza);
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

	public int getContCandidatas(){
		//total de candidatas
		return this.contCandidatas;
	}
}