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
        System.out.println("Mês em que foram implementadas mais sinalizações: " + map.get("mes")
                + " -> " + map.get("quantidade"));
    }

    public void navegationMode() {
        boolean ok;
        int opcao;
        Element element;
        System.out.println("Indique um index entre 0 e 3125 para iniciar a navegação:");
        int index = in.nextInt();
        element = lista.get(index);
        System.out.println("========================================");
        for (int i = index - 2; i <= index + 2; i++) {
            if (i == index) {
                int tam = element.getLista().size();
                System.out.println("--> " + element.getNomeLog() + ": " + "\n " + "Total de sinalizações = "
                        + tam + "\n" + " Primeira sinalização = " + element.getLista().getDataImplantacao(0) + "\n"
                        + " Última sinalização = " + element.getLista().getDataImplantacao(tam - 1) + " <--" + "\n");
            } else {
                System.out.println("[" + lista.get(i).getNomeLog() + "]" + "\n");
            }
        }
        System.out.println("========================================");
        do {
            ok = true;
            System.out.println(
                    "Para avançar, selecione [2]. Para retroceder, selecione [1]. Para sair do modo navegação, selecione [0].");
            opcao = in.nextInt();
            if (opcao == 2) {
                index++;
                element = lista.get(index);
            }
            if (opcao == 1) {
                index--;
                element = lista.get(index);
            }
            if (opcao == 0) {
                ok = false;
            }
            System.out.println("========================================");
            for (int i = index - 2; i <= index + 2; i++) {
                if (i == index) {
                    int tam = element.getLista().size();
                    System.out.println("--> " + element.getNomeLog() + ": " + "\n " + "Total de sinalizações = "
                            + tam + "\n" + " Primeira sinalização = " + element.getLista().getDataImplantacao(0) + "\n"
                            + " Última sinalização = " + element.getLista().getDataImplantacao(tam - 1) + " <--" + "\n");
                } else {
                    System.out.println("["+ lista.get(i).getNomeLog()+ "]" + "\n");
                }
            }
            System.out.println("========================================");
        } while (ok);

    }

}
