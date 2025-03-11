import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {

    private JFrame frame;
    private JTextField display;
    private StringBuilder currentInput;

    public Entrada ent = new Entrada();

    public Calculadora() {
        currentInput = new StringBuilder();
        frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(new BorderLayout());

        // Display
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 30));
        display.setEditable(false);
        frame.add(display, BorderLayout.NORTH);

        // Painel de botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        // Botões da calculadora
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        // Adicionando botões ao painel
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("=")) {
                if(String.valueOf(ent.getN1()).length() != 0 && String.valueOf(ent.getN2()).length() != 0){
                    try {
                        ent.setOp();
                        //calcular corretamente os valores
                        Double response = ent.calc(ent.getN1(), ent.getN2(), ent.getOperador());
                        ent.setCalculado();
    
                        //double result = evaluateExpression(currentInput.toString());
    
                        display.setText(String.valueOf(response)); // result
                        currentInput.setLength(0);
                        currentInput.append(response); //result
    
                        ent.ClearN();
                        ent.addN1(String.valueOf(response));

    
                    } catch (Exception ex) {
                        display.setText("Erro");
                        currentInput.setLength(0);
                        ent.ClearN();
                        ent.setForceOp();
                    }
                }
            } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
                if(ent.getCalculado()) ent.setCalculado();
                if(ent.getOpAtiv()){
                    System.out.println("testee 11");
                    if(String.valueOf(ent.getN2()).length() == 0){
                        System.out.println("asdasdasdasdsadsa");
                        display.setText(command);
                        ent.setOperador(command);
                    }
                    else{
                        //calcular aq, pq operador foi ativado pela segunda vez (calcular resultado, adicionar na tela e adicionar o novo operador)
                        Double response = ent.calc(ent.getN1(), ent.getN2(), ent.getOperador());
    
                        ent.ClearN();
                        ent.addN1(String.valueOf(response));
    
                        display.setText(String.valueOf(response) + command); // result
                        currentInput.setLength(0);
                        currentInput.append(response);
                        currentInput.append(command);
                    }
                }
                else{
                    currentInput.append(command);
                    display.setText(currentInput.toString());
                    ent.setOp();
                }
                ent.setOperador(command);

            } 
            else {
                if(ent.getCalculado()){
                    ent.ClearN();
                    currentInput.setLength(0);
                    display.setText("");
                    ent.setCalculado();
                }
                currentInput.append(command);
                display.setText(currentInput.toString());
                if(!ent.getOpAtiv())
                    ent.addN1(command);
                else
                    ent.addN2(command);
            }
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculadora();
            }
        });
    }
}
