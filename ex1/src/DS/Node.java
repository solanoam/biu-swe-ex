package DS;

public class Node {

    private int val;
    private Node nextNode;

    public Node() {
        this.val = 0;
        this.nextNode = null;
    }

    public Node(int val) {
        this.val = val;
        this.nextNode = null;
    }

    public Node(int val, Node nextNode) {
        this.val = val;
        this.nextNode = nextNode;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

}

