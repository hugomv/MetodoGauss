public class Execucao {

    public static void main(String[] args) {

        // write your code here

        EliminacaoGauss eliminacaoGauss = new EliminacaoGauss();
        float matriz[][] = {{1,2,3,4},{2,1,2,3},{3,2,1,2},{4,3,2,1}};
        eliminacaoGauss.preencherMatrizA(matriz);
        float matrizB[] = {10,7,6,5};
        eliminacaoGauss.preencherMatrizB(matrizB);
        eliminacaoGauss.iterarK();
        float[] resultados = eliminacaoGauss.retornaValoresdeX();

        int k = 0;
        for (float i : resultados){
            System.out.format("x%d = %f",k,i);
            k++;
        }

    }
}
