#include <bits/stdc++.h>
using namespace std;

class Stack {
private:
    int top;
    int capacity;
    int* arr;

    void increaseSize() {
        int* newArr = new int[2 * capacity];
        for (int i = 0; i <= top; i++) {
            newArr[i] = arr[i];
        }
        capacity *= 2;
        delete[] arr;
        arr = newArr;
    }

public:
    Stack() {
        top = -1;
        capacity = 10;
        arr = new int[capacity];
    }
    void pushal(int data) {
        if (top + 1 == capacity) {
            increaseSize();
        }
        arr[++top] = data;
    }
    int peekal() {
        return arr[top];
    }
    int popal() {
        int temp = arr[top];
        arr[top--] = 0;
        return temp;
    }
    bool isEmptyal() {
        return (top == -1);
    }
    int sizeal() {
        return top + 1;
    }

    void printStackal() {
        cout << "The Stack is: ";
        for (int i = 0; i <= top; i++) {
            cout << arr[i] << " ";
        }
        cout << endl;
    }

    ~Stack() {
        delete[] arr;
    }
};

int main() {
    Stack st;

    int t;
    cout<<"How many elements do you want? : ";
    cin>>t;

    for(int i=0 ; i<t ; ++i){
        int x;
        cout<<"Element "<<i+1<<":";
        cin>>x;
        st.pushal(x);
    }
    
    st.printStackal();
    cout << "Element popped: " << st.popal() << endl;
    cout << "Element popped: " << st.popal() << endl;
    cout << "Element at top: " << st.peekal() <<endl;
    st.printStackal();

    return 0;
}
