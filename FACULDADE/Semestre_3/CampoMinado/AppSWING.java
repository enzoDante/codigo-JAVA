
import java.awt.*;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AppSWING extends JFrame{
    private CardLayout layout;
    private JPanel cards;
    
    public AppSWING(){
        setTitle("Campo Minado Ligado");


        layout = new CardLayout();
        cards = new JPanel(layout);
        // criarMenu();
        getContentPane().add(cards);
        Menu menu = new Menu(cards);
        
        // Container tela = getContentPane();
        // int tamanho = 10;
        
        // ComponenteSWING comp = new ComponenteSWING(tela, tamanho);
        // comp.iniciarCampo();
        


        setSize(600, 600);
        setResizable(false);
        // pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        new AppSWING();
    }

    private void criarMenu(){
        // Painel do Menu
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Campo Minado");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton jogarBtn = new JButton("Jogar");
        jogarBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        jogarBtn.addActionListener(e -> iniciarJogo());

        menuPanel.add(Box.createVerticalGlue());
        menuPanel.add(titulo);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        menuPanel.add(jogarBtn);
        menuPanel.add(Box.createVerticalGlue());

        cards.add(menuPanel, "menu");
        layout.show(cards, "menu");
    }

    private void iniciarJogo() {
        JPanel jogoPanel = new JPanel(new BorderLayout());

        int tamanho = 10;
        ComponenteSWING comp = new ComponenteSWING(jogoPanel, tamanho);

        comp.cabeca();        // Se você quiser que o cabeçalho vá no topo
        comp.iniciarCampo();  // Campo minado

        cards.add(jogoPanel, "jogo");
        layout.show(cards, "jogo");
    }

}
