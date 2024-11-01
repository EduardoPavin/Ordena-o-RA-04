public class QuickSort {
    private int iteracoes;
    private int trocas;

    public void ordenar(int[] array) {
        iteracoes = 0;
        trocas = 0;
        quickSort(array, 0, array.length - 1);
    }




    private void quickSort(int[] array, int baixo, int alto) {
        iteracoes++; // Conta uma iteração
        if (baixo < alto) {
            int pi = particionar(array, baixo, alto);
            quickSort(array, baixo, pi - 1);
            quickSort(array, pi + 1, alto);
        }
    }

    private int particionar(int[] array, int baixo, int alto) {
        int pivo = array[alto];
        int i = (baixo - 1);
        for (int j = baixo; j < alto; j++) {
            iteracoes++;
            if (array[j] <= pivo) {
                i++;
                trocar(array, i, j);
                trocas++;
            }
        }
        trocar(array, i + 1, alto);
        trocas++;
        return i + 1;
    }




    private void trocar(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public int getIteracoes() {
        return iteracoes;
    }

    public int getTrocas() {
        return trocas;
    }
}
