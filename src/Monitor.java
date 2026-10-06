public class Monitor implements Runnable {

    private Descarga[] descargas;

    //Recibe los hilos que va a supervisar
    public Monitor(Descarga[] descargas) {
        this.descargas = descargas;
    }

    public void run() {
        boolean DescargasActivas = true;
        //Mientras haya descargas activas esperara 500ms y comprobara cuantos hilos hay activos
        while (DescargasActivas) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

                break;
            }

            int activas = 0;

            // Con este bucle veremos la cantidad de descargas activas
            for (Descarga d : descargas) {
                if (d.isAlive()) {
                    activas++;
                }
            }

            //Si hay mas de 0 descargas activas el programa termina, si no se vuelve a ejecutar
            if (activas > 0) {
                System.out.println("[MONITOR] Descargas en curso: " + activas);
            } else {

                DescargasActivas = false;
            }
        }

        System.out.println("[MONITOR] Supervisión finalizada. No quedan descargas activas.");
    }
}