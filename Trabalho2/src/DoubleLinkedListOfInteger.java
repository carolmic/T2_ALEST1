
public class DoubleLinkedListOfInteger {
    // Referencia para o sentinela de inicio da lista encadeada.
    private Node header;
    // Referencia para o sentinela de fim da lista encadeada.
    private Node trailer;
    // Referencia para a posicao corrente.
    private Node current;
    // Contador do numero de elementos da lista.
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

    public DoubleLinkedListOfInteger() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Adiciona um elemento ao final da lista
     * 
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Element element) {
        // Primeiro cria o nodo
        Node n = new Node(element);
        // Primeiro conecta o novo nodo na lista
        n.next = trailer;
        n.prev = trailer.prev;
        // Depois atualiza os encadeamentos
        trailer.prev.next = n;
        trailer.prev = n;
        // Atualiza o count
        count++;
    }

    /**
     * Insere um elemento em uma determinada posicao da lista
     * 
     * @param index   a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Element element) throws IndexOutOfBoundsException {
        if (index < 0 || index > count) // indice invalido
            throw new IndexOutOfBoundsException();
        // Implementar este método
    }

    // Metodo que tem como objetivo retornar uma referencia
    // para o nodo da posicao "index" recebida como parametro.
    // Por exemplo, se index for 2, ele retorna a referencia
    // para o nodo da posicao 2.
    private Node getNodeIndex(int index) {
        Node aux = null;
        if (index < count / 2) { // caminha do inicio para o meio
            aux = header.next;
            for (int i = 0; i < index; i++)
                aux = aux.next;
        } else { // caminha do fim para o meio
            aux = trailer.prev;
            for (int i = count - 1; i > index; i--)
                aux = aux.prev;
        }
        return aux;
    }

    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente
     * 
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
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

    /**
     * Remove o elemento de uma determinada posicao da lista
     * 
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Element removeByIndex(int index) {
        // Primeiro verifica se index eh valido
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }

        // "Caminha" ate a posicao index
        Node aux = getNodeIndex(index);

        // Faz a remocao
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        count--;

        // Retorna o elemento removido
        return aux.element;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista
     * 
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Element get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getNodeIndex(index);
        return aux.element;
    }


    /**
     * Substitui o elemento armanzenado em uma determinada posicao da lista pelo
     * elemento indicado
     * 
     * @param index   a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Element set(int index, Element element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        // Implementar este método
        return null;
    }

    /**
     * Retorna um arranjo com uma copia de um subconjunto dos elementos da
     * lista.
     *
     * @param fromIndex a posição inicial ("inclusive") dos elementos a serem
     *                  incluídos
     * @param toIndex   a posição final ("exclusive") dos elementos a serem
     *                  incluídos
     * @return um arranjo com um subconjunto da lista
     * @throws IndexOutOfBoundsException se (fromIndex < 0 || toIndex > size())
     * @throws IllegalArgumentException  se (fromIndex > toIndex)
     */
    // public String[] subList(int fromIndex, int toIndex) {
    // // Implementar este método
    // return null;
    // }

    /**
     * Retorna true se a lista contem o elemento especificado
     * 
     * @param element o elemento a ser testado
     * @return true se a lista contém o elemento especificado
     */
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
    
    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista não contém o elemento
     * 
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     *         lista não contém o elemento
     */
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

    /**
     * Esvazia a lista
     */
    public void clear() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Retorna o numero de elementos da lista
     * 
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Retorna true se a lista não contem elementos
     * 
     * @return true se a lista não contem elementos
     */
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

    public void orderedAdd (Element element)  { 
        Node aux = containsElement(element.getNomeLog()); // verifica se ja contem element para não inserir duplicado
        if (aux == null) {  // se nao contem element, insere
            Node n = new Node(element);

            if (header.next == trailer) { 
                // se a lista está vazia
                n.prev = header;
                n.next = trailer;
                trailer.prev = n;
                header.next = n;

            } 
            else if (element.getNomeLog().compareTo(header.next.element.getNomeLog())<0) { 
                // se for menor que o primeiro, insere no inicio
                n.next = header.next;
                n.prev = header;
                header.next = n;
                n.next.prev = n;
            }
            else if (element.getNomeLog().compareTo(trailer.prev.element.getNomeLog())>0) {
                // se for maior que o ultimo, insere no final
                n.next = trailer;
                n.prev = trailer.prev;
                trailer.prev.next = n;
                trailer.prev = n;
            }
            else {
                // senao procura a posicao correta para insercao
                aux = header.next;
                boolean inseriu=false;
                while (aux!=trailer && !inseriu) {
                    if (element.getNomeLog().compareTo(aux.element.getNomeLog())<0) {
                        inseriu = true;
                        n.next = aux;
                        n.prev=aux.prev;
                        aux.prev.next = n;
                        aux.prev = n;
                    }
                    aux = aux.next;
                }
            }
            count++;
        }
    }

    /**
     * Inicializa o current na primeira posicao (para percorrer do inicio para o
     * fim).
     */
    public void reset() {
        current = header.next;
    }

    /**
     * Retorna o elemento da posicao corrente e faz current apontar para o proximo
     * elemento da lista.
     * 
     * @return elemento da posicao corrente
     */
    public Element next() {
        if (current != trailer) {
            Element num = current.element;
            current = current.next;
            return num;
        }
        return null;
    }
}
