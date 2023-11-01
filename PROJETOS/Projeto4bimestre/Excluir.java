public class Excluir extends Consultar{
    public String ExcluirPaciente(String value){
        try {
            String[] response = getPaciente(value);
            if(response.length > 1){
                int id = Integer.parseInt(response[0]);
                String query = "DELETE FROM Paciente WHERE id="+id;
                ExecutarQuery(query);
                return "Paciente excluido!";
            }

        } catch (Exception e) {
            System.out.println("Erro ao executar query Excluir ");
        }
        return "Paciente inexistente!";

    }
}
