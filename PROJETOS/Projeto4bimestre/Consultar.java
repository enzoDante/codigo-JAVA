import java.sql.*;
public class Consultar extends Conect{
    public String[] getPaciente(String email){
        try{            
            String query = "SELECT * FROM Paciente where email='"+email+"'";
            ResultSet rs = ExecutarQuerySelect(query);
            if(rs.next()){                        
                int id = Integer.parseInt(rs.getString("id"));
                String nome = rs.getString("nome");
                Double altura = Double.parseDouble(rs.getString("altura"));
                Double peso = Double.parseDouble(rs.getString("peso"));
                Double imc = Double.parseDouble(rs.getString("imc"));
                String imcDesc = rs.getString("imcDesc");
                
                return new String[] {id+"", nome, email, altura+"", peso+"", imc+"", imcDesc};
            
            }

        }catch (Exception e) {
            System.out.println("Erro ao executar query de consulta");
        }
        return new String[] {"Paciente inexistente!"};

    }
}
