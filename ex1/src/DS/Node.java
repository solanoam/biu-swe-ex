package DS;

public class Node {

    private int val;
    private Node nextNode;

    public Node() {
        this.val = 0;
    }
    public Node(int val) {
        this.val = val;
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

