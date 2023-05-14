public class ListadeSinalizacoes {

	private Node head;
	private Node tail;
	private Node current;
	private int count;

	private class Node {
		public Sinalizacao element;
		public Node next;

		public Node(Sinalizacao e) {
			this.element = e;
			next = null;
		}
	}

	public ListadeSinalizacoes() {
		head = null;
		tail = null;
		count = 0;
	}

	// Métodos
	public void add(Sinalizacao element) {
		Node n = new Node(element);
		if (head == null) {
			head = n;
		} else {
			tail.next = n;
		}
		tail = n;
		count++;

	}

	public int size() { // Retorna o total de sinalizações
		return count;
	}

	public int getMonth(int index) { // retorna o mês de implantação da iésima sinalização
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

	// -- PRECISO FAZER UM PARSE DE STRING PARA INT --
	// retorna data de implantação da iésima
	// sinalização, para depois comparar qual
	// é maior ou menor
	public int getDataImplantacao(int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException();
		}
		if (index == count - 1) {
			return tail.element.getDataExtracao();
		}
		Node aux = head;
		int c = 0;
		while (c < index) {
			aux = aux.next;
			c++;
		}
		return aux.element.getDataExtracao();
	}

	// getMenorData() // retorna a data da primeira sinalização instalada
	// (considerando esta lista)
	// getMaiorData() // retorna a data da última sinalização instalada
	// (considerando esta lista)

	// reset()
	// next()

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
