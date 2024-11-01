public class MedidorDeDesempenho {
    private QuickSort quickSort;
    private RadixSort radixSort;

    public MedidorDeDesempenho() {
        quickSort = new QuickSort();
        radixSort = new RadixSort();
    }




    public Resultado medirQuickSort(int[] array) {
        int[] copia = array.clone();
        long tempoInicio = System.nanoTime();
        quickSort.ordenar(copia);
        long tempoFim = System.nanoTime();
        return new Resultado(tempoFim - tempoInicio, quickSort.getIteracoes(), quickSort.getTrocas());
    }




    public Resultado medirRadixSort(int[] array) {
        int[] copia = array.clone();
        long tempoInicio = System.nanoTime();
        radixSort.ordenar(copia);
        long tempoFim = System.nanoTime();
        return new Resultado(tempoFim - tempoInicio, radixSort.getIteracoes(), radixSort.getTrocas());
    }
}
