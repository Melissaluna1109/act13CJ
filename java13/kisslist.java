import java.util.ArrayList;
import java.util.List;

interface ordenarAlf {
    void metodoOrdenarAlf();
}

interface ordenarLong {
    void metodoOrdenarLong();
}

interface metodoReferencia {
    void ordenamiento(List<String> kiss);
}

class ordenamiento {

    void ordenamientoAlf(List<String> kiss) {
        kiss.sort(new OrdenarAlfabeticamente());
        System.out.println("Ordenamiento alfabetico con método de referencia");
        for (String alf : kiss) {
            System.out.println(alf);
        }
        System.out.println();
    }

    void ordenamientoLong(List<String> kiss) {
        kiss.sort(new OrdenarLongitud());
        System.out.println("Ordenamiento por longitud con método de referencia");
        for (String longi : kiss) {
            System.out.println(longi);
        }
        System.out.println();
    }
}

public class kisslist {

    static List<String> kiss = new ArrayList<>();

    public static void main(String[] args) {
        kisslist principal = new kisslist();
        kiss.add("Kevin");
        kiss.add("Jared");
        kiss.add("Luis");
        kiss.add("Ricardo");
        kiss.add("Iram");
        kiss.add("Carlos");
        kiss.add("Alfredo");
        kiss.add("David");
        kiss.add("Alan");
        kiss.add("Zarec");

        ordenarAlf Alf = new ordenarAlf() {
            @Override
            public void metodoOrdenarAlf() {
                kiss.sort(new OrdenarAlfabeticamente());
                System.out.println("Ordenamiento alfabetico con clase anonima");
                for (String alf : kiss) {
                    System.out.println(alf);
                }
                System.out.println();
            }
        };

        ordenarLong Long = new ordenarLong() {
            public void metodoOrdenarLong() {
                kiss.sort(new OrdenarLongitud());
                System.out.println("Ordenamiento por longitud con clase anonima");
                for (String longi : kiss) {
                    System.out.println(longi);
                }
                System.out.println();
            }
        };

        Alf.metodoOrdenarAlf();
        Long.metodoOrdenarLong();
        System.out.println("Ordenamiento alfabetico con expresión Lambda");
        principal.imprimirLista(principal.ordenAlfLambda());
        System.out.println();
        System.out.println("Ordenamiento por longitud con expresión Lambda");
        principal.imprimirLista(principal.ordenLongLambda());
        System.out.println();

        ordenamiento orden = new ordenamiento();
        metodoReferencia ordenAlf = orden::ordenamientoAlf;
        metodoReferencia ordenLong = orden::ordenamientoLong;
        ordenAlf.ordenamiento(kiss);
        ordenLong.ordenamiento(kiss);
    }

    public List<String> ordenAlfLambda() {
        final List<String> kiss = kisslist.kiss;
        kiss.sort((f1, f2) -> f1.compareToIgnoreCase(f2));
        return kiss;
    }

    public List<String> ordenLongLambda() {
        kiss.sort((f1, f2) -> f1.length() - f2.length());
        return kiss;
    }

    public void imprimirLista(List<String> kiss) {
        kiss.forEach(System.out::println);
    }
}