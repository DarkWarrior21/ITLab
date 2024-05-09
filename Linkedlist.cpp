#include<bits/stdc++.h>
using namespace std;

template <typename T>
class node{
  public:
  T data;
  node* next;

  node(int val){
    data = val;
    next = NULL;
  }

};

class Linked_List{
  public:
//-------------------------------------------------------------------Lab02--------------------------------------------------------------------
  void insertAtLast(node<int>* &head , int val){
    node<int>* n = new node<int>(val);
    if(head==NULL){
      head = n;
      return;
    }
    node<int>* temp=head;
    while(temp->next!=NULL){
      temp=temp->next;
    }
    temp->next=n;
  } 
  void printList(node<int>* head){
    node<int>* temp = head;
    while(temp!=NULL){
      cout<<temp->data<<" ";
      temp=temp->next;
    }
  }
  void Sorting(node<int>* &head){
    int swapped;
    node<int>* temp;
    node<int>* last = NULL;
    
    // If the list is empty or has only one node, it's already sorted
    if (head == NULL || head->next == NULL)
        return;
    
    while (swapped){
        swapped = 0;
        temp = head;
        while (temp->next != last) {
            if (temp->data > temp->next->data) {
                swap(temp->data, temp->next->data);
                swapped = 1;
            }
            temp = temp->next;
        }
        last = temp;
    } 
}
  void Middle(node<int>* head){
    node<int>* temp = head;
    int count =0;
    while(temp->next!=NULL){
      count++;
      temp=temp->next;
    }
    int n = count/2;
    node<int>* hell = head;
    for(int i=0 ; i<n ; ++i){
      hell=hell->next;
    }
    cout<<hell->data<<endl;
  }
  

  //-----------------------------------------------------------------Lab03-------------------------------------------------------------------
  void deleteLastvalue(node<int>* &head){
    if(head == NULL)
        return;
    if(head->next == NULL){
        delete head;
        head = NULL;
        return;
    }
    node<int>* temp = head;
    while(temp->next->next != NULL){
        temp = temp->next;
    }
    delete temp->next;
    temp->next = NULL;
  }
  void middleViaHareTortoise(node<int>* head){
    node<int>* slow = head;
    node<int>* fast = head;

    while(fast->next!=NULL && fast->next->next!=NULL){
      fast = fast->next->next;
      slow = slow->next;
    }

    cout<<slow->data<<endl;
  }
  node<int>* Reverse(node<int>* head) {
    if (head == NULL || head->next == NULL) {
        return head;
    }
    node<int>* prev = NULL;
    node<int>* curr = head;
    node<int>* next = NULL;

    while (curr != nullptr) {
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }

    return prev;
  }

};


int main(){
Linked_List list;
  node<int>* head=NULL;
  int t;
  cout<<"How many elements do you want? : ";
  cin>>t;

  for(int i=0 ; i<t ; ++i){
    int x;
    cout<<"Element "<<i+1<<":";
    cin>>x;
    list.insertAtLast(head,x);
  }
  cout<<"Your New List: "<<endl;
  list.printList(head);

  cout<<endl<<"The middle term is: ";
  list.middleViaHareTortoise(head);

  cout<<"After Sorting value:"<<endl;
  list.Sorting(head);
  list.printList(head);

  cout<<endl<<"After deleting a value:"<<endl;
  list.deleteLastvalue(head);
  list.printList(head);
  
  cout<<"After Reversing: "<<endl;
  head = list.Reverse(head);
  list.printList(head);
}