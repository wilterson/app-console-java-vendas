import java.util.List;
import java.util.Scanner;

public class Menu {

    public static int escolha;
    public static Scanner interacao = new Scanner(System.in);

    public int codigo;
    public int senha;

    public static int usuarioAtivo;
    public static String nomeUsuarioAtivo;
    public static TipoUsuario roleUsuarioAtivo;

    public void login(){
        int cod;
        int senha;
        Scanner opcao = new Scanner(System.in);

        limpaTela();
        System.out.println("Bem vindo. Faça login para acessar as opções. \n\n");
        System.out.println("************** LOGIN **************");
        System.out.print("Codigo: ");
        cod = opcao.nextInt();
        setCodigo(cod);

        System.out.print("Senha: ");
        senha = opcao.nextInt();
        setSenha(senha);
    }

    public static void limpaTela() {
        for(int i = 0; i < 50; i++){
            System.out.println("");
        }
    }

    public static boolean continuar() {
        Scanner interacao = new Scanner(System.in);
        String continua;
        System.out.print("\nContinuar...");
        continua = interacao.nextLine();
        return true;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public static int getUsuarioAtivo(){
        return usuarioAtivo;
    }

    public static TipoUsuario getUsuarioAtivoRole(){
        return roleUsuarioAtivo;
    }

    public static String getNomeUsuarioAtivo() {
        return nomeUsuarioAtivo;
    }

    public TipoUsuario doLogin(int cod, int senha, List pessoas) {

        List<Pessoa> pessoasList = pessoas;

        for (int i = 0; i < pessoas.size(); i++){
            int codLogin = pessoasList.get(i).getLogin();
            int senhaLogin = pessoasList.get(i).getSenha();
            int codUser = pessoasList.get(i).getCodigo();
            Pessoa pessoa = pessoasList.get(i);
            TipoUsuario tipoUser = pessoasList.get(i).getRole();

            if((cod == codLogin) && (senha == senhaLogin)){
                usuarioAtivo = codUser;
                nomeUsuarioAtivo = pessoa.getNome();
                roleUsuarioAtivo = tipoUser;

                return tipoUser;
            }
        }

        return TipoUsuario.INVALIDO;
    }

    public void doLogout(){
        usuarioAtivo = 0;
        nomeUsuarioAtivo = "";
    }

    public int getEscolhaMenu() {
        int escolha;
        Scanner lerOpcao = new Scanner(System.in);
        System.out.print("\nEscolha uma Opção: ");
        escolha = lerOpcao.nextInt();
        return escolha;
    }

    public static void mostraCabecalhoCardapio(TipoProduto tipo) {
        System.out.format("%-20s %-18s %20s \n",
                "**********************",
                tipo,
                "**********************"
        );

        System.out.format("%-6s | %-30s | %-15s \n",
                "Código",
                "Nome",
                "Valor"
        );
    }
}
