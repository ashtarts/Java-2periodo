import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos produtos deseja criar? ");
        int quantidadeProdutos = scanner.nextInt();

        Produto[] produtos = new Produto[quantidadeProdutos];

        for (int i = 0; i < quantidadeProdutos; i++) {
            System.out.println("Produto " + (i + 1) + ":");
            System.out.print("Código: ");
            String codigo = scanner.nextLine();
            System.out.print("Descrição: ");
            String descricao = scanner.nextLine();
            System.out.print("Fornecedor: ");
            String fornecedor = scanner.nextLine();
            System.out.print("Preço: ");
            double preco = scanner.nextDouble();
            System.out.print("Estoque: ");
            int estoque = scanner.nextInt();

            produtos[i] = new Produto(codigo, descricao, fornecedor, preco, estoque);
        }

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("\nDigite o número do produto para aplicar desconto: ");
                    int indiceDesconto = scanner.nextInt() - 1;
                    System.out.print("Digite o percentual de desconto: ");
                    double percentualDesconto = scanner.nextDouble();
                    produtos[indiceDesconto].Desconto(percentualDesconto);
                    break;
                case 2:
                    System.out.print("\nDigite o número do produto para aplicar aumento: ");
                    int indiceAumento = scanner.nextInt() - 1;
                    System.out.print("Digite o percentual de aumento: ");
                    double percentualAumento = scanner.nextDouble();
                    produtos[indiceAumento].Aumento(percentualAumento);
                    break;
                case 3:
                    System.out.print("\nDigite o número do produto para atualizar o estoque: ");
                    int indiceEstoque = scanner.nextInt() - 1;
                    System.out.print("Digite a quantidade a ser adicionada ao estoque: ");
                    int quantidadeEstoque = scanner.nextInt();
                    produtos[indiceEstoque].Estoque(quantidadeEstoque);
                    break;
                case 4:
                    System.out.print("\nDigite o número do produto para registrar a venda: ");
                    int indiceVenda = scanner.nextInt() - 1;
                    System.out.print("Digite a quantidade vendida: ");
                    int quantidadeVenda = scanner.nextInt();
                    produtos[indiceVenda].Vender(quantidadeVenda);
                    break;
                case 5:
                    System.out.println("\nProdutos após as alterações:");
                    for (Produto produto : produtos) {
                        System.out.println(produto);
                    }
                    break;
                case 6:
                    System.out.println("\nEncerrando o programa...");
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
            System.out.println();
        } while (opcao != 6);
    }

    private static void exibirMenu() {
        System.out.println("MENU");
        System.out.println("1. Aplicar desconto a um produto");
        System.out.println("2. Aplicar aumento a um produto");
        System.out.println("3. Atualizar estoque de um produto");
        System.out.println("4. Registrar venda de um produto");
        System.out.println("5. Exibir produtos");
        System.out.println("6. Sair do programa");
        System.out.print("Digite sua opção: ");
    }
}
