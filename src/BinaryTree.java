
public class BinaryTree {
    public Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }
    public BinaryTree() {
    }

    private class Node{
        private int data;
        private Node left;
        private Node right;
        public Node(int data) {
            this.data = data;
        }
    }
    public void create(){
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;
    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
    }

}
