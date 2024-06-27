if __name__ == '__main__':
    n = int(input())
    arr = list(map(int, input().split()))
    for n in range(len(arr)-1,0 ,-1):
       for i in range(n) :
          if(arr[i]>arr[i+1]):
              temp=arr[i]  
              arr[i]=arr[i+1]
              arr[i+1]=temp
              
    max=arr[-1]
    for i in range(len(arr),0,-1):
        if(arr[i-1]<max):
            max=arr[i-1]  
            break;  
         
    print(max)
         