public class IsUnique3 {
    public static boolean isUniqueChars(String str){
        //assume that the strings are only using lowercase letters
        int checker = 0;
        for(int i=0;i<str.length();i++){
            int val = str.charAt(i) - 'a';
            /*
            00000000000000000000000000000001 a 2^0

            00000000000000000000000000000010 b 2^1

            00000000000000000000000000000100 c 2^2

            00000000000000000000000000001000 d 2^3
             */
            if((checker & (1 << val)) > 0 ) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
    public static void main(String [] arg){
        String str = "Shovon";
        System.out.println(isUniqueChars(str));
    }
}
