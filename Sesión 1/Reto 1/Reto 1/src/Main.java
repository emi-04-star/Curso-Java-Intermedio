import java.util.*;

public class Main{

    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        System.out.println("Órdenes registradas:");
        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }
    }

    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        System.out.println("Procesando órdenes personalizadas...");
        for (Object obj : lista) {
            if (obj instanceof OrdenPersonalizada) {
                OrdenPersonalizada op = (OrdenPersonalizada) obj;
                System.out.println("Orden " + op.getCodigo() + " ajustada con costo adicional de $" + costoAdicional);
            }
        }
    }

    // 🚀 Código de desafío opcional: contar órdenes por tipo
    public static void contarOrdenes(List<? extends OrdenProduccion> lista) {
        long masas = lista.stream().filter(o -> o instanceof OrdenMasa).count();
        long personalizadas = lista.stream().filter(o -> o instanceof OrdenPersonalizada).count();
        long prototipos = lista.stream().filter(o -> o instanceof OrdenPrototipo).count();

        System.out.println("Resumen total de órdenes:");
        System.out.println("Producción en masa: " + masas);
        System.out.println("Personalizadas: " + personalizadas);
        System.out.println("Prototipos: " + prototipos);
    }

    public static void main(String[] args) {
        List<OrdenProduccion> todasLasOrdenes = new ArrayList<>();

        List<OrdenMasa> masas = Arrays.asList(
                new OrdenMasa("A123", 500),
                new OrdenMasa("A124", 750)
        );

        List<OrdenPersonalizada> personalizadas = Arrays.asList(
                new OrdenPersonalizada("P456", 100, "ClienteX"),
                new OrdenPersonalizada("P789", 150, "ClienteY")
        );

        List<OrdenPrototipo> prototipos = Arrays.asList(
                new OrdenPrototipo("T789", 10, "Diseño"),
                new OrdenPrototipo("T790", 5, "Pruebas")
        );

        // Agregamos todas las órdenes a la lista combinada
        todasLasOrdenes.addAll(masas);
        todasLasOrdenes.addAll(personalizadas);
        todasLasOrdenes.addAll(prototipos);

        // Mostrar órdenes por tipo
        mostrarOrdenes(masas);
        mostrarOrdenes(personalizadas);
        mostrarOrdenes(prototipos);

        // Procesar órdenes personalizadas
        procesarPersonalizadas(personalizadas, 200);

        // Código de desafío opcional: contar órdenes por tipo
        contarOrdenes(todasLasOrdenes);
    }
}


