class TopVotedCandidate {
    
    int[][] arr= new int[5001][3];
    int max = 0;int cand = -1;
    TreeMap<Integer,Integer> mp = new TreeMap<>();
    public TopVotedCandidate(int[] persons, int[] times) {
        for(int i=0;i<persons.length;i++)
        {
            arr[i][0]=i;
            arr[i][1]=0;
        }
        for(int i=0;i<persons.length;i++)
        {
            arr[persons[i]][1]++;
            if(max<=arr[persons[i]][1])
            {
                max  =arr[persons[i]][1];
                cand=persons[i];
            }
            mp.put(times[i],cand);
            
        }
        
    }
    
    public int q(int t) {
        return mp.get(mp.floorKey(t));
        
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */