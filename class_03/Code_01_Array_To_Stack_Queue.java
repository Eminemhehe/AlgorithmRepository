package class_03;

public class Code_01_Array_To_Stack_Queue {

    public static class ArrayStack {
        private Integer[] arr;
        private Integer Index;

        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            Index = 0;
        }

        public Integer peek() {
            if (Index == 0) {
                return null;
            }
            return arr[Index - 1];
        }

        public void push(int obj) {
            if (Index == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            arr[Index++] = obj;
        }

        public Integer pop() {
            if (Index == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            return arr[--Index];
        }
    }

    public static class ArrayQueue {
        private Integer[] arr;
        private Integer size;
        //表示如果需要取出数的index
        private Integer start;
        //表示进队列的数的index
        private Integer end;

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
            start = 0;
            end = 0;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[start];
        }

        public void push(int obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            size++;
            arr[end] = obj;
            //到底部返回开头
            end = end == arr.length - 1 ? 0 : end + 1;
        }

        public Integer poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size--;
            int tmp = start;
            start = start == arr.length - 1 ? 0 : start + 1;
            return arr[tmp];
        }
    }

    public static void main(String[] args) {

    }

}
