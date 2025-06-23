import java.util.*;


public class Main {

    public static void main(String[] args) {
        List<Pedido> pedidos = List.of(
                new Pedido("Pedro", "domicilio", "811-1234"),
                new Pedido("Cherry", "local", null),
                new Pedido("Carlos", "domicilio", null),
                new Pedido("Pablo", "domicilio", "811-0254")
        );


        List<String> mensajes = pedidos.stream()
                .filter(p -> p.getTipoEntrega().equalsIgnoreCase("domicilio"))
                .map(Pedido::getTelefono)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(tel -> "Confirmación enviada al número: " + tel)
                .toList();

        System.out.println("Confirmaciones de pedidos a domicilio:");
        mensajes.forEach(System.out::println);
    }
}