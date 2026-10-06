public class Monitor implements Runnable {

    private Descarga[] descargas;


    public Monitor(Descarga[] descargas) {
        this.descargas = descargas;
    }

    public void run() {
        boolean DescargasActivas = true;

        while (DescargasActivas) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

                break;
            }

            int activas = 0;


            for (Descarga d : descargas) {
                if (d.isAlive()) {
                    activas++;
                }
            }


            if (activas > 0) {
                System.out.println("[MONITOR] Descargas en curso: " + activas);
            } else {

                DescargasActivas = false;
            }
        }

        System.out.println("[MONITOR] Supervisión finalizada. No quedan descargas activas.");
    }
}