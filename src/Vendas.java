import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Vendas {

    private Cliente comprador;
    private List<Produtos> itensVenda;
    private Data dataVenda;
    private BigDecimal valorTotal = new BigDecimal(0);
    private Funcionario funcionarioAtendimento;

    LocalDate localDate = LocalDate.now();
    int day = localDate.getDayOfMonth();
    int month = localDate.getMonthValue();
    int year = localDate.getYear();

    public Vendas(Cliente comprador, List<Produtos> itensVenda, Funcionario vendedor) {
        this.comprador = comprador;
        this.itensVenda = itensVenda;
        this.dataVenda = new Data(day, month, year);
        this.funcionarioAtendimento = vendedor;
        setValorTotal(itensVenda);
    }

    public void setValorTotal(List<Produtos> itensVenda){
        for(int i = 0; i < itensVenda.size(); i++){
            valorTotal = this.valorTotal.add(itensVenda.get(i).getValor());
        }
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public String getComprador() {
        return comprador.getNome();
    }

    public String getFuncionarioAtendimento() {
        return funcionarioAtendimento.getNome();
    }

    public List<Produtos> getItensVenda() {
        return itensVenda;
    }

    public Data getDataVenda() {
        return dataVenda;
    }

    public int getCodComprador() {
        return this.comprador.getCodigo();
    }
}
