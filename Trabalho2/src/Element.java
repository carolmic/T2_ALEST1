public class Element {
    private String logradouro;
    private String nomeLog;
    private SinalizationsList lista;

    public Element(String logradouro, String nomeLog, SinalizationsList lista) {
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

    public SinalizationsList getLista() {
        return lista;
    }

}