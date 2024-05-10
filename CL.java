import java.util.*;

class Node {
    Object data;
    Node next;

    Node(Object data) {
        this.data = data;
        this.next = null;
    }

    Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class CircularLinkedList {
    Node Head;

    CircularLinkedList() {
        Head = null;
    }

    void reverseLinkedList() {
        Node temp = Head;
        Node prev = null;
        do {
            Node face = temp.next;
            temp.next = prev;
            prev = temp;
            temp = face;
        } while (temp != Head);
        Head = prev;
        return;
    }

    void insertAtHead(Object data) {
        if (Head == null) {
            Head = new Node(data);
            Head.next = Head;
            return;
        }
        Node node = new Node(data, Head);
        Node temp = Head;
        while (temp.next != Head) {
            temp = temp.next;
        }
        temp.next = node;
        Head = node;
    }

    void insertAtIthIndex(Object data, int index) {
        if (index == 0) {
            insertAtHead(data);
            return;
        }
        Node temp = Head;
        for (int i = 0; i < (index - 1); i++) {
            temp = temp.next;
        }
        temp.next = new Node(data, temp.next);
    }

    void insertAtTail(Object data) {
        if (Head == null) {
            Head = new Node(data);
            Head.next = Head;
            return;
        }
        Node temp = Head;
        while (temp.next != Head) {
            temp = temp.next;
        }
        temp.next = new Node(data, Head);
    }

    void removeHead() {
        if (Head == null)
            return;
        Node temp = Head;
        while (temp.next != Head) {
            temp = temp.next;
        }
        temp.next = Head.next;
        Head = Head.next;
    }

    void removeTail() {
        if (Head == null)
            return;
        Node temp = Head;
        while (temp.next.next != Head) {
            temp = temp.next;
        }
        temp.next = Head;
    }

    void removeAtIthIndex(int index) {
        if (index == 0) {
            removeHead();
            return;
        }
        Node temp = Head;
        for (int i = 0; i < (index - 1); i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    Object mid() {
        Node slow = Head;
        Node fast = Head;
        while (fast.next != Head && fast.next.next != Head) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    void printCircularList() {
        if (Head == null)
            return;
        Node temp = Head;
        do {
            System.out.println(temp.data);
            temp = temp.next;
        } while (temp != Head);
    }
}

public class CL {
    public static void main(String[] args) {
        CircularLinkedList CLL = new CircularLinkedList();
        CLL.insertAtHead(1);
        CLL.insertAtHead(2);
        CLL.insertAtIthIndex(3, 2);
        CLL.insertAtTail(4);
        System.out.println("Original Circular List:");
        CLL.printCircularList();

        System.out.println("After removing Head and Tail:");
        CLL.removeHead();
        CLL.removeTail();
        CLL.printCircularList();

        System.out.println("After removing first index:");
        CLL.removeAtIthIndex(1);
        CLL.printCircularList();
    }
}
