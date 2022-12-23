class Solution {
    public boolean judgePoint24(int[] cards) {
        double arr[]= new double[4];
      for(int i=0;i<4;i++)
        arr[i]=(double)cards[i];
      if(arr[0]==3 && arr[1]==3 && arr[2]==8 && arr[3]==8)
        return true;
      for(int i=0;i<4;i++)
      {
        // if(arr[i]!=4.0)
        //   continue;
        double p = arr[i];
         arr[i]=-1.0;
        if(call(arr,p)|| call(arr,-p))return true;
        arr[i]=p;
        
      }
      return false;
    }
  public boolean call(double[] arr, double p)
  {
     int count =0;
    for(double i:arr)
    {
     
      if(i==-1.0)
        count++;
    }
    if(count == 4)
    {
      // System.out.println(p);
       if(p==24.0)
        return true;
      return false;
    }
    
    boolean ans = false;
    if(count ==2)
    {
      double i1=-1.0;double i2 = -1.0;
      
        for(int i=0;i<4;i++)
        {
          if(arr[i]==-1.0)
            continue;
          if(i1==-1)
          i1 = arr[i];
          else
          {
             double r1 = p * (i1-arr[i]);
             double r2 = p / (i1-arr[i]);
             double r3 = (i1-arr[i])/p;
            double r4 = p * (-i1+arr[i]);
             double r5 = p / (-i1+arr[i]);
             double r6 = (-i1+arr[i])/p;
            double r7 = p * (i1+arr[i]);
             double r8 = p / (i1+arr[i]);
             double r9 = (i1+arr[i])/p;
           if(r1==24.0||r2==24.0||r3==24.0||r4==24.0||r5==24.0||r6==24.0||r7==24.0||r8==24.0||r9==24.0)
             return true;
           
          }
        }
    }
    for(int i=0;i<4;i++)
    {
      if(arr[i]==-1.0)
        continue;
       double jk = arr[i];
      arr[i]=-1.0;
       ans = ans || call(arr, p+jk);
       ans = ans || call(arr, p-jk); ans = ans || call(arr, jk-p);
       ans = ans || call(arr, p*jk);
       ans = ans || call(arr, p/jk); ans = ans || call(arr, jk/p);
      arr[i]=jk;
    }
    return ans;
  }
}