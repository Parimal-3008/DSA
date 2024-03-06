class Solution {
    public int rotatedDigits(int n) {
        int ans = 0;
        for(int i=1;i<=n;i++)
        {
            int j = i;
            int flag = 3;
            while(j>0)
            {
                int rem = j%10;
                if(rem ==4 || rem == 7 || rem ==3)
                    flag = -1;
                j/=10;
            }
            if(flag ==-1)
                continue;
             j = i;
            
            while(j>0)
            {
                int rem = j%10;
                if(rem ==2 || rem == 5 || rem ==6 || rem == 9)
                    flag = 4;
                j/=10;
            }
            if(flag ==3)
                continue;
            ans++;
        }
        return ans;
    }
}