import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree{
    Node node;

    BinaryTree(){
        node = null;
    }

    public void bfs(Node node){
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(true){
            node = q.poll();
            if(node == null) break;
            System.out.println(node.value);
            q.add(node.left);
            q.add(node.right);
        }
    }

    public void dfs(Node node){
        if(node == null) return;
        dfs(node.left);

        System.out.println(node.value);

        dfs(node.right);
    }

    public void findLeaf(Node node, int value){
        if(node == null){
            this.node = new Node();
            this.node.push(value);
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(true){
            node = q.poll();
            if(node.left == null){
                node.left = new Node();
                node.left.push(value);
                break;
            }else if(node.right == null){
                node.right = new Node();
                node.right.push(value);
                break;
            }
            q.add(node.left);
            q.add(node.right);
        }
    }

}
