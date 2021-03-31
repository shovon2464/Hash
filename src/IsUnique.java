import java.util.HashSet;

public class IsUnique {
    public static void main(String [] args){
        String test = "Shovn";
        HashSet<Character> testSet = new HashSet<Character>();
        for(int i=0; i<test.length();i++){
            if(testSet.contains(test.charAt(i))){
                System.out.println("Yes");
            }
            else{
                testSet.add(test.charAt(i));
            }
        }
        System.out.println("No");
    }
}
