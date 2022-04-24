package Hangman;
import java.util.Scanner;
import java.util.*;
public class Hangman {
    public static String[] words = {"terminator", "banana", "computer", "cow", "rain", "water","kids" };
    public static String word = words[(int) (Math.random() * words.length)];
    public static  Set<String> track = new LinkedHashSet<>();
    public static String question = new String(new char[word.length()]).replace("\0", "?");
    public static int count=0;
    public static int check=0;
    public static StringBuilder myName = new StringBuilder(question);
    public static void printMenu() {
        System.out.println(" * menu *");
        System.out.println("quit   - quits the game");
        System.out.println("status  - prints the game status");
        System.out.println("a single letter uses the letter as a guess");
        System.out.println("menu   - prints this menu");
    }
    public static boolean gameOn(){
        return true;
    }
    public static void printStatus(){
        if (track.isEmpty()){
            System.out.println("You have not made any guesses yet.");
            System.out.println("Unused letters: abcdefghijklmnopqrstuvwxyz");
        }
        else {
            System.out.println("letters used: ");
            System.out.println(track);
        }
    }
    public static void printWord(String letter){
        for (int i=0;i<word.length();i++){
            if(word.charAt(i)==letter.charAt(0)){
                myName.setCharAt(i,letter.charAt(0));
            }
        }
        System.out.println("word: "+myName);
    }
    public static void printMan(String letter){
        if (count == 1) {
            System.out.println("Wrong guess, try again");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("___|___");
            System.out.println();
        }
        if (count == 2) {
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 3) {
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
        }
        if (count == 4) {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 5) {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 6) {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
        if (count == 7) {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }

    }
    public static void guess(String letter){
        track.add(letter);
        for (int i=0;i<word.length();i++){
            if(word.charAt(i)==letter.charAt(0)){
                check=1;
            }

        }
        if(check==1){
            System.out.println("The letter "+ letter + " was found in the word!");
        }
        else {
            System.out.println("The letter "+ letter + " is not in the word!");
            count++;
            System.out.println("you have "+ (7-count)+" tries left!");

        }
        check=0;
    }

    public static void main(String[] args) {
        System.out.println(word);
        Scanner reader = new Scanner(System.in);
        Hangman hangman = new Hangman();
        System.out.println("************");
        System.out.println("* Hangman *");
        System.out.println("************");
        System.out.println("");
        printMenu();
        while (hangman.gameOn()) {
            String command = reader.nextLine();

            if (command.equals("quit") || ((7-count)==0)){
                System.out.println("Thank you for playing!");
                System.out.println("GAME OVER! The word was " + word);
                break;
            }
            else if(command.equals("status")){
                hangman.printStatus();
            }
            else if (command.equals("menu")){
                printMenu();
            }
            else if (command.length()==1)
            {
                hangman.guess(command);
                hangman.printWord(command);
                hangman.printMan(command);
            }
            else{
                System.out.println("Wrong command: See menu for description");
            }

        }
        System.out.println("");


    }
}
