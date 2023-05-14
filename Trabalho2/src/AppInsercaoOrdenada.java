public class AppInsercaoOrdenada {
    public static void main(String[] args) {
        // LinkedListOfString lista = new LinkedListOfString();
        DoubleLinkedListOfInteger lista = new DoubleLinkedListOfInteger();
        LeituraArquivo leitura = new LeituraArquivo();
        leitura.leituraArquivo(lista);
        System.out.println(lista.get((int) Math.floor((Math.random() * lista.size()))).getLista());
        for (int i=0; i<1000; i++) {
            Element element = lista.get(i);
            System.out.println("Sinalizações do logradouro " + element.getNomeLog());

        }

    }
}
