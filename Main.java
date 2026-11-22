import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Produto> produtos = cadastrarProdutos();
        Fatura fatura = new Fatura();

        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro(sc, "Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    comprar(sc, produtos, fatura);
                    break;
                case 2:
                    fatura.exibirFatura();
                    break;
                case 3:
                    System.out.println("Encerrando o programa. Obrigado pela compra!");
                    break;
                default:
                    System.out.println("Opção inválida. Digite 1, 2 ou 3.");
            }
        } while (opcao != 3);

        sc.close();
    }

    // Produtos definidos pelo sistema (o usuário não cadastra produtos)
    private static ArrayList<Produto> cadastrarProdutos() {
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Caderno", 101, 25.90));
        produtos.add(new Produto("Caneta", 102, 3.50));
        produtos.add(new Produto("Mochila", 103, 149.99));
        return produtos;
    }

    private static void exibirMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1 - Comprar");
        System.out.println("2 - Ver Fatura");
        System.out.println("3 - Encerrar Programa");
    }

    private static void listarProdutos(ArrayList<Produto> produtos) {
        System.out.println("\n--- Produtos disponíveis ---");
        for (Produto p : produtos) {
            p.exibirInformacoes();
        }
    }

    private static Produto buscarProdutoPorCodigo(ArrayList<Produto> produtos, int codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    private static void comprar(Scanner sc, ArrayList<Produto> produtos, Fatura fatura) {
        listarProdutos(produtos);

        int codigo = lerInteiro(sc, "Informe o código do produto: ");
        Produto produto = buscarProdutoPorCodigo(produtos, codigo);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        int quantidade = lerInteiro(sc, "Informe a quantidade: ");
        if (quantidade <= 0) {
            System.out.println("A quantidade deve ser maior que zero.");
            return;
        }

        fatura.realizarCompra(produto, quantidade);
        System.out.println("Item adicionado à fatura.");
    }

    private static int lerInteiro(Scanner sc, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }
}
