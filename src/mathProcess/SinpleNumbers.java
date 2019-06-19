package mathProcess;

public class SinpleNumbers {
     public int[] numbers ={};



    synchronized public int[] setNumbers(int[] numbers,int numberToadd) {



        if(numbers.length==0){
            int [] selectedNumbers ={ numberToadd};
            numbers=selectedNumbers;


        }else {
            int j = numbers.length+1;
           int [] arrayNumbers = new int[j];
            for (int i = 0; i < numbers.length; i++) {
                arrayNumbers[i] = numbers[i];
            }
            arrayNumbers[j-1] = numberToadd;
            numbers = arrayNumbers;
        }
        return numbers;



    }
}
