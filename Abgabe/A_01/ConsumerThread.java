import java.util.Arrays;

public class ConsumerThread extends Thread{
    private Stack stack;
    private int iterate;

    public ConsumerThread(Stack stack, int iterate) {
        this.stack = stack;
        this.iterate = iterate;
    }

    @Override
    public void run() {
        for (int i=0; i < this.iterate; i++){
            try {
                int popItem = this.stack.pop();
                System.out.println("ConsumerThread: " + Thread.currentThread().threadId() + "\t\t Item:" + popItem +
                        "\t\tCurrentArray: " + Arrays.toString(stack.getArray()));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
