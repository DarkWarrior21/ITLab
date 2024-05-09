#include<bits/stdc++.h>
using namespace std;

template <typename T>
class node{
public:
    T data;
    node* next;

    node(T val){
        data = val;
        next = NULL;
    }
};

template <typename T>
class Stack_LL{
public:

    void push(node<T>* &head , T val){
        node<T>* n = new node<T>(val);
        if(head==NULL){
            head = n;
            return;
        }
        node<T>* temp=head;
        while(temp->next!=NULL){
            temp=temp->next;
        }
        temp->next=n;
    }
    void peek(node<T>* head){
        if(isempty(head)) 
            cout<<"NULL"<<endl;
        else{
            node<T>* temp = head;
            while(temp->next!=NULL){
                temp=temp->next;
            }
            cout<<(T)temp->data<<" ";
            cout<<endl;
        }
    }
    void pop(node<T>* &head){
        if(head == NULL)
            return;
        if(head->next == NULL){
            delete head;
            head = NULL;
            return;
        }
        node<T>* temp = head;
        while(temp->next->next != NULL){
            temp = temp->next;
        }
        delete temp->next;
        temp->next = NULL;
    }
    bool isempty(node<T>* head){
        if(head == NULL){
            return true;
        }
        else{
            return false;
        }
    }
};

template <typename T>
void mainf(node<T>* head){
    Stack_LL<T> list;
    cout<<"What would you like to do with the stack:  0->POP ,1->PUSH, 2->PEEK, 3->CANCEL: ";
    int n;
    cin>>n;

    if(n==0){
        list.pop(head);
        cout<<"Done! The value was deleted.."<<endl;
        mainf(head);
    }
    else if(n==1){
        T val;
        cout<<"Value you want to add: ";
        cin>>val;
        list.push(head ,val);
        cout<<"Done! The value was added."<<endl;
        mainf(head);
    }
    else if(n==2){
        list.peek(head);
        mainf(head);
    }
    else{
        return;
    }
}

//==========================Data Type======================
#define s double
//==========================Data Type======================

int main(){

    Stack_LL<s> list;
    node<s>* head=NULL;
    int t;
    cout<<"How many elements do you want? : ";
    cin>>t;

    for(int i=0 ; i<t ; ++i){
        s x;
        cout<<"Element "<<i+1<<":";
        cin>>x;
        list.push(head,x);
    }

    mainf(head);
    return 0;
}
