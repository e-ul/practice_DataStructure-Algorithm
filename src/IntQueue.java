// ring buffer로 queue 만들기

public class IntQueue {
    private int max;
    private int front;
    private int rear;
    private int num;
    private int[] que;

    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }

    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }

    public IntQueue(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch(OutOfMemoryError e) {
            max = 0;
        }
    }

    public int enque(int x) throws OverflowIntQueueException {
        if (num >= max){
            throw new OverflowIntQueueException();
        }

        que[rear++] = x;
        num++;

        if(rear == max){
            rear = 0;
        }
        return x;
    }

    public int deque() throws EmptyIntQueueException {
        if ( num <= 0 ) {
            throw new EmptyIntQueueException();
        }

        int x = que[front++];
        num--;

        if(front == max){
            front = 0;
        }

        return x;
    }

    public int peek() throws EmptyIntQueueException {
        if ( num <= 0 ) {
            throw new EmptyIntQueueException();
        }
        return que[front];
    }

    public int indexOf(int x) {
        int idx;
        for(int i = 0 ; i < max ; i++) {
            idx = (i + front) % max;
            if(que[idx] == x) {
                return idx;
            }
        }

        return -1;
    }

    public void clear(){
        num = front = rear = 0;
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

    // 04 - Q5 search 함수 생성. Queue안에서 몇번째에 있는가를 양수로 반환(Queue의 front에 있는 경우 1). 검색에 실패하면 0.
    public int search(int x) {
        int idx;
        for(int i = 0 ; i < max ; i++) {
            idx = (i + front) % max;
            if(que[idx] == x) {
                return i + 1;
            }
        }

        return 0;
    }

}
