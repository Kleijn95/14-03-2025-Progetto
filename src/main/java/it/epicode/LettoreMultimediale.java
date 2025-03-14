package it.epicode;

import it.epicode.classi.ElementoMultimediale;
import it.epicode.classi.Immagine;
import it.epicode.classi.RegistrazioneAudio;
import it.epicode.classi.Video;
import it.epicode.enums.LimitiVolume;
import it.epicode.interfacce.Riproducibile;

import java.util.Scanner;

public class LettoreMultimediale {
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\033[1m";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu di benvenuto
        System.out.println("Benvenuto nel Lettore Multimediale!");
        System.out.println("Sarà possibile inserire 5 elementi multimediali.");
        System.out.println("Seleziona l'elemento da inserire (Immagine, Audio, Video) seguendo le istruzioni.");

        ElementoMultimediale[] elementi = new ElementoMultimediale[5];


        for (int i = 0; i < elementi.length; i++) {
            System.out.println("\nInserimento elemento " + (i + 1) + " di 5");

            System.out.println("Inserisci il tipo di elemento (1 - Immagine, 2 - Audio, 3 - Video): ");
            int tipo = -1;


            while (tipo < 1 || tipo > 3) {
                tipo = scanner.nextInt();
                if (tipo < 1 || tipo > 3) {
                    System.out.println(BOLD + RED +"Errore! Inserisci un numero tra 1 e 3. (Inserendo qualcosa che non sia un numero il programma crasherà)" + RESET
                    );
                }
            }

            scanner.nextLine();

            System.out.print("Inserisci il titolo: ");
            String titolo = scanner.nextLine();

            if (tipo == 1) {
                int luminosita = -1;

                while (luminosita < 0 || luminosita > 100) {
                    System.out.print("Inserisci il valore della luminosità (0-100): ");
                    luminosita = scanner.nextInt();
                    if (luminosita < 0 || luminosita > 100) {
                        System.out.println(BOLD +RED + "Errore! La luminosità deve essere tra 0 e 100." + RESET
                        );
                    }
                }
                elementi[i] = new Immagine(titolo, luminosita);
                System.out.println(BOLD +GREEN + "Hai inserito correttamente un'immagine con nome " + titolo + " e con luminosità " + luminosita + "/100!" + RESET
                );

            } else if (tipo == 2) {
                int durata = -1;
                int volume = -1;

                while (durata <= 0) {
                    System.out.print("Inserisci la durata (in secondi): ");
                    durata = scanner.nextInt();
                    if (durata <= 0) {
                        System.out.println(BOLD +RED + "Errore! La durata deve essere un valore positivo." + RESET
                        );
                    }
                }

                while (volume < LimitiVolume.MIN.getValore() || volume > LimitiVolume.MAX.getValore()) {
                    System.out.print("Inserisci il volume (0-10): ");
                    volume = scanner.nextInt();
                    if (volume < LimitiVolume.MIN.getValore() || volume > LimitiVolume.MAX.getValore()) {
                        System.out.println(BOLD +RED+ "Errore! Il volume deve essere tra 0 e 10." + RESET
                        );
                    }
                }

                elementi[i] = new RegistrazioneAudio(titolo, durata, volume);
                System.out.println(BOLD +GREEN + "Hai inserito correttamente un audio con nome " + titolo + " con durata " + durata + " secondi e volume " + volume + "/10!" + RESET
                );

            } else if (tipo == 3) {
                int durata = -1;
                int volume = -1;
                int luminosita = -1;

                while (durata <= 0) {
                    System.out.print("Inserisci la durata (in secondi): ");
                    durata = scanner.nextInt();
                    if (durata <= 0) {
                        System.out.println(BOLD +RED + "Errore! La durata deve essere un valore positivo." + RESET
                        );
                    }
                }

                while (volume < LimitiVolume.MIN.getValore() || volume > LimitiVolume.MAX.getValore()) {
                    System.out.print("Inserisci il volume (0-10): ");
                    volume = scanner.nextInt();
                    if (volume < LimitiVolume.MIN.getValore() || volume > LimitiVolume.MAX.getValore()) {
                        System.out.println(BOLD +RED + "Errore! Il volume deve essere tra 0 e 10." + RESET
                        );
                    }
                }

                while (luminosita < 0 || luminosita > 100) {
                    System.out.print("Inserisci la luminosità (0-100): ");
                    luminosita = scanner.nextInt();
                    if (luminosita < 0 || luminosita > 100) {
                        System.out.println(BOLD +RED + "Errore! La luminosità deve essere tra 0 e 100." + RESET
                        );
                    }
                }

                elementi[i] = new Video(titolo, durata, volume, luminosita);
                System.out.println(BOLD +GREEN + "Hai inserito correttamente un video con nome " + titolo + " con durata " + durata + " secondi, volume " + volume + "/10 e luminosità " + luminosita + "/100!" + RESET
                );
            }

            System.out.println(BOLD +GREEN + "Inserimento completato. " + (5 - (i + 1)) + " inserimenti rimanenti." + RESET
            );
            scanner.nextLine();
        }

        // Ciclo per eseguire gli elementi
        while (true) {
            System.out.println("\nSeleziona un elemento multimediale da riprodurre (1-5) o 0 per terminare il programma: ");
            int scelta = scanner.nextInt();

            if (scelta == 0) {
                System.out.println("Programma terminato.");
                break;
            }

            if (scelta >= 1 && scelta <= 5) {
                ElementoMultimediale elemento = elementi[scelta - 1];
                if (elemento instanceof Immagine) {
                    ((Immagine) elemento).show();
                } else {
                    ((Riproducibile) elemento).play();
                }
            } else {
                System.out.println(BOLD +RED + "Scelta non valida, riprova." + RESET
                );
            }
        }

        scanner.close();
    }
}
