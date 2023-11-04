import java.sql.*;

public class Conect {
    Connection con;
    String c_user="root";
    String c_senha="";
    String c_fonte="jdbc:mysql://localhost/projeto4_java";
    //String c_fonte="jdbc:mysql://localhost:3306/projeto4_java?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    public Conect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        
            con = DriverManager.getConnection(c_fonte,c_user,c_senha);
            
            //System.out.println("Conexao sucedida");
    
    
        }catch (Exception e) { 
            System.out.println("Erro na Abertura do banco de Dados" + e); 
        }
    }
    public Connection getConn(){
        return con;
    }
    public void ExecutarQuery(String query){
        try{
            Statement st = getConn().createStatement();
            st.executeUpdate(query);

        }catch (Exception e){
            System.out.println("erro ao executar query 1\n\n"+e);
        }
    }
    public ResultSet ExecutarQuerySelect(String query){
       try{
            Statement st = getConn().createStatement();
            ResultSet rs = st.executeQuery(query);//query
            return rs;
            
        }catch (Exception e){
            System.out.println("erro ao executar query 2");
            return null;
        } 
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

}
