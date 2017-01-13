class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
       String testString="AAABBB";
        System.out.print("Minimum deletions count is " + countDeletions(testString));
        
        
    }
    
    public static int countDeletions(String str) {
        int deletionsCount = 0;
        
       for (int i=0; i<str.length()-1; i++)
        {
            if (str.charAt(i)==str.charAt(i+1)) deletionsCount++;
        }
        return deletionsCount;
    }
}
