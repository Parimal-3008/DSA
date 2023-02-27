/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public String getDirections(TreeNode root, int start, int end) {
        StringBuilder str1=  call(root,start,new StringBuilder(""));
        StringBuilder str2=  call(root,end,new StringBuilder(""));
      String a1 = str1.toString();
      String a2= str2.toString();
      int ind =-1;
      for(int i=0;i<Math.min(a1.length(),a2.length());i++)
      {
        char c1= a1.charAt(i);
        char c2= a2.charAt(i);
        if(c1==c2)
        {
          ind =i;
        }
        else
          break;
      }
      // System.out.println(a1+" "+a2);
      a1=a1.substring(ind+1,a1.length());
      a2=a2.substring(ind+1,a2.length());
      // System.out.println(a1+" "+a2);
      String ans ="";
      for(int i=0;i<a1.length();i++)
      {
        char c = a1.charAt(i);
        if(c=='L' || c=='R')
          ans=ans+"U";
      }
      return ans+a2;
      
      
    }
  public StringBuilder call(TreeNode root, int search,StringBuilder str)
  {
    if(root ==  null)
      return null;
    if(root.val==search)
      return new StringBuilder(str.toString());
    // StringBuilder p1= new StringBuilder(str.toString());
    // StringBuilder p2= new StringBuilder(str.toString());
    str=str.append("L");
    StringBuilder b = call(root.left,search,str);
     if(b!=null)
      return b;
    str = str.deleteCharAt(str.length() - 1);
    str=str.append("R");
    StringBuilder c = call(root.right,search,str);
    str = str.deleteCharAt(str.length() - 1);   
    if(c!=null)
      return c;
    return null;    
  }
}