import programThreads.MyThreads;
import threadsClasses.Flow;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Введите интервал поиска");
        System.out.println("Начало поиска:");
        Scanner scanMinInt =new Scanner(System.in);
        int minInt = scanMinInt.nextInt() ;
        System.out.println("Конец поиска:");
        Scanner scanMaxInt =new Scanner(System.in);
        int maxInt = scanMaxInt.nextInt() ;
        int size =maxInt-minInt+2;
        System.out.println("Введите количество потоков");
        Scanner scan =new Scanner(System.in);
        int a = scan.nextInt() ;
        int sizeForthread =size/a;
        Flow[] flows ={};
        int i ;
        for ( i=0; i<a; i++) {
            flows= addThreads(flows,minInt,maxInt,sizeForthread);
        }
        startProgramm(flows);


    }
    public static Flow[] addThreads(Flow[] flows,int minInt,int maxInt,int sizeForthread ) {

        if (flows.length == 0) {
            Flow thread = new Flow (minInt,sizeForthread);
            Flow[] threads = new Flow[]{thread};
            flows = threads;
        } else {
            int j =flows.length + 1;
            Flow[] arrayFlows = new Flow[j];

            for(int i = 0; i < flows.length; ++i) {
                arrayFlows[i] = flows[i];
            }
            int min =arrayFlows[j-2].getMax();
            int max = min+sizeForthread+1;
            if (max<=maxInt){
            Flow thread = new Flow (min,max);
            arrayFlows[j - 1] = thread;
            flows = arrayFlows;
        }else {
            max =maxInt+1;
                Flow thread = new Flow (min,max);
                arrayFlows[j - 1] = thread;
                flows = arrayFlows;
            }
        }

        return flows;
    }

    public static void startProgramm(Flow[] flows){
        for (Flow flow : flows){
            MyThreads thread = new MyThreads(flow.getMin(),flow.getMax());
            thread.start();

        }

    }
}
