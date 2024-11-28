import java.util.Arrays;
import java.util.Random;

public class ProducerThread extends Thread{

    private Random random;

    private Stack stack;
    private int iterate;

    public ProducerThread(Stack stack, int iterate) {
        this.random = new Random();

        this.stack = stack;
        this.iterate = iterate;
    }

    @Override
    public void run() {
        for (int i=0; i < this.iterate; i++){
            try {
                int pushItem = random.nextInt(9)+1;
                this.stack.push(pushItem);
                System.out.println("ProducerThread: " + Thread.currentThread().threadId() + "\t\t Item:" + pushItem +
                        "\t\tCurrentArray: " + Arrays.toString(stack.getArray()));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
