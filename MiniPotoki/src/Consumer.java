public class Consumer implements Runnable {

    private static final int AMOUNT_CONSUMED = 10; // Сколько товара будет приобретено всего
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 0; i < AMOUNT_CONSUMED; i++) {
                int value = buffer.remove();
                System.out.println("-Потреблен товар с серийным номером " + value);
                Thread.sleep((int) (Math.random() * 100));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}