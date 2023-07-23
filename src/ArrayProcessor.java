public class ArrayProcessor {

    private int[]array;

    public ArrayProcessor(int[] array) {
        this.array = array;
    }

    public int findMaxValue(){
        int max = array[0];
        for(int elem : array){
            if (elem > max){
                max = elem;
            }
        }
        return max;
    }

    public int findMinValue(){
        int min = array[0];
        for(int elem : array){
            if (elem < min){
                min = elem;
            }
        }
        return min;
    }
    public void countingSort(){
        int max = findMaxValue();
        int min = findMinValue();

        int[] tempArray = new int[max - min + 1];

        for (int i = 0; i < this.array.length; i++){
            tempArray[this.array[i] - min] += 1;
        }

        int [] resultArray = new int [this.array.length];
        int currentIndex = 0;
        for(int i = 0; i < tempArray.length; i++){
            for (int j = 0; j < tempArray[i]; j++){
                resultArray[currentIndex] = i + min;
                currentIndex++;
            }
        }
        this.array = resultArray;
    }
    public void printArray(){
        for(int elem : this.array){
            System.out.print(elem + " ");
        }
        System.out.println("\n");
    }

    public void shiftArray(int shift){
        int[] tempArray = new int[array.length];
        for (int i = 0; i < (tempArray.length - shift); i++){
            tempArray[i + shift] = array[i];
        }
        for (int i = 0; i < shift; i++){
            tempArray[i] = array[(array.length - shift) + i];
        }
        this.array = tempArray;
    }

}
