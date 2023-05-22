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

    }

    /**
     * Permitir entrar em um modo de navegacao. Onde ́e possıvel navegar pelas
     * rua/av/trav, isto ́e,
     * avan ̧car e retroceder, apresentando o n ́umero total de sinaliza ̧c ̃oes
     * desta rua/av/trav e qual foi a
     * primeira e a ́ultima sinaliza ̧c ̃ao registrada na rua.
     */
    public void navegationMode() {
        System.out.println("Indique um index entre 0 e " + (lista.size() - 1) + " para iniciar a navegação: ");
        int index = 0;
        String n = null;
        boolean ok = true;
        Element element;
        index = in.nextInt();
        while (ok) {
            element = lista.get(index);
            System.out
                    .println(element.getNomeLog() + element.getLista().size() + element.getLista().getDataImplantacao(0)
                            + element.getLista().getDataImplantacao(element.getLista().size() - 1));
        }
        n = in.nextLine();
        if (n == "n") {
            index++;
        }
        if (n == "b") {
            index--;
        } else
            ok = false;

    }

}
