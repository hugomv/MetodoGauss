import java.util.Arrays;

public class EliminacaoGauss {



    int matrizA[][] = new int[10][10];
    int matrizB[] = new int[10];
    int k = 0;
    int [] pivo = new int[2];
    int[] multiplicadoresA;

    /**
     * Preenche a matriz quadrada 10 X 10 dos coeficientes
     * @param matriz
     */
    public void preencherMatrizA(int [][]matriz){
        matrizA = matriz;
    }

    /**
     * Preenche a matriz coluna dos termos independentes.
     * @param matriz
     */
    public void preencherMatrizB(int []matriz){
        matrizB = matriz;
    }

    /**
     * Seleciona o pivô para o valor de k. Pivô não pode ser zero.
     */
    public void selecionarPivo() {
        if (matrizA[k][k] != 0) {
            pivo[0] = k;
            pivo[1] = k;
        }else {
            //invertendo as linhas
            int[][] auxA = matrizA;
            int[] auxB = matrizB;

            matrizA[k] = auxA[k+1];
            matrizA[k+1] = auxA[k];

            matrizB[k] = auxB[k+1];
            matrizB[k+1] = auxB[k];

            selecionarPivo();
        }
    }

    /**
     * Calcula um array de multiplicadores, de tamanho 10-k
     */
    public void calcularMultiplicadores(){

        multiplicadoresA = new int[(matrizA.length-1) - k];
        int j = 0;
        for(int i = k +1;i<matrizA.length;i++){
            multiplicadoresA[j] = matrizA[i][k] / matrizA[pivo[0]][pivo[1]];
            j++;
        }
    }

    /**
     * Multiplica a matriz inteira pelos multiplicadores
     */
    public void multiplicarMatriz(){

        for(int coluna = 0;coluna<matrizA[0].length;coluna++){
            int m = 0;
            for(int linha = k+1;linha<matrizA.length;linha++){
                matrizA[linha][coluna] = matrizA[linha][coluna] - multiplicadoresA[m++] * matrizA[pivo[0]][coluna];
            }
        }
        int l = 0;
        for(int i = k +1;i<matrizB.length;i++) {
            matrizB[i] = matrizB[i] - multiplicadoresA[l++] * matrizB[pivo[0]];
        }
    }

    /**
     * Retorna os valores de X
     */
    public int[] retornaValoresdeX(){
        int[] valores = new int[matrizB.length];
        for(int x : matrizB){
                
        }
    }


    /**
     * Iterar o valor de k
     */
    public void iterarK(){

        while(k<=matrizA.length){
            selecionarPivo();
            calcularMultiplicadores();
            multiplicarMatriz();
        }
    }





}
