class Solution {
    public int[] restoreArray(int[][] arr) {
        int[] ans= new int[arr.length+1];
        Map<Integer,List<Integer>> mp = new HashMap<>();
        for(int i[]:arr)
        {
            List<Integer> list = new ArrayList<>();
            if(mp.containsKey(i[0]))
                list= mp.get(i[0]);
            list.add(i[1]);
            mp.put(i[0],list);
            list = new ArrayList<>();
            if(mp.containsKey(i[1]))
                list= mp.get(i[01]);
            list.add(i[0]);
            mp.put(i[01],list);            
        }
        // System.out.println(mp);
        for(Map.Entry<Integer,List<Integer>> entry:mp.entrySet())
        {
            if(entry.getValue().size()==1){
                ans[0]=entry.getKey();break;}
        }
        for(int i=1;i<ans.length;i++)
        {
            List<Integer> list = mp.get(ans[i-1]);
            if(i==1)
            {
                ans[i]=list.get(0);
                continue;
            }
            if( list.get(0)==ans[i-2])
                ans[i]=list.get(1);
            else if(i>1)
                ans[i]=list.get(0);            
        }
        return ans;
    }
}