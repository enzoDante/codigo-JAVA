import java.util.Scanner;
public class NumeroExtenso{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		
		
		int num = 0;
		do{
			//System.out.println("Digite um numero entre 0 e 9999:");
			num = Integer.parseInt(scan.nextLine());

		}while(num < 0 || num > 9999);
		String numeroextenso = "";
		if(num < 20){
			Unidade unidad = new Unidade();
			unidad.setUnidadeExtenso(num);
			numeroextenso = unidad.getUnidade();
		}else if(num < 100){
			Dezena dezes = new Dezena();
			dezes.setDezenaExtenso(num);
			numeroextenso = dezes.getDezena();
		}else if(num < 1000){
			Centena cents = new Centena();
			cents.setCentenaExtenso(num);
			numeroextenso = cents.getCentena();
		}else{
			Milhar milh = new Milhar();
			milh.setMilharExtenso(num);
			numeroextenso = milh.getMilhar();
		}
		Caracteres FormatarExtenso = new Caracteres(numeroextenso);
		//Unidade unidad = new Unidade(num);
		//Caracteres FormatarExtenso = new Caracteres(unidad.getUnidade());
		FormatarExtenso.getExtensFormat();
	}
}