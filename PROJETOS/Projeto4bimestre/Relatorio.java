import java.sql.*;
import java.io.*;
public class Relatorio extends Conect{
    private int total = 0;

    public int[] qtdIMC(){
        try {
            int magreza = 0, saudavel = 0, sobrepeso = 0, obsg1 = 0, obsg2 = 0, obsg3 = 0;
            String query = "SELECT COUNT(*) FROM Paciente";
            ResultSet rs = ExecutarQuerySelect(query);
            if(rs.next()){
                this.total = rs.getInt(1);
            }

            query = "SELECT COUNT(*) FROM Paciente WHERE imc < 18.5";
            rs = ExecutarQuerySelect(query);
            if(rs.next()){
                magreza = rs.getInt(1);
            }
            query = "SELECT COUNT(*) FROM Paciente WHERE imc >= 18.5 AND imc< 25";
            rs = ExecutarQuerySelect(query);
            if(rs.next()){
                saudavel = rs.getInt(1);
            }
            query = "SELECT COUNT(*) FROM Paciente WHERE imc >= 25 AND imc < 30";
            rs = ExecutarQuerySelect(query);
            if(rs.next()){
                sobrepeso = rs.getInt(1);
            }
            query = "SELECT COUNT(*) FROM Paciente WHERE imc >= 30  AND imc < 35";
            rs = ExecutarQuerySelect(query);
            if(rs.next()){
                obsg1 = rs.getInt(1);
            }
            query = "SELECT COUNT(*) FROM Paciente WHERE imc >= 35 AND imc < 40";
            rs = ExecutarQuerySelect(query);
            if(rs.next()){
                obsg2 = rs.getInt(1);
            }
            query = "SELECT COUNT(*) FROM Paciente WHERE imc >= 40";
            rs = ExecutarQuerySelect(query);
            if(rs.next()){
                obsg3 = rs.getInt(1);
            }

            return new int[] {magreza, saudavel, sobrepeso, obsg1, obsg2, obsg3};
        } catch (Exception e) {
            System.out.println("Erro ao executar query quantidade de pessoas");
        }
        return null;
        
    }
    public String todosPacientes(){
        try {
            String tabela = "<table border=\"1\">\r\n" +
                    "        <tr>\r\n" +
                    "            <th>Nome</th>\r\n" +
                    "            <th>Peso (kg)</th>\r\n" +
                    "            <th>Altura (m)</th>\r\n" +
                    "            <th>IMC</th>\r\n" +
                    "            <th>Classificação</th>\r\n" +
                    "        </tr>\r\n";

            String query = "SELECT * FROM Paciente ORDER BY nome";
            ResultSet rs = ExecutarQuerySelect(query);
            while(rs.next()){
                tabela += "<tr>\r\n" +
                    "   <td>"+rs.getString("nome")+"</td>\r\n" +
                    "   <td>"+rs.getString("peso")+"</td>\r\n" +
                    "   <td>"+rs.getString("altura")+"</td>\r\n" +
                    "   <td>"+rs.getString("imc")+"</td>\r\n" +
                    "   <td>"+rs.getString("imcDesc")+"</td>\r\n" +
                    "</tr>";
            }
            tabela += "</table>";
            return tabela;

        } catch (Exception e) {
            System.out.println("Erro ao executar query de select");
        }
        return null;
    }
    public void gerarRelatorio(){

        int[] valores = qtdIMC();

        String htmlText = "<!DOCTYPE html>\r\n" + 
                "<html lang=\"en\">\r\n" + 
                "<head>\r\n" + 
                "<meta charset=\"UTF-8\">\r\n" + 
                "<title>Document</title>\r\n" + 
                "<script src='https://cdn.plot.ly/plotly-2.27.0.min.js'></script>\r\n" + 
                "<style>\r\n" + 
                    "table {\r\n" + 
                    "   border-collapse: collapse;\r\n" + 
                    "   width: 50%;\r\n" + 
                    "   margin: 0 auto;\r\n" + 
                    "   margin-top: 20px;\r\n" +
                    "}\r\n" + 
                    "th, td {\r\n" + 
                    "   padding: 10px;\r\n" + 
                    "   text-align: center;\r\n" + 
                    "}\r\n" + 
                    "th {\r\n" + 
                    "   background-color: white;\r\n" + 
                    "   color: black;\r\n" + 
                    "}\r\n" + 
                    "tr:nth-child(even) {\r\n" + 
                    "   background-color: #f2f2f2;\r\n" + 
                    "}\r\n" + 
                    "tr:nth-child(odd) {\r\n" + 
                    "   background-color: #e0e0e0;\r\n" + 
                    "}\r\n" + 
                "</style>" +
                "</head>\r\n" + 
                "<body>\r\n" + 
                "<center><div id='myDiv' style=\"width: 500px; height:500px;\">Pesquisa de Indice\r\n" + 
                "de Massa Corporal</div></center>\r\n" + 
                "<script>\r\n" + 
                "var data = [{\r\n" + 
                "type: 'scatterpolar',\r\n" + 
                "r: ["+valores[0]+", "+valores[1]+", "+valores[2]+", "+valores[3]+", "+valores[4]+", "+valores[5]+"],\r\n" + 
                "theta: ['Magreza','Saúdavel','Sobrepeso', 'OBG-I', 'OBG-II', 'OBG-III'],\r\n" + 
                "fill: 'toself'\r\n" + 
                "}]\r\n" + 
                "layout = {\r\n" + 
                "polar: {\r\n" + 
                "radialaxis: {\r\n" + 
                "visible: true,\r\n" + 
                "range: [0, 10]\r\n" +  //"+this.total+" 50
                "}\r\n" + 
                "},\r\n" + 
                "showlegend: false\r\n" + 
                "}\r\n" + 
                "Plotly.newPlot(\"myDiv\", data, layout)\r\n" + 
                "</script>\r\n" + 
                todosPacientes() +
                "</body>\r\n" + 
                "</html>";
        try {
            FileWriter arquivo = new FileWriter("relatorio.html", false);
            arquivo.write(htmlText);
            arquivo.close();
        } catch (Exception e) {
            System.out.println("Erro ao gerar arquivo!");
        }
        
    }
}
