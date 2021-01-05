import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        BinaryTree root = new BinaryTree();

        int[] arr = {42,13,12,42,13,16,41};
        Arrays.stream(arr).forEach(item -> root.findLeaf(root.node, item));

        System.out.println("\n print BFS");
        root.bfs(root.node);

        System.out.println("\n print DFS");
        root.dfs(root.node);
    }
}
