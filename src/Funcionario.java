import java.math.BigDecimal;

public class Funcionario extends Pessoa {

    private BigDecimal salario;
    private BigDecimal comissoes;
    private BigDecimal comissao;

    public Funcionario(int login, String nome, Data dtNasc, String cpf, int senha, BigDecimal salario) {
        super(login, nome, dtNasc, cpf, senha);
        super.setRole(TipoUsuario.FUNCIONARIO);

        this.salario = salario;
        this.comissoes = new BigDecimal(0);
    }

    public BigDecimal getSalario() {
        return this.salario;
    }

    public BigDecimal getComissao(){
        return this.comissoes;
    }

    public void setComissao(BigDecimal valorVenda) {
        BigDecimal percentualComissao = new BigDecimal(0.5);
        this.comissoes = comissoes.add( valorVenda.multiply(percentualComissao));
    }
}
