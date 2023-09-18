public class Numero extends Fibonacci{
    private int num = 0;

    public void setNum(int value){
        this.num = value;
    }
    public int getNum(){
        return this.num;
    }
    public String calcFibo(){
        String svalores = "";
        int[] nm = this.fibo(this.getNum());
        for(int i = 0; i < nm.length; i++){
            svalores += nm[i] + "  ";
        }
        return svalores;
    }
}
