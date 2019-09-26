public class EliminacaoGauss {



    float matrizA[][] = new float[10][10];
    float matrizB[] = new float[10];
    int k = 0;
    int [] pivo = new int[2];
    float[] multiplicadoresA;

    /**
     * Preenche a matriz quadrada 10 X 10 dos coeficientes
     * @param matriz
     */
    public void preencherMatrizA(float[][] matriz){
        matrizA = matriz;
    }

    /**
     * Preenche a matriz coluna dos termos independentes.
     * @param matriz
     */
    public void preencherMatrizB(float[] matriz){
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
            float[][] auxA = matrizA;
            float[] auxB = matrizB;

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

        multiplicadoresA = new float[(matrizA.length - 1) - k];
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
    public float[] retornaValoresdeX(){
        float[] valores = new float[matrizB.length];

        for(int i = matrizA.length-1;i>-1;i--){
            valores[i] = (matrizB[i] - multiplicacao(matrizA[i],valores,i+1,matrizA.length-1)) / matrizA[i][i];
        }
        return valores;
    }



    /**
     * Iterar o valor de k
     */
    public void iterarK(){

        while(k<matrizA.length-1){
            selecionarPivo();
            calcularMultiplicadores();
            multiplicarMatriz();
            k++;
        }
    }

    private float soma(float[] input, int inicio, int fim){
        if(inicio<0 || fim>=input.length || inicio > fim) return 0;
        float soma = 0;
        for(int i = inicio; i<fim+1; i++){
            soma =+ input[i];
        }
            return soma;
    }

    private float multiplicacao(float[] input, float[] inputB, int inicio, int fim){
        if(inicio<0 || fim>input.length-1 || inicio > fim) return 0;
        float multiplicacao = 0;
        for(int i = inicio; i<fim+1; i++){
            multiplicacao += input[i] * inputB[i];
        }
        return multiplicacao;
    }





}
