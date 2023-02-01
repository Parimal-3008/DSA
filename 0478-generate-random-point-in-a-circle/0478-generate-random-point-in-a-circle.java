class Solution {
  double x;double y;double r;

    public Solution(double r1, double x1, double y1) {
        x = x1 + r;y = y1;r=r1;
    }
    
    public double[] randPoint() {
      double pi = 22.0/7.0;
      double deg = 2 * Math.random()*pi;
      double length = Math.sqrt(Math.random()) * r;
      double m = x+ (length*Math.cos(deg));
      double n = y+ (length*Math.sin(deg));
        double ans[]={m,n};
      return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */