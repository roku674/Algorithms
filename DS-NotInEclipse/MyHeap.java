package inClass;

public class MyHeap {
	int[] heap;
	int heapSize;
	private int data;
	
	public static void main(String[] args) {
		int[] integers = {36, 31};
		MyHeap heapy = new MyHeap();
		int[] result = heapy.heapSize();
		System.out.println("printing here");
		for(int i = 0; i < result.length; i++){
			System.out.println(result[i]);
		}
	}
	
	MyHeap() {
		heap = new int[10];
	 heapSize = 1;
	}
	
	public void insert(int val){
		data = val;
		/*heap[heapSize] = val;
		upHeap(heapSize);
		heapSize++;*/
		if (heapSize == heap.length) {
			System.out.println("Heap's underlying storage is overflowed");
		}
      else {
            heapSize++;
            heap[heapSize] = val;
            upHeap(heapSize);
      }
	}
	
	 private void downHeap(int nodeIndex) {
         int LeftCI, rightCI, minIndex, tmp;
         LeftCI = getLeft(nodeIndex);
         rightCI = getRight(nodeIndex);
         if (rightCI >= heapSize) {
               if (LeftCI >= heapSize)
                     return;
               else
                     minIndex = LeftCI;
         } else {
               if (heap[LeftCI] <= heap[rightCI])
                     minIndex = LeftCI;
               else
                     minIndex = rightCI;
         }
         if (heap[nodeIndex] > heap[minIndex]) {
               tmp = heap[minIndex];
               heap[minIndex] = heap[nodeIndex];
               heap[nodeIndex] = tmp;
               //downHeap(minIndex);
           }
         }
	
	void upHeap(int index) {
		while  (index >= 1 && heap[index] < heap[index / 2]) {
			swap(index, index /2);
		}
	}
	
	void swap(int index1, int index2) {
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
	
	public int getLeft(int nodeIndex)
	{
		return 2 *nodeIndex + 1;
	}
	
	public int getRight(int nodeIndex){
		return 2 * nodeIndex + 2;
	}
	
	public boolean isEmpty(){
		// are you empty? 
		return (heapSize != 0);
		// if empty say false
		// if full say true
	}
	
	public int[] heapSize(){
		return heap;}
	
	public int getKey(){return data;}
	
	public void min(int heapSize){
		heap = new int[heapSize];
        heapSize = 0;
	}
	
  public void removeMin() {
	if (isEmpty()) {
		heap[0] = heap[heapSize - 1];
    	heapSize--;
    	downHeap(0);
	}
	else {
		 System.out.println("Heap is empty");
	}
  }
  

	public void createLinear(){}
	public void createNonLinear(){}
	

}