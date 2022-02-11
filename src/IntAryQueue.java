// array로 Queue 만들기
public class IntAryQueue {
    private int max;
    private int num;
    private int[] que;

    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }

    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }

    public IntAryQueue(int capacity) {
        num = 0;
        max = capacity;

        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int enque(int x) throws OverflowIntQueueException {
        if(num >= max) {
            throw new OverflowIntQueueException();
        }

        return que[num++] = x;
    }

    public int deque() throws EmptyIntQueueException {
        if (num <= 0) {
            throw new EmptyIntQueueException();
        }

        int x = que[0];
        num--;
        for(int i = 0 ; i < num ; i++) {
            que[i] = que[i+1];
        }

        return x;
    }

    public int peek() throws EmptyIntQueueException {
        if (num <= 0) {
            throw new EmptyIntQueueException();
        }
        return que[num - 1];
    }

    public int indexOf(int x){
        for(int i = 0 ; i < num ; i++){
            if( que[i] == x ) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        num = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= max;
    }
}
