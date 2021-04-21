package cs146project1;

import java.util.Collections;
import java.util.Vector;

public class HeapSort {

    public void heapSort(Vector<Customer> customers) {
        buildMaxHeap(customers);

        int heapSize = customers.size();
        for (int i = customers.size() - 1; i >= 1; i--) {
            Collections.swap(customers, 0, i);
            heapSize = heapSize - 1;
            maxHeapify(customers, 0, heapSize);
        }

    }

    private void buildMaxHeap(Vector<Customer> customers) {
        int heapSize = customers.size();
        for (int i = customers.size() / 2 - 1; i >= 0; i--) {
            maxHeapify(customers, i, heapSize);
        }


    }


    private void maxHeapify(Vector<Customer> customers, int index, int heapSize) {
        int leftIndex = left(index);
        int rightIndex = right(index);
        int largest;
        if (leftIndex < heapSize && customers.get(leftIndex).getTime() > customers.get(index).getTime()) {
            largest = leftIndex;
        } else {
            largest = index;
        }

        if (rightIndex < heapSize && customers.get(rightIndex).getTime() > customers.get(largest).getTime()) {
            largest = rightIndex;
        }

        if (largest != index) {
            Collections.swap(customers, index, largest);
            maxHeapify(customers, largest, heapSize);
        }
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private int right(int index) {
        return 2 * index + 2;
    }
}
