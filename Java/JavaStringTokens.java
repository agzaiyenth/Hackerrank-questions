import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        
        String regex="[! , ? . _ ' @ ]";
        ArrayList <String> stuff= new ArrayList <> (Arrays.asList(s.split(regex)));
        ArrayList <String> stuffs=new ArrayList<>();
        for(String k:stuff){
            if(!k.isEmpty()){
               stuffs.add(k);
            }
        }
       
        System.out.println(stuffs.size());
        for(String j:stuffs){
            System.out.println(j);
            
        }   
        scan.close();
    }
}