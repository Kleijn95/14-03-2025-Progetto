package it.epicode.test;

import it.epicode.classi.Immagine;

import java.util.Scanner;

public class TestImmagine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Test Immagine");

        Immagine immagine = new Immagine("Paesaggio", 5);
        immagine.show();

        scanner.close();
    }
}
