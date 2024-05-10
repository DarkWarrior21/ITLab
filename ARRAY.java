import java.util.*;

class Array_List{
    private  Object[] arr;
    int num=0;
    Array_List(){
        arr=new Object[5];
    }
    Object getindex(int i){ //O(1)
        return arr[i];
    }
    void clearall(){//O(n)
        num=0;
        for(int i=0;i<arr.length;i++){
            arr[i]=null;
        }
    }
    void removeithindex(int y){//O(2*n)
        Object[] arr1= new Object[num-1];
        for(int i=0;i<y;i++){
            arr1[i]=arr[i];
    }
    for(int i=y;i<arr1.length;i++){
        arr1[i]=arr[i+1];
    }
    arr=new Object[arr1.length];
    for(int i=0;i<arr.length;i++){
        arr[i]=arr1[i];
    }
    num--;
    return;
}
    int checkArraySize(){//O(1)
        return num;
    }
    void removeLasttIndex(){//O(2*n)
        Object[] arr1= new Object[num-1];
        for(int i=0;i<arr1.length;i++){
            arr1[i]=arr[i];
        }
        arr=new Object[arr1.length];
            for(int i=0;i<arr1.length;i++){
                arr[i]=arr1[i];}
                num--;
                return;
        
        }
    void removeFirstIndex(){//O(2*N)
        Object[] arr1= new Object[num-1];
        for(int i=0;i<arr1.length;i++){
            arr1[i]=arr[i+1];
        }

            for(int i=0;i<arr1.length;i++){
                arr[i]=arr1[i];}
                num--;
                return;
        }
    void addithindex(Object x,int y){//O(2*N)
        Object[] arr1= new Object[num+1];
        for(int i=0;i<y;i++){
            arr1[i]=arr[i];
    }
    arr1[y]=x;
    for(int i=y+1;i<arr1.length;i++){
        arr1[i]=arr[i-1];
    }
    arr=new Object[arr.length+1];
    for(int i=0;i<arr.length;i++){
        arr[i]=arr1[i];
    }
    num++;
    return;
}
    void increaseArraysize(Object[] arr){//O(2*N)
        Object[] arr1= new Object[2*arr.length];
        for(int i=0;i<num;i++){
            arr1[i]=arr[i];
        }
        arr= new Object[2*arr.length];
        for(int i=0;i<num;i++){
            arr[i]=arr1[i];}
            return;
    }
    void addLastIndex(Object x){//O(2*N) or O(1)
        if(num==arr.length){
            increaseArraysize(arr);
        }
        arr[num]=x;
        num++;
        return;
    }
    void addFirstIndex(Object x){//O(2*N)
    Object[] arr1= new Object[num+1];
    arr1[0]=x;
    for(int i=0;i<num;i++){
        arr1[i+1]=arr[i];
    }
    num++;
    arr= new Object[num];
        for(int i=0;i<arr1.length;i++){
            arr[i]=arr1[i];}
            return;
    }
}
public class ARRAY{
    public static void main(String[] args) {
        Array_List List= new Array_List();
        List.addLastIndex(6.1);
        System.out.println("Number added at last index:"+List.getindex(0));
        List.addFirstIndex(5.2);
        List.addFirstIndex(4.3);
        List.addFirstIndex("Ayush");
        List.addFirstIndex(2);
        List.addFirstIndex(1.6);
        System.out.println("Number added at first index:"+List.getindex(0));
        for(int i=0;i<(List.num);i++){
            System.out.println(List.getindex(i));
        }
        List.removeFirstIndex();
        System.out.println("Size of array after addition:"+List.checkArraySize());
        List.removeLasttIndex();
        System.out.println("Size of array after deletion:"+List.checkArraySize());
        for(int i=0;i<(List.num);i++){
            System.out.println(List.getindex(i));
        }
        List.addithindex(2.2,1);
        List.clearall();
        System.out.println("After this array is cleared");
        for(int i=0;i<(List.num);i++){
            System.out.println(List.getindex(i));
        }
        System.out.println("Array is cleared");
        System.out.println(List.checkArraySize());
        System.out.println(List.getindex(1));
        
    }
}