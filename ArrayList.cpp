#include <iostream>
#include <vector>
using namespace std;
template<class T>
class Array_List {
private:
    vector<T> arr;
    int num;
public:
    Array_List() : num(0) {
        arr.resize(5);
    }

    T getindex(int i) { //O(1)
        return arr[i];
    }

    void clearall() {//O(n)
        num = 0;
        arr.clear();
        arr.resize(5);
    }

    void removeithindex(int y) {//O(2*n)
        vector<T> arr1(num - 1);
        for (int i = 0; i < y; i++) {
            arr1[i] = arr[i];
        }
        for (int i = y; i < arr1.size(); i++) {
            arr1[i] = arr[i + 1];
        }
        arr = arr1;
        num--;
    }

    int checkArraySize() {//O(1)
        return num;
    }

    void removeLasttIndex() {//O(2*n)
        vector<T> arr1(num - 1);
        for (int i = 0; i < arr1.size(); i++) {
            arr1[i] = arr[i];
        }
        arr = arr1;
        num--;
    }

    void removeFirstIndex() {//O(2*N)
        vector<T> arr1(num - 1);
        for (int i = 0; i < arr1.size(); i++) {
            arr1[i] = arr[i + 1];
        }
        arr = arr1;
        num--;
    }

    void addithindex(T x, int y) {//O(2*N)
        vector<T> arr1(num + 1);
        for (int i = 0; i < y; i++) {
            arr1[i] = arr[i];
        }
        arr1[y] = x;
        for (int i = y + 1; i < arr1.size(); i++) {
            arr1[i] = arr[i - 1];
        }
        arr = arr1;
        num++;
    }

    void increaseArraysize(std::vector<T>& arr) {//O(2*N)
        vector<T> arr1(2 * arr.size());
        for (int i = 0; i < num; i++) {
            arr1[i] = arr[i];
        }
        arr = arr1;
    }

    void addLastIndex(T x) {//O(2*N) or O(1)
        if (num == arr.size()) {
            increaseArraysize(arr);
        }
        arr[num] = x;
        num++;
    }

    void addFirstIndex(T x) {//O(2*N)
        vector<T> arr1(num + 1);
        arr1[0] = x;
        for (int i = 0; i < num; i++) {
            arr1[i + 1] = arr[i];
        }
        num++;
        arr = arr1;
    }
};

int main() {
    Array_List<int> List;
    List.addLastIndex(6);
    std::cout << "Number added at last index: " << List.getindex(0) << std::endl;
    List.addFirstIndex(5);
    List.addFirstIndex(4);
    List.addFirstIndex(3);
    List.addFirstIndex(2);
    List.addFirstIndex(1);
    std::cout << "Number added at first index: " << List.getindex(0) << std::endl;
    for (int i = 0; i < List.checkArraySize(); i++) {
        std::cout << List.getindex(i) << std::endl;
    }
    List.removeFirstIndex();
    std::cout << "Size of array after addition: " << List.checkArraySize() << std::endl;
    List.removeLasttIndex();
    std::cout << "Size of array after deletion: " << List.checkArraySize() << std::endl;
    for (int i = 0; i < List.checkArraySize(); i++) {
        std::cout << List.getindex(i) << std::endl;
    }
    List.addithindex(2, 1);
    List.clearall();
    std::cout << "After this array is cleared" << std::endl;
    for (int i = 0; i < List.checkArraySize(); i++) {
        std::cout << List.getindex(i) << std::endl;
    }
    std::cout << "Array is cleared" << std::endl;
    std::cout << List.checkArraySize() << std::endl;
    std::cout << List.getindex(1) << std::endl;

    return 0;
}
