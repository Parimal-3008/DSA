class Solution {
    public int[] mostCompetitive(int[] arr, int k) {
        Stack<Integer> st = new Stack<>();
      int ans[]= new int[k];
      for(int i=0;i<arr.length;i++)
      {
        while(!st.isEmpty() && arr[i]<arr[st.peek()] && arr.length-i+st.size()>k)
          st.pop();
        if(st.size()<k)
          st.push(i);
      }
      for(int i=k-1;i>=0;i--)
        ans[i]=arr[st.pop()];
      return ans;
    }
}