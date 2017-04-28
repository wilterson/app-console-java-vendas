public class Registros {

    Data data;
    String acao;
    String autor;

    public Registros(String acao, String autor) {
        this.acao = acao;
        this.autor = autor;
        this.data = Data.getDataHoje();
    }

    public Data getData() {
        return data;
    }

    public String getAcao() {
        return acao;
    }

    public String getAutor() {
        return autor;
    }
}
