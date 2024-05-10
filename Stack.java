class Stack {
    private int top;
    private Object[] arr;

    Stack() {
        top = -1;
        arr = new Object[10];
    }

    void increaseSize() {
        Object[] newArr = new Object[2 * arr.length];
        for (int i = 0; i <= top; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    void push(Object data) {
        if (top + 1 == arr.length){
            increaseSize();
        }
        arr[++top] = data;
    }

    Object peek() {
        return arr[top];
    }

    Object pop() {
        Object temp = arr[top];
        arr[top--] = null;
        return temp;
    }

    boolean isEmpty() {
        if (top == -1)
            return true;
        return false;
    }

    int size() {
        return top + 1;
    }

    void printStack() {
        System.out.println("The Stack is: ");
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}


public class STACK {
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(5);
        st.push(3);
        st.push(0);
        st.push(1);
        st.push(2);
        st.push(5);
        st.push(4);
        st.push(3);
        st.push(0);
        st.push(1);
        st.push(2);
        st.push(5);
        st.printStack();
        System.out.println("Element popped: " + st.pop());
        System.out.println("Element popped: " + st.pop());
        System.out.println("Element at top: " + st.peek());
        st.printStack();
    
    
}}
