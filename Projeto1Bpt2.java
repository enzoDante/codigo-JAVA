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
public class Projeto1Bpt2{

    public static void main(String args[]){
        int indiceG = 1, indiceTotal = 2, DescubraX = 0;
        double x = 0;

        //dias que formou os grupos
        for(int i = 0; i < Integer.parseInt(args[0]); i++){
            //caso total de alunos seja par:
            if(Integer.parseInt(args[indiceTotal]) % 2 == 0){
                //descobrir x
                for(int z = 1; z < Integer.parseInt(args[indiceG]); z++){
                    DescubraX += 2; // 0, 2, 4, 6...
                    x += DescubraX; // 0 + 2 + 4 + 6 + ...
                }
                //calculando x: (total pessoas - x) / total de grupos
                x = (Double.parseDouble(args[indiceTotal]) - x) / Integer.parseInt(args[indiceG]);

    
                //inserindo na equação do grupo, porem temos x
                for(int z = 1; z <= Integer.parseInt(args[indiceG]); z++){
                    System.out.printf("%1.0f, ", x);
                    x += 2;
                }
            }else
                System.out.println("o total de alunos deve ser par!");

            System.out.println("");

            indiceG += 2;
            indiceTotal += 2;
            DescubraX = 0;
            x = 0;
        }

    }
}