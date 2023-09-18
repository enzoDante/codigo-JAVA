public class Fibonacci {
    public int[] fibo(int num){
        int num1 = 1, num2 = 0;
        int[] valores = new int[num];
        for(int i=0; i<num; i++){
            num1 = num1 + num2;
            num2 = num1 - num2;
            valores[i] = num1;
        }
        return valores;
    }    
}
