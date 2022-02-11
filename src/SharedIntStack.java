// 하나의 배열을 공유하여 2개의 스택을 구현하는 int형 데이터용 스택 클래스를 만드세요.
// 스택에 저장하는 데이터는 int형 값으로 아래 그림처럼 배열의 처음과 끝을 사용하세요.
// 바닥--Stack A--> 꼭대기    꼭대기<--Stack B--바닥
// ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ

// Stack의 종류를 enum으로 만들어 case문을 사용했으면 사용자 오류도 줄이고 훨씬 깔끔했을 듯,,,

public class SharedIntStack {
    private int max;
    private int ptr_a;
    private int ptr_b;
    private int[] stk;

    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() { }
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {}
    }

    public SharedIntStack(int capacity){
        ptr_a = 0;
        ptr_b = capacity - 1;
        max = capacity;

        try {
            stk = new int[capacity];
        } catch (OutOfMemoryError e){
            max = 0;
        }
    }

    public int push(String stkType, int x){
        if(ptr_a >= ptr_b + 1) {
            throw new OverflowIntStackException();
        }

        if("a".equals(stkType)){
            return stk[ptr_a++] = x;
        } else if("b".equals(stkType)){
            return stk[ptr_b--] = x;
        } else {
            throw new EmptyIntStackException();
        }
    }

    public int pop(String stkType) {
        if("a".equals(stkType)){
            if(ptr_a <= 0){
                throw new EmptyIntStackException();
            } else {
                return stk[--ptr_a];
            }
        } else if("b".equals(stkType)){
            if(ptr_b >= max - 1){
                throw new EmptyIntStackException();
            } else {
                return stk[++ptr_b];
            }
        } else {
            throw new EmptyIntStackException();
        }
    }

    public int peek(String stkType) {
        if("a".equals(stkType)){
            if(ptr_a <= 0){
                throw new EmptyIntStackException();
            } else {
                return stk[ptr_a - 1];
            }
        } else if("b".equals(stkType)){
            if(ptr_b >= max - 1){
                throw new EmptyIntStackException();
            } else {
                return stk[ptr_b + 1];
            }
        } else {
            throw new EmptyIntStackException();
        }
    }

    public int indexOf(String stkType, int x) {
        if("a".equals(stkType)){
            for(int i = ptr_a - 1; i >= 0 ; i--){
                if(stk[i] == x){
                    return i;
                }
            }
        } else if ("b".equals(stkType)){
            for (int i = ptr_b + 1 ; i < max ; i++) {
                if(stk[i] == x) {
                    return i;
                }
            }
        } else {
            throw new EmptyIntStackException();
        }

        return -1;
    }

    public void clear(String stkType){
        if("a".equals(stkType)){
            ptr_a = 0;
        } else if ("b".equals(stkType)){
            ptr_b = max - 1;
        }
    }

    public int capacity(){
        return max;
    }

    public int size(String stkType){
        if("a".equals(stkType)){
            return ptr_a;
        } else if("b".equals(stkType)){
            return max - ptr_b - 1;
        } else {
            return 0;
        }
    }

    public boolean isEmpty(String stkType){
        if("a".equals(stkType)){
            return ptr_a <= 0 ;
        } else if ("b".equals(stkType)){
            return ptr_b >= max - 1;
        }
        return true;
    }

    public boolean isFull() {
        return ptr_a >= ptr_b + 1;
    }
}
