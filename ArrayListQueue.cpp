#include <bits/stdc++.h>
using namespace std;

class Queue {
private:
    int frontIdx;
    int rearIdx;
    int capacity;
    int* arr;

    void increaseSize() {
        int* newArr = new int[2 * capacity];
        for (int i = frontIdx; i <= rearIdx; i++) {
            newArr[i] = arr[i];
        }
        capacity *= 2;
        delete[] arr;
        arr = newArr;
    }

public:
    Queue() {
        frontIdx = 0;
        rearIdx = -1;
        capacity = 10;
        arr = new int[capacity];
    }
    void enqueue(int data) {
        if (rearIdx + 1 == capacity) {
            increaseSize();
        }
        arr[++rearIdx] = data;
    }
    int peek() {
        return arr[frontIdx];
    }
    int dequeue() {
        if (isEmpty()) {
            cout << "Queue is empty." << endl;
            return INT_MIN;
        }
        int temp = arr[frontIdx++];
        return temp;
    }
    bool isEmpty() {
        return frontIdx > rearIdx;
    }
    int size() {
        return rearIdx - frontIdx + 1;
    }

    void printQueue() {
        cout << "The Queue is: ";
        for (int i = frontIdx; i <= rearIdx; i++) {
            cout << arr[i] << " ";
        }
        cout << endl;
    }

};

int main() {
    Queue q;

    int t;
    cout << "How many elements do you want? : ";
    cin >> t;

    for (int i = 0; i < t; ++i) {
        int x;
        cout << "Element " << i + 1 << ": ";
        cin >> x;
        q.enqueue(x);
    }

    q.printQueue();
    cout << "Element dequeued: " << q.dequeue() << endl;
    cout << "Element dequeued: " << q.dequeue() << endl;
    cout << "Element at front: " << q.peek() << endl;
    q.printQueue();

    return 0;
}
