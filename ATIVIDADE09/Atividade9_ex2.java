/* *******************************************************************
 * Colegio Técnico Antônio Teixeira Fernandes (Univap)
 * Curso Técnico em Informática - Data de Entrega: 12/09/2023
 * Autores do Projeto: Enzo Dante Mícoli
 * Turma: 3H  Disciplina: Programação - II
 * Avaliação parcial referente ao 1 - Bimestre
 * Observação: <colocar se houver>
 * 
 * nome_arquivo.java
 * ******************************************************************/
import java.awt.*;

public class Atividade9_ex2 extends Frame{
	Panel p1;
	Panel p2;
	Panel p3;
	Label labe1;
	Label labe2;
	Label labe3;
	TextField text1;
	Button btn1;
	public Atividade9_ex2(){
		setLayout(new BorderLayout());
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		labe1 = new Label("Digite um texto:");
		labe2 = new Label("Digite um caractere:");
		labe3 = new Label("=======================================");
		text1 = new TextField(30);
		btn1 = new Button("Verificar");


		add("North", p1);
		p1.add(labe1);
		p1.add(text1);
		p1.add(labe2);

		add("Center", p2);
		p2.add(labe3);

		add("South", p3);
		p3.add(btn1);

		reshape(100, 100, 700, 300);
		show();
	}
	public boolean action(Event evt, Object arg){
		if("Verificar".equals(arg)){
			String txt = text1.getText();
            
            String resultado = removerRepetido(txt);
			text1.setText(resultado);
			labe3.setText(resultado);
		}
		return true;

	}
    public String removerRepetido(String value){
        int totalC = 0;
        String resultado = value;
        int z = 0;
        for(int i = 0; i < value.length(); i++){
            for(int x = 0; x < resultado.length(); x++){
                if(resultado.charAt(z) == resultado.charAt(x))
                    totalC++;
            }
            if(totalC > 1)
                resultado = resultado.replace(resultado.charAt(z)+"", "");
            totalC = 0;
            if(z < resultado.length()-1)
                z++;
            
        }
        return resultado;
    }
	public static void main(String args[]){
		new Atividade9_ex2();
	}
}