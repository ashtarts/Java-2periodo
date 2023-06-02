public class Produto {
    private String codigo;
    private String descricao;
    private String fornecedor;
    private double preco;
    private int estoque;

    public Produto(String codigo, String descricao, String fornecedor, double preco, int estoque) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
        this.preco = preco;
        this.estoque = estoque;
    }

    public void Desconto(double percentualDesconto) {
        double valorDesconto = this.preco * (percentualDesconto / 100.0);
        this.preco -= valorDesconto;
    }

    public void Aumento(double percentualAumento) {
        double valorAumento = this.preco * (percentualAumento / 100.0);
        this.preco += valorAumento;
    }

    public void Estoque(int quantidade) {
        this.estoque += quantidade;
    }

    public void Vender(int quantidade) {
        this.estoque -= quantidade;
    }


    public String toString() {
        return "Produto{" +
                "codigo='" + codigo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", fornecedor='" + fornecedor + '\'' +
                ", preco=" + preco +
                ", estoque=" + estoque +
                '}';
    }
}
