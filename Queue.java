class Queue{
    Array_List Q;
    Queue(){
        Q = new Array_List();
    }
    void push(Object data){
        Q.addLastIndex(data);
    }
    Object pop(){
        Object temp=Q.getindex(0);
        Q.removeFirstIndex();
        return temp;
    }
    Object peek(){
        return Q.getindex(0);
    }
    Boolean checkEmpty(){
        if(Q.checkArraySize()==0){
            return true;
        }
        else{
            return false;
        }
    }
    int checkSize(){
        return Q.checkArraySize();
    }
 }