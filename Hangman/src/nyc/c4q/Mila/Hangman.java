package nyc.c4q.Mila;

import java.util.Scanner;

/**
 * Created by Millochka on 8/30/16.
 */
public class Hangman {
    private final SecretWord mSecretWord;
    private char mLastGuess;
    private int mMisses = 0;
    public static boolean yes;

    public enum Answer{

        YES,
        NO,
        N,
        Y;

        static Answer fromAnswer(String userAnswer){
            Answer[] answer= Answer.values();
            for(int i=0;i<answer.length;i++){
                if(userAnswer.equalsIgnoreCase(answer[i].name())){
                    return answer[i];
                }
            }
            return null;
        }

    }

    public Hangman(){
        mSecretWord = new SecretWord();
    }


    public int getMisses(){
        return mMisses;
    }
    private void readLetter() {
        Scanner scanner = new Scanner(System.in);
        char input = scanner.next().charAt(0);
        mLastGuess = Character.toUpperCase(input);
    }

    private void promptPlayer(String string) {
        System.out.println(string);
    }

    private boolean checkLetter() {
        if (mSecretWord.isLetter(mLastGuess)) {
            // If letter is in word do something
            mSecretWord.set(mLastGuess);
            return true;
        } else {
            mMisses++;
            return false;
        }
    }

    private void printCurrentWord(){
        System.out.println(mSecretWord);
    }


    public static void main(String[] args) {
        yes=true;
        while (yes){
            Hangman hangman = new Hangman();
            while (hangman.getMisses() < 5) {
                hangman.printCurrentWord();
                hangman.promptPlayer("Enter a letter: ");
                hangman.readLetter();
                hangman.checkLetter();
                if (hangman.guessedSuccessfully()) {
                    break;
                }
                System.out.println(Drawing.get(hangman.getMisses()));
                System.out.println("Misses -> " + hangman.getMisses());
            }
            if (hangman.guessedSuccessfully()) {
                System.out.println("Success");
            } else {
                System.out.println("The answer was " + hangman.getSecretWord());
            }

            yes = askToPlay();
        }
    }

    public static boolean askToPlay(){
        System.out.println("Do you want to play again?");
        Scanner scanner = new Scanner(System.in);
        Answer userAnswer = Answer.fromAnswer(scanner.next());
        while(userAnswer==null){
            System.out.println("Ops....I am afraid I don't understand your answer. Please type yes or no");
            userAnswer = Answer.fromAnswer(scanner.next());
        }
        switch (userAnswer){
            case Y: case YES:
                return true;
            case N: case NO:
                return false;


        }

        return false;
    }

//    public static boolean askToPlay(){
//
//        System.out.println("Do you want to play again?");
//        Scanner scanner = new Scanner(System.in);
//        String userAnswer = scanner.next();
//        boolean answer =!userAnswer.toLowerCase().equalsIgnoreCase("yes") && !userAnswer.toLowerCase().equalsIgnoreCase("y") && !userAnswer.toLowerCase().equalsIgnoreCase("no") && !userAnswer.toLowerCase().equalsIgnoreCase("n");
//        while(answer){
//            System.out.println("Ops....I am afraid I don't understand your answer. Please type yes or no");
//            userAnswer = scanner.next();
//            answer =!userAnswer.toLowerCase().equalsIgnoreCase("yes") && !userAnswer.toLowerCase().equalsIgnoreCase("y") && !userAnswer.toLowerCase().equalsIgnoreCase("no") && !userAnswer.toLowerCase().equalsIgnoreCase("n");
//        }
//
//        if(userAnswer.equalsIgnoreCase("yes")||userAnswer.equalsIgnoreCase("y")){
//       return true; }else {return  false;}
//    }

    private String getSecretWord() {
        return mSecretWord.reveal();
    }

    private boolean guessedSuccessfully() {
        return mSecretWord.isGuessed();
    }
}
