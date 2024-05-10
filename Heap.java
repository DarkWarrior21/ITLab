import java.util.*;
class MaxHeap{
    int maxsize;
    int[] Heap;
    int size;
    MaxHeap(int maxsize){
        this.maxsize=maxsize;
        this.size=0;
        Heap=new int[this.maxsize];
    }
    int parent(int pos){
        return (pos -1)/2;}

    int leftChild(int pos){
       return (2 * pos) + 1; }
    
    int rightChild(int pos){
       return (2 * pos) + 2;}

    boolean lastNode(int pos)
       {
           if (pos > (size / 2) && pos <= size) {
               return true;
           }
           return false;
       }

    void swap(int pos1, int pos2)
    {
        int temp;
        temp = Heap[pos1];
        Heap[pos1] = Heap[pos2];
        Heap[pos2] = temp;
    }

    void maxHeapify(int pos){
        if (lastNode(pos)) {
            return;
        }
        if(Heap[pos]<Heap[leftChild(pos)] ||Heap[pos]<Heap[rightChild(pos)] ){

            if (Heap[leftChild(pos)]  > Heap[rightChild(pos)]) {
                swap(pos,leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }


    void insert(int item){
        int i;
        Heap[size]=item;
        i=size;
        while(Heap[i]>Heap[parent(i)]){
            swap(i,parent(i));
            i=parent(i);
        }
        size++;
    }

  void delete(int pos){ 
    int[] newarr=new int[maxsize-1];
        for(int i=0;i<pos;i++){
            newarr[i]=Heap[i];
        }
        for(int j=pos;j<size;j++){
            newarr[j]=Heap[j+1];
        }
        Heap=new int[newarr.length];
        for(int i=0;i<size;i++){
            Heap[i]=newarr[i];
        }
  }
    int extractMax(){
        int a=Heap[0];
        Heap[0]=Heap[--size];
        maxHeapify(0);
        return a;
    }
}
public class CS162_202351016_LAB8 {
    public static void main(String[] args){
        MaxHeap arr = new MaxHeap(5);
        arr.insert(3);
        arr.insert(5);
        arr.insert(4);
        arr.insert(7);
        arr.insert(8);
        for(int i=0;i<5;i++){
            System.out.print(arr.Heap[i] +" ");
        }
        int max=arr.extractMax();
        System.out.println("");
        arr.delete(2);
        System.out.println("The max element in the heap is "+max);
        for(int i=0;i<4;i++){
            System.out.print(arr.Heap[i] +" ");
        }
    }
    
}



import java.util.*;

class MinHeap {
    int maxsize;
    int[] Heap;
    int size;

    MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize];
    }

    int parent(int pos) {
        return (pos - 1) / 2;
    }

    int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    boolean lastNode(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    void swap(int pos1, int pos2) {
        int temp;
        temp = Heap[pos1];
        Heap[pos1] = Heap[pos2];
        Heap[pos2] = temp;
    }

    void minHeapify(int pos) {
        if (lastNode(pos)) {
            return;
        }
        if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {

            if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                minHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                minHeapify(rightChild(pos));
            }
        }
    }

    void insert(int item) {
        int i;
        Heap[size] = item;
        i = size;
        while (Heap[i] < Heap[parent(i)]) {
            swap(i, parent(i));
            i = parent(i);
        }
        size++;
    }

    void delete(int pos) {
        int[] newarr = new int[maxsize - 1];
        for (int i = 0; i < pos; i++) {
            newarr[i] = Heap[i];
        }
        for (int j = pos; j < size; j++) {
            newarr[j] = Heap[j + 1];
        }
        Heap = new int[newarr.length];
        for (int i = 0; i < size; i++) {
            Heap[i] = newarr[i];
        }
    }

    int extractMin() {
        int a = Heap[0];
        Heap[0] = Heap[--size];
        minHeapify(0);
        return a;
    }
}

public class Main {
    public static void main(String[] args) {
        MinHeap arr = new MinHeap(5);
        arr.insert(3);
        arr.insert(5);
        arr.insert(4);
        arr.insert(7);
        arr.insert(8);
        for (int i = 0; i < 5; i++) {
            System.out.print(arr.Heap[i] + " ");
        }
        int min = arr.extractMin();
        System.out.println("");
        arr.delete(2);
        System.out.println("The min element in the heap is " + min);
        for (int i = 0; i < 4; i++) {
            System.out.print(arr.Heap[i] + " ");
        }
    }
}
