class LUPrefix {
     int no=0;
    int max = -1;
    int length =0;
    TreeSet<Integer> set = new TreeSet<>();
    public LUPrefix(int n) {
        no = n;
        for(int i=01;i<=n;i++)
            set.add(i);
    }
    
    public void upload(int i) {
        set.remove(i);
    }
    
    public int longest() {
        if(set.size()!=0)
       return set.first()-1;
        return no;
        
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */