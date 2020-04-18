package DataStructure;

public class Sort {

    int[] array;

    public Sort(int[] array){
        this.array = array;
    }

    public void bubbleSort(){
        for (int i = array.length-1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public void selectSort(){//가장 작은 값을 선택 하여 앞으로 보
        for (int i = 0; i < array.length; i++) {
            int minIdx = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[minIdx] > array[j]){
                    minIdx = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIdx];
            array[minIdx] = temp;
        }
    }

    public void insertSort(){

        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int idx = i;
            for (int j = i-1; j >= 0; j--) {
                if(array[j] > value){
                    int temp = array[j];
                    array[j] = value;
                    array[idx] = temp;
                    idx--;
                }
            }
        }

    }

    public void printArray(){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
