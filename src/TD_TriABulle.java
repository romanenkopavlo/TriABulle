import clavier.In;

import java.util.Random;

public class TD_TriABulle {
    static int [] numbers;
    static int[] originalNumbers;
    static int buffer;
    static int amount_of_numbers = 0;
    static int amount_of_lines = 0;
    static boolean sorted = false;
    static Random rd = new Random();
    public static void main(String[] args) {
        int choix = 0;
        String array_name = null;

        System.out.print("Entrez le nombre de numeros par ligne: ");
        amount_of_numbers = In.readInteger();

        System.out.print("Entrez le nombre de lignes: ");
        amount_of_lines = In.readInteger();

        numbers = new int[amount_of_numbers * amount_of_lines];
        originalNumbers = new int[amount_of_numbers * amount_of_lines];


        fill_array();
        copyOriginalArray();


        while (choix != 4) {
            System.out.println("...Classement...");
            System.out.print("Le tableaux non trie:\n");
            display_array();
            System.out.println("\nPour classer par ordre croissant entrez 1");
            System.out.println("Pour classer par ordre decroissant entrez 2");
            System.out.println("Pour generer un nouveau tableau entrez 3");
            System.out.println("Pour sortir de programme entrez 4");
            System.out.print("Votre choix: ");
            choix = In.readInteger();

            switch (choix) {
                case 1:
                    increased_order_sorting();
                    array_name = "croissant";
                    break;
                case 2:
                    decreased_order_sorting();
                    array_name = "decroissant";
                    break;
                case 3:
                    fill_array();
                    copyOriginalArray();
                    break;
                case 4:
                    System.out.print("Exit from a programme");
                    break;
            }

            if (choix != 3 && choix != 4) {
                display_changes();
                System.out.print("Le tableau classe par ordre " + array_name + " est:\n");
                display_array();
                restoreOriginalArray();
                System.out.print("\n");
                System.out.print("\n");
            }
        }
    }

    public static void fill_array() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rd.nextInt(1, 90);
        }
    }

    public static void display_array() {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
            if ((i + 1) % amount_of_numbers == 0) {
                System.out.print("\n");
            }
        }
    }
    public static void increased_order_sorting() {
        for (int i = 0; i < numbers.length - 1 && !sorted; i++) {
            sorted = true;
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    buffer = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = buffer;
                    sorted = false;
                }
            }
        }
        sorted = false;
    }

    public static void decreased_order_sorting() {
        for (int i = numbers.length - 1; i > 0 && !sorted; i--) {
            sorted = true;
            for (int j = numbers.length - 1; j > 0; j--) {
                if (numbers[j] > numbers[j - 1]) {
                    buffer = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = buffer;
                    sorted = false;
                }
            }
        }
        sorted = false;
    }

    public static void display_changes() {
        System.out.println("Les changements: ");
        for (int i = 0; i < originalNumbers.length; i++) {
            System.out.println(originalNumbers[i] + " => " + numbers[i]);
        }
    }
    public static void copyOriginalArray() {
        for (int i = 0; i < numbers.length; i++) {
            originalNumbers[i] = numbers[i];
        }
    }
    public static void restoreOriginalArray() {
        for (int i = 0; i < originalNumbers.length; i++) {
            numbers[i] = originalNumbers[i];
        }
    }
}