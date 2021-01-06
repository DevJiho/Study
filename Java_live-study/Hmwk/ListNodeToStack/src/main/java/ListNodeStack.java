

public class ListNodeStack extends ListNode implements Stack{
    ListNode head = new ListNode();

    @Override
    public void push(int data){
        ListNode node = this.head;
        while(node.next != null){
            node = node.next;
        }
        node.next = new ListNode(data);
    }

    @Override
    public int pop(){
        ListNode node = this.head;
        while(node.next.next != null){
            node = node.next;
        }
        int ret = node.next.value;
        node.next = null;
        return ret;
    }
}
