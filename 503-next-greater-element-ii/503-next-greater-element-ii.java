class Solution {
    public int[] nextGreaterElements(int[] arr) {
        Stack<Integer> st = new Stack<>();
       int n = arr.length;
      for(int i=n-1;i>=0;i--)
        st.push(arr[i]);
      int ans[]= new int[n];
      for(int i=n-1;i>=0;i--)
      {
        if(!st.isEmpty() && st.peek()>arr[i])
        {
           ans[i]=st.peek();
          st.push(arr[i]);
        }
        else if(!st.isEmpty())
          while(!st.isEmpty())
          {
            st.pop();
            if(!st.isEmpty() && st.peek()>arr[i])
            {
              ans[i]= st.peek();
              st.push(arr[i]);break;
            }
            if(st.isEmpty())
            {
              ans[i]=-1;
              st.push(arr[i]);break;
            }
            
          }
        else
        {
          ans[i]=-1;
              st.push(arr[i]);
        }
      }
      return ans;
    }
}