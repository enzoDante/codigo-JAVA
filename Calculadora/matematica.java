public class matematica {
    
    public String calcularSoma(String value){
        // String teste = "123+434";
        // int posicao = teste.indexOf("+"); -- determinar a posição para trocar o sinal
        String[] x = value.split("+");
        int result = Integer.parseInt(x[0]) + Integer.parseInt(x[1]);
        return ""+result;
    }

    public boolean verificarSina(String value){
        
        
        return false;
    }


    public int verificarSinal(String value){
        String a = "123+456";
        int posicao = -1;
        
        char caractere = '0';
        for (int i = 0; i < value.length(); i++) {
            caractere = value.charAt(i);            
            // Verifica se o caractere é um dos operadores matemáticos
            if (caractere == '+' || caractere == '-' || caractere == '*' || caractere == '/'){
                posicao = value.indexOf(String.valueOf(caractere));
                break;
            }
        }

        return posicao;

    }


    public boolean posicaoD(String value, String caractere){
        //int posicao = value.indexOf(String.valueOf(caractere));

        return value.indexOf(caractere) != -1? true : false;

        
    }

}
