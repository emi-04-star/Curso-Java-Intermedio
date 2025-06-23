package MisionEspacial;

import java.util.concurrent.Callable;

public class SistemaSoporteVital implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1200);
        return "Soporte vital: Presión y oxígeno dentro de parámetros normales.";
    }
}