public class Palindrome2 {
    public static boolean isPalindrome(String str){
        int count = 0;
        for (int i=0;i<str.length();i++){
            int val = str.charAt(i)-'a';
            if(val<0){
               continue;
            }
            if((count & (1<<val)) > 0){
                int temp = ~(1<<val);
                count &= temp;
            }
            else{
                count |= (1<<val);
            }
        }
        if((count & (count-1)) == 0){
            return true;
        }
        return false;
    }
    public static void main(String [] args){
        String str = "taco cat";
        System.out.println(isPalindrome(str));
    }
}
