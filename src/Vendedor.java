import java.math.BigDecimal;

public class Vendedor extends Funcionario {
    public Vendedor(int codigo, String nome, Data dtNasc, String cpf, int senha, BigDecimal salario) {
        super(codigo, nome, dtNasc, cpf, senha, salario);
        super.setRole(TipoUsuario.FUNCIONARIO);
    }
}
