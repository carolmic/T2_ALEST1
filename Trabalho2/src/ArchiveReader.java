import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ArchiveReader {
    public static void lerPreencher(DoubleLinkedList lista) {
      

        String linhas[] = new String[110000];
        int numLinhas = 0;

        Path filePath = Paths.get("Trabalho2/src/dataEditado.csv");

        // Ler o arquivo
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line = reader.readLine();
            line = reader.readLine();

            while (line != null) {
                linhas[numLinhas] = line;
                numLinhas++;
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.err.format("Erro na leitura do arquivo: ", e.getMessage());
        }

        long tempoInicial = System.currentTimeMillis();
        try {

            for (int i = 0; i < numLinhas; i++) {
                String[] campos = linhas[i].split(";");

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
                LocalDateTime dateTime = LocalDateTime.parse(campos[0], formatter);
                int anoDataExtracao = dateTime.getYear();
                int mesDataExtracao = dateTime.getMonthValue();
                int diaDataExtracao = dateTime.getDayOfMonth();
                int horaDataExtracao = dateTime.getHour();
                int minDataExtracao = dateTime.getMinute();

                String descricao = campos[1];

                int anoImplantacao = 1500;
                int mesImplantacao = 1;
                int diaImplantacao = 1;
                if (!campos[4].equals("")) {
                    if (campos[4].contains("-"))
                        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    else
                        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate date = LocalDate.parse(campos[4], formatter);
                    anoImplantacao = date.getYear();
                    mesImplantacao = date.getMonthValue();
                    diaImplantacao = date.getDayOfMonth();
                }

                String logradouro = campos[5].split(" ", 2)[0];
                String nomeLog = campos[5].split(" ", 2)[1];

                double numInicial;
                if (campos[6].equals(""))
                    numInicial = 0;
                else
                    numInicial = Double.parseDouble(campos[6]);

                double numFinal;
                if (campos[7].equals(""))
                    numFinal = 0;
                else
                    numFinal = Double.parseDouble(campos[7]);

                String lado = campos[10];
          
                String localInstalacao = "";
                if (campos.length >= 13)
                    localInstalacao = campos[12];

                Sinalization sinalizacao = new Sinalization(descricao, anoDataExtracao, mesDataExtracao, diaDataExtracao,
                        horaDataExtracao, minDataExtracao, numInicial, numFinal, lado, localInstalacao, diaImplantacao,
                        mesImplantacao, anoImplantacao);
               
                if (lista.contains(nomeLog)) {
                    int index = lista.indexOf(nomeLog);
                    Element element = lista.get(index);
                    element.getLista().add(sinalizacao);
                } else {
                    ListadeSinalizacoes lista2 = new ListadeSinalizacoes();
                    lista2.add(sinalizacao);
                    lista.orderedAdd((new Element(logradouro, nomeLog, lista2)));
                }
            }
        } catch (Exception e) {
            System.err.format("Erro na leitura do arquivo: ", e.getMessage());
        }
        long tempoFinal = System.currentTimeMillis();

        printTime(tempoFinal - tempoInicial);
    }

    private static void printTime(long time) {
        long minutes = time / 60000;
        long seconds = (time % 60000) / 1000;
        long milis = time % 1000;
        System.out.println("Tempo de execucao: " + minutes + " min, " + seconds + " seg, " + milis + " ms");
    }
}
