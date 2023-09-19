public class Fibonacci {
    public int[] fibo(int num){
        int[] valores = new int[num];
        int a = 1, b = 0, aux = 0;
        for(int i = 0; i < num; i++){
            valores[i] = a;
            aux = a;
            a += b;
            b = aux;
        }
        return valores;
    }    
}
