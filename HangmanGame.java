package org.example;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) {


    String[] words = {"morgana", "linda", "diogo", "feio"};
    //sorteador
    Random random = new Random();
    String letterUsed = "";
    int wordLength = words.length;
    Scanner keyboard = new Scanner(System.in);
    int sortIndex = random.nextInt(wordLength); //indice sorteado
    String sort = words[sortIndex];//palavra sorteada

    char[] acertos = new char[sort.length()];
        for (int i = 0; i < acertos.length; i++) {
        acertos[i] = 0;
    }
    char letter;
    boolean win = false;
    int lifes = sort.length();

        for (int i = 0; i < sort.length(); i++) {
        System.out.print(" _ ");
    }
        System.out.println("\n");
        do {
        System.out.println("\n" + "You have " + lifes + " lifes " + "\nLetters used: " + letterUsed + "\nType a letter:");
        letter = keyboard.next().toLowerCase().charAt(0);
        letterUsed += " " + letter;

        boolean lostLife = true;
        for (int i = 0; i < sort.length(); i++) {
            if (letter == sort.charAt(i)) {
                //  System.out.println("Have this letter on position " + i);
                acertos[i] = 1;
                lostLife = false;
            }
        }
        if (lostLife) {
            lifes--;
        }
        System.out.println("\n");
        win = true;
        for (int i = 0; i < sort.length(); i++) {
            if (acertos[i] == 0) {
                System.out.print(" _ ");
                win = false;
            } else {
                System.out.print(" " + sort.charAt(i) + " ");
            }
        }
        System.out.println("\n");
    } while (!win && lifes > 0);

        if (lifes != 0) {
        System.out.println("\nCongratulations!");
    } else {
        System.out.println("\nGame Over!");
        System.out.println("The word is: " + sort);
    }
}
}
//https://www.youtube.com/live/g2E4NbDKtxU?si=WJln3JGB_7NEoBe7
