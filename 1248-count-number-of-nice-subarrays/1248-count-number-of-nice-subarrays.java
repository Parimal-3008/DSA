class Solution {
    public int numberOfSubarrays(int[] arr, int k) {
        int arr2[]= new int[50010];
         int sum=0;int p=1;
        Arrays.fill(arr2,-1);
        arr2[0]=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]%2==1)
               { arr2[p]=i+1;p++;}
        }
        arr2[p]=arr.length+1;
       // for(int i=0;i<=p;i++)
       //     System.out.print(arr2[i]+" ");
        
        for(int i=1;i<p+1;i++)
        {
            int id= arr2[i] -arr2[i-1];
            int j= i+k-1;
           
            if(j+1<p+1)
            {
                 int jd=arr2[j+1]-arr2[j];
                 sum+=(id*jd);
            }
            else
                break;
        }
        return sum;
    }
}