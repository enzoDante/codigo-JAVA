import java.util.Scanner;

class ex1{
    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);

        System.out.println("Ano inicial:");
        int anoI = Integer.parseInt(scan.nextLine());
        System.out.println("Ano final:");
        int anoF = Integer.parseInt(scan.nextLine());
        System.out.println("numero de Olimpiadas:");
        int nOlimpiadas = Integer.parseInt(scan.nextLine());
        System.out.println("Quantas o Brasil ganhou:");
        int nVencidas = Integer.parseInt(scan.nextLine());

        int r = (anoF-anoI) / (nOlimpiadas-1);
        int anoGanhou = anoI + (r*(nVencidas-1));

        System.out.printf("Primeiro ano = %d",anoGanhou);

    
    }
}