
public class ValidarDados {
    

    public boolean ValidStr(String value){
        for(int i = 0; i < value.length(); i++){
            if(isNumeric(value.charAt(i)+"")) return false;
        }
        return true;
    }


    public boolean ValidStrAlfa(String value){
        for(int i = 0; i < value.length(); i++){
            if(isNumeric(value.charAt(i)+"") || !isAlfabeta(value.charAt(i)+"")) return false;
        }
        return true;
    }

    public boolean ValidIdade(String value){
        if(!isNumeric(value)) return false;
        
        if(Integer.parseInt(value) < 1 || Integer.parseInt(value) > 100) return false;

        return true;
    }

    public boolean ValidPerid(String value){
        if(!isNumeric(value)) return false;

        if(Integer.parseInt(value) < 1 || Integer.parseInt(value) > 14) return false;

        return true;
    }

    public boolean validarRA(String value){
        if(value.length() > 2 && value.toUpperCase().startsWith("RA") && isNumeric(value.substring(2, value.length())))
            return true;
        
        return false;
    }

    public boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
 
        boolean foundDecimal = false;
        for (char c : str.toCharArray()) { // percorre a string
            if (!Character.isDigit(c)) { // verifica se eh digito
                if (c == '.' && !foundDecimal) { // verifica se existe um unico ponto
                    foundDecimal = true;
                } else {
                    return false;
                }
            }
        }            
        return true;
    }
    public boolean isAlfabeta(String str) {
        // Verifica se o caractere é alfabético (A-Z ou a-z) ou numérico (0-9)
        return (str.matches("[a-zA-ZàáâãäåéèêëíìîïóòôõöúùûüÿçÇ ]") || isNumeric(str));   

    }




}
