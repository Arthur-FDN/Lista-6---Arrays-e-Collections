import java.util.ArrayList;

public class Fatura {
    private ArrayList<Item> itens;
    private double valorTotal;

    public Fatura() {
        this.itens = new ArrayList<>();
        this.valorTotal = 0;
    }

    public ArrayList<Item> getItens() { return itens; }
    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
        calcularValorTotal();
    }

    public double getValorTotal() { return valorTotal; }

    public int quantidadeItens() {
        return itens.size();
    }

    // Cria um item a partir do produto e da quantidade e o inclui na fatura
    public void realizarCompra(Produto produto, int quantidade) {
        Item item = new Item(produto, quantidade);
        adicionarItem(item);
    }

    public void adicionarItem(Item item) {
        itens.add(item);
        calcularValorTotal();
    }

    // Soma o valor de todos os itens da fatura
    public void calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getValorTotal();
        }
        this.valorTotal = total;
    }

    public void exibirFatura() {
        System.out.println("\n========== FATURA ==========");
        if (itens.isEmpty()) {
            System.out.println("Nenhum item comprado.");
        } else {
            for (int i = 0; i < itens.size(); i++) {
                System.out.print((i + 1) + ". ");
                itens.get(i).exibirInformacoes();
            }
        }
        System.out.printf("----------------------------%nValor final: R$ %.2f%n", valorTotal);
        System.out.println("============================");
    }
}
