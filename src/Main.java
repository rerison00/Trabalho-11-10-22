import javax.management.Query;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Hashtable<String, ArrayList<String>> tabela =
                new Hashtable<String, ArrayList<String>>();

        ArrayList<String> vizinhosMilena
                = new ArrayList<String>();
        vizinhosMilena.add("Yadira");
        vizinhosMilena.add("Juan");

        ArrayList<String> vizinhosJuan
                = new ArrayList<String>();
        vizinhosJuan.add("Milena");
        vizinhosJuan.add("Lucia");
        vizinhosJuan.add("Maria");

        ArrayList<String> vizinhosJavier
                = new ArrayList<String>();
        vizinhosJavier.add("Milena");
        vizinhosJavier.add("Yadira");
        vizinhosJavier.add("Andres");

        ArrayList<String> vizinhosYadira
                = new ArrayList<String>();
        vizinhosYadira.add("Lucia");

        ArrayList<String> vizinhosAndres
                = new ArrayList<String>();
        vizinhosAndres.add("Maria");

        tabela.put("Milena", vizinhosMilena);
        tabela.put("Juan", vizinhosJuan);
        tabela.put("Javier", vizinhosJavier);
        tabela.put("Yadira", vizinhosYadira);
        tabela.put("Andres", vizinhosAndres);

        showData(tabela);

        System.out.println("Milena - "+pesquisaEmLargura(tabela, "Milena"));
        System.out.println("Juan - "+pesquisaEmLargura(tabela, "Juan"));
        System.out.println("Javier - "+pesquisaEmLargura(tabela, "Javier"));
        System.out.println("Yadira - "+pesquisaEmLargura(tabela, "Yadira"));
        System.out.println("Andres - "+pesquisaEmLargura(tabela, "Andres"));
    }

    private static String pesquisaEmLargura(Hashtable<String, ArrayList<String>> tabela, String verticeInicial){
        Queue<String> fila = new LinkedList<String>();
        ArrayList<String> verificados = new ArrayList<String>();

        fila = enfileirar(fila, (ArrayList<String>)tabela.get(verticeInicial));

        while(fila.size() > 0){
            String pessoa = fila.poll();

            if ("Maria".equals(pessoa))
                return "Maria foi encontrada!";

            if (verificados.contains(pessoa))
                continue;

            fila = enfileirar(fila, (ArrayList<String>)tabela.get(pessoa));
            verificados.add(pessoa);
        }

        return "Maria não foi encontrada!";
    }

    private static Queue<String> enfileirar(Queue<String> fila, ArrayList<String> lista){
        if (lista == null)
            return fila;

        for (String item : lista){
            fila.offer(item);
        }

        return fila;
    }

    private static void showData(Hashtable<String, ArrayList<String>> tabela){
        for (Map.Entry<String, ArrayList<String>> entry : tabela.entrySet()){
            String chave = entry.getKey();
            ArrayList<String> dados = entry.getValue();

            System.out.println("Chave: " + chave + " Dados: " + dados);
        }
    }
}