import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class Projeto2bi{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		//int contCandidatas = 0;
		//ClasseCandidatas[] candidatas = new ClasseCandidatas[1];

		ClasseOpcoes escolhas = new ClasseOpcoes();
		while(true){
			System.out.println("Escolha uma das opcoes:\n1-Incluir / 2-Consultar / 3-Alterar / 4-Excluir / 5-Relatar / 6-Sair");
			int opcao = Integer.parseInt(scan.nextLine());
			while(opcao < 1 || opcao > 6){
				System.out.println("Escolha uma das opcoes:\n1-Incluir / 2-Consultar / 3-Alterar / 4-Excluir / 5-Relatar / 6-Sair");
				opcao = Integer.parseInt(scan.nextLine());
			}

			//int totalCandidatas = escolhas.getCandidatasLength();
			int totalCandidatas = escolhas.getContCandidatas();
			if(opcao != 6){
				//====================
				if(opcao == 1){
					System.out.println("Digite o nome da candidata:");
					String nome = scan.nextLine();

					System.out.println("Digite a nota de simpatia(0-10):");
					Float simpatia = Float.parseFloat(scan.nextLine());
					System.out.println("Digite a nota de elegancia(0-10):");
					Float elegancia = Float.parseFloat(scan.nextLine());
					System.out.println("Digite a nota de beleza(0-10):");
					Float beleza = Float.parseFloat(scan.nextLine());

					escolhas.InserirCandidata(nome, simpatia, elegancia, beleza);
				//=================================================================
				}else if(totalCandidatas != 0){
					//=================================================================
					int consulta = 0;
					ClasseCandidatas candidata;

					if(opcao == 2){
						escolhas.getCandidatasNome();
						System.out.println("\nDigite o id da candidata:");
						consulta = Integer.parseInt(scan.nextLine());						
						
						if(consulta >= 0 && consulta <= escolhas.getContCandidatas()){
							candidata = escolhas.getCandidata(consulta);
							System.out.printf("Nome: [%s] Simpatia: [%1.1f] Elegancia: [%1.1f] Beleza: [%1.1f] - Nota: [%1.1f]\n", candidata.getNome(), candidata.getSimpatia(), candidata.getElegancia(), candidata.getBeleza(), candidata.getNota());

						}else
							System.out.println("Nao existe esse registro");	
					//=================================================================
					}else if(opcao == 3){
						escolhas.getCandidatasNome();
						System.out.println("\nDigite o id da candidata:");
						//===================id candidata==================
						consulta = Integer.parseInt(scan.nextLine());
						if(consulta >= 0 && consulta <= escolhas.getContCandidatas()){
							candidata = escolhas.getCandidata(consulta);
							System.out.printf("O que deseja alterar? 1-Nome / 2-Simpatio(0-10) / 3-Elegancia(0-10) / 4-Beleza(0-10)\n");
							int opcaoAlterar = Integer.parseInt(scan.nextLine());
							while(opcaoAlterar < 1 || opcaoAlterar > 4){
								System.out.println("Escolha uma das opcoes:\n1-Nome / 2-Simpatio(0-10) / 3-Elegancia(0-10) / 4-Beleza(0-10)");
								opcaoAlterar = Integer.parseInt(scan.nextLine());
							}
							
							switch(opcaoAlterar){
								case 1:
									System.out.println("Digite o novo nome da candidata:");
									String nome = scan.nextLine();
									escolhas.setCandidataNome(consulta, nome);
									break;
								case 2:
									System.out.println("Digite a nova nota de simpatia(0-10):");
									Float simpatia = Float.parseFloat(scan.nextLine());
									escolhas.setCandidataSimpatia(consulta, simpatia);
									break;
								case 3:
									System.out.println("Digite a nova nota de elegancia(0-10):");
									Float elegancia = Float.parseFloat(scan.nextLine());
									escolhas.setCandidataElegancia(consulta, elegancia);
									break;
								case 4:
									System.out.println("Digite a nova nota de beleza(0-10):");
									Float beleza = Float.parseFloat(scan.nextLine());
									escolhas.setCandidataBeleza(consulta, beleza);
									break;
							}

						}else
							System.out.println("Nao existe esse registro");
					//=================================================================
					}else if(opcao == 4){
						escolhas.getCandidatasNome();
						System.out.println("\nDigite o id da candidata que deseja excluir:");
						consulta = Integer.parseInt(scan.nextLine());						
						
						if(consulta >= 0 && consulta <= escolhas.getContCandidatas()){
							//candidata = escolhas.getCandidata(consulta);
							escolhas.removerCandidata(consulta);

						}else
							System.out.println("Nao existe esse registro");	
					//=================================================================
					}else{
						escolhas.relatar();
					}
				}else{
					System.out.println("Nao existe candidatas cadastradas");
				}

				//==============================================================
				System.out.println("Deseja continuar? 1-sim/2-nao");
				int escolha = Integer.parseInt(scan.nextLine());
				if(escolha != 1)
					break;
				
			}else
				break;
			
			//escolhas.InserirCandidata();
		}
		//contCandidatas
		// for(int i = 0; i < escolhas.getContCandidatas(); i++){
		// 	System.out.println(escolhas.getCandidataNome(i));//candidatas[i].getNome()
		// }

	}
}