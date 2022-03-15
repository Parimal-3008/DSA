class Solution {
    public String minRemoveToMakeValid(String str) {
        int arr[]= new int[str.length()];
        Arrays.fill(arr,-1);
        Stack<Integer> st = new Stack();
        String st3="";
        for(int i=0;i<str.length();i++)
        {
            char ch =str.charAt(i);
            if(ch=='(')
            {
                st.push(i);
            }
            else if(ch==')')
            {
                if(!st.isEmpty()&&str.charAt(Math.abs(st.peek()))=='(')
                {
                    int p= st.pop();
                    int q=i;
                   // System.out.println(p+" "+q);
                    arr[p]=1;arr[q]=1;
                }
                else 
                    st.push(i*(-1));
                
            }
            else
               arr[i]=1;
        }
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==1)
            {
                st3=st3+String.valueOf(str.charAt(i));
            }
        }
        return st3;
    }
}