import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Jay Ajwani on 2/3/2017.
 */
public class Node {
    public int data;
    public Node left;
    public Node right;
    public Node Parent;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.left = null;
    }
}

class Tree {
    Node root;


    public Tree() {
        CreateTree();
    }

    private void CreateTree() {

        Node node = new Node(1);
        root = node;
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        root.left.right.right = new Node(10);

        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(11);
    }

    public void preOrder() { // preOrder
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder() { // inOrder
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void postOrder() { // postOrder
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public int getSize() { // get the size of the tree
        return getSize(root);
    }

    private int getSize(Node node) {
        if (node == null)
            return 0;
        return 1 + getSize(node.left) + getSize(node.right);
    }

    public int getHeight() { // get the height of the tree
        return getHeight(root);
    }

    private int getHeight(Node node) {
        if (node == null)
            return 0;
        int lHeight = getHeight(node.left);
        int rHeight = getHeight(node.right);

        return 1 + Math.max(lHeight, rHeight);
    }

    public void printLevelOrder() { // print according to the levels
        printLevelOrder(root);
    }

    private void printLevelOrder(Node node) {
        if (node == null)
            return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);

        while (queue.size() > 0) {
            Node curr = queue.poll();
            if (curr != null) {
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
                System.out.print(curr.data + "  ");
            } else {
                if (queue.size() == 0)
                    break;
                queue.add(null);
                System.out.println();
            }
        }
    }

    public void printZigZag() { // print level in a ZigZag way
        printZigZag(root);
    }

    private void printZigZag(Node node) {
        if (node == null)
            return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);
        boolean bPrint = true;
        Stack<Node> stack = new Stack<Node>();
        while (queue.size() > 0) {
            Node curr = queue.poll();
            if (curr != null) {
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
                if (bPrint)
                    System.out.print(curr.data + "  ");
                else
                    stack.push(curr);
            } else {
                if (queue.size() == 0)
                    break;
                queue.add(null);
                while (stack.size() > 0)
                    System.out.print(stack.pop().data + "  ");
                bPrint = !bPrint;
                System.out.println();
            }
        }
        while (stack.size() > 0)
            System.out.print(stack.pop().data + "  ");
    }


    public void PrintLeafNodes() {
        PrintLeafNodes(root);
    }

    private void PrintLeafNodes(Node node) {
        if (node != null) {
            PrintLeafNodes(node.left);
            PrintLeafNodes(node.right);

            if (node.left == null && node.right == null)
                System.out.print(node.data + ",");
        }
    }


    public static void main(String args[]) {
        Tree p = new Tree();
        p.preOrder();


    }
}


