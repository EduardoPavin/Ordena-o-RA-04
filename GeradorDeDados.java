import java.util.Random;

public class GeradorDeDados {
    private int[][] conjuntosDeDados;
    private int numeroDeConjuntos;
    private int tamanhoDosDados;
    private long seed;




    public GeradorDeDados(int numeroDeConjuntos, int tamanhoDosDados, long seed) {
        this.numeroDeConjuntos = numeroDeConjuntos;
        this.tamanhoDosDados = tamanhoDosDados;
        this.seed = seed;
        this.conjuntosDeDados = new int[numeroDeConjuntos][tamanhoDosDados];
        gerarConjuntosDeDados();
    }





    private void gerarConjuntosDeDados() {
        for (int i = 0; i < numeroDeConjuntos; i++) {
            Random rand = new Random(seed + i);
            for (int j = 0; j < tamanhoDosDados; j++) {
                conjuntosDeDados[i][j] = rand.nextInt(); // Gera números inteiros aleatórios
            }
        }
    }




    public int[][] getConjuntosDeDados() {
        return conjuntosDeDados;
    }





    public static void main(String[] args) {
        GeradorDeDados gerador = new GeradorDeDados(1, 200, 42);
        int[][] dados = gerador.getConjuntosDeDados();

        for (int num : dados[0]) {
            System.out.println(num);
        }
    }
}
