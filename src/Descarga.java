public class Descarga extends Thread{

    private String archivo;
    private int tiempoFichero;
    private long tiempoFinal;


    public Descarga(String fichero) {
        this.archivo = fichero;
        this.tiempoFichero = (int) (Math.random() * 401) + 100;
    }

     public void run () {
            System.out.println("Iniciando descarga de " + archivo);
            long inicio = System.currentTimeMillis();


            for (int i = 1; i <= 10; ++i) {
                try {

                    Thread.sleep(tiempoFichero);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                int avance = i * 10;

                System.out.println("[" + archivo + "] " + avance + "%");
            }


            long fin = System.currentTimeMillis();
            this.tiempoFinal = fin - inicio;

            System.out.println("[" + archivo + "] completada en " + tiempoFinal + " ms");
        }

    public long getTiempoFinal() {
        return tiempoFinal;
    }
}







