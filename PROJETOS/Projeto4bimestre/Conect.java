import java.sql.*;

public class Conect {
    Connection con;
    String c_user="root";
    String c_senha="";
    //String c_fonte="jdbc:mysql://localhost/projeto4_java";
    String c_fonte="jdbc:mysql://localhost:3306/projeto4_java";

    public Conect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        
            con = DriverManager.getConnection(c_fonte,c_user,c_senha);
            
            System.out.println("Conexao FEITA");
    
    
        }catch (Exception e) { 
            System.out.println("Erro na Abertura do banco de Dados" + e); 
        }
    }
    public Connection getConn(){
        return con;
    }
    /*public Boolean ExecutarQuery(String query){
        try{
            Statement st = getConn().createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs)
            return true;

        }catch (Exception e){
            return false;
        }
    }*/
    /*public static void main(String[] args){
        try{
            String c_user="root";
            String c_senha="";
            String c_fonte="jdbc:mysql://localhost/projeto4_java";
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection(c_fonte,c_user,c_senha);
            
            System.out.println("Conexao MS-ACCESS O.K.");
    
    
        }catch (Exception e) { 
            System.out.println("Erro na Abertura do banco de Dados"); 
        }
    }*/

}
