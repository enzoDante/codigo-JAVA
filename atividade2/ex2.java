import java.util.Scanner;
public class ex2{
        public static void main(String args[]){
                Scanner scan = new Scanner(System.in);
                int num = Integer.parseInt(scan.nextLine());
                int auxNum = num, i2 = 2;
                for(int i = 1; i < num; i++){
                        if(auxNum % i2 == 0){
                                auxNum = auxNum / i2;
                                System.out.println(i2);
                        }else
                                i2++;
                }
        }
}