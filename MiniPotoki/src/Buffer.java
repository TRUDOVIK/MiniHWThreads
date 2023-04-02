public class Buffer {
    private int[] data;
    private int size;
    private int count;

    public Buffer(int size) {
        this.data = new int[size];
        this.size = size;
        this.count = 0;
    }

    /**
     * Добавляет продукт на склад. Если тот свободен.
     * @param value
     * @throws InterruptedException
     */
    public synchronized void add(int value) throws InterruptedException {
        while (count == size) {
            System.out.println("Производитель ожидает ");
            wait();
        }
        data[count++] = value;
        Thread.sleep((int) 10); // Добавлено для более корректного уведомления о производстве и потреблении.
        notifyAll();
    }

    /**
     * Забирает продукт со склада, если он не пуст.
     * @return
     * @throws InterruptedException
     */
    public synchronized int remove() throws InterruptedException {
        while (count == 0) {
            System.out.println("Потребитель ожидает ");
            wait();
        }
        int value = data[--count];
        Thread.sleep((int) 10); // Добавлено для более корректного уведомления о производстве и потреблении.
        notifyAll();
        return value;
    }
}