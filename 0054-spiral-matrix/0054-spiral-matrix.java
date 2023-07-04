class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        List<Integer> list = new ArrayList<>();
        char curr='R';int tot = arr.length * arr[0].length;
        int i=0;int j=0;
        while(tot>0)
        {
            if(j==arr[0].length)
            {
                curr='D';
                j=arr[0].length-1;
                i++;
            }            
            else if(i==arr.length)
            {
                curr='L';
                j=arr[0].length-2;
                i--;
            }
            else if(j<0)
            {
                j=0;
                curr='U';
                i--;
            }            
            else if(arr[i][j]!=-101)
            {
                list.add(arr[i][j]);
                arr[i][j]=-101;
                if(curr=='R')
                    j++;
                if(curr=='L')
                    j--;
                if(curr=='U')
                    i--;
                if(curr=='D')
                    i++;                
                tot--;
            }
            else
            {
                if(curr=='R')
                 {
                    curr='D';
                    i++;j--;
                 }
                else if(curr=='L')
                  {
                    i--;j++;
                    curr='U';
                  }
                else if(curr=='U')
                  { 
                    i++;j++;
                    curr='R';
                }
                else
                  {
                    i--;j--;
                    curr='L';
                }
            }
            // System.out.println(i+" "+j+" "+curr);
        }
        return list;
    }
} 