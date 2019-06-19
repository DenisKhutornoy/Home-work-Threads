package programThreads;


import mathProcess.SinpleNumbers;

public class MyThreads extends  Thread {
    private int min;
    private int max;
SinpleNumbers simple =new SinpleNumbers();


    public MyThreads(int min, int max) {


        this.min = min;

        this.max = max;
    }

    @Override
    public void run() {
        for (int i = this.min; i < this.max; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int b = getSinple(i);
            if (b == 1) {
                System.out.println("число " + i + "  простое");
                 simple.setNumbers(simple.numbers,i);
            }

        }
    }


    public int getSinple(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return 0;
            }
        }
        return 1;

    }



}


