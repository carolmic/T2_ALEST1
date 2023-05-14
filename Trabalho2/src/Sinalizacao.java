import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Sinalizacao {
    // Atributos
    private String descricao;
    private int anoDataExtracao;
    private int mesDataExtracao;
    private int diaDataExtracao;
    private int horaDataExtracao;
    private int minDataExtracao;
    private double num_inicial;
    private double num_final;
    private String lado;
    private String local_de_instalacao;
    private int dia;
    private int mes;
    private int ano;

    // Metodos
    public Sinalizacao(String descricao, int anoDataExtracao, int mesDataExtracao, int diaDataExtracao,
            int horaDataExtracao, int minDataExtracao, double num_inicial, double num_final, String lado,
            String local_de_instalacao, int dia, int mes, int ano) {
        this.descricao = descricao;
        this.anoDataExtracao = anoDataExtracao;
        this.mesDataExtracao = mesDataExtracao;
        this.diaDataExtracao = diaDataExtracao;
        this.horaDataExtracao = horaDataExtracao;
        this.minDataExtracao = minDataExtracao;
        this.num_inicial = num_inicial;
        this.num_final = num_final;
        this.lado = lado;
        this.local_de_instalacao = local_de_instalacao;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getAnoDataExtracao() {
        return anoDataExtracao;
    }

    public int getMesDataExtracao() {
        return mesDataExtracao;
    }

    public int getDiaDataExtracao() {
        return diaDataExtracao;
    }

    public int getHoraDataExtracao() {
        return horaDataExtracao;
    }

    public int getMinDataExtracao() {
        return minDataExtracao;
    }

    public double getNum_inicial() {
        return num_inicial;
    }

    public double getNum_final() {
        return num_final;
    }

    public String getLocal_de_instalacao() {
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

    // @Override
    // public String toString() {
    // try {
    // // Convertendo a string em um objeto Date
    // Date date = new SimpleDateFormat("yyyy-MM-dd
    // HH:mm:ss.SSS").parse(data_extracao);

    // // Formatando a data no formato dd/mm/aaaa
    // SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
    // return formatter.format(date);
    // } catch (Exception e) {
    // // Tratando exceções
    // e.printStackTrace();
    // return null;
    // }
    // }

    // Métodos get e toString (para data de implantação, imprimir dd/mm/aa)
    // private void splitDataExtracao() {
    // try {
    // LocalDate date = LocalDate.parse(data_extracao,
    // DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    // this.dia = date.getDayOfMonth();
    // this.mes = date.getMonthValue();
    // this.ano = date.getYear();
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }



    @Override
    public String toString() {
        return "Sinalizacao [descricao=" + descricao + ", anoDataExtracao=" + anoDataExtracao + ", mesDataExtracao="
                + mesDataExtracao + ", diaDataExtracao=" + diaDataExtracao + ", horaDataExtracao=" + horaDataExtracao
                + ", minDataExtracao=" + minDataExtracao + ", num_inicial=" + num_inicial + ", num_final=" + num_final
                + ", lado=" + lado + ", local_de_instalacao=" + local_de_instalacao + ", dia=" + dia + ", mes=" + mes
                + ", ano=" + ano + "]";
    }
}
