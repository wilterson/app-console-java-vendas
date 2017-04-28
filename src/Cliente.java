public class Cliente extends Pessoa {

    public Cliente(int login, String nome, Data dtNasc, String cpf, int senha) {
        super(login, nome, dtNasc, cpf, senha);
        super.setRole(TipoUsuario.CLIENTE);
    }
}
