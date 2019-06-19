package mathProcess;

public class SinpleNumbers {
     public int[] numbers ={};



    synchronized public int[] setNumbers(int[] numbers,int numberToadd) {



        if(numbers.length==0){
            int [] selectedNumbers ={ numberToadd};
            numbers=selectedNumbers;


        }else {
            int j = numbers.length+1;
           int [] arrayFlower = new int[j];
            for (int i = 0; i < numbers.length; i++) {
                arrayFlower[i] = numbers[i];
            }
            arrayFlower[j-1] = numberToadd;
            numbers = arrayFlower;
        }
        return numbers;



    }
}
