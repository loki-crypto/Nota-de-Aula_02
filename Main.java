public class Main {
    public static void main(String[] args) {
        Produto produto = new Produto(1, "Camiseta", "M", "Azul", 50.0, 10);

        Venda venda1 = new Venda(produto, 2, "Pix", 0);
        venda1.realizarVenda();

        Venda venda2 = new Venda(produto, 1, "Espécie", 60.0);
        venda2.realizarVenda();

        Venda venda3 = new Venda(produto, 3, "Crédito", 0);
        venda3.realizarVenda();

        System.out.println("Quantidade em estoque: " + produto.getQuantidadeEstoque());
    }
}
