public class Main {
    public static void main(String[] args){
        ListNodeStack Head = new ListNodeStack();
        Head.push(1);
        Head.push(2);
        Head.push(3);

        System.out.println(Head.pop());
        System.out.println(Head.pop());
        System.out.println(Head.pop());
    }
}
