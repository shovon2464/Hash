//beware of the selection of the first string to put it in the array

public class Permuation2 {
    public static boolean isPermutation(String s, String t){
        //if their lenghts are different then they are not permutations
        int [] char_set = new int [128];
        //counting the number of each character in ASCII
        for(int i=0;i<s.length();i++){
            int c = s.charAt(i);
            char_set[c]++;
        }
        for(int i=0;i<t.length();i++){
            int c = t.charAt(i);
            char_set[c]--;
            //there's no way the value will go into negative if they are permuation
            if(char_set[c]<0){
                return false;
            }
        }
        return true;
    }
    public static void main(String [] args){
        String s = "xebt";
        String t = "xeb";
        System.out.println(isPermutation(s,t));
    }
}
