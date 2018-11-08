/**************************************
 * Author: Noam Solan
 * ID: 204484703
 * Course: 83-459-01 (Software engineering)
 * Practice: 83-459-03 (Gil)
 **************************************/
package DS;

public class MyLinkedList {
    private Node head;
    private int elementsNum;

    //default constructor
    public MyLinkedList() {
        this.head = null;
        this.elementsNum = 1;
    }
    //getters and setters
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
    //incrementing num of elements in the list
    public void IncElementsSize(){
        this.elementsNum++;
    }
    //deceasing num of elements in the list
    public void DecElementsSize(){
        this.elementsNum--;
    }
    //adding node to the end of the list
    public void AddNode(Node n){
        Node currentNode = this.head;
        //new list
        if (currentNode == null){
            setHead(n);
            return;
        }
        //getting to the end of the list
        while (currentNode != null) {
            if (currentNode.getNextNode() != null){
                currentNode = currentNode.getNextNode();
            }
            //updating the last element
            else {
                currentNode.setNextNode(n);
                IncElementsSize();
                break;
            }
        }
    }
    //adding node with index
    public void AddNode(Node n, int index){
        Node currentNode = this.head;
        for (int i = 0 ; i < index-1 ; i++){
            //getting to the correct index
            currentNode = currentNode.getNextNode();
            //return if index is not correct
            if (currentNode == null) {
                System.out.println("Index do not exist");
                return;
            }
        }
        //set the new node in between the old nodes
        n.setNextNode(currentNode.getNextNode());
        currentNode.setNextNode(n);
        IncElementsSize();
    }
    //remove the last node in the list
    public void RemoveNode(){
        Node currentNode = null;
        Node prevNode = currentNode;
        currentNode = this.head;
        //if list is empty
        if (currentNode == null){
            System.out.println("List is empty");
            return;
        }
        //getting to the end of the list
        while (currentNode != null) {
            if (currentNode.getNextNode() != null){
                prevNode = currentNode;
                currentNode = currentNode.getNextNode();
            }
            //with help of prevNode, removing the last element
            else {
                prevNode.setNextNode(null);
                DecElementsSize();
                break;
            }
        }
    }
    //remove node with index
    public void RemoveNode(int index){
        Node currentNode = this.head;
        Node prevNode = null;
        //if list is empty
        if (currentNode == null){
            System.out.println("List is empty");
            return;
        }
        //getting to the correct index
        for (int i = 0 ; i < index ; i++){
            prevNode = currentNode;
            currentNode = currentNode.getNextNode();
            //return if index isn't correct
            if (currentNode == null) {
                System.out.println("Index do not exist");
                return;
            }
        }
        //cutting the index of the list and update the previous
        prevNode.setNextNode(currentNode.getNextNode());
        DecElementsSize();
    }
    //printing list
    public void PrintList(){
        Node currentNode = this.head;
        int index = 0;
        //if list is empty
        if (currentNode == null){
            System.out.println("List is empty");
            return;
        }
        //looping though the elements
        while (currentNode != null) {
            System.out.println("Index:" + index);
            System.out.println("Value:" + currentNode.getVal() + "\n");
            currentNode = currentNode.getNextNode();
            index++;
        }
    }
    //reversing the list
    public void Reverse(){
        Node currentNode = this.head;
        Node prevNode = null;
        Node nextNode;
        //if list is empty
        if (currentNode == null){
            System.out.println("List is empty");
            return;
        }
        //looping though all the elements
        while (currentNode != null){
            nextNode = currentNode.getNextNode();
            currentNode.setNextNode(prevNode);
            prevNode = currentNode;
            currentNode = nextNode;
        }
        this.setHead(prevNode);
    }
}
