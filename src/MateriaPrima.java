import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class MateriaPrima {

    String nome;
    private static final AtomicInteger count = new AtomicInteger(0);
    private int codigo;
    StatusProduto statusProduto;
    Data dataAlteracao;
    int quantidade;
    BigDecimal valor;
    Funcionario autor;

    public MateriaPrima(String nome, int quantidade, BigDecimal valor, Funcionario autor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.codigo = count.incrementAndGet();
        this.dataAlteracao = Data.getDataHoje();
        this.statusProduto = StatusProduto.PENDENTE;
        this.autor = autor;
    }

    public int getCodigo() {
        return codigo;
    }

    public StatusProduto getStatusProduto() {
        return statusProduto;
    }

    public void setDataAlteracao(Data dataAquisicao) {
        this.dataAlteracao = dataAquisicao;
    }

    public Data getDataAlteracao() {
        return dataAlteracao;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void aprovaAquisicao(){
        this.statusProduto = StatusProduto.APROVADO;
        this.setDataAlteracao(Data.getDataHoje());
    }

    public void recusaAquisicao(){
        this.statusProduto = StatusProduto.RECUSADO;
        this.setDataAlteracao(Data.getDataHoje());
    }

    public String getResponsavel() {
        return autor.getNome();
    }
}
