class Solution {
    public int maximalRectangle(char[][] arr) {
        int m= arr.length;
        int n = arr[0].length;
        int arr2[][]= new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0)
                {
                    arr2[i][j]=(arr[i][j]=='0')?0:1;
                }
                else
                {
                    arr2[i][j]=(arr[i][j]=='0')?0:(arr2[i-1][j]+1);
                }
            }
        }
        int ans = 0;
        for(int i[]:arr2)
        {
            ans = Math.max(ans,largestRectangleArea(i));
            
        }
        return ans;
        
    } public int largestRectangleArea(int[] arr) {
        int arr1[]= new int[arr.length];
        int arr2[]= new int[arr.length];
        right(arr1,arr);//next smaller element to right
        left(arr2,arr);//next smaller element to left
        int ans = 0;
//         for(int i:arr1)
//             System.out.print(i+" ");
//         System.out.println();
//         for(int i:arr2)
//             System.out.print(i+" ");
        
        for(int i=0;i<arr.length;i++)
        {
            
            int temp =arr[i]*(arr1[i]-arr2[i]-1);
            ans = Math.max(ans,temp);
        }
        return ans;        
    }
    public void right(int[] arr1, int[] arr)
    {
        Stack<Integer> st = new Stack();
        // Arrays.fill(arr1,arr.length-1);
        for(int i=arr.length-1;i>=0;i--)
        {
            while(true)
            {
                if(st.isEmpty())
                {
                    arr1[i]=arr.length;
                    st.push(i);
                    break;
                }
                if(arr[st.peek()]>arr[i])
                    st.pop();
                else  if(arr[st.peek()]<arr[i])
              {
                    arr1[i]=st.peek();
                    st.push(i);
                   break;
                }
                else
                {
                    arr1[i]=arr1[st.peek()];
                    st.push(i);
                    break;
                }
            }
        }
    }
      public void left(int[] arr1, int[] arr)
    {
        Stack<Integer> st = new Stack();
        // Arrays.fill(arr1,0);
        for(int i=0;i<arr.length;i++)
        {
            while(true)
            {
                if(st.isEmpty())
                {
                    arr1[i]=-1;
                    st.push(i);
                    break;
                }
                if(arr[st.peek()]>arr[i])
                    st.pop();
                else  if(arr[st.peek()]<arr[i])
                   {
                    arr1[i]=st.peek();
                    st.push(i);
                   break;
                }
                else
                {
                    arr1[i]=arr1[st.peek()];
                    st.push(i);
                    break;
                }
            }
        }
    }
}