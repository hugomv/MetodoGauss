public class Execucao {

    public static void main(String[] args) {

        // write your code here

        EliminacaoGauss eliminacaoGauss = new EliminacaoGauss();
        int matriz[][] = {{1,2,3,4},{2,1,2,3},{3,2,1,2},{4,3,2,1}};
        eliminacaoGauss.preencherMatrizA(matriz);
        int matrizB[] = {10,7,6,5};
        eliminacaoGauss.preencherMatrizB(matrizB);
        eliminacaoGauss.iterarK();

    }
}
