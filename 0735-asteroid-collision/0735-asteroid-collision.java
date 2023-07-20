class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st= new Stack<>();
        st.push(arr[arr.length-1]);
        for(int i=arr.length-2;i>=0;i--)
        {
            if(st.isEmpty())
                 {
                st.push(arr[i]);
                continue;
            }
            else if( (st.peek()<0 && arr[i]<0)|| (st.peek()>0 && arr[i]>0))
            {
                st.push(arr[i]);
                continue;
            }
            while(!st.isEmpty())
            {
                int p = st.peek();
                if((p<0 && arr[i]>0))
                {
                    if(Math.abs(p)<Math.abs(arr[i]))
                    {st.pop();}
                    else if(Math.abs(p)==Math.abs(arr[i]))
                    {st.pop();break;}
                    else
                       {
                       break;
                      }
                    if(st.isEmpty()){
                        st.push(arr[i]);break;}
                }
                else {
                        st.push(arr[i]);break;}
            }
        }
        int ans[]= new int[st.size()];
        for(int i=0;i<ans.length;i++)
            ans[i]=st.pop();
        return ans;
        
    }
}