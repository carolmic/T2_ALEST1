

public class AppInsercaoOrdenada {
    public static void main(String[] args) {
       
        DoubleLinkedListOfInteger lista = new DoubleLinkedListOfInteger();
        LeituraArquivo.lerPreencher(lista);
  
        String nome = "JOSE GOMES";
        int index = lista.indexOf(nome);
        Element test = lista.get(index);
        System.out.println("QUANTIDADE:  " + test.getLista().size());
        System.out.println("Mês com mais sinalizações: " +  lista.monthMoreSinalizations(nome)); 
   
        System.out.println("Mais sinalizações registradas: " + lista.moreSinalizations().getNomeLog() + "Quantidade:" + lista.moreSinalizations().getLista().size());
    }
}


// 