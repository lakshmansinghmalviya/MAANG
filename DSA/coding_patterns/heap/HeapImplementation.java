// https://takeuforward.org/plus/dsa/problems/heaps-theory

package coding_patterns.heap;

//left child is 2*i+1;  or 2*i
//right child is 2*i+2;  or 2*i+1
// parent of any node/element is i/2 or ceil(i/2)-1

class Heap {
    int arr[];
    int size;
    // when the size reached to the arr.length then we do copy the elements and move
    // further

    Heap() {
        arr = new int[100];
        size = 0;
    }

    // implemented max heap
    void insert(int value) {
        size = size + 1;
        int index = size;
        arr[index] = value;

        while (index > 1) {
            int parent = (index / 2);

            if (arr[parent] <= arr[index]) {
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            } else
                break;
            index = parent;
        }
    }

    void insertMinHeap(int value) {

        size = size + 1;
        int index = size;
        arr[index] = value;

        while (index > 1) {
            int parent = (index / 2);

            if (arr[parent] > arr[index]) {
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            } else
                break;
            index = parent;
        }
    }

    void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }
}

public class HeapImplementation {

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insertMinHeap(55);
        heap.insertMinHeap(20);
        heap.insertMinHeap(23);
        heap.insertMinHeap(70);
        heap.insertMinHeap(30);
        heap.insertMinHeap(20);
        heap.print();
    }
}
