import java.util.Scanner;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        if (dataValida(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            this.dia = 1;
            this.mes = 1;
            this.ano = 1;
        }
    }

    private boolean dataValida(int dia, int mes, int ano) {
        if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || ano < 1) {
            return false;
        }

        boolean bissexto = (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);

        int[] diasPorMes = { 31, bissexto ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        return dia <= diasPorMes[mes - 1];
    }

    public int compareTo(Data outraData) {
        int resultado = 0;

        if (this.ano > outraData.ano) {
            resultado = 1;
        } else if (this.ano < outraData.ano) {
            resultado = -1;
        } else {
            if (this.mes > outraData.mes) {
                resultado = 1;
            } else if (this.mes < outraData.mes) {
                resultado = -1;
            } else {
                if (this.dia > outraData.dia) {
                    resultado = 1;
                } else if (this.dia < outraData.dia) {
                    resultado = -1;
                }
            }
        }

        return resultado;
    }

    private String obterDiaSemana() {
        int a = (14 - mes) / 12;
        int y = ano - a;
        int m = mes + 12 * a - 2;
        int d = (dia + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12) % 7;

        String[] diasSemana = { "Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira",
                "Sexta-feira", "Sábado" };

        return diasSemana[d];
    }

    public void exibePorExtenso() {
        String[] meses = { "janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro",
                "outubro", "novembro", "dezembro" };

        String diaSemana = obterDiaSemana();

        System.out.println(diaSemana + ", " + dia + " de " + meses[mes - 1] + " de " + ano);
    }
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }
}
