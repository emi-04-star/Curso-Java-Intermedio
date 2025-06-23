package MisionEspacial;

import java.util.concurrent.Callable;

public class SistemaControlTermico implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1100);
        return "Control Térmico: Temperatura estable (22°C).";
    }
}