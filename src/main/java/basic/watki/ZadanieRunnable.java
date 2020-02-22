package basic.watki;

class ZadanieRunnable implements Runnable {
    private String nazwa;
    private boolean aktywny = true;
    public ZadanieRunnable(String nazwa) {
        this.nazwa = nazwa;
    }
    public void wylacz() {
        System.out.println(this.nazwa + " : 16:00 - idę do domu!");
        this.aktywny = false;
    }
    @Override
    public void run() {
        while(this.aktywny) {
            System.out.println(this.nazwa + " : pracuje!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
