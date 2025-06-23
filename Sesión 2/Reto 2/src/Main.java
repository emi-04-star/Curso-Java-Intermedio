import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando simulación de acceso al recurso...");

        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(new Profesional("Dra. Kiramman", salaCirugia));
        executor.submit(new Profesional("Dr. Talis", salaCirugia));
        executor.submit(new Profesional("Enfermero Kang", salaCirugia));
        executor.submit(new Profesional("Dra. Lanes", salaCirugia));

        executor.shutdown();
    }
}