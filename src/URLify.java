public class URLify {
    public static String doURLify(String str, int trueLength){
        //converting the string into char array
        char [] str_arr = str.toCharArray();

        int spaceCount = 0;
        //counting the number of spaces;
        for(int i=0;i<trueLength;i++){
            if(str_arr[i] == ' '){
                spaceCount +=1;
            }
        }
        int index = trueLength + spaceCount*2;
        //mention the end of string
        if(trueLength<str_arr.length){
            str_arr[trueLength] = '\0';
        }
        //inserting those characters by traversing the char array from the back
        for(int i=trueLength-1; i>=0;i--){
              if(str_arr[i] == ' '){
                  str_arr[index-1] = '0';
                  str_arr[index-2] = '2';
                  str_arr[index-3] = '%';
                  index -=3;
              }
              else{
                  str_arr[index-1] = str_arr[i];
                  index -=1;
              }
        }
        System.out.println(str_arr);
        return str_arr.toString();

    }
    public static void main(String [] args){
        System.out.println(doURLify("Mr John Smith    ",13));
    }
}
