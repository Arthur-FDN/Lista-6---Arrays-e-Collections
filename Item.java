public class Item {
    private Produto produto;
    private int quantidade;
    private double valorTotal;

    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = calcularValorTotal();
    }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) {
        this.produto = produto;
        this.valorTotal = calcularValorTotal();
    }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.valorTotal = calcularValorTotal();
    }

    public double getValorTotal() { return valorTotal; }

    // Valor do produto vezes a quantidade comprada
    public double calcularValorTotal() {
        return produto.getPreco() * quantidade;
    }

    public void exibirInformacoes() {
        System.out.printf("%s (código %d) | Preço unit.: R$ %.2f | Quantidade: %d | Total: R$ %.2f%n",
                produto.getNome(), produto.getCodigo(), produto.getPreco(), quantidade, valorTotal);
    }
}
