class Cadastro {
    private Funcionario[] funcionarios;
    private int cont;

    public Cadastro() {
        funcionarios = new Funcionario[1000];
        cont = 0;
    }

    public void adcionar(Funcionario novo) {
        if (procura(novo.getMatricula()) == -1) {
            funcionarios[cont] = novo;
            cont++;
            System.out.println("Funcionário cadastrado com sucesso.");
        } else {
            System.out.println("Já existe um funcionário com essa matrícula.");
        }
    }

    public void exibeFuncionario() {
        System.out.println("Lista de Funcionários:");
        for (int i = 0; i < cont; i++) {
            System.out.println(funcionarios[i]);
        }
    }

    public int procura(String matricula) {
        for (int i = 0; i < cont; i++) {
            if (funcionarios[i].getMatricula().equals(matricula)) {
                return i;
            }
        }
        return -1;
    }

    public void aumento(String matricula, double pers) {
        int posicao = procura(matricula);
        if (posicao != -1) {
            Funcionario funcionario = funcionarios[posicao];
            funcionario.aplicarAumento(pers);
            System.out.println("Aumento aplicado com sucesso.");
        } else {
            System.out.println("Matrícula inexistente.");
        }
    }

    public void exibe(String matricula) {
        int posicao = procura(matricula);
        if (posicao != -1) {
            Funcionario funcionario = funcionarios[posicao];
            System.out.println("Dados do Funcionário:");
            System.out.println(funcionario);
        } else {
            System.out.println("Matrícula inexistente.");
        }
    }

    public void demite(String matricula) {
        int posicao = procura(matricula);
        if (posicao != -1) {
            for (int i = posicao; i < cont - 1; i++) {
                funcionarios[i] = funcionarios[i + 1];
            }
            cont--;
            System.out.println("Funcionário demitido com sucesso.");
        } else {
            System.out.println("Matrícula inexistente.");
        }
    }

    public void crescente() {
        for (int i = 1; i < cont; i++) {
            Funcionario chave = funcionarios[i];
            int j = i - 1;
            while (j >= 0 && funcionarios[j].compareTo(chave) > 0) {
                funcionarios[j + 1] = funcionarios[j];
                j--;
            }
            funcionarios[j + 1] = chave;
        }
        System.out.println("Cadastro ordenado em ordem crescente.");
    }

    public void decrescente() {
        for (int i = 0; i < cont - 1; i++) {
            int max = i;
            for (int j = i + 1; j < cont; j++) {
                if (funcionarios[j].compareTo(funcionarios[max]) > 0) {
                    max = j;
                }
            }
            Funcionario temp = funcionarios[i];
            funcionarios[i] = funcionarios[max];
            funcionarios[max] = temp;
        }
        System.out.println("Cadastro ordenado em ordem decrescente.");
    }
}
