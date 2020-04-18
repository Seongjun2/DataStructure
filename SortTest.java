package DataStructure;

public class SortTest {

    public static void main(String[] args) {
        int[] array = {5,1,3,7,8,2,9,10,6,4};
        Sort s = new Sort(array);

//        s.bubbleSort();
//        s.selectSort();
        s.insertSort();
        s.printArray();


    }
}
