import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("quantas linahs");
        int linhas = scanner.nextInt();
        System.out.println("quantas colunas");
        int colunas = scanner.nextInt();
        double[][] matriz = new double[linhas][colunas];
        preencher(matriz, scanner);
        double[][] transposta = calcula(matriz);
        System.out.println("matriz transposta:");
        exibir(transposta);
        System.out.println("quantas linhas");
        int linhas2 = scanner.nextInt();
        System.out.println("quantas colunas");
        int colunas2 = scanner.nextInt();
        int[][] matriz2 = new int[linhas2][colunas2];
        int p = (int) menor(matriz2);
        System.out.println(p);
    }
    public static void preencher(double[][] matriz, Scanner scanner) {
        System.out.println("Digite os valores da matriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.printf("Posição (%d,%d): ", i+1, j+1);
                matriz[i][j] = scanner.nextInt();
            }
        }
    }
    public static void exibir(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }
    public static double[][] calcula(double[][] matriz) {
        int linhas = matriz[0].length;
        int colunas = matriz.length;
        double[][] transposta = new double[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                transposta[i][j] = matriz[j][i];
            }
        }
        return transposta;
    }
    public static double menor(int[][] matriz2) {
        int menor = matriz2[0][0];
        for (int i=0; i<matriz2.length;i++){
            for (int j=0;j<matriz2[i].length;i++){
                if(matriz2[i][j] < matriz2[i].length){
                    menor = matriz2[i][j];
                }
            }
        }
        return menor;
    }
}
