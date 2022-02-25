class Solution {
    public int compareVersion(String str1, String str2) {
        String[] arr1 = str1.split("[.]", 0);  
        String[] arr2 = str2.split("[.]", 0);  
        
        if(arr1.length<arr2.length)
        {
            for(int i=0;i<arr1.length;i++)
            {
                int a = Integer.parseInt(arr1[i]);
                int b = Integer.parseInt(arr2[i]);
                if(a>b)
                    return 1;
                else if(a<b)
                    return -1;
            }
            for(int i=arr1.length;i<arr2.length;i++)
            {
                int b = Integer.parseInt(arr2[i]);
                if(b>0)
                    return -1;
            }
        }
        else
        {
             for(int i=0;i<arr2.length;i++)
            {
                int a = Integer.parseInt(arr1[i]);
                int b = Integer.parseInt(arr2[i]);
                 System.out.println(arr1[i]+" "+arr2[i]);
                if(a>b)
                    return 1;
                else if(a<b)
                    return -1;

            }
             for(int i=arr2.length;i<arr1.length;i++)
            {
                int b = Integer.parseInt(arr1[i]);
                if(b>0)
                    return 1;
            }
        }
        
        return 0;
    }
}