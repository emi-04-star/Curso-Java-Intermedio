import java.util.*;

public class ProcesadorEncuestas {

    public static void main(String[] args) {

        List<Sucursal> sucursales = List.of(
                new Sucursal("Centro", List.of(
                        new Encuesta("Carolina", "El tiempo de espera fue largo", 2),
                        new Encuesta("Luis", null, 5)
                )),
                new Sucursal("Norte", List.of(
                        new Encuesta("Alexa", "La atención fue buena, pero la limpieza puede mejorar", 3),
                        new Encuesta("Alejandro", null, 4)
                )),
                new Sucursal("Sur", List.of(
                        new Encuesta("Pablo", null, 2),
                        new Encuesta("Cruz", "No encontré el medicamento que necesitaba", 1)
                ))
        );

        System.out.println("Seguimiento a pacientes insatisfechos:");

        sucursales.stream()
                .flatMap(sucursal ->
                        sucursal.getEncuestas().stream()
                                .filter(e -> e.getCalificacion() <= 3)
                                .map(encuesta -> new Seguimiento(encuesta, sucursal.getNombre()))
                )
                .filter(seg -> seg.encuesta().getComentario().isPresent())
                .map(seg -> {
                    String comentario = seg.encuesta().getComentario().get();
                    return "Sucursal " + seg.sucursal() +
                            ": Seguimiento a paciente con comentario: \"" + comentario + "\"";
                })
                .forEach(System.out::println);
    }


    record Seguimiento(Encuesta encuesta, String sucursal) {
    }
}


    record Seguimiento(Encuesta encuesta, String sucursal) {
    }
