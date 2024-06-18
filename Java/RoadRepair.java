import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {
    public static long getMinCost(List<Integer> crew_id, List<Integer> job_id) {
        long timeTaken=0;
        int [] crew=new int[crew_id.size()];
        int o=0;
        for(int i:crew_id){
            crew[o]=i;
            o++;
        }
        int [] job=new int[job_id.size()];
        o=0;
        for(int i:job_id){
            job[o]=i;
            o++;
        }
        int j,l,temp;
        boolean swap;
        for(int i=0;i<crew.length-1;i++){
            swap=false;
            for(j=0;j<crew.length-i-1;j++){
                if(crew[j]>crew[j+1]){
                    temp=crew[j];
                    crew[j]=crew[j+1];
                    crew[j+1]=temp;
                    swap=true;
                }
            }
            if(swap==false){
                break;
            }
                                                                            
        }
        j=0;
        l=0;
        temp=0;
        swap=false;
        for(int i=0;i<job.length-1;i++){
            swap=false;
            for(j=0;j<job.length-i-1;j++){
                if(job[j]>job[j+1]){
                    temp=job[j];
                    job[j]=job[j+1];
                    job[j+1]=temp;
                    swap=true;
                }
            }
            if(swap==false){
                break;
            }
                                                                            
        }
        for (int i=0;i<crew_id.size();i++){
            if(crew[i]>job[i]){
                timeTaken+=crew[i]-job[i];
            }else{
                timeTaken+=job[i]-crew[i];
            }
        }
        
        return timeTaken;
}