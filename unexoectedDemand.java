class Result {

public static int filledOrders(List<Integer> order, int k) {
    int count=0;
        int [] myorders=new int[order.size()];
        int o=0;
        for(int i:order){
            myorders[o]=i;
            o++;
        }
    int j,l,temp;
        boolean swap;
        for(int i=0;i<myorders.length-1;i++){
            swap=false;
            for(j=0;j<myorders.length-i-1;j++){
                if(myorders[j]>myorders[j+1]){
                    temp=myorders[j];
                    myorders[j]=myorders[j+1];
                    myorders[j+1]=temp;
                    swap=true;
                    
                }
            }
            if(swap==false){
                break;
            }
        }
    for(int i:myorders){
            if(i<=k){
                count++;
                k-=i;
            }
            
        }
        return count;
        
}