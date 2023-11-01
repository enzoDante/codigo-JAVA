import java.text.DecimalFormat;
import java.sql.*;
public class Alterar extends Conect{
    public String[] setDadosBanco(int id, String nome, String email, double altura, double massa){
        try {
            ResultSet rs = ExecutarQuerySelect("SELECT COUNT(*) FROM Paciente WHERE id="+id);
            if(rs.next()){
                int exist = rs.getInt(1);
                if(exist > 0){
                    CalcIMC calcularIMC = new CalcIMC();
                    String[] imcs = calcularIMC.DadosIMCCalc(massa, altura);

                    String query = "UPDATE Paciente SET nome=\""+nome+"\", email=\""+email+"\", altura="+altura+", peso="+massa+", imc="+Double.parseDouble(imcs[0])+", imcDesc=\""+imcs[1]+"\" WHERE id="+id;

                    ExecutarQuery(query);
                    DecimalFormat form = new DecimalFormat();
                    form.applyPattern("#.##");
                    String imcForm = form.format(Double.parseDouble(imcs[0]));
                    
                    return new String[] {"Dados do Paciente atualizado!", imcForm, imcs[1]};
                }else
                    return new String[] {"Paciente inexistente!"};
            }
        } catch (Exception e) {
            System.out.println("erro ao executar query alterar");
        }
        
        return null;
    }
}
