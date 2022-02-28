class Solution {
    public List<Integer> pathInZigZagTree(int n) {
        List<Integer> list = new LinkedList<>();   
        list.add(1);
        
        int arr[] = new int[21];
         arr[0]=1;
        for(int i=01;i<21;i++)
        arr[i]=arr[i-1]+(int)Math.pow(2,i);
        int c=0;
        while(n/2>1)
        {
            list.add(n);
            c=n/2;
            int ind = (int) ((double)Math.log(c)/(double)Math.log(2)); 
            int start=arr[ind-1]+1;
            int end=arr[ind];
           
            n = (end-c)+start;
             //System.out.println(ind+" "+start+" "+end+" "+n);
        }
        // if(n==3)
        //     list.add(2);
        // else
        //     list.add(3);
        if(n!=1)
        list.add(n);
        Collections.sort(list);
        return list;
    }
}
/*
1
2 3                          R
4 5 6 7
8 9 10 11 12 13 14 15        R
16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31
*/