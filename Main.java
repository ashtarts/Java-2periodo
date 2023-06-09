import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int tam = 100;
        String[] nome = new String[tam];
        int contador = 0;
        int estadoVetor = 1;

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("—————— Opções disponíveis: ——————————| ");
            System.out.println("    1. Cadastrar novo nome           | ");
            System.out.println("    2. Exibir todos os nomes         | ");
            System.out.println("    3. Ordenar em ordem crescente    | ");
            System.out.println("    4. Ordenar em ordem decrescente  | ");
            System.out.println("    5. Realizar busca                | ");
            System.out.println("    0. Sair do programa              | ");
            System.out.println("      Informe a opção desejada:      | ");
            System.out.println("—————————————————————————————————————| ");
            System.out.print("R:");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    int resultadoInsercao = adicionarNome(nome, contador);
                    if (resultadoInsercao == 1) {
                        contador++;
                        estadoVetor = 1;
                    } else if (resultadoInsercao == -1) {
                        System.out.println("O vetor está cheio. Não é possível adicionar nomes.");
                    } else if (resultadoInsercao == -2) {
                        System.out.println("O nome já existe no vetor. Não foi colocado.");
                    }
                }
                case 2 -> exibirNomes(nome, contador);
                case 3 -> {
                    Crescente(nome, contador);
                    estadoVetor = 2;
                    System.out.println("Vetor em ordem crescente.");
                }
                case 4 -> {
                    Decrescente(nome, contador);
                    estadoVetor = 3;
                    System.out.println("Vetor em ordem decrescente.");
                }
                case 5 -> {
                    busca(nome, contador, estadoVetor, scanner);
                }

                case 0 -> System.out.println("Encerrando o programa...");
                default -> System.out.println("Opção inválida. Digite novamente.");
            }

            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }
    private static void busca(String[] nome, int contador, int estadoVetor, Scanner scanner) {
        System.out.print("Digite o nome a ser buscado: ");
        scanner.nextLine();

        String nomeBusca = scanner.nextLine();
        int posicao;

        if (estadoVetor == 1) {
            posicao = buscaSequencial(nome, contador, nomeBusca);
        } else if (estadoVetor == 2) {
            posicao = buscaBinaria(nome, contador, nomeBusca);
        } else {
            posicao = buscaBinariaDecrescente(nome, contador, nomeBusca);
        }

        if (posicao != -1) {
            System.out.println("O nome está na posição " + (posicao + 1) + " do vetor.");
        } else {
            System.out.println("O nome não foi encontrado.");
        }
    }
    private static int adicionarNome(String[] nome, int contador) {
        final int tam = nome.length;

        if (contador >= tam) {
            return -1;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome a ser adicionado: ");
        String name = scanner.nextLine();

        for (int i = 0; i < contador; i++) {
            if (nome[i].equals(name)) {
                return -2;
            }
        }

        nome[contador] = name;
        return 1;
    }

    private static void exibirNomes(String[] nome, int contador) {
        System.out.println("Nomes armazenados:");
        for (int i = 0; i < contador; i++) {
            System.out.println(nome[i]);
        }
    }

    private static void Crescente(String[] nome, int contador) {
        for (int i = 1; i < contador; i++) {
            String name = nome[i];
            int j = i - 1;
            while (j >= 0 && nome[j].length() > name.length()) {
                nome[j + 1] = nome[j];
                j--;
            }
            nome[j + 1] = name;
        }
    }
    private static void Decrescente(String[] nome, int contador) {
        for (int i = 1; i < contador; i++) {
            String name = nome[i];
            int j = i - 1;
            while (j >= 0 && nome[j].length() < name.length()) {
                nome[j + 1] = nome[j];
                j--;
            }
            nome[j + 1] = name;
        }
    }


    private static int buscaSequencial(String[] nome, int contador, String nomeBusca) {
        for (int i = 0; i < contador; i++) {
            if (nome[i].equals(nomeBusca)) {
                return i;
            }
        }
        return -1;
    }

    private static int buscaBinaria(String[] nome, int contador, String nomeBusca) {
        int esquerda = 0;
        int direita = contador - 1;

        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            int comparacao = nome[meio].compareTo(nomeBusca);

            if (comparacao == 0) {
                return meio;
            } else if (comparacao < 0) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        return -1;
    }

    private static int buscaBinariaDecrescente(String[] nome, int contador, String nomeBusca) {
        int esquerda = 0;
        int direita = contador - 1;

        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            int comparacao = nome[meio].compareTo(nomeBusca);

            if (comparacao == 0) {
                return meio;
            } else if (comparacao > 0) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        return -1;
    }
}
