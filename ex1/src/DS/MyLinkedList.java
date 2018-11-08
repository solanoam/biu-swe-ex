package DS;

public class MyLinkedList {
    private Node head;
    private int elementsNum;

    public MyLinkedList(Node head) {
        this.head = head;
        this.elementsNum = 1;
    }
    public MyLinkedList() {
        this.head = null;
        this.elementsNum = 1;
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
    public void DecElementsSize(){
        this.elementsNum--;
    }

    public void AddNode(Node n){
        Node currentNode = this.head;
        //new list
        if (currentNode == null){
            setHead(n);
            return;
        }
        while (currentNode != null) {
            if (currentNode.getNextNode() != null){
                currentNode = currentNode.getNextNode();
            }
            else {
                currentNode.setNextNode(n);
                IncElementsSize();
            }
        }
    }
    public void AddNode(Node n, int index){
        Node currentNode = this.head;
        for (int i = 0 ; i <= index ; i++){
            currentNode = currentNode.getNextNode();
            if (currentNode == null) {
                return;
            }
        }
        Node nextNewNode;
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
        Node currentNode = null;
        Node prevNode = currentNode;
        currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.getNextNode() != null){
                prevNode = currentNode;
                currentNode = currentNode.getNextNode();
            }
            else {
                prevNode.setNextNode(null);
                DecElementsSize();
            }
        }
    }
    public void RemoveNode(int index) {
        Node currentNode = this.head;
        Node prevNode = currentNode;
        for (int i = 0; i <= index; i++) {
            prevNode = currentNode;
            currentNode = currentNode.getNextNode();
            if (currentNode == null) {
                return;
            }
        }
        Node nextNewNode;
        if (currentNode.getNextNode() != null) {
            nextNewNode = currentNode.getNextNode();
        } else {
            nextNewNode = null;
        }
        prevNode.setNextNode(nextNewNode);
        DecElementsSize();
    }
    public void PrintList(){
        Node currentNode = this.head;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.getNextNode() != null){
                currentNode = currentNode.getNextNode();
                System.out.println("Object's Index's:" + index);
                System.out.println("Object's Value's:" + currentNode.getVal());
                index++;
            }
        }
    }
    public void Reverse(){

    }
}
