import java.util.*;
class Node{
    Object data;
    Node next;
    Node prev;
    Node(Object data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
    Node(Object data,Node next,Node prev){
        this.data=data;
        this.next=next;
        this.prev=prev;
    }
}
class DoublyLinkedList{
    Node Head;
    DoublyLinkedList(){
        Head=null;
    }
    void deleteAtHead(){//O(1)
        Node temp=Head;
        Head=temp.next;
        temp.next=null;
        temp.data=null;
        Head.prev=null;
    }
    void insertAtHead(Object data){//O(1)
        if(Head==null){
            Head=new Node(data);
            return;
        }
        Node node=new Node(data);
        node.next=Head;
        Head.prev=node;
        Head=node;
    }
    void insertAtIthIndex(Object data, int index){//0(N)
        Node temp=Head;
        for(int i=0;i<(index-1);i++){
            temp=temp.next;
            System.out.println("inside loop");
        }
        temp.next= new Node(data,temp.next,temp);
        temp.next.next.prev=temp.next;
    }
    void insertAtTail(Object data){//0(N)
        Node temp=Head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=new Node(data,null,temp);
    }
    void deleteElement(Object data){//0(N)
        Node temp=Head;
        while(temp.data!=data){
            temp=temp.next;
        }
        temp.data=null;
        temp.next.prev=temp.prev;
        temp.prev.next=temp.next;
        temp.next=null;
    }
    void deleteAtTail(){//0(N)
        Node temp=Head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.prev.next=null;
        temp.prev=null;
    }
    void deleteAtIthIndex(int index){//0(N)
        Node temp=Head;
        for(int i=0;i<(index-1);i++){
            temp=temp.next;
        }
        temp.next.data=null;
        temp.next=temp.next.next;
        temp.next.next.prev=temp;
        
}}
class clNode{
    Object data;
    clNode next;
    clNode(Object data){
        this.data=data;
        this.next=null;
    }
    clNode(Object data, clNode next){
        this.data=data;
        this.next=next;
    }
}
class CircularList{
    int size;
    clNode head;
    CircularList(){
        head=null;
        size=0;
    }
    void insertAtIthIndex(Object data,int index){
        if(index==0){
            insertAtHead(data);
        }
        else{
            clNode temp=head;
            for(int i=0;i<size;i++){
                temp=temp.next;}
            clNode node= new clNode(data);
            node.next=temp.next;
            temp.next=node;
            size++;
            
        }
        
    }
    void insertAtHead(Object data){
        if(head==null){
            head=new clNode(data);
            head.next=head;
            size++;
            return;
        }
        else{
            clNode temp=head;
            clNode node= new clNode(data);
            node.next=head;
            while(temp.next!=head){
                temp=temp.next;
            }
            temp.next=node;
            head=node;    
            size++;       
        }
    }
    void deleteAtHead(){
        clNode temp=head;
        head=head.next;
        while(temp.next!=head){
            temp=temp.next;
        }
        temp.next=head;
        size--;

    }
    void deleteAtIthIndex(int index){
        if(index==0){
            deleteAtHead();
        }
        else{
            clNode temp=head;
            for(int i=0;i<size;i++){
                temp=temp.next;}
                temp.next=temp.next.next;
                size--;
        }
    }
}

public class DLL{
    public static void main(String[] args) {
    DoublyLinkedList DLL= new DoublyLinkedList();
    System.out.println("Doubly Linked List implementation:");
    DLL.insertAtHead(1);
    DLL.insertAtHead(2);
    DLL.insertAtHead(3);
    DLL.insertAtIthIndex(7, 1);
    DLL.insertAtHead(4);
    DLL.insertAtHead(5);
    DLL.insertAtHead(6);
    DLL.insertAtTail(8);
   
    System.out.println("Doubly Linked List after inserting elements:");
    Node ptr= DLL.Head;
    while ((ptr!=null)) {
        System.out.print(ptr.data+"->");
        ptr=ptr.next;
    }
    System.out.println(" ");
    DLL.deleteAtHead();
    DLL.deleteAtTail();
    System.out.println("Deleting element at Head and Tail:");
    Node ptr1= DLL.Head;
    while ((ptr1!=null)) {
        System.out.print(ptr1.data+"->");
        ptr1=ptr1.next;
    } 
    System.out.println(" ");
    DLL.deleteAtIthIndex(1);
    System.out.println("Deleting element at index 1:");
    Node ptr2= DLL.Head;
    while ((ptr2!=null)) {
        System.out.print(ptr2.data+"->");
        ptr2=ptr2.next;
    }

    System.out.println(" ");
    System.out.println("Circular List implementation:");
    CircularList CL= new CircularList();
    CL.insertAtHead(1);
    CL.insertAtHead(2);
    CL.insertAtHead(3);
    clNode ptr3=CL.head;
    for(int i=0;i<CL.size;i++) {
        System.out.print(ptr3.data+"->");
        ptr3=ptr3.next;
    }
    
    CL.insertAtIthIndex(4,0 );
    System.out.println(" ");
    System.out.println("Adding at index 0:");
    clNode ptr4=CL.head;
    for(int i=0;i<CL.size;i++) {
        System.out.print(ptr4.data+"->");
        ptr4=ptr4.next;
    }
    CL.deleteAtIthIndex(0);
    System.out.println(" ");
    System.out.println("Deleting at INDEX 0");`
    clNode ptr5=CL.head;
    for(int i=0;i<CL.size;i++) {
        System.out.print(ptr5.data+"->");
        ptr5=ptr5.next;
    }
    }
}
