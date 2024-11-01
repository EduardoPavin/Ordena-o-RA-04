import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;




public class Main extends JFrame {
    private JButton botaoExecutar;
    private JTextArea areaDeResultados;
    private JPanel painelGraficos;

    public Main() {
        setTitle("Análise de Algoritmos de Ordenação");
        setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciaComponentes();
        //System.out.println("Janela Principal inicializada.");
    }

    private void iniciaComponentes() {
        botaoExecutar = new JButton("Executar Testes");
        areaDeResultados = new JTextArea();
        areaDeResultados.setEditable(false);
        painelGraficos = new JPanel();

        botaoExecutar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executarTestes();
            }
        });




        JScrollPane scrollPane = new JScrollPane(areaDeResultados);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(botaoExecutar, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(painelGraficos, BorderLayout.SOUTH);
    }

    private void executarTestes() {
        Executor executor = new Executor();
        executor.executarTestes(areaDeResultados, painelGraficos);
        Random random = new Random(42); // você pode alterar a seed (42)
        int[] numbers = new int[200];



        for (int i = 0; i < 200; i++) {
            numbers[i] = random.nextInt();

        }



        for (int num : numbers) {
            System.out.println(num);
        }
        executor.executarTestes(areaDeResultados, painelGraficos);

        System.out.println("Execução dos testes concluída.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
    //System.out.println("Aplicação inicializada.");
}
