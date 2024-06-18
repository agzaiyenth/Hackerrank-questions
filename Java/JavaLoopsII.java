import java.util.ArrayList;
import java.util.Scanner;

public class JavaLoopsII {
    public static double multiplier(int a,int b,int d){
        if(d==0){
            return a+b;
        }
        else {
            return b*(Math.pow(2,d))+multiplier(a,b,d-1);
        }

    }

    public static void main(String[] args) {

        ArrayList<int[]> NumberSet=new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int[] list={a,b,n};
            NumberSet.add(list);
        }


        for(int set[]:NumberSet){
            for(int i=0;i<set[2];i++){
                System.out.print((int) multiplier(set[0],set[1],i)+" ");
            }
            System.out.println();
        }



    }
}