public class Node implements NodeInterface{
    Integer value;
    Node left, right;
    public static int size;

    @Override
    public void push(int value){
        this.value = value;
    }
}
