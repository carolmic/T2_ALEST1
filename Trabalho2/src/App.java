import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class App {
    Scanner in;

    DoubleLinkedList lista;

    public App() {

        in = new Scanner(System.in);
        lista = new DoubleLinkedList();
        ArchiveReader.lerPreencher(lista);
    }

    public void execute() {
        boolean ok;
        int opcao = 0;
        do {
            do {
                ok = true;
                menu();
                try {
                    opcao = in.nextInt();
                } catch (InputMismatchException e) {
                    in.nextLine();
                    ok = false;
                    System.out.println("Tipo incorreto. Redigite.");
                } catch (Exception e1) {
                    in.nextLine();
                    ok = false;
                    e1.printStackTrace();
                    System.out.println("Redigite.");
                }
            } while (!ok);
            in.nextLine();
            switch (opcao) {
                case 1:
                    mostSinalization();
                    break;
                case 2:
                    monthMostSinalization();
                    break;
                case 3:
                    navegationMode();
                    break;
                case 0:
                    break;
            }
        } while (opcao != 0);
    }

    public void menu() {
        System.out.println("========================================");
        System.out.println("Bem-vindo ao modo de navegação:");
        System.out.println("Selecione a opção desejada:");
        System.out.println("[1] Apresentar a rua/av/trav com mais sinalizações registradas");
        System.out.println("[2] Apresentar o mês em que foram implementadas mais sinalizações em uma rua/av/trav");
        System.out.println("[3] Modo navegação");
        System.out.println("[0] Sair do sistema");
        System.out.println("========================================");
    }

    public void mostSinalization() {
        Element element = lista.moreSinalizations();
        System.out.println("Rua/Av/Trav com mais sinalizações registradas: " + element.getNomeLog() + " -> "
                + element.getLista().size() + " sinalizações.");
    }

    public void monthMostSinalization() {
        Map<String, String> map = lista.monthMostSinalizations();
        System.out.println("Mês em que foram implementadas mais sinalizações: " + map.get("mes") + " -> "
                + map.get("quantidade") + " sinalizações.");
        // System.out.println(
        // "Digite o nome da rua/av/trav que você deseja saber o mês em que foram mais
        // implementadas sinalizações: ");
        // String nome = in.nextLine().toUpperCase();
        // Map<String, String> map = lista.monthMostSinalizations(nome);
        // System.out.println("Mês em que foram implementadas mais sinalizações em " +
        // nome + ": " + map.get("mes")
        // + " -> " + map.get("quantidade"));
    }

    public void navegationMode() {
        System.out.println("Insira a posição que você deseja acessar: ");
        int index = in.nextInt();
        while (index > -1) {
            lista.Navigate(index);
        }
    }
    // public static void main(String[] args) {

    // DoubleLinkedList lista = new DoubleLinkedList();
    // ArchiveReader.lerPreencher(lista);

    // String nome = "WALDOMIRO SCHAPKE";
    // int index = lista.indexOf(nome);
    // Element test = lista.get(index);
    // System.out.println("QUANTIDADE: " + test.getLista().size());
    // System.out.println("Mês com mais sinalizações: " +
    // lista.monthMostSinalizations(nome));

    // System.out.println("Mais sinalizações registradas: " +
    // lista.moreSinalizations().getNomeLog() + "Quantidade:" +
    // lista.moreSinalizations().getLista().size());
    // }
}

//