
package DS;

public class MyLinkedList {
    private Node head;
    private int elementsNum;

    public MyLinkedList(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getElementsNum() {
        return elementsNum;
    }

    public void setElementsNum(int elementsNum) {
        this.elementsNum = elementsNum;
    }

    public void IncElementsSize(){
        this.elementsNum++;
    }
    public void AddNode(Node n){
        Node temp;
        temp = this.head;
        while (temp != null) {
            if (temp.getNextNode() != null){
                temp = temp.getNextNode();
            }
            else {
                temp.setNextNode(n);
                IncElementsSize();
            }
        }
    }
    public void AddNode(Node n, int index){
        Node currentNode;
        Node nextNewNode;
        currentNode = this.head;
        for (int i = 0 ; i <= index ; i++){
            currentNode = currentNode.getNextNode();
            if (currentNode == null) {
                return;
            }
        }
        if (currentNode.getNextNode() != null) {
            nextNewNode = currentNode.getNextNode();
        }
        else {
            nextNewNode = null;
        }
        currentNode.setNextNode(n);
        n.setNextNode(nextNewNode);
        IncElementsSize();
    }
    public void RemoveNode(){

    }
    public void RemoveNode(int index){

    }
}