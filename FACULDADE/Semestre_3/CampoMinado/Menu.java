import java.awt.*;
import javax.swing.*;

public class Menu {
    private CardLayout layout;
    private Container tela;
    private JPanel cards;

    public Menu(Container tela) {
        this.tela = tela;
        this.layout = new CardLayout();
        this.cards = new JPanel(layout);
        
        criarMenu();
        tela.add(cards);
    }

    private void criarMenu() {
        // Tela de Menu
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

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
        JPanel jogoPanel = new JPanel();
        jogoPanel.setLayout(new BorderLayout());

        int dimensao = 10; // Exemplo de tamanho
        ComponenteSWING comp = new ComponenteSWING(jogoPanel, dimensao);

        comp.cabeca(); // Você deve implementar o cabeçalho no painel se necessário
        comp.iniciarCampo();

        cards.add(jogoPanel, "jogo");
        layout.show(cards, "jogo");
    }
}