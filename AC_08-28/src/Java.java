import java.util.Scanner;

/**
 * Created by Millochka on 8/29/16.
 */
public class Java {


    public static  void printHashtag(String tweet){
        Scanner scanner = new Scanner(tweet);
        while(scanner.hasNext()){
            String word = scanner.next();
            if(word.charAt(0)=='@' || word.charAt(0)=='#'){
                System.out.println(word);
            }
        }

    }

    public static void main(String[] args) {
        //Student student = new Student("Mila");

        printHashtag("@MMViverito @C4QNYC @PerScholas launch task force on diversity, inclusion & equity in NYC's tech sector http://bit.ly/2bcfygs #NYCCLabs #GynaWedding");
    }
}




