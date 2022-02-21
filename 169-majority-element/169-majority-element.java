class Solution {
    // sort and then count
    // use hash table
    //majority vote algo
    public int majorityElement(int[] arr) {
        int count=0;
        int m= arr[0];
        for(int i=0;i<arr.length;i++)
        {
            if(count == 0)
            {
                count++;m= arr[i];
            }
            else if(arr[i]==m)
            {
                count++;
            }
            else
            {
                count--;
                
            }
        }
        return m;
    }
}