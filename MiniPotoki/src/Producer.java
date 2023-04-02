public class Producer implements Runnable {
    private static final int AMOUNT_PRODUCED = 10; // Сколько товара необходимо произвести всего
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 0; i < AMOUNT_PRODUCED; i++) {
                buffer.add(i);
                System.out.println("+Произведен товар с серийным номером " + i);
                Thread.sleep((int) (Math.random() * 100));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
