public class GestorDescargas {

    public static void main(String[] args) throws InterruptedException {

        String[] archivos;

        if (args.length == 0) {

            archivos = new String[]{
                    "cuarzos.png",
                    "meditacion.mp4",
                    "mantras.mp3",
                    "horoscopo.pdf"
            };
        } else {

            archivos = args;
        }

        Descarga[] descargas = new Descarga[archivos.length];

        for (int i = 0; i < archivos.length; i++) {
            descargas[i] = new Descarga(archivos[i]);
            descargas[i].setName("Descarga-" + archivos[i]);
        }

        Monitor monitorRunnable = new Monitor(descargas);
        Thread hiloMonitor = new Thread(monitorRunnable);

        long inicioPrograma = System.currentTimeMillis();

        for (Descarga d : descargas){

            d.start();

        }

        hiloMonitor.start();

        for (Descarga d : descargas){

            d.join();

        }

        long finPrograma = System.currentTimeMillis();

        long tiempoReal = finPrograma - inicioPrograma;
        long sumaSecuencial = 0;

        for (Descarga d : descargas){
            sumaSecuencial += d.getTiempoFinal();

        }


        System.out.println("Todas las descargas han terminado.");
        System.out.println("Tiempo real (paralelo): " + tiempoReal + " ms");
        System.out.println("Tiempo en secuencia (suma): " + sumaSecuencial + " ms");

    }
}