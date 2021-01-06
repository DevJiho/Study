public class ArrayQueue implements ArrayQueueInterface{
    private int[] arr;
    int size;

    private ArrayQueue(){}

    public ArrayQueue(int size){
        this.arr = new int[size];
        size = 0;
    }

    @Override
    public void push(int data){
        if(size == this.arr.length){
            System.err.println("Size Over");
            System.exit(1);
        }
        arr[size++] = data;
    }

    @Override
    public int pop(){
        if(size == 0){
            System.err.println("Error!");
            System.exit(1);
        }
        int ret = arr[0];
        for(int i = 0; i < size; i++){
            arr[i] = arr[i + 1];
        }
        size--;

        return ret;
    }
}
