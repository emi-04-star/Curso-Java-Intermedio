package MisionEspacial;

import java.util.concurrent.Callable;

public class SistemaNavegacion implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Navegación: Trayectoria corregida con éxito.";
    }
}