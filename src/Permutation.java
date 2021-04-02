import java.util.Arrays;
public class Permutation {
    public static boolean isPermutation(String s, String t){
        char [] contentS = s.toCharArray();
        char [] contentT = t.toCharArray();
        Arrays.sort(contentS);
        Arrays.sort(contentT);
        if (s.length() != t.length()){
            return false;
        }
        if (s.equals(t)){
            return false;
        }
        return true;
    }
    public static void main(String [] args){
        String s = "btex";
        String t = "xetb";
        System.out.println(isPermutation(s,t));
    }
}
