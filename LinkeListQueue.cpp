#include <bits/stdc++.h>
using namespace std;

template <typename T>
class node
{
public:
  T data;
  node *next;

  node(T val)
  {
    data = val;
    next = NULL;
  }
};

template <typename T>
class LL_Queue
{
public:
  void insert(node<T> *&head, T val)
  {
    node<T> *n = new node<T>(val);
    if (head == NULL)
    {
      head = n;
      return;
    }
    node<T> *temp = head;
    while (temp->next != NULL)
    {
      temp = temp->next;
    }
    temp->next = n;
  }
  void printList(node<T> *head)
  {
    node<T> *temp = head;
    while (temp != NULL)
    {
      cout << temp->data << " ";
      temp = temp->next;
    }
  }
  void enqueue(node<T> *&head, T val)
  {
    insert(head, val); // Since insert function inserts at the end, it acts as enqueue for queue
  }
  void dequeue(node<T> *&head)
  {
    if (head == NULL)
    {
      cout << "Queue is empty." << endl;
      return;
    }
    node<T> *temp = head;
    head = head->next;
    delete temp;
  }
  T front(node<T> *head)
  {
    if (head == NULL)
    {
      cout << "Queue is empty." << endl;
      return T();
    }
    return head->data;
  }
  bool isEmpty(node<T> *head)
  {
    return head == NULL;
  }
};

template <typename T>
void mainf(node<T> *head)
{
  LL_Queue<T> list;
  cout << endl
       << "What would you like to do with the stack:  0->Dequeue ,1->enqueue, 2->Print, 3->CANCEL: ";
  int n;
  cin >> n;

  if (n == 0)
  {
    list.dequeue(head);
    cout << "Done! The value was deleted.." << endl;
    mainf(head);
  }
  else if (n == 1)
  {
    T val;
    cout << "Value you want to add: ";
    cin >> val;
    list.enqueue(head, val);
    cout << "Done! The value was added." << endl;
    mainf(head);
  }
  else if (n == 2)
  {
    list.printList(head);
    mainf(head);
  }
  else
  {
    return;
  }
}

//*!==========================--Data Type--======================
#define s double
//*!==========================--Data Type--======================

int main()
{
  LL_Queue<s> q;
  node<s> *head = NULL;
  //*TODO Isko LL_Queue me hi set krna haii
  cout << "How many elements: ";
  int t;
  cin >> t;

  for (int i = 0; i < t; ++i)
  {
    cout << "Element " << i + 1 << ": ";
    s n;
    cin >> n;
    q.insert(head, n);
  }

  mainf(head);
}