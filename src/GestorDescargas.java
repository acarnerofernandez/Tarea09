public class GestorDescargas {

    public static void main(String[] args) throws InterruptedException {

        String[] archivos;

        if (args.length == 0) {

            // Comprueba si llegan archivos por terminal, si no, usa los valores por defecto
            archivos = new String[]{
                    "cuarzos.png",
                    "meditacion.mp4",
                    "mantras.mp3",
                    "horoscopo.pdf"
            };
        } else {

            archivos = args;
        }

        // Instancia el array de objetos Descarga (hilos)
        Descarga[] descargas = new Descarga[archivos.length];

        // Prepara cada hilo y le asigna un nombre identificado
        for (int i = 0; i < archivos.length; i++) {
            descargas[i] = new Descarga(archivos[i]);
            descargas[i].setName("Descarga-" + archivos[i]);
        }

        // Preparamos el monitor para poder ejecutarlo
        Monitor monitorRunnable = new Monitor(descargas);
        Thread hiloMonitor = new Thread(monitorRunnable);

        //Iniciamos la cuenta atras del programa
        long inicioPrograma = System.currentTimeMillis();


        // Por cada descarga iniciamos un hilo
        for (Descarga d : descargas){

            d.start();

        }

        //Iniciamos el hilo monitor
        hiloMonitor.start();

        // Con este comando hacemos que el programa espere a que todos los hilos de descarga terminen
        for (Descarga d : descargas){

            d.join();

        }

        //Registramos el fin del programa
        long finPrograma = System.currentTimeMillis();

        //Calculamos el tiempo real restando el tiempo de fin y de inicio
        long tiempoReal = finPrograma - inicioPrograma;
        long sumaSecuencial = 0;

        //Por cada hilo de descarga suma el tiempo necesitado a la variable de secuencia
        for (Descarga d : descargas){
            sumaSecuencial += d.getTiempoFinal();

        }


        System.out.println("Todas las descargas han terminado.");
        System.out.println("Tiempo real (paralelo): " + tiempoReal + " ms");
        System.out.println("Tiempo en secuencia (suma): " + sumaSecuencial + " ms");

    }
}