class Solution {
    class Edge
    {
        int pos;int health; char dir;
        public Edge(int pos,int health, char dir)
        {
            this.pos= pos;
            this.health= health;
            this.dir = dir;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String str) {
        Edge[] arr= new Edge[positions.length];
       Stack<Edge> st = new Stack<>();
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=new Edge(positions[i],healths[i],str.charAt(i));
        }
         Arrays.sort(arr, new Comparator<Edge>(){
            public int compare(Edge a, Edge b)
            {
                return Integer.compare(a.pos,b.pos);
            }
        });
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].dir == 'L')
            {
                boolean flag = true;
                while(!st.isEmpty() && st.peek().dir=='R')
                {
                    Edge e = st.pop();
                    if(arr[i].health>e.health)
                    {
                        
                        arr[i].health--;
                        e.health=0;                                                      
                    }
                    else if(arr[i].health<e.health)
                    {
                        
                        arr[i].health=0;;
                       e.health--; 
                        if(e.health>0)
                        st.push(e);
                        flag = false;
                        break;
                    }
                    else
                    {
                        arr[i].health=0;
                        e.health=0;
                        flag = false;
                        break;
                    }
                    
                }
                if((st.isEmpty() || st.peek().dir=='L') && flag && arr[i].health>0)
                    st.push(arr[i]);
            }
            else
                st.push(arr[i]);
        }
        List<Integer> list = new ArrayList<>();
         Map<Integer,Edge> mp = new HashMap<>();
        while(!st.isEmpty())
        {
            Edge e = st.pop();
            mp.put(e.pos,e);
        }
        for(int i=0;i<arr.length;i++)
        {
            if(mp.containsKey(positions[i]))
                list.add(mp.get(positions[i]).health);
        }
        return list;
    }
}