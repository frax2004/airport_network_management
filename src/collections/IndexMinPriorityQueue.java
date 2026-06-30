package collections;

import java.util.Arrays;
import java.util.NoSuchElementException;


public class IndexMinPriorityQueue<Key extends Comparable<Key>> {
  private int capacity;
  private int count = 0;
  private int[] heap;
  private int[] heapToIndex;
  private Key[] keys;

  @SuppressWarnings("unchecked")
  public IndexMinPriorityQueue(int capacity) {
    if(capacity < 0) throw new IllegalArgumentException();
    this.capacity = capacity;
    this.count = 0;
    this.keys = (Key[])new Comparable[capacity + 1];
    this.heap = new int[capacity + 1];
    this.heapToIndex = new int[capacity + 1];
    Arrays.fill(this.heapToIndex, -1);
  }

  public boolean isEmpty() {
    return this.count == 0;
  }

  public boolean contains(int i) {
    this.assertValidIndex(i);
    return this.heapToIndex[i] != -1;
  }

  public int size() {
    return this.count;
  }

  public void insert(int i, Key key) {
    this.assertValidIndex(i);
    if(this.contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
    this.count++;
    this.heapToIndex[i] = this.count;
    this.heap[this.count] = i;
    this.keys[i] = key;
    this.bottomUpHeapify(this.count);
  }

  public int extract() {
    if(this.count == 0) throw new NoSuchElementException("Priority queue underflow");
    int min = this.heap[1];
    swap(1, this.count--);
    topDownHeapify(1);
    assert min == this.heap[this.count+1];
    this.heapToIndex[min] = -1;
    this.keys[min] = null;
    this.heap[this.count+1] = -1;
    return min;
  }

  public void decrease(int i, Key key) {
    this.assertValidIndex(i);
    if(!this.contains(i)) throw new NoSuchElementException("index is not in the priority queue");
    if(this.keys[i].compareTo(key) == 0)
      throw new IllegalArgumentException("Calling decrease() with a key equal to the key in the priority queue");
    if(this.keys[i].compareTo(key) < 0)
      throw new IllegalArgumentException("Calling decrease() with a key strictly greater than the key in the priority queue");
    this.keys[i] = key;
    this.bottomUpHeapify(this.heapToIndex[i]);
  }

  private void assertValidIndex(int i) {
    if(i < 0 || i >= this.capacity) throw new IndexOutOfBoundsException(i);
  }

  private boolean greater(int i, int j) {
    return this.keys[this.heap[i]].compareTo(this.keys[this.heap[j]]) > 0;
  }

  private void swap(int i, int j) {
    int tmp = this.heap[i];
    this.heap[i] = this.heap[j];
    this.heap[j] = tmp;
    this.heapToIndex[this.heap[i]] = i;
    this.heapToIndex[this.heap[j]] = j;
  }

  private void bottomUpHeapify(int k) {
    while (k > 1 && this.greater(k/2, k)) {
      this.swap(k, k/2);
      k = k/2;
    }
  }

  private void topDownHeapify(int k) {
    while (2*k <= this.count) {
      int j = 2*k;
      if(j < this.count && this.greater(j, j+1)) j++;
      if(!this.greater(k, j)) break;
      this.swap(k, j);
      k = j;
    }
  }

}