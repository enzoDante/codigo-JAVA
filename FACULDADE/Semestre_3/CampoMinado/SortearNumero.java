import java.util.Random;

public class SortearNumero {
    /**
     *  função que sortea número entre n e n2 onde quanto maior o número, mais raro de ser sorteado
     * @param n
     * @param n2
     * @param alpha grau de raridade (quanto maior, mais difícil sair um número alto)
     * @return int número sorteado ou n2 por segurança
     */
    public static int sortearComPeso(int n, int n2, double alpha){
        int range = n2 - n + 1;
        double[] pesos = new double[range];
        double somaPesos = 0;

        // calcula os pesos inversamente proporcionais com base no índice
        for(int i = 0; i < range; i++){
            int valor = n + 1;
            pesos[i] = 1.0 / Math.pow(valor, alpha);
            somaPesos += pesos[i];
        }

        // Sorteia um número com base nos pesos
        Random rand = new Random();
        double r = rand.nextDouble() * somaPesos;
        double acumulado = 0;

        for(int i = 0; i < range; i++){
            acumulado += pesos[i];
            if(r <= acumulado)
                return n+i;
        }

        return n2; // retorno de segurança
    }
}
