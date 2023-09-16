import java.util.Stack;

public class tree {
    public Node root;
    private class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
    public void createBT(){
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

       //connecting Node to form tree
        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
    }

    // recursive method
    public void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    // inorder traversal using stack
    public void inOrder(){
        if(root == null){
            return;
        }
        Stack<Node> S = new Stack<>();
        Node curr = root;
        while(curr != null || S.size() > 0){
            while(curr != null){
                S.push(curr);
                curr = curr.left;
            }
            curr = S.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    //inorder traversal using morris traversal
    public void inorder(){
        if(root == null){
            return;
        }
        Node curr = root;
        //While current is not null, check if it has a left child.
        //If there is no left child, print the current node and move to the right child of the current node.
        while(curr != null){
            if(curr.left == null){
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
            // find the rightmost node of the left subtree or the node whose right child is the current node:
            else{
                Node temp = curr.left;
                while(temp.right != null && temp.right!= curr) {
                    temp = temp.right;
                }
                    if(temp.right == null){
                        temp.right = curr;
                        curr = curr.left;
                    }
                    else{
                        System.out.print(curr.data + " ");
                        temp.right = null;
                        curr = curr.right;
                    }

            }
        }
    }

    public static void main(String[] args) {
        tree tr = new tree();

        tr.createBT();
//        tr.preOrder(tr.root);
//        tr.inOrder(tr.root);
//        tr.postOrder(tr.root);
        tr.inorder();

    }
}
