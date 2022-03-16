class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int arr[] = new int[1001];
        int j=0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<popped.length;i++)
        {
             if(arr[popped[j]]==0)
             {
                 while(arr[popped[j]]==0)
                 {
                    // System.out.println("push "+pushed[i]);
                     st.push(pushed[i]);
                     arr[pushed[i]]=1;
                     i++;
                 }
                  i--;                       
             }
             else
             {
                 if(st.peek()==popped[j])
                   {   //System.out.println("pop "+popped[j]);
                    st.pop();j++;}
                 else
                     return false;
                 i--;
             }
            
        }
        while(!st.isEmpty())
        {
            if(st.pop()==popped[j])
                j++;
            else
                return false;
        }
        return true;
    }
}