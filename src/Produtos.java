import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

public class Produtos {

    private static final AtomicInteger count = new AtomicInteger(0);
    private int produtoCod;
    private TipoProduto tipo;
    private BigDecimal valor;
    private String nome;

    public Produtos(TipoProduto tipo, BigDecimal valor, String nome) {
        this.tipo = tipo;
        this.valor = valor;
        this.nome = nome;
        this.produtoCod = count.incrementAndGet();
    }

    public int getCod() {
        return produtoCod;
    }

    public void setCod(int produtoCod) {
        this.produtoCod = produtoCod;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Produtos{" + "produtoCod=" + produtoCod + ", tipo=" + tipo + ", valor=" + valor + ", nome='" + nome + '\'' + '}';
    }
}
