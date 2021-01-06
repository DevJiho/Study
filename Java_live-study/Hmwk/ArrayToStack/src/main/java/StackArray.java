public class StackArray implements StackInterface{
    int[] Arr;
    int pos = 0;

    private StackArray(){ }
    public StackArray(int size){
        Arr = new int[size];
    }

    @Override
    public void push(int data){
        Arr[pos++] = data;
    }

    @Override
    public int pop(){
        return Arr[--pos];
    }

}
