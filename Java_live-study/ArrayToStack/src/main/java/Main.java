public class Main {
    public static void main(String[] args){
        StackArray stack = new StackArray(10);
        stack.push(10);
        stack.push(12);

        System.out.println(stack.pop());
    }
}
