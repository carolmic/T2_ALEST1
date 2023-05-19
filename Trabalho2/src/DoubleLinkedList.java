import java.util.HashMap;
import java.util.Map;

public class DoubleLinkedList {

    private Node header;

    private Node trailer;

    private Node current;

    private int count;

    private class Node {
        public Element element;
        public Node next;
        public Node prev;

        public Node(Element e) {
            element = e;
            next = null;
            prev = null;
        }
    }

    public DoubleLinkedList() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    public void add(Element element) {

        Node n = new Node(element);

        n.next = trailer;
        n.prev = trailer.prev;

        trailer.prev.next = n;
        trailer.prev = n;

        count++;
    }

    public Element moreSinalizations() {
        int num = 0;
        Element element = null;
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            if (aux.element.getLista().size() > num) {
                num = aux.element.getLista().size();
                element = aux.element;
            }
            aux = aux.next;
        }
        return element;
    }

    public Map<String, String> monthMostSinalizations() {
        int[] months = new int[13];
        Map<String, String> map = new HashMap<String, String>(2);

        Node aux = header.next;
        Node aux2 = trailer.prev;
        for (int i = 0; i < count / 2; i++) {
            for (int j = 1; j <= 12; j++) {
                if (aux.element.getLista().moreSinalizations().get("mes") == j) {
                    months[0]++;
                    months[j]++;
                }
                if (aux2.element.getLista().moreSinalizations().get("mes") == j) {
                    months[0]++;
                    months[j]++;
                }
            }
            aux = aux.next;
            aux2 = aux2.prev;
        }

        int maior = 1;
        for (int i = 1; i < months.length; i++)
            if (months[i] > months[maior])
                maior = i;
        map.put("mes", monthToString(maior));
        map.put("quantidade", Integer.toString(months[maior]));
        return map;
        // Map<String, Integer> map = element.getLista().moreSinalizations();
        // Map<String, String> map2 = new HashMap<String, String>(2);
        // map2.put("mes", monthToString(map.get("mes")));
        // map2.put("quantidade", map.get("quantidade").toString());
        // return map2;
    }

    public Element Navigate(int index) {
        if (index < 0 || index >= size()) {
            index = 0;
        }
        return null;
    }

    private String monthToString(int month) {
        switch (month) {
            case 1:
                return "Janeiro";

            case 2:
                return "Fevereiro";

            case 3:
                return "Março";

            case 4:
                return "Abril";

            case 5:
                return "Maio";

            case 6:
                return "Junho";

            case 7:
                return "Julho";

            case 8:
                return "Agosto";

            case 9:
                return "Setembro";

            case 10:
                return "Outubro";

            case 11:
                return "Novembro";

            case 12:
                return "Dezembro";

            default:
                return "Mês inválido";
        }
    }

    public void add(int index, Element element) throws IndexOutOfBoundsException {
        if (index < 0 || index > count)
            throw new IndexOutOfBoundsException();

    }

    private Node getNodeIndex(int index) {
        Node aux = null;
        if (index < count / 2) {
            aux = header.next;
            for (int i = 0; i < index; i++)
                aux = aux.next;
        } else {
            aux = trailer.prev;
            for (int i = count - 1; i > index; i--)
                aux = aux.prev;
        }
        return aux;
    }

    public boolean remove(Element element) {
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            if (aux.element.equals(element)) {
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                count--;
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    public Element removeByIndex(int index) {

        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }

        Node aux = getNodeIndex(index);

        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        count--;

        return aux.element;
    }

    public Element get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getNodeIndex(index);
        return aux.element;
    }

    public Element set(int index, Element element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        return null;
    }

    public boolean contains(String nomeLog) {
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            if (aux.element.getNomeLog().equals(nomeLog)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    private Node containsElement(String element) {
        Node aux = header.next;

        while (aux != trailer) {
            if (aux.element.equals(element)) {
                return aux;
            }
            aux = aux.next;
        }

        return null;
    }

    public int indexOf(String nomeLog) {
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            if (aux.element.getNomeLog().equals(nomeLog)) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }

    public void clear() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.getNomeLog());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }

    public void orderedAdd(Element element) {
        Node aux = containsElement(element.getNomeLog()); // verifica se ja contem element para não inserir duplicado
        if (aux == null) { // se nao contem element, insere
            Node n = new Node(element);

            if (header.next == trailer) {
                // se a lista está vazia
                n.prev = header;
                n.next = trailer;
                trailer.prev = n;
                header.next = n;

            } else if (element.getNomeLog().compareTo(header.next.element.getNomeLog()) < 0) {
                // se for menor que o primeiro, insere no inicio
                n.next = header.next;
                n.prev = header;
                header.next = n;
                n.next.prev = n;
            } else if (element.getNomeLog().compareTo(trailer.prev.element.getNomeLog()) > 0) {
                // se for maior que o ultimo, insere no final
                n.next = trailer;
                n.prev = trailer.prev;
                trailer.prev.next = n;
                trailer.prev = n;
            } else {
                // senao procura a posicao correta para insercao
                aux = header.next;
                boolean inseriu = false;
                while (aux != trailer && !inseriu) {
                    if (element.getNomeLog().compareTo(aux.element.getNomeLog()) < 0) {
                        inseriu = true;
                        n.next = aux;
                        n.prev = aux.prev;
                        aux.prev.next = n;
                        aux.prev = n;
                    }
                    aux = aux.next;
                }
            }
            count++;
        }
    }

    public void reset() {
        current = header.next;
    }

    public Element next() {
        if (current != trailer) {
            Element num = current.element;
            current = current.next;
            return num;
        }
        return null;
    }
}
