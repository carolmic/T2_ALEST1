import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Sinalizacao {
    // Atributos
    private String descricao;
    private String data_extracao;
    private int num_inicial;
    private int num_final;
    private String lado;
    private String local_de_instalacao;
    private int dia;
    private int mes;
    private int ano;

    // Metodos
    public Sinalizacao(String descricao, String data_extracao, int num_inicial, int num_final, String lado,
            String local_de_instalacao) {
        this.descricao = descricao;
        this.data_extracao = data_extracao;
        this.num_inicial = num_inicial;
        this.num_final = num_final;
        this.lado = lado;
        this.local_de_instalacao = local_de_instalacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getDataExtracao() {
        return Integer.parseInt((data_extracao));
    }

    public int getNumInicial() {
        return num_inicial;
    }

    public int getNumFinal() {
        return num_final;
    }

    public String getLado() {
        return lado;
    }

    public String getLocalDeInstalacao() {
        return local_de_instalacao;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        try {
            // Convertendo a string em um objeto Date
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(data_extracao);

            // Formatando a data no formato dd/mm/aaaa
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
            return formatter.format(date);
        } catch (Exception e) {
            // Tratando exceções
            e.printStackTrace();
            return null;
        }
    }

    // Métodos get e toString (para data de implantação, imprimir dd/mm/aa)
    private void splitDataExtracao() {
        try {
            LocalDate date = LocalDate.parse(data_extracao, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            this.dia = date.getDayOfMonth();
            this.mes = date.getMonthValue();
            this.ano = date.getYear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
