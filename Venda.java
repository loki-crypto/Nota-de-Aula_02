import java.text.DecimalFormat;

public class Venda {
    private Produto produto;
    private int quantidade;
    private String formaPagamento;
    private double valorPago;

    public Venda(Produto produto, int quantidade, String formaPagamento, double valorPago) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.formaPagamento = formaPagamento;
        this.valorPago = valorPago;
    }

    public void realizarVenda() {
        if (produto.vender(quantidade)) {
            double valorTotal = produto.getValor() * quantidade;
            double valorFinal = calcularValorFinal(valorTotal);
            System.out.println("Venda realizada com sucesso!");
            System.out.println("Valor total: R$" + formatarValor(valorTotal));
            System.out.println("Valor final: R$" + formatarValor(valorFinal));

            if (formaPagamento.equalsIgnoreCase("Espécie") && valorPago > valorFinal) {
                double troco = valorPago - valorFinal;
                System.out.println("Troco: R$" + formatarValor(troco));
            }
        }
    }

    private double calcularValorFinal(double valorTotal) {
        switch (formaPagamento.toUpperCase()) {
            case "PIX":
            case "DÉBITO":
            case "TRANSFERÊNCIA":
            case "ESPÉCIE":
                return valorTotal * 0.95;
            case "CRÉDITO":
                System.out.println("Parcelado em 3x sem juros: R$" + formatarValor(valorTotal / 3) + " por mês");
                return valorTotal;
            default:
                System.out.println("Forma de pagamento inválida. Sem desconto aplicado.");
                return valorTotal;
        }
    }

    private String formatarValor(double valor) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(valor);
    }
}
