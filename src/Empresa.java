import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Empresa {

    public String nome;
    List<Cliente> clientes;
    List<Funcionario> funcionarios;
    List<Vendas> vendas;
    List<Produtos> produtos;
    List<MateriaPrima> estoque;
    List<Registros> registros;
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    Menu menu = new Menu();
    private Random randomGenerator;

    public Empresa(String nome) {
        this.nome = nome;
        clientes = new ArrayList<>();
        funcionarios = new ArrayList<>();
        produtos = new ArrayList<>();
        vendas = new ArrayList<>();
        randomGenerator = new Random();
        estoque = new ArrayList<>();
        registros = new ArrayList<>();
    }

    public void inicializa(){
        //Clientes
        Cliente cli1 = new Cliente(1, "Frank Castle", new Data(12, 05, 1986), "05430939983", 150);
        Cliente cli2 = new Cliente(2, "Matt Murdock", new Data(5, 4, 1995), "02245678951", 250);
        Cliente cli3 = new Cliente(3, "Jessica Jones", new Data(1, 12, 1946), "06340950943", 350);
        Cliente cli4 = new Cliente(4, "Elektra Natchios", new Data(14, 7, 1992), "05450987451", 450);
        Cliente cli5 = new Cliente(5, "Danny Rand", new Data(25, 1, 1999), "54012055819", 550);

        clientes.add(cli1);
        clientes.add(cli2);
        clientes.add(cli3);
        clientes.add(cli4);
        clientes.add(cli5);

        //Funcionarios
        Funcionario fun1 = new Funcionario(1, "Bruce Banner", new Data(12, 05, 1986), "02193998352", 100, new BigDecimal(1000));
        Funcionario fun2 = new Funcionario(2, "Steve Rogers", new Data(5, 4, 1995), "02215478966", 200, new BigDecimal(1500));
        Funcionario fun3 = new Funcionario(3, "Natasha Romanoff", new Data(1, 12, 1946), "02660394871", 300, new BigDecimal(1250));
        Funcionario fun4 = new Funcionario(4, "Wanda Maximoff", new Data(14, 7, 1992), "02845785520", 400, new BigDecimal(1900));
        Funcionario fun5 = new Funcionario(5, "Tony Stark", new Data(25, 1, 1999), "60340913085", 500, new BigDecimal(1800));

        Funcionario admin = new Diretor(6, "Wilterson Garcia", new Data(5,4,1995), "05415988844", 666, new BigDecimal(12000));

        funcionarios.add(fun1);
        funcionarios.add(fun2);
        funcionarios.add(fun3);
        funcionarios.add(fun4);
        funcionarios.add(fun5);
        funcionarios.add(admin);

        //Produtos
        Produtos pro1 = new Produtos(TipoProduto.COMIDAS, new BigDecimal(2.50), "Hot Dog Simples");
        Produtos pro2 = new Produtos(TipoProduto.COMIDAS, new BigDecimal(4), "Hot Dog Plus");
        Produtos pro3 = new Produtos(TipoProduto.COMIDAS, new BigDecimal(5.60), "Hot Dog Plus Catupiry");
        Produtos pro4 = new Produtos(TipoProduto.COMIDAS, new BigDecimal(10.90), "Hot Dog Plus Cheddar");
        Produtos pro5 = new Produtos(TipoProduto.COMIDAS, new BigDecimal(12.50), "Hot Dog Master Vina");
        Produtos pro6 = new Produtos(TipoProduto.COMIDAS, new BigDecimal(25), "Hot Dog Master Premium");
        Produtos pro7 = new Produtos(TipoProduto.BEBIDAS, new BigDecimal(4.50), "Coca-Cola Lata");
        Produtos pro8 = new Produtos(TipoProduto.BEBIDAS, new BigDecimal(5.50), "Coca-Cola 1 L");
        Produtos pro9 = new Produtos(TipoProduto.BEBIDAS, new BigDecimal(1.50), "Água");
        Produtos pro10 = new Produtos(TipoProduto.BEBIDAS, new BigDecimal(3.50), "Suco Natural");

        produtos.add(pro1);
        produtos.add(pro2);
        produtos.add(pro3);
        produtos.add(pro4);
        produtos.add(pro5);
        produtos.add(pro6);
        produtos.add(pro7);
        produtos.add(pro8);
        produtos.add(pro9);
        produtos.add(pro10);

        List<Produtos> itensVenda = new ArrayList<>();
        itensVenda.add(pro1);
        itensVenda.add(pro2);
        itensVenda.add(pro10);
        Vendas vend1 = new Vendas(cli1, itensVenda, fun1);
        vendas.add(vend1);

        BigDecimal valorTotal = new BigDecimal(0).add(pro1.getValor()).add(pro2.getValor()).add(pro10.getValor());
        fun1.setComissao(valorTotal);

        List<Produtos> itensVenda2 = new ArrayList<>();
        itensVenda2.add(pro6);
        itensVenda2.add(pro10);
        itensVenda2.add(pro8);
        Vendas vend2 = new Vendas(cli1, itensVenda2, fun1);
        vendas.add(vend2);

        BigDecimal valorTotal2 = new BigDecimal(0).add(pro6.getValor()).add(pro10.getValor()).add(pro8.getValor());
        fun1.setComissao(valorTotal2);

        List<Produtos> itensVenda3 = new ArrayList<>();
        itensVenda3.add(pro5);
        itensVenda3.add(pro4);
        itensVenda3.add(pro7);
        Vendas vend3 = new Vendas(cli1, itensVenda3, fun2);
        vendas.add(vend3);

        BigDecimal valorTotal3 = new BigDecimal(0).add(pro5.getValor()).add(pro4.getValor()).add(pro7.getValor());
        fun2.setComissao(valorTotal3);

        List<Produtos> itensVenda4 = new ArrayList<>();
        itensVenda4.add(pro3);
        itensVenda4.add(pro5);
        itensVenda4.add(pro9);
        Vendas vend4 = new Vendas(cli2, itensVenda4, fun4);
        vendas.add(vend4);

        BigDecimal valorTotal4 = new BigDecimal(0).add(pro3.getValor()).add(pro5.getValor()).add(pro9.getValor());
        fun4.setComissao(valorTotal4);

        List<Produtos> itensVenda5 = new ArrayList<>();
        itensVenda5.add(pro6);
        itensVenda5.add(pro3);
        itensVenda5.add(pro7);
        Vendas vend5 = new Vendas(cli3, itensVenda5, fun5);
        vendas.add(vend5);

        BigDecimal valorTotal5 = new BigDecimal(0).add(pro6.getValor()).add(pro3.getValor()).add(pro7.getValor());
        fun5.setComissao(valorTotal5);

        List<Produtos> itensVenda6 = new ArrayList<>();
        itensVenda6.add(pro5);
        itensVenda6.add(pro4);
        itensVenda6.add(pro7);
        Vendas vend6 = new Vendas(cli4, itensVenda6, fun3);
        vendas.add(vend6);

        BigDecimal valorTotal6 = new BigDecimal(0).add(pro5.getValor()).add(pro4.getValor()).add(pro7.getValor());
        fun3.setComissao(valorTotal6);

        MateriaPrima mat1 = new MateriaPrima("Salsichas", 500, new BigDecimal(250), fun1);
        MateriaPrima mat2 = new MateriaPrima("Pão para Hot Dog", 1500, new BigDecimal(150), fun1);
        MateriaPrima mat3 = new MateriaPrima("Catchup", 15, new BigDecimal(90), fun2);
        MateriaPrima mat4 = new MateriaPrima("Mostarda", 15, new BigDecimal(98), fun5);
        MateriaPrima mat5 = new MateriaPrima("Tomates", 30, new BigDecimal(45), fun4);
        MateriaPrima mat6 = new MateriaPrima("Catupiry", 5, new BigDecimal(28), fun2);

        estoque.add(mat1);
        estoque.add(mat2);
        estoque.add(mat3);
        estoque.add(mat4);
        estoque.add(mat5);
        estoque.add(mat6);
    }

    public List getClientes(){
        return clientes;
    }

    public List getFuncionarios(){
        return funcionarios;
    }

    public void getCardapio(TipoProduto tipo){

        TipoProduto tipoProd = TipoProduto.COMIDAS;

        if(tipo == TipoProduto.BEBIDAS){
            tipoProd = TipoProduto.BEBIDAS;
        }

        Menu.mostraCabecalhoCardapio(tipoProd);

        for (int i = 0; i < produtos.size(); i++){
            if(produtos.get(i).getTipo() == tipoProd) {
                System.out.format("%-6s | %-30s | %-15s \n",
                        produtos.get(i).getCod(),
                        produtos.get(i).getNome(),
                        formatter.format(produtos.get(i).getValor()));
            }
        }
    }

    public void comprar() {
        int codComida;
        int codBebida = 0;
        int escolha;
        int usuarioAtivo = Menu.getUsuarioAtivo();
        int index = randomGenerator.nextInt(funcionarios.size());
        boolean compraValida = true;

        BigDecimal valorTotal = new BigDecimal(0);

        Funcionario funcionario = funcionarios.get(index);

        Scanner interacao = new Scanner(System.in);
        List<Produtos> itensVenda = new ArrayList<>();

        getCardapio(TipoProduto.COMIDAS);
        codComida = menu.getEscolhaMenu();

        do {
            System.out.print("Deseja alguma bebida ? (1 - Sim / 2 - Não): ");
            escolha = interacao.nextInt();
            itensVenda.add(produtos.get(codComida-1));

            if (escolha == 1) {
                Menu.limpaTela();
                getCardapio(TipoProduto.BEBIDAS);
                codBebida = menu.getEscolhaMenu();

                itensVenda.add(produtos.get(codBebida - 1));
            }
        }while (escolha != 1 && escolha != 2);

        for(int i = 0; i < itensVenda.size(); i++){
            valorTotal = valorTotal.add(itensVenda.get(i).getValor());
        }

        for(int i =0; i < vendas.size(); i++){
            if(vendas.get(vendas.size()-1).getCodComprador() == Menu.getUsuarioAtivo() && vendas.get(vendas.size()-1).getValorTotal().equals(valorTotal)){
                compraValida = false;
            }
        }

        if(compraValida){
            Vendas venda = new Vendas(clientes.get(usuarioAtivo-1), itensVenda, funcionario);
            vendas.add(venda);
            funcionario.setComissao(valorTotal);
            System.out.println("Compra efetuada com sucesso! Aguarde seu pedido na mesa.");

            Registros log = new Registros("Compra efetuada no valor de R$"+valorTotal, Menu.getNomeUsuarioAtivo());
            registros.add(log);
        }else {
            System.out.println("Não foi possível realizar a compra.");
            System.out.println("Valor idêntico ao já cobrado.");
        }

        if(Menu.continuar()) {
            Menu.limpaTela();
        }
    }

    public void visualizarVendas() {
        for (int i = 0; i < vendas.size(); i++){
            System.out.format("%-10s %-25s\n","Código: "+ i, "Data da Venda: "+ vendas.get(i).getDataVenda());
            System.out.println("Cliente: "+ vendas.get(i).getComprador());
            System.out.println("Funcionário: "+ vendas.get(i).getFuncionarioAtendimento());
            System.out.println();

            for (int j =0; j < vendas.get(i).getItensVenda().size(); j++){
                Produtos produto = vendas.get(i).getItensVenda().get(j);

                if(j == 0){
                    System.out.format("%-25s | %-10s\n", "Produto", "Valor");
                }

                System.out.format("%-25s | %-10s\n",
                        produto.getNome(),
                        formatter.format(produto.getValor())
                );
            }
            System.out.println("___________________________________");
            System.out.format("%-25s | %-10s\n", "Total: ", formatter.format(vendas.get(i).getValorTotal()));
            System.out.println("\n");
        }

        Menu.continuar();
    }

    public void visualizarCardapio(TipoProduto tipoProd) {
        getCardapio(tipoProd);
        Menu.continuar();
    }

    public void visualizarVendasCliente() {
        for (int i = 0; i < vendas.size(); i++) {
            if (vendas.get(i).getCodComprador() == Menu.usuarioAtivo) {
                System.out.format("%-10s %-25s\n", "Código: " + i, "Data da Venda: " + vendas.get(i).getDataVenda());
                System.out.println();

                for (int j = 0; j < vendas.get(i).getItensVenda().size(); j++) {

                    Produtos produto = vendas.get(i).getItensVenda().get(j);

                    if (j == 0) {
                        System.out.format("%-25s | %-10s\n", "Produto", "Valor");
                    }

                    System.out.format("%-25s | %-10s\n", produto.getNome(), formatter.format(produto.getValor()));
                }
                System.out.println("___________________________________");
                System.out.format("%-25s | %-10s\n", "Total: ", formatter.format(vendas.get(i).getValorTotal()));
                System.out.println("\n");
            }
        }

        Menu.continuar();
    }

    public void addCardapioItem() {
        int tipo;
        String nome;
        BigDecimal valor;

        TipoProduto tipoProd = TipoProduto.COMIDAS;
        Scanner interacaoTipo = new Scanner(System.in);
        Scanner interacaoNome = new Scanner(System.in);
        Scanner interacaoValor = new Scanner(System.in);

        System.out.println("Adicionar novo item ao cardápio.");
        System.out.println("1 - Comidas");
        System.out.println("2 - Bebidas");
        System.out.print("Opção: ");
        tipo = interacaoTipo.nextInt();

        if(tipo == 2){
            tipoProd = TipoProduto.BEBIDAS;
        }

        do{
            System.out.print("Nome: ");
            nome = interacaoNome.nextLine();
        }while (itemCardapioUnico(nome));

        System.out.print("Valor: R$");
        valor = interacaoValor.nextBigDecimal();

        Produtos produtoNew = new Produtos(tipoProd, valor, nome);
        produtos.add(produtoNew);

        System.out.println("\nProduto cadastrado com sucesso!");

        Registros log2 = new Registros("Item adicionado ao cardápio.", Menu.getNomeUsuarioAtivo());
        registros.add(log2);

        Menu.continuar();
    }

    private boolean itemCardapioUnico(String nome) {
        boolean temp = false;
        for(int i=0; i < produtos.size(); i++){
             temp = produtos.get(i).getNome().contains(nome);
        }

        if(temp){
            System.out.println("Produto já cadastrado.");
            return temp;
        }

        return temp;
    }

    public void visualizarFuncionarios() {
        for(int i = 0; i < funcionarios.size(); i++){
            if(i == 0){
                System.out.format("%-8s | %-8s | %-25s | %-12s | %-10s\n", "Código", "Login", "Nome", "CPF", "Salário");
            }

            System.out.format("%-8s | %-8s | %-25s | %-12s | %-10s\n",
                    funcionarios.get(i).getCodigo(),
                    funcionarios.get(i).getLogin(),
                    funcionarios.get(i).getNome(),
                    funcionarios.get(i).getCpf(),
                    formatter.format(funcionarios.get(i).getSalario())
            );
        }

        Menu.continuar();
    }

    public void visualizarClientes() {
        for(int i = 0; i < clientes.size(); i++){
            if(i == 0){
                System.out.format("%-8s | %-8s | %-25s | %-15s | %-15s\n", "Código", "Login", "Nome", "CPF", "Data Nascimento");
            }

            System.out.format("%-8s | %-8s | %-25s | %-15s | %-15s\n",
                    clientes.get(i).getCodigo(),
                    clientes.get(i).getLogin(),
                    clientes.get(i).getNome(),
                    clientes.get(i).getCpf(),
                    clientes.get(i).getDtNasc()
            );
        }

        Menu.continuar();
    }

    public void addNewFuncionario() {
        int login;
        int senha;
        int dia;
        int mes;
        int ano;
        String nome;
        BigDecimal salario;
        Data dataNasc;
        String cpf;

        Scanner interacaoLogin = new Scanner(System.in);
        Scanner interacaoSenha = new Scanner(System.in);
        Scanner interacaoDia = new Scanner(System.in);
        Scanner interacaoMes = new Scanner(System.in);
        Scanner interacaoAno = new Scanner(System.in);
        Scanner interacaoNome = new Scanner(System.in);
        Scanner interacaoSalario = new Scanner(System.in);
        Scanner interacaoCpf = new Scanner(System.in);

        System.out.println("Adicionar novo funcionário");
        System.out.print("Nome: ");
        nome = interacaoNome.nextLine();

        do{
            System.out.print("Login: ");
            login = interacaoLogin.nextInt();
        }while (!validaLogin(login, TipoUsuario.FUNCIONARIO));

        System.out.print("Senha: ");
        senha = interacaoSenha.nextInt();

        System.out.print("Salário: R$");
        salario = interacaoSalario.nextBigDecimal();

        System.out.print("Data Nascimento dia:");
        dia = interacaoDia.nextInt();

        System.out.print("Data Nascimento mês:");
        mes = interacaoMes.nextInt();

        System.out.print("Data Nascimento ano:");
        ano = interacaoAno.nextInt();

        dataNasc = new Data(dia, mes, ano);

        do {
            System.out.print("CPF: ");
            cpf = interacaoCpf.next();
        }while (!validaCpfUnico(cpf, TipoUsuario.FUNCIONARIO));

        Funcionario funcNew = new Funcionario(login, nome, dataNasc, cpf, senha, salario);
        funcionarios.add(funcNew);

        Registros log3 = new Registros("Adicionado novo funcionário.", Menu.getNomeUsuarioAtivo());
        registros.add(log3);

        System.out.println("Funcionário cadastrado com sucesso!");
        Menu.continuar();
    }

    private boolean validaCpfUnico(String cpf, TipoUsuario tipo) {
        if(cpf.length()<11){
            System.out.println("CPF precisa ter 11 dígitos.");
            return false;
        }

        if(tipo == TipoUsuario.FUNCIONARIO) {
            for (int i = 0; i < funcionarios.size(); i++) {
                if (funcionarios.get(i).getCpf().equals(cpf)) {
                    System.out.println("Usuário com esse CPF já cadastrado.");
                    return false;
                }
            }
        }else{
            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).getCpf().equals(cpf)) {
                    System.out.println("Usuário com esse CPF já cadastrado.");
                    return false;
                }
            }
        }

        return true;
    }

    private boolean validaLogin(int login, TipoUsuario tipo) {
        if(tipo == TipoUsuario.FUNCIONARIO) {
            for (int i = 0; i < funcionarios.size(); i++) {
                if (funcionarios.get(i).getLogin() == login) {
                    System.out.println("Login já usado, escolha outro.");
                    return false;
                }
            }
        }else{
            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).getLogin() == login) {
                    System.out.println("Login já usado, escolha outro.");
                    return false;
                }
            }
        }

        return true;
    }

    public void verRendimentos() {
        for (int i = 0; i < funcionarios.size(); i++){
            if (funcionarios.get(i).getCodigo() == Menu.getUsuarioAtivo()){
                if(i == 0){
                    System.out.println("Ficha Financeira: " + funcionarios.get(i).getNome());
                }

                BigDecimal salario = funcionarios.get(i).getSalario();
                BigDecimal comissao = funcionarios.get(i).getComissao();

                System.out.format("%-15s | %-15s\n", "Salário", formatter.format(salario));
                System.out.format("%-15s | %-15s\n", "Comissões", formatter.format(comissao));
                System.out.format("%-15s | %-15s\n", "Total Líquido", formatter.format(salario.add(comissao)));
            }
        }

        Menu.continuar();
    }

    public void addNewCliente() {
        int login;
        int senha;
        int dia;
        int mes;
        int ano;
        String nome;
        Data dataNasc;
        String cpf;

        Scanner interacaoLogin = new Scanner(System.in);
        Scanner interacaoSenha = new Scanner(System.in);
        Scanner interacaoDia = new Scanner(System.in);
        Scanner interacaoMes = new Scanner(System.in);
        Scanner interacaoAno = new Scanner(System.in);
        Scanner interacaoNome = new Scanner(System.in);
        Scanner interacaoCpf = new Scanner(System.in);

        System.out.println("Adicionar novo cliente");
        System.out.print("Nome: ");
        nome = interacaoNome.nextLine();

        do{
            System.out.print("Login: ");
            login = interacaoLogin.nextInt();
        }while (!validaLogin(login, TipoUsuario.CLIENTE));

        System.out.print("Senha: ");
        senha = interacaoSenha.nextInt();

        System.out.print("Data Nascimento dia:");
        dia = interacaoDia.nextInt();

        System.out.print("Data Nascimento mês:");
        mes = interacaoMes.nextInt();

        System.out.print("Data Nascimento ano:");
        ano = interacaoAno.nextInt();

        dataNasc = new Data(dia, mes, ano);

        do {
            System.out.print("CPF: ");
            cpf = interacaoCpf.next();
        }while (!validaCpfUnico(cpf, TipoUsuario.FUNCIONARIO));

        Cliente clienteNew = new Cliente(login, nome, dataNasc, cpf, senha);
        clientes.add(clienteNew);

        Registros log4 = new Registros("Adicionado novo cliente.", Menu.getNomeUsuarioAtivo());
        registros.add(log4);

        System.out.println("\nCliente cadastrado com sucesso! ");
        Menu.continuar();
    }

    public void visualizarEstoque(){
        for(int i = 0; i < estoque.size(); i++){
            if(Menu.getUsuarioAtivoRole() == TipoUsuario.FUNCIONARIO){
                if (i == 0) {
                    System.out.format("%-8s | %-15s | %-25s | %-10s | %-10s\n",
                            "Código",
                            "Data Alteração",
                            "Item",
                            "Quantidade",
                            "Valor"
                    );
                }
                if(estoque.get(i).getStatusProduto() == StatusProduto.APROVADO) {
                    System.out.format("%-8s | %-15s | %-25s | %-10s | %-10s\n",
                            estoque.get(i).getCodigo(),
                            estoque.get(i).getDataAlteracao(),
                            estoque.get(i).getNome(),
                            estoque.get(i).getQuantidade(),
                            formatter.format(estoque.get(i).getValor())
                    );
                }
            } else{
                if (i == 0) {
                    System.out.format("%-8s | %-15s | %-25s | %-10s | %-10s | %-15s\n",
                            "Código",
                            "Data Alteração",
                            "Item",
                            "Status",
                            "Quantidade",
                            "Valor"
                    );
                }

                System.out.format("%-8s | %-15s | %-25s | %-10s | %-10s | %-15s\n",
                        estoque.get(i).getCodigo(),
                        estoque.get(i).getDataAlteracao(),
                        estoque.get(i).getNome(),
                        estoque.get(i).getStatusProduto(),
                        estoque.get(i).getQuantidade(),
                        formatter.format(estoque.get(i).getValor())
                );

                if(i == estoque.size()-1){
                    Scanner interacao = new Scanner(System.in);
                    int escolha;
                    System.out.println("\nDigite 1 para escolher um produto para aprovar/recusar");
                    System.out.println("Digite 0 para sair");
                    escolha = interacao.nextInt();

                    if (escolha == 1){
                        aprovarRequisicao();
                    }

                    break;
                }
            }
        }

        Menu.continuar();
    }

    public void requisitarCompras() {
        Menu.limpaTela();

        boolean produtoExiste = false;

        String nome;
        Scanner interacaoNome = new Scanner(System.in);

        BigDecimal valor;
        Scanner interacaoValor = new Scanner(System.in);

        int quantidade;
        Scanner interacaoQtd = new Scanner(System.in);

        System.out.println("Requisitar compra de Materia Prima");
        System.out.print("Nome: ");
        nome = interacaoNome.nextLine();

        System.out.print("Valor: ");
        valor = interacaoValor.nextBigDecimal();

        System.out.print("Quantidade: ");
        quantidade = interacaoQtd.nextInt();

        for(int i = 0; i < estoque.size(); i++){
            if(nome.equals(estoque.get(i).getNome())){
                produtoExiste = estoque.get(i).getQuantidade() > 0;
            }
        }

        if(!produtoExiste){
            for(int i = 0; i < funcionarios.size(); i++){
                if(funcionarios.get(i).getCodigo() == Menu.getUsuarioAtivo()){
                    Funcionario autor = funcionarios.get(i);
                    MateriaPrima materiaPrima = new MateriaPrima(nome, quantidade, valor, autor);
                    estoque.add(materiaPrima);

                    Registros log5 = new Registros("Registrada nova requisição de compra.", Menu.getNomeUsuarioAtivo());
                    registros.add(log5);

                    System.out.println("\nRequisição enviada com sucesso!");
                }
            }
        }else{
            System.out.println("Só é possível realizar o pedido de produtos já esgotados.");
        }

        Menu.continuar();
    }

    public void aprovarRequisicao() {
        Menu.limpaTela();

        Scanner interacao = new Scanner(System.in);
        Scanner interact = new Scanner(System.in);
        int codProduto;
        int escolha;
        BigDecimal valorMaterial = new BigDecimal(0);
        String responsavel = "";

        for(int i = 0; i < estoque.size(); i++){
            if(estoque.get(i).getStatusProduto() == StatusProduto.PENDENTE) {
                valorMaterial = estoque.get(i).getValor();
                responsavel = estoque.get(i).getResponsavel();

                if (i == 0) {
                    System.out.format("%-8s | %-15s | %-25s | %-10s | %-10s | %-15s | %-15s\n",
                            "Código",
                            "Data Alteração",
                            "Item",
                            "Status",
                            "Quantidade",
                            "Valor",
                            "Funcionário Responsável"
                    );
                }

                System.out.format("%-8s | %-15s | %-25s | %-10s | %-10s | %-15s | %-15s\n",
                        estoque.get(i).getCodigo(),
                        estoque.get(i).getDataAlteracao(),
                        estoque.get(i).getNome(),
                        estoque.get(i).getStatusProduto(),
                        estoque.get(i).getQuantidade(),
                        formatter.format(estoque.get(i).getValor()),
                        estoque.get(i).getResponsavel()
                );
            }
        }

        System.out.print("\nDigite o código do produto que vc deseja alterar: ");
        codProduto = interacao.nextInt();

        System.out.println("\n1 - Aprovar");
        System.out.println("2 - Recusar");
        System.out.print("Opção: ");
        escolha = interact.nextInt();

        for(int i = 0; i < estoque.size(); i++){
            if(codProduto == estoque.get(i).getCodigo()) {
                if(escolha == 1) {
                    estoque.get(i).aprovaAquisicao();

                    Registros log6 = new Registros("Aprovado requisição de compra de material no valor de R$"+valorMaterial, Menu.getNomeUsuarioAtivo());
                    registros.add(log6);

                    System.out.println("Aprovado com sucesso!");
                }else{
                    estoque.get(i).recusaAquisicao();

                    Registros log6 = new Registros("Recusado requisição de compra de material no valor de R$" + valorMaterial, Menu.getNomeUsuarioAtivo());
                    registros.add(log6);
                    System.out.println("Recusado com sucesso!");
                }
            }
        }

        Menu.continuar();
    }

    public void visualizaLog() {
        for(int i = 0; i < registros.size(); i++){
            if(i == 0){
                System.out.format("%-10s | %-40s | %-15s\n", "Data", "Ação", "Autor");
            }

            System.out.format("%-10s | %-40s | %-15s\n",
                    registros.get(i).getData(),
                    registros.get(i).getAcao(),
                    registros.get(i).getAutor()
            );
        }
        Menu.continuar();
    }
}
