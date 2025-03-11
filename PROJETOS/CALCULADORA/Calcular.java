public class Calcular {
    boolean calculado = false;

    public void setCalculado(){
        this.calculado = !this.calculado;
    }
    public boolean getCalculado(){
        return this.calculado;
    }

    public double calc(Double num1, Double num2, String op) {

        switch (op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Divisão por zero");
                }
                return num1 / num2;
            default:
                throw new UnsupportedOperationException("Operador desconhecido");
        }
    }
}

