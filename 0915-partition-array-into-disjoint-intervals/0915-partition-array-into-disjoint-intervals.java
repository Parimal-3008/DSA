class Solution {
    public int partitionDisjoint(int[] arr) {
        int max[]= new int[arr.length];
        for(int i=arr.length-1;i>=0;i--)
        {
            if(i==arr.length-1)
            max[i]= arr[i];
            else
                max[i]=Math.min(max[i+1],arr[i]);
        }
        int min = arr[0];
        for(int i=0;i<arr.length-1;i++)
        {
            if(min<=max[i+1])
                return i+1;
            min = Math.max(min,arr[i]);
                
        }
        return -1;
    }
}