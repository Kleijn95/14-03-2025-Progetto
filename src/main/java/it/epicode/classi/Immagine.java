package it.epicode.classi;

import it.epicode.enums.LimitiLuminosita;
import it.epicode.interfacce.Luminosita;
import lombok.Getter;
import lombok.ToString;

import java.util.Scanner;

@Getter
@ToString
public class Immagine extends it.epicode.classi.ElementoMultimediale implements Luminosita {
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = Math.max(LimitiLuminosita.MIN.getValore(), Math.min(luminosita, LimitiLuminosita.MAX.getValore()));
    }

    @Override
    public void alzaLuminosita() {
        if (luminosita < LimitiLuminosita.MAX.getValore()) {
            luminosita++;
        }
        else System.out.println("La luminosita' e' gia' al massimo");
    }

    @Override
    public void abbassaLuminosita() {
        if (luminosita > LimitiLuminosita.MIN.getValore()) {
            luminosita--;
        }
        else System.out.println("La luminosita' e' gia' al minimo");
    }

    public void show() {

        System.out.println("Immagine: " + titolo + "*".repeat(luminosita));
        System.out.println("Luminosità attuale: " + luminosita + "/100");

        // Chiedo all'utente se vuole modificare la luminosità
        Scanner scanner = new Scanner(System.in);
        System.out.print("Vuoi modificare la luminosità? (si/no): ");
        String risposta = scanner.nextLine();
        if (risposta.equalsIgnoreCase("si")) {
            System.out.print("Di quanto vuoi modificare la luminosità? (inserisci un numero positivo per aumentare, negativo per abbassare): ");
            int cambioLuminosita = scanner.nextInt();


            if (cambioLuminosita > 0) {
                for (int i = 0; i < cambioLuminosita; i++) {
                    alzaLuminosita();
                }
            } else if (cambioLuminosita < 0) {
                for (int i = 0; i < -cambioLuminosita; i++) {
                    abbassaLuminosita();
                }
            }

            System.out.println("Nuova luminosità: " + luminosita + "/100");

            System.out.println("Immagine: " + titolo + "*".repeat(luminosita));
        }
    }}
