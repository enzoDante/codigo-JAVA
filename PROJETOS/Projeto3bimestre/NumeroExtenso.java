import java.util.Scanner;
public class NumeroExtenso{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		
		
		int num = 0;
		do{
			System.out.println("Digite um numero entre 0 e 9999:");
			num = Integer.parseInt(scan.nextLine());

		}while(num < 0 || num > 9999);
		
		Unidade unidad = new Unidade(num);
		Caracteres FormatarExtenso = new Caracteres(unidad.getUnidade());
		FormatarExtenso.getExtensFormat();

		//if(num < 20)
			//unidad.getExtenso();
	}
}