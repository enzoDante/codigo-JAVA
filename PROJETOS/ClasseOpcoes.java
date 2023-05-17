import java.util.Scanner;

public class ClasseOpcoes{
	private int contCandidatas = 0;
	ClasseCandidatas[] candidatas = new ClasseCandidatas[1];

	public void InserirCandidata(){
		Scanner scan = new Scanner(System.in);
		//this.contCandidatas = 0;
		//ClasseCandidatas[] candidatas = new ClasseCandidatas[1];
		System.out.println("Digite o nome da candidata:");
		String nome = scan.nextLine();

		System.out.println("Digite a nota de simpatia(0-10):");
		Float simpatia = Float.parseFloat(scan.nextLine());
		System.out.println("Digite a nota de elegancia(0-10):");
		Float elegancia = Float.parseFloat(scan.nextLine());
		System.out.println("Digite a nota de beleza(0-10):");
		Float beleza = Float.parseFloat(scan.nextLine());
		//ClasseCandidatas candidata = new ClasseCandidatas(nome);

		if(getContCandidatas() > 0){
			//array com espaço a mais(nova candidata)
			ClasseCandidatas[] novasCandidatas = new ClasseCandidatas[getCandidatasLength()+1];
			//salvando candidatas anteriores
			for(int i = 0; i < getCandidatasLength(); i++){
					novasCandidatas[i] = new ClasseCandidatas(getCandidataNome(i), getCandidataSimpatia(i), getCandidataElegancia(i), getCandidataBeleza(i));//candidatas[i].getNome()
			}
			//criando a nova candidata
			novasCandidatas[getCandidatasLength()] = new ClasseCandidatas(nome, simpatia, elegancia, beleza);

			//array original que vai ter todas as candidatas
			setCandidatasLength(novasCandidatas.length);
			//candidatas = new ClasseCandidatas[novasCandidatas.length];
			for(int i = 0; i < getContCandidatas()+1; i++){
					setCandidatas(i, novasCandidatas[i].getNome(), novasCandidatas[i].getSimpatia(), novasCandidatas[i].getElegancia(), novasCandidatas[i].getBeleza());
					//candidatas[i] = new ClasseCandidatas(novasCandidatas[i].getNome());
			}
		}else
			//caso seja o primeiro registro
			setCandidatas(getContCandidatas(), nome, simpatia, elegancia, beleza);
			//candidatas[getContCandidatas()] = new ClasseCandidatas(nome);
		setContCandidatas(getContCandidatas()+1);			
		
	}

	public void setCandidatas(int i, String nome, Float simpatia, Float elegancia, Float beleza){
		this.candidatas[i] = new ClasseCandidatas(nome, simpatia, elegancia, beleza);
	}
	public void setCandidatasLength(int l){
		this.candidatas = new ClasseCandidatas[l];
	}
	public void setContCandidatas(int value){
		this.contCandidatas = value;
	}

	public int getCandidatasLength(){
		return this.candidatas.length;
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
		return this.contCandidatas;
	}
}