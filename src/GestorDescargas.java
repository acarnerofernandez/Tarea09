public class GestorDescargas {

    public static void main(String[] args) throws InterruptedException {


        Descarga d1 = new Descarga("cuarzos.png");
        Descarga d2 = new Descarga("meditacion.mp4");
        Descarga d3 = new Descarga("mantras.mp3");
        Descarga d4 = new Descarga("horoscopo.pdf");


        d1.setName("Descarga-cuarzos.png");
        d2.setName("Descarga-meditacion.mp4");
        d3.setName("Descarga-mantras.mp3");
        d4.setName("Descarga-horoscopo.pdf");


        long inicioPrograma = System.currentTimeMillis();


        d1.start();
        d2.start();
        d3.start();
        d4.start();


        d1.join();
        d2.join();
        d3.join();
        d4.join();


        long finPrograma = System.currentTimeMillis();


        long tiempoReal = finPrograma - inicioPrograma;
        long sumaSecuencial = d1.getTiempoFinal() + d2.getTiempoFinal()  + d3.getTiempoFinal() + d4.getTiempoFinal();



        System.out.println("Todas las descargas han terminado.");
        System.out.println("Tiempo real (paralelo): " + tiempoReal + " ms");
        System.out.println("Tiempo en secuencia (suma): " + sumaSecuencial + " ms");

    }
}