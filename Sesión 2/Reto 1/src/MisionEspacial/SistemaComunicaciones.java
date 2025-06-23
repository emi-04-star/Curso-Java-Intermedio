package MisionEspacial;

import java.util.concurrent.Callable;

public class SistemaComunicaciones implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(800);
        return "Comunicaciones: Enlace con estación terrestre establecido.";
    }
}