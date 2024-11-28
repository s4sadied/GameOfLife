public class Stack {

    private int maxSize;
    private int[] stack;
    private int position;

    private Thread[] threadlist;

    public Stack() {
        this.maxSize = 50;
        this.stack = new int[maxSize];
        this.position = 0;
        this.threadlist = new Thread[20];
    }

    public synchronized void push(int item) throws InterruptedException {
        while (position == maxSize-1) wait() ;
        this.stack[position] = item;
        this.position++;
        notify();
    }

    public synchronized int pop() throws InterruptedException {
        while (position < 1) wait();
        int returnVal = this.stack[position];
        this.stack[position] = 0;
        this.position--;
        notify();
        return returnVal;
    }

    public int[] getArray(){
        return this.stack;
    }

    public static void main(String[] args) throws InterruptedException {
        Stack stack = new Stack();

        for (int i=0; i<10; i++){
            ProducerThread pt = new ProducerThread(stack, 50);
            ConsumerThread ct = new ConsumerThread(stack, 50);
            stack.threadlist[i] = pt;
            stack.threadlist[i+10] = ct;
            pt.start();
            ct.start();
        }

        for (int i=0; i<stack.threadlist.length; i++){
            stack.threadlist[i].join();
        }

    }

}
