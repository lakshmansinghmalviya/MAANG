// https://takeuforward.org/plus/dsa/problems/heaps-theory

package coding_patterns.heap;

import java.util.Arrays;

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
    void offer(int value) {
        size = size + 1;
        int index = size;
        arr[index] = value;

        while (index > 1) {
            int parent = (index / 2);

            if (arr[parent] <= arr[index]) {
                swap(arr, parent, index);
            } else
                break;
            index = parent;
        }
    }

    void insertMinoffer(int value) {

        size = size + 1;
        int index = size;
        arr[index] = value;

        while (index > 1) {
            int parent = (index / 2);

            if (arr[parent] > arr[index]) {
                swap(arr, parent, index);
            } else
                break;
            index = parent;
        }
    }

    int pollMaxHeap() {
        // remove the first or root put the last at the root and
        // place the root at its correct place
        if (size <= 0)
            return -1;

        int element = arr[1];

        arr[1] = arr[size];
        size = size - 1;

        int index = 1;
        while (index * 2 < size) {
            int leftIndex = 2 * index;
            int rightIndex = 2 * index + 1;

            if (leftIndex < size && arr[leftIndex] > arr[index]) {
                swap(arr, leftIndex, index);
                index = leftIndex;
            } else if (rightIndex < size && arr[rightIndex] > arr[index]) {
                swap(arr, rightIndex, index);
                index = rightIndex;
            } else
                break;
        }
        return element;
    }

    void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void heapify(int arr[], int n, int index) {
        int largest = index;
        int left = index * 2;
        int right = index * 2 + 1;

        if (left < n && arr[largest] < arr[left]) {
            largest = left;
        }
        if (right < n && arr[largest] < arr[right]) {
            largest = right;
        }
        if (largest != index) {
            swap(arr, index, largest);
            heapify(arr, n, largest);
        }
    }

    void makeArrayHeapify(int arr[], int tillIndex) {
        // calculate internal nodes
        // (n/2+1)->n; leaf node node
        // means 1- n/2+1 these are internal nodes
        int n = arr.length;
        System.out.println(Arrays.toString(arr));
        for (int i = (n / 2); i >= tillIndex; i--) {
            heapify(arr, n, i);
        }
        System.out.println(Arrays.toString(arr));
    }
}

public class HeapImplementation {

    public static void main(String[] args) {
        Heap heap = new Heap();
        // heap.insertMinoffer(55);
        // heap.insertMinoffer(20);
        // heap.insertMinoffer(23);
        // heap.insertMinoffer(70);
        // heap.insertMinoffer(30);
        // heap.insertMinoffer(20); // this is for min heap

        heap.offer(55);
        heap.offer(20);
        heap.offer(23);
        heap.offer(70);
        heap.offer(30);
        heap.offer(50);
        heap.print();
        heap.pollMaxHeap();
        heap.pollMaxHeap();
        heap.pollMaxHeap();
        heap.print();

        System.out.println("Heapify algo ");
        int arr[] = { -1, 54, 53, 55, 20, 30, 70, 80 };
        heap.makeArrayHeapify(arr, 1);
    }
}