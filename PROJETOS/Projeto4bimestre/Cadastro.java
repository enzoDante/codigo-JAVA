import java.sql.*;
public class Cadastro extends Conect{
    private String nome;
    private String email;
    private double altura;
    private double peso;
    private String msg;
    private boolean aceito = true;

    public String[] setValores(String nome, String email, double altura, double peso){
        try{  
            this.setNome(nome);    
            String query = "SELECT COUNT(*) FROM Paciente where email='"+email+"' OR nome='"+nome+"'";
            ResultSet rs = ExecutarQuerySelect(query);
            if(rs.next()){
                
                int existe = rs.getInt(1);
                if(existe > 0){
                    this.msg = "E-mail ou Nome existente!";
                    return new String[] {this.aceito+"",this.msg};
                }else
                this.setEmail(email);
            }            
            this.setAltura(altura);
            this.setPeso(peso);
            
            CalcIMC CalculIMC = new CalcIMC();
            String[] imcvalues = CalculIMC.DadosIMCCalc(this.getPeso(), this.getAltura());
            
            //inserir
            query = "INSERT INTO Paciente (nome, email, altura, peso, imc, imcDesc) VALUES(\""+this.getNome()+"\", \""+this.getEmail()+"\","+this.getAltura()+","+this.getPeso()+", "+Double.parseDouble(imcvalues[0])+", \""+imcvalues[1]+"\")";
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
}
