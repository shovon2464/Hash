public class Palindrome1 {
    public static boolean isPalindrome(String str){
        int [] table  = makeFrequencyTable(str);
        return maxOdd(table);
    }
    //count the max number of odd
    public static boolean maxOdd(int [] table){
        int odd = 0;
        for (int i=0;i<table.length;i++){
            //checking if the value of the array index is odd
            if(table[i]%2==1){
                odd ++;
            }
        }
        if(odd>2){
            return false;
        }
        return true;
    }

    // count how many times each character appears
    public static int [] makeFrequencyTable(String str){
        char [] char_set = str.toCharArray();
        int [] table = new int [26];
        for(int i=0;i<str.length();i++){
            int index = Character.getNumericValue(char_set[i]);
            if (index>=97 && index<=122){
                table[index] ++;
            }
        }
        return table;
    }
    public static void main(String [] args){
        String str = "Tact Coa";
        System.out.println(isPalindrome(str));
    }
}

