package it.epicode.test;

import it.epicode.enums.LimitiVolume;
import it.epicode.classi.RegistrazioneAudio;
import java.util.Scanner;

public class TestRegistrazioneAudio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        RegistrazioneAudio audio = new RegistrazioneAudio("Musica", 3, 5);
        audio.play();


        System.out.print("Inserisci un nuovo valore di volume (0-10): ");
        int nuovoValoreVolume = scanner.nextInt();
        if (nuovoValoreVolume >= LimitiVolume.MIN.getValore() && nuovoValoreVolume <= LimitiVolume.MAX.getValore()) {
            audio = new RegistrazioneAudio("Musica", 3, nuovoValoreVolume);
        } else {
            System.out.println("Valore volume non valido. Deve essere tra 0 e 10.");
        }


        System.out.print("Inserisci una nuova durata (in secondi): ");
        int nuovaDurata = scanner.nextInt();
        if (nuovaDurata >= 0) {
            audio = new RegistrazioneAudio("Musica", nuovaDurata, nuovoValoreVolume);
        } else {
            System.out.println("Durata non valida. Deve essere un numero positivo.");
        }

        audio.play();

        scanner.close();
    }
}
