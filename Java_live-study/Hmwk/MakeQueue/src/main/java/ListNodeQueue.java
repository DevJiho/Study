public class ListNodeQueue extends ListNode implements ListNodeQueueInterface{
    ListNode head;

    public ListNodeQueue(){
        head = new ListNode();
    }

    @Override
    public void push(int data) {
        ListNode node = head;
        while(node.next != null){
            node = node.next;
        }
        node.next = new ListNode(data);
    }

    @Override
    public int pop() {
        ListNode node = head;

        if(node.next == null){
            System.err.println("Error!");
            System.exit(1);
        }

        node = node.next;
        head.next = node.next;

        return node.value;
    }
}
