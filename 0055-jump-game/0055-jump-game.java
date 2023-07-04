class Solution {
    public boolean canJump(int[] arr) {
        int max = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(max>0)
            { 
                max--;
            max = Math.max(max,arr[i]);
            }
            else
            return false;
        }
        return true;
        
    }
}