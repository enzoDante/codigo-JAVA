/* *******************************************************************
 * Colegio Tecnico Antonio Teixeira Fernandes (Univap)
 * Curso Tecnico em Informatica - Data de Entrega: DD/MM/2020
 * Autores do Projeto: Enzo Dante Micoli
 *                     Davi
 * Turma: 3H  Disciplina: Programacao - II
 * Avaliacao parcial referente ao 1 - Bimestre
 * Observacao: 
 * 
 * nome_arquivo.java
 * ******************************************************************/
public class Projeto1B{
        public static void main(String args[]){
               System.out.println("teste");
               int total = args.length / 3;
               double totalMenor21 = 0;
               boolean maiorde60 = false;
               double totalMulheres = 0, totalHomens = 0;
               int totalInterior = 0;
               double porcHomens = 0, porcMulheres = 0;
               
               //idade
               int i1 = 1, i2 = 2;
               for(int i=0; i <= args.length-1; i+=3){
                       int idade = 2023 - Integer.parseInt(args[i]);
                       System.out.printf("tes %s e idade %d \n", args[i], idade);
                       //idade
                       if(idade < 21)
                                totalMenor21++;
                        else if(idade > 60)
                                maiorde60 = true;

                        //genero
                        if(Integer.parseInt(args[i1]) == 2) 
                                totalMulheres++;
                        else totalHomens++;
                        //fazer media de homens e mulheres!

                        
                        //procedencia
                        if(Integer.parseInt(args[i2]) == 1) 
                                totalInterior++;

                        
                        i1 += 3;
                        i2 += 3;
               }
               System.out.printf("%1.0f \n", totalMenor21);
               System.out.printf("total %d \n", total); 
               double porcMenor21 = (totalMenor21 / total) * 100;
               porcMulheres = (totalMulheres / total) * 100;
               porcHomens = (totalHomens / total) * 100;
               
               System.out.printf("Porcentagem de motoristas menor de 21 anos: %1.2f%% \n", porcMenor21);  
               System.out.printf("Total de mulheres: %1.0f \n", totalMulheres);
               System.out.printf("Total de pessoas do interior: %d \n", totalInterior);
               System.out.printf(maiorde60 ? "Existe alguem acima de 60 anos \n" : "Nao existe alguem acima de 60 anos \n");
               System.out.printf("%1.2f%% sao homens e %1.2f%% sao mulheres \n", porcHomens, porcMulheres);
               
               //genero
               /*
                for(int i=1; i<= args.length-1; i += 3)
                        if(Integer.parseInt(args[i]) == 2) totalMulheres++;

                System.out.printf("Total de mulheres: %d \n", totalMulheres);

                //procedencia
                for(int i=2; i<= args.length-1; i += 3)
                        if(Integer.parseInt(args[i]) == 1) totalInterior++;

                System.out.printf("Total de pessoas do interior: %d \n", totalInterior); */
                
                               

        }
}