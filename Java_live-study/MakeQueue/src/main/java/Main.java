public class Main {
    public static void main(String[] args){
        ArrayQueue Arr_q = new ArrayQueue(100);

        Arr_q.push(10);
        Arr_q.push(20);
        Arr_q.push(50);

        System.out.println(Arr_q.pop());
        System.out.println(Arr_q.pop());
        System.out.println(Arr_q.pop());
        //System.out.println(Arr_q.pop());

        ListNodeQueue LNQueue = new ListNodeQueue();

        LNQueue.push(12);
        LNQueue.push(41);
        LNQueue.push(131);

        System.out.println(LNQueue.pop());
        System.out.println(LNQueue.pop());
        System.out.println(LNQueue.pop());

    }
}
