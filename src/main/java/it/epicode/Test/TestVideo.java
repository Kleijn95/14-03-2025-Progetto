package it.epicode.Test;

import it.epicode.Enum.LimitiLuminosita;
import it.epicode.Enum.LimitiVolume;
import it.epicode.Classi.Video;
import java.util.Scanner;

public class TestVideo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Video video = new Video("Film", 5, 5, 50);
        video.play();  // Esegui il video


        System.out.print("Inserisci un nuovo valore di volume (0-10): ");
        int nuovoValoreVolume = scanner.nextInt();
        if (nuovoValoreVolume >= LimitiVolume.MIN.getValore() && nuovoValoreVolume <= LimitiVolume.MAX.getValore()) {
            video = new Video("Film", video.getDurata(), nuovoValoreVolume, video.getLuminosita());
        } else {
            System.out.println("Valore volume non valido. Deve essere tra 0 e 10.");
        }


        System.out.print("Inserisci un nuovo valore di luminosità (0-100): ");
        int nuovaLuminosita = scanner.nextInt();
        if (nuovaLuminosita >= LimitiLuminosita.MIN.getValore() && nuovaLuminosita <= LimitiLuminosita.MAX.getValore()) {
            video = new Video("Film", video.getDurata(), video.getVolume(), nuovaLuminosita);
        } else {
            System.out.println("Valore luminosità non valido. Deve essere tra 0 e 100.");
        }


        System.out.print("Inserisci una nuova durata (in secondi): ");
        int nuovaDurata = scanner.nextInt();
        if (nuovaDurata >= 0) {
            video = new Video("Film", nuovaDurata, video.getVolume(), video.getLuminosita());
        } else {
            System.out.println("Durata non valida. Deve essere un numero positivo.");
        }

        video.play();

        scanner.close();
    }
}
