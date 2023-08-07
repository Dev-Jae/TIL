package practice;


public class HeapSort {
    /* 평균 수행 시간이 O(logN)인 알고리즘
     * 퀵 정렬(Quick Sort), 병합 정렬(Merge Sort), 힙 정렬(Heap Sort)
     * 한번 수행될 때마다 정렬되어야 하는 수의 범위가 1/2로 줄어드는 경우
     * 퀵 정렬 이외의 다른 알고리즘은 추가적인 메모리가 필요함
     */
    private int SIZE;
    private int heapArr[];

    public static void main(String[] args) {
        /* 힙 정렬(Heap Sort)
         * heap 은 배열로 표현, 인덱스 0번째는 사용하지 않음(나누기 2를 해야하기 떄문에)
         * parent 위치의 인덱스는 child 인덱스의 1/2 인덱스
         * 우선순위 큐 구현할때 사용
         */

        HeapSort h = new HeapSort();
        h.insertHeap(80);
        h.insertHeap(50);
        h.insertHeap(70);
        h.insertHeap(10);
        h.insertHeap(60);
        h.insertHeap(20);

        h.printHeap();

        int n, data;
        n = h.getHeapSize();
        for(int i = 1; i <= n ; i++){
            data = h.deleteHeap();
            System.out.printf("\n 출력 : [%d]", data);
        }
    }

    public HeapSort(){
        SIZE = 0;
        heapArr = new int[50];
    }

    public void insertHeap(int input){
        int i = ++SIZE;
        /*while((i != 1) && ( input > heapArr[i/2])){
            // max heap
        }*/

        while((i != 1) && ( input < heapArr[i/2])){
            // min heap
            heapArr[i] = heapArr[i/2]; // heapArr[i/2] : parent
            i = i/2; // i를 parent 위치로
        }
        heapArr[i] = input;
    }

    public int getHeapSize(){
        return SIZE;
    }

    public int deleteHeap(){
        // delete는 O(log2N)
        int parent, child;
        int data, temp;
        data = heapArr[1];

        temp = heapArr[SIZE];
        SIZE -= 1;
        parent = 1;
        child = 2;

        while(child <= SIZE){
            // if((child < SIZE) && (heapArr[child] < heapArr[child + 1])) // max heap
            if((child < SIZE) && (heapArr[child] > heapArr[child + 1])){
                child++;
            }
            // if(temp >= heapArr[child]) break; // max heap
            if(temp <= heapArr[child]){ // min heap
                break;
            }
            heapArr[parent] = heapArr[child];
            parent = child;
            child *=2 ;

        }
        heapArr[parent] = temp;
        return data;
    }

    public void printHeap(){
        //System.out.println("\n Max Heap : ");
        System.out.printf("\n Min Heap : ");
        for(int i = 1; i <= SIZE; i++){
            System.out.printf("[%d] ", heapArr[i]);
        }
    }
}
