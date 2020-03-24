package day2;

public class Main {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0){
            return 0;
        }
        int temp=0;
        for (int i = 0; i <array.length ; i++) {
            if(array[i]>array[i+1]){
                temp=array[i+1];
                break;
            }
        }
        return temp;
    }
}
