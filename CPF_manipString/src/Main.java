import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cpf;
        boolean valido;

        do {
            System.out.print("Digite o CPF (somente números): ");
            cpf = scanner.next();

            if (cpf.length() != 11) {
                System.out.println("CPF inválido! O CPF deve ter 11 dígitos.");
                System.out.print("Deseja validar outro CPF? (S/N) ");
                System.out.println("");
                continue;
            }

            valido = validarCPF(cpf);

            if (valido) {
                System.out.println("O CPF " + cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "."
                        + cpf.substring(6, 9) + "-" + cpf.substring(9) + " é válido.");
            } else {
                System.out.println("O CPF " + cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "."
                        + cpf.substring(6, 9) + "-" + cpf.substring(9) + " não é válido.");
            }

            System.out.print("Deseja validar outro CPF? (S/N) ");
            System.out.println("");
        } while (scanner.next().equalsIgnoreCase("S"));

        scanner.close();
    }

    public static boolean validarCPF(String cpf) {
        int soma = 0;
        int resto;

        for (int i = 0; i < 9; i++) {
            soma += Integer.parseInt(cpf.substring(i, i + 1)) * (10 - i);
        }

        resto = soma % 11;

        if (resto == 1 || resto == 0) {
            if (Integer.parseInt(cpf.substring(9, 10)) != 0) {
                return false;
            }
        } else if (Integer.parseInt(cpf.substring(9, 10)) != 11 - resto) {
            return false;
        }

        soma = 0;

        for (int i = 0; i < 10; i++) {
            soma += Integer.parseInt(cpf.substring(i, i + 1)) * (11 - i);
        }

        resto = soma % 11;

        if (resto == 1 || resto == 0) {
            if (Integer.parseInt(cpf.substring(10)) != 0) {
                return false;
            }
        } else if (Integer.parseInt(cpf.substring(10)) != 11 - resto) {
            return false;
        }

        return true;
    }
}