import java.sql.*;
public class Cadastro extends Conect{
    private String nome;
    private String email;
    private double altura;
    private double peso;
    private double imc;
    private String[] imcDescs = {"Magreza", "Saudavel", "Sobrepeso", "Obesidade grau I", "Obesidade grau II", "Obesidade grau III"};
    private String imcDesc;
    private String msg;
    private boolean aceito = true;
    //private Connection conn;
    //private Statement st;

    public Cadastro(){
        //this.conn = getConn();
    }
    public String[] setValores(String nome, String email, double altura, double peso){
        try{
            //this.st = this.conn.createStatement();
            //st = this.con.createStatement();    
            this.setNome(nome);    
            String query = "SELECT COUNT(*) FROM Paciente where email='"+email+"'";
            ResultSet rs = ExecutarQuerySelect(query);
            if(rs.next()){
                //int existe = Integer.parseInt(rs.getString("id"));
                int existe = rs.getInt(1);
                if(existe > 0){
                    this.msg = "E-mail existente!";
                    return new String[] {this.aceito+"",this.msg};
                }else
                this.setEmail(email);
            }
            
            this.setAltura(altura);
            this.setPeso(peso);
            this.setIMC();
            
            //inserir
            query = "INSERT INTO Paciente (nome, email, altura, peso, imc, imcDesc) VALUES(\""+this.getNome()+"\", \""+this.getEmail()+"\","+this.getAltura()+","+this.getPeso()+", "+this.getIMC()+", \""+this.getIMCDesc()+"\")";
            ExecutarQuery(query);
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
    public void setAltura(double value){
        this.altura = value;
    }
    public void setPeso(double value){
        this.peso = value;
    }
    public void setIMC(){
        this.imc = this.getPeso() / (this.getAltura() * this.getAltura());
        this.setIMCDesc(this.getIMC());
    }
    public void setIMCDesc(double imc){
        if(imc < 18.5)
            this.imcDesc = this.imcDescs[0];
        else if(imc < 25)
            this.imcDesc = this.imcDescs[1];
        else if(imc < 30)
            this.imcDesc = this.imcDescs[2];
        else if(imc < 35)
            this.imcDesc = this.imcDescs[3];
        else if(imc < 40)
            this.imcDesc = this.imcDescs[4];
        else
            this.imcDesc = this.imcDescs[5];
    }

    public String getNome(){
    return this.nome;
    }
    public String getEmail(){
        return this.email;
    }
    public double getAltura(){
        return this.altura;
    }
    public double getPeso(){
        return this.peso;
    }
    public double getIMC(){
        return this.imc;
    }
    public String getIMCDesc(){
        return this.imcDesc;
    }
}
