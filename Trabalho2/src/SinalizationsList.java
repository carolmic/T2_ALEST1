import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class SinalizationsList {

    private Node head;
    private Node tail;
    private Node current;
    private int count;

    private class Node {
        public Sinalization element;
        public Node next;

        public Node(Sinalization e) {
            this.element = e;
            next = null;
        }
    }

    public SinalizationsList() {
        head = null;
        tail = null;
        count = 0;
    }

    public void add(Sinalization element) {
        Node n = new Node(element);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
        count++;

    }

	public Map<String,Integer> moreSinalizations() { //Método que indica o mês com mais sinalizações na lista, e qual a quantidade de sinalizações
        int[] months = new int[13];
        Map<String,Integer> map = new HashMap<String,Integer>(2);

        Node aux = head;
        for(int i = 0; i < count; i++) {
            for (int j = 1; j <= 12; j++)
                if (aux.element.getMes() == j) {
                    months[0]++;
                    months[j]++;
                }
            aux = aux.next;     
        }
        
        int maior = 1;
        for(int i = 1; i < months.length; i++)
            if(months[i] > months[maior])
                maior = i;
		map.put("mes", maior);
        map.put("quantidade", months[maior]);
		return map;
	}

    public int size() { 
        return count;
    }

    public int getMonth(int index) { // Método que retorna o mês de implantação da iésima sinalização
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }

        if (index == count - 1) {
            return tail.element.getMes();
        }
        Node aux = head;
        int c = 0;
        while (c < index) {
            aux = aux.next;
            c++;
        }
        return aux.element.getMes();
    }

    public LocalDate getDataImplantacao(int index) { // Método que retorna a data de implantação da sinalização localizada no index indicado
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        if (index == count - 1) {
            return tail.element.getDataImplantacao();
        }
        Node aux = head;
        int c = 0;
        while (c < index) {
            aux = aux.next;
            c++;
        }
        return aux.element.getDataImplantacao();
    }

    public LocalDate getMenorData() { // retorna a data da primeira sinalização instalada
        Node aux = head.next;
        Node ant = head;
        LocalDate menorData = ant.element.getDataImplantacao();
        for (int i=0; i < count; i++) {
            if (aux == null) {
                return menorData;
            }
            LocalDate date1 = aux.element.getDataImplantacao();
          
            if (date1.compareTo(menorData) <= 0) {
                menorData = date1;
            
            ant = ant.next; 
            aux = aux.next; 
        }
    }
    return menorData;
    } 
    public LocalDate getMaiorData() { // retorna a data da última sinalização instalada
        Node aux = head.next;
        Node ant = head;
        LocalDate maiorData = ant.element.getDataImplantacao();
        for (int i=0; i < count; i++) {
            if (aux == null) {
                return maiorData;
            }
            LocalDate date1 = aux.element.getDataImplantacao();
       
            if (date1.compareTo(maiorData) >= 0) {
                maiorData = date1;
            }
            ant = ant.next; 
            aux = aux.next; 
        }
        return maiorData;
    }
 

    @Override
    public String toString() {
        String s = "";
        Node aux = head;
        while (aux != null) {
            s += aux.element + "\n";
            aux = aux.next;
        }
        return s;
    }
}
