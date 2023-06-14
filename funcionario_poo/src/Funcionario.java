import java.util.Scanner;

class Funcionario  {
    private String matricula;
    private String nome;
    private String cargo;
    private double salario;
    private int anoContratacao;

    public Funcionario(String matricula, String nome, String cargo, double salario, int anoContratacao) {
        this.matricula = matricula;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.anoContratacao = anoContratacao;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public int getAnoContratacao() {
        return anoContratacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setAnoContratacao(int anoContratacao) {
        this.anoContratacao = anoContratacao;
    }

    public void aplicarAumento(double percentual) {
        salario += salario * percentual / 100.0;
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula +
                ", Nome: " + nome +
                ", Cargo: " + cargo +
                ", Salário: " + salario +
                ", Ano de Contratação: " + anoContratacao;
    }
    public int compareTo(Funcionario outroFuncionario) {
        return matricula.compareTo(outroFuncionario.matricula);
    }
}