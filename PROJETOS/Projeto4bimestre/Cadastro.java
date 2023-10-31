import java.sql.*;
public class Cadastro extends Conect{
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private String cSenha;
    private String msg;
    private boolean aceito = true;
    private Connection conn;
    private Statement st;

    public Cadastro(){
        this.conn = getConn();
    }
    public String[] setValores(String nome, String email, String telefone, String senha, String csenha){
        try{
            //this.st = this.conn.createStatement();
            st = this.con.createStatement();
    
            this.setNome(nome);
    
            ResultSet rs=st.executeQuery("SELECT COUNT(*) FROM usuario where email="+email);
            //ResultSet rs = ExecutarQuery("SELECT COUNT(*) FROM usuario where email="+email);
            if(rs.next()){
                //int existe = Integer.parseInt(rs.getString("id"));
                int existe = rs.getInt(1);
                if(existe > 0){
                    this.msg = "E-mail existente!";
                    return new String[] {this.aceito+"",this.msg};
                }else
                this.setEmail(email);
            }
            
            this.setTelefone(telefone);
            if(senha.equals(csenha)){
                this.setSenha(senha);
                this.setCSenha(csenha);
            }else{
                this.msg = "Confirmar senha está diferente da senha!";
                return new String[] {this.aceito+"",this.msg};
            }
            
    
            this.msg = "Cadastrado com sucesso!";
            return new String[] {true+"",this.msg};
        }catch (Exception e){
            System.out.println("Erro ao executar query");
            return new String[] {};
        }
    }

    public void setNome(String value){
        this.nome = value;
    }
    public void setEmail(String value){
        this.email = value;
    }
    public void setTelefone(String value){
        this.telefone = value;
    }
    public void setSenha(String value){
        this.senha = value;
    }
    public void setCSenha(String value){
        if(getSenha().equals(value))
            this.cSenha = value;
        else{

        }
    }

    public String getNome(){
    return this.nome;
    }
    public String getEmail(){
        return this.email;
    }
    public String getTelefone(){
        return this.telefone;
    }
    public String getSenha(){
        return this.senha;
    }
}
