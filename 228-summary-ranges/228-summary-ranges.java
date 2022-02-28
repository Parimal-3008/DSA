class Solution {
    public List<String> summaryRanges(int[] arr) {
        List<String> list = new LinkedList<>();
        if(arr.length==0)
            return list;
        int prev=arr[0];String str=String.valueOf(arr[0]);int count=0;
        for(int i=01;i<arr.length;i++)
        {
            if(arr[i]-1==prev)
            {
                if(count==0)
                str+="->";
                count++;
            }
            else if(arr[i]-1>prev)
            {
                if(count!=0)
                str+=String.valueOf(prev);
                list.add(str);str="";count=0;
                str=String.valueOf(arr[i]);
            }
            prev=arr[i];
        }
        if(count==0)
            list.add(str);
        else
            list.add(str+=String.valueOf(prev));
        return list;
    }
}