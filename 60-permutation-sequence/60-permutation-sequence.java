class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers= new LinkedList<>();
        int fact=1;
        for(int i=1;i<n;i++)
        {
            fact*=i;
            numbers.add(i);
            
        }
        numbers.add(n);
        String curr="";
        k--;
        while(true)
        {
            curr+=numbers.get(k/fact);
            numbers.remove(k/fact);
            if(numbers.size()==0)
                break;
            k= k%fact;
            fact=fact/numbers.size();
        }
        return curr;
    }
}