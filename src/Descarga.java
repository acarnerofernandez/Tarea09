public class Descarga extends Thread{

    private String archivo;
    private int tiempoFichero;
    private long tiempoFinal;

    // Un simple constructor que recoge el nombre del fichero y el tiempo aleatorio de descarga
    public Descarga(String fichero) {
        this.archivo = fichero;
        this.tiempoFichero = (int) (Math.random() * 401) + 100;
    }

    // COn este metodo se iniciara la descarga
     public void run () {
            System.out.println("Iniciando descarga de " + archivo);
            long inicio = System.currentTimeMillis();

            // Este bucle fragmentara la descarga en 10 para poner el porcentage de 10 en 10 hasta 100
            for (int i = 1; i <= 10; ++i) {
                try {

                    Thread.sleep(tiempoFichero);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                int avance = i * 10;

                System.out.println("[" + archivo + "] " + avance + "%");
            }

            // Calculamos el tiempo final de la descarga
            long fin = System.currentTimeMillis();
            this.tiempoFinal = fin - inicio;

            System.out.println("[" + archivo + "] completada en " + tiempoFinal + " ms");
        }

    // Creamos un getter del tiempo final ya que sera necesario para usar en el GestorDescargas
    public long getTiempoFinal() {
        return tiempoFinal;
    }
}







