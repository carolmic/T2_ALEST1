public class Element {
    private String logradouro;
    private String nomeLog;
    private ListadeSinalizacoes lista;

    public Element(String logradouro, String nomeLog, ListadeSinalizacoes lista) {
        this.logradouro = logradouro;
        this.nomeLog = nomeLog;
        this.lista = lista;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNomeLog() {
        return nomeLog;
    }

    public ListadeSinalizacoes getLista() {
        return lista;
    }

}