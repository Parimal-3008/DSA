class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++)
        list.add(i);
       
        int j=(k-1)%n;
        while(list.size()>1)
        {
            int p= list.size();
            //System.out.println(list);
            int po=j;
            list.remove(j);
            j=(po+k-1)%(p-1);
           
            
            
            
        }
        //System.out.println(list);
        return list.get(0);
    }
}