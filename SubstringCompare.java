import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String subWord=s.substring(0,k);
        String smallest =subWord;
        String largest =subWord;
        for(int i=1;i<=s.length()-k;i++){
            subWord=s.substring(i,i+k);
            if(subWord.compareTo(largest)>0){
                largest=subWord;
            }
            if(subWord.compareTo(smallest) <0 ){
                smallest=subWord;
            }
        }
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}