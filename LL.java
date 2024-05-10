import java.util.*;
class Node{
    Object data;
    Node next;
    Node(Object data){
        this.data=data;
        this.next=null;
    }
}
class LinkedList{
    Node Head;
    LinkedList(){
        Head=null;
    }
    void insertAtHead(Object data){
        if(Head==null){
            Head=new Node(data);
            return;
        }
        Node node=new Node(data);
        node.next=Head;
        Head=node;
    }
    void removeFromHead(){
        Node temp=Head;
        Head=temp.next;
        temp.next=null;
        temp.data=null;
    }
    void insertAtTail(Object data){
        Node temp=Head;
        while (true) {
            if(temp.next==null){
                temp.next=new Node(data);
                return;
            }
            temp=temp.next;
        }
    }


}

public class LL {
    public static void main(String[] args) {
        LinkedList LL=new LinkedList();
        LL.insertAtHead(1);
        LL.insertAtHead(2);
        LL.insertAtHead(3);
        LL.insertAtHead(4);
        LL.insertAtTail(5);
        Node LLptr=LL.Head;
        while(LLptr!=null){
            System.out.println(LLptr.data);
            LLptr=LLptr.next;
        }
        LL.removeFromHead();
        Node LLptr1=LL.Head;
        while(LLptr1!=null){
            System.out.println(LLptr1.data);
            LLptr1=LLptr1.next;
        }

    }
}
