package cs146project1;

import java.util.Collections;
import java.util.Vector;

public class PriorityQueue {

    Customer[] heapPriorityQueue = new Customer[100];
    private int heapSize = -1;


    public Customer heapExtractMax() throws Exception {
        if (heapSize < 0) {
            throw new Exception("Heap underflow error");

        }

        Customer max = heapPriorityQueue[0];
        swap(0, heapSize);
        heapSize = heapSize - 1;
        maxHeapify( 0, heapSize);

        return max;
    }

    private void swap(int indexA, int indexB) {
        Customer temp = heapPriorityQueue[indexA];
        heapPriorityQueue[indexA] = heapPriorityQueue[indexB];
        heapPriorityQueue[indexB] = temp;

    }

    public void heapIncreaseKey( int index, Customer key)
            throws Exception {

        if (key.getTotalWaitingScore() < heapPriorityQueue[index].getTotalWaitingScore()) {
            throw new Exception("new key is smaller than current key");
        }
        heapPriorityQueue[index] =  key;

        int parentIndex = parent(index);
        while (index > 0 &&
                heapPriorityQueue[parentIndex].getTotalWaitingScore()
                        < heapPriorityQueue[index].getTotalWaitingScore()) {



            swap( index, parentIndex);
            index = parentIndex;
            parentIndex = parent(index);
        }
    }


    public void maxHeapInsert(  Customer key) throws Exception{
        heapSize = heapSize + 1;
        heapPriorityQueue[heapSize] =  key;
        heapIncreaseKey( heapSize, key);
    }

    private void maxHeapify( int index, int heapSize) {
        int leftIndex = left(index);
        int rightIndex = right(index);
        int largest;
        if (leftIndex < heapSize && heapPriorityQueue[leftIndex].getTotalWaitingScore()
                > heapPriorityQueue[index].getTotalWaitingScore()) {
            largest = leftIndex;
        } else {
            largest = index;
        }

        if (rightIndex < heapSize && heapPriorityQueue[rightIndex].getTotalWaitingScore() >
                heapPriorityQueue[largest].getTotalWaitingScore()) {
            largest = rightIndex;
        }

        if (largest != index) {
            swap( index, largest);
            maxHeapify(largest, heapSize);
        }
    }

    public int findIndexOfCustomer(String name) {
        for(int i=0; i< heapPriorityQueue.length; i++) {
            if(heapPriorityQueue[i].getName().equalsIgnoreCase(name)) {
                return i;
            }
        }

        return -1;
    }

    public Customer findCustomer(String name) {
        for(int i=0; i< heapPriorityQueue.length; i++) {
            if(heapPriorityQueue[i].getName().equalsIgnoreCase(name)) {
                return heapPriorityQueue[i];
            }
        }

        return null;
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private int right(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return index / 2;
    }


    public void print() {
        System.out.println("Customer Priority Queue");
        for (int i= 0; i< heapPriorityQueue.length; i++) {
            if(heapPriorityQueue[i] != null)
            System.out.println(heapPriorityQueue[i]);
        }
    }
}
