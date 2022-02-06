class Solution {
    public int removeDuplicates(int[] arr) {
        int prev=arr[0];
        int count=01;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]==prev)
            {
                count++;
                if(count>2)
                {
                    arr[i]=Integer.MAX_VALUE;
                    count--;
                }
            }
            else
            {
                prev=arr[i];
                count=1;
            }
        }
       Arrays.sort(arr);
        int c=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==Integer.MAX_VALUE)
                break;
            c++;
        }
       
        return c;
    }
}