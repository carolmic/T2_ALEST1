

public class App {
    public static void main(String[] args) {
       
        DoubleLinkedList lista = new DoubleLinkedList();
        ArchiveReader.lerPreencher(lista);
  
        String nome = "WALDOMIRO SCHAPKE";
        int index = lista.indexOf(nome);
        Element test = lista.get(index);
        System.out.println("QUANTIDADE:  " + test.getLista().size());
        System.out.println("Mês com mais sinalizações: " +  lista.monthMostSinalizations(nome)); 
   
        System.out.println("Mais sinalizações registradas: " + lista.moreSinalizations().getNomeLog() + "Quantidade:" + lista.moreSinalizations().getLista().size());
    }
}


// 