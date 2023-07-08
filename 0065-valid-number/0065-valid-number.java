class Solution {
    public boolean isNumber(String str) {
        if(str.toLowerCase().equals("infinity") ||str.toLowerCase().equals("-infinity") ||str.toLowerCase().equals("+infinity"))
            return false;
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(Character.isLetter(ch) && ch!='e' && ch !='E')
                return false;
        }
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
}