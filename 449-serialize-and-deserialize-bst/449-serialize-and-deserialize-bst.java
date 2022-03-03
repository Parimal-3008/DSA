/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
      String str="";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        call(root);
        //System.out.println(str);
        return str;
    }
    public void call(TreeNode root)
    {
        if(root== null)
           {
           // str+="null ";
            return;
        }
        str+=(String.valueOf(root.val)+" ");
        call(root.left);
        call(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String str1) {
        if(str1.equals(""))
            return null;
        String[] s= str1.split(" ");
        int[] arr= new int[s.length];
        for(int i=0;i<s.length;i++)
           {
            arr[i]=Integer.parseInt(s[i]);
            //System.out.print(arr[i]+",");
           }
        return call2(arr,0,s.length-1);
    }
    public TreeNode call2(int[] arr, int s1, int e1)
    {
        if(s1>e1)
            return null;
        if(s1==e1)
            return new TreeNode(arr[s1]);
        TreeNode temp = new TreeNode(arr[s1]);
        for(int j=s1+1;j<=e1;j++)
            if(arr[j]>arr[s1])
            {
                TreeNode l =call2(arr,s1+1,j-1);
                TreeNode r = call2(arr,j,e1);
               // System.out.println(l.val+" "+r.val);
                           temp.left = l;
                temp.right = r;
               return temp;
            }       
        temp.left = call2(arr,s1+1,e1);
        return temp;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;