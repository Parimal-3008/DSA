class Solution {
    public void sortColors(int[] arr) {
        int i=0;int j= arr.length-1;
        for(int k=0;k<=j && i<j;k++)
        {
            if(arr[k]==0)
            {
                swap(arr,i,k);
                i++;
            }
            else if(arr[k]==2)
            {
                swap(arr,j,k);
                j--;
                k--;
            }
            // if(i>=j)
            //     break;
            
        }
        
    }
    public void swap(int[] arr,int i, int j)
    {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}