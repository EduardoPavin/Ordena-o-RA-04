public class RadixSort {
    private int iteracoes;
    private int trocas;

    public void ordenar(int[] array) {
        iteracoes = 0;
        trocas = 0;

        int[] positivos = new int[array.length];
        int[] negativos = new int[array.length];
        int posCount = 0, negCount = 0;

        for (int num : array) {
            if (num >= 0) {
                positivos[posCount++] = num;
            } else {
                negativos[negCount++] = -num;
            }
        }
        

        radixSort(positivos, posCount);
        radixSort(negativos, negCount);


        int index = 0;
        for (int i = negCount - 1; i >= 0; i--) {
            array[index++] = -negativos[i];
        }
        for (int i = 0; i < posCount; i++) {
            array[index++] = positivos[i];
        }
    }



    private void radixSort(int[] array, int length) {
        int max = getMax(array, length);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(array, length, exp);
        }
    }

    private void countSort(int[] array, int length, int exp) {
        int[] output = new int[length];
        int[] count = new int[10];





        for (int i = 0; i < length; i++) {
            iteracoes++;
            int index = (array[i] / exp) % 10;
            count[index]++;
        }

        for (int i = 1; i < 10; i++) {
            iteracoes++;
            count[i] += count[i - 1];
        }


        for (int i = length - 1; i >= 0; i--) {
            iteracoes++;
            int index = (array[i] / exp) % 10;
            output[count[index] - 1] = array[i];
            count[index]--;
            trocas++;
        }

        for (int i = 0; i < length; i++) {
            iteracoes++;
            array[i] = output[i];
        }
    }



    private int getMax(int[] array, int length) {
        int max = array[0];
        for (int i = 1; i < length; i++) {
            iteracoes++;
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public int getIteracoes() {
        return iteracoes;
    }

    public int getTrocas() {
        return trocas;
    }
}
