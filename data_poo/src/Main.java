import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a primeira data (ex: 01 01 2023):");
        int dia1 = scanner.nextInt();
        int mes1 = scanner.nextInt();
        int ano1 = scanner.nextInt();
        Data data1 = new Data(dia1, mes1, ano1);

        System.out.println("Digite a segunda data (ex: 01 01 2023):");
        int dia2 = scanner.nextInt();
        int mes2 = scanner.nextInt();
        int ano2 = scanner.nextInt();
        Data data2 = new Data(dia2, mes2, ano2);

        System.out.println();
        System.out.println("A primeira data é: ");
        data1.exibePorExtenso();
        System.out.println();

        System.out.println("A segunda data é: ");
        data2.exibePorExtenso();
        System.out.println();

        int resultado = data1.compareTo(data2);
        if (resultado > 0) {
            System.out.println("A data " + data1 + " vem depois da data " + data2);
        } else if (resultado < 0) {
            System.out.println("A data " + data2 + " vem depois da data " + data1);
        } else {
            System.out.println("As datas são iguais");
        }
    }
}