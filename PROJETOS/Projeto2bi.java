import java.util.Scanner;

public class Projeto2bi{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		//int contCandidatas = 0;
		//ClasseCandidatas[] candidatas = new ClasseCandidatas[1];

		ClasseOpcoes escolhas = new ClasseOpcoes();
		while(true){
			escolhas.InserirCandidata();
			/*System.out.println("Digite o nome da candidata:");
			String nome = scan.nextLine();
			//ClasseCandidatas candidata = new ClasseCandidatas(nome);

			if(contCandidatas > 0){
				//array com espaço a mais(nova candidata)
				ClasseCandidatas[] novasCandidatas = new ClasseCandidatas[candidatas.length+1];
				//salvando candidatas anteriores
				for(int i = 0; i < candidatas.length; i++){
					novasCandidatas[i] = new ClasseCandidatas(candidatas[i].getNome());
				}
				//criando a nova candidata
				novasCandidatas[candidatas.length] = new ClasseCandidatas(nome);

				//array original que vai ter todas as candidatas
				candidatas = new ClasseCandidatas[novasCandidatas.length];
				for(int i = 0; i < contCandidatas+1; i++){
					candidatas[i] = new ClasseCandidatas(novasCandidatas[i].getNome());
				}
			}else
				//caso seja o primeiro registro
				candidatas[contCandidatas] = new ClasseCandidatas(nome);

			System.out.println("Deseja continuar? 1-sim/2-nao");
			int escolha = Integer.parseInt(scan.nextLine());
			if(escolha != 1)
					break;
			contCandidatas++;*/
			System.out.println("Deseja continuar? 1-sim/2-nao");
			int escolha = Integer.parseInt(scan.nextLine());
			if(escolha != 1)
				break;

		}
		//contCandidatas
		for(int i = 0; i < escolhas.getContCandidatas(); i++){
			System.out.println(escolhas.getCandidataNome(i));//candidatas[i].getNome()
		}

	}
}