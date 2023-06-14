import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        Scanner scanner = new Scanner(System.in);

        int opcao = 9;
        while (opcao != 0) {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a matrícula do funcionário:");
                    scanner.nextLine();
                    String matricula = scanner.nextLine();
                    System.out.println("Digite o nome do funcionário:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o cargo do funcionário:");
                    String cargo = scanner.nextLine();
                    System.out.println("Digite o salário do funcionário:");
                    double salario = scanner.nextDouble();
                    System.out.println("Digite o ano de contratação do funcionário:");
                    int anoContratacao = scanner.nextInt();

                    Funcionario novo = new Funcionario(matricula, nome, cargo, salario, anoContratacao);
                    cadastro.adcionar(novo);
                    break;

                case 2:
                    cadastro.exibeFuncionario();
                    break;

                case 3:
                    System.out.println("Digite a matrícula do funcionário:");
                    scanner.nextLine();
                    matricula = scanner.nextLine();
                    cadastro.exibe(matricula);
                    break;

                case 4:
                    System.out.println("Digite a matrícula do funcionário:");
                    scanner.nextLine();
                    matricula = scanner.nextLine();
                    System.out.println("Digite o percentual de aumento:");
                    double pers = scanner.nextDouble();
                    cadastro.aumento(matricula, pers);
                    break;

                case 5:
                    System.out.println("Digite a matrícula do funcionário:");
                    scanner.nextLine();
                    matricula = scanner.nextLine();
                    cadastro.demite(matricula);
                    break;

                case 6:
                    cadastro.crescente();
                    break;

                case 7:
                    cadastro.decrescente();
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    public static void exibirMenu() {
        System.out.println("1 - Adicionar funcionário");
        System.out.println("2 - Exibir funcionários cadastrados");
        System.out.println("3 - Exibir dados de um funcionário");
        System.out.println("4 - Aplicar aumento de salário");
        System.out.println("5 - Demitir funcionário");
        System.out.println("6 - Ordenar cadastro em ordem crescente");
        System.out.println("7 - Ordenar cadastro em ordem decrescente");
        System.out.println("0 - Encerrar o programa");
        System.out.println("Digite a opção desejada:");
    }
}