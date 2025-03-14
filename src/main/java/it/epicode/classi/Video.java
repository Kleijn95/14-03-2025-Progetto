package it.epicode.classi;

import it.epicode.enums.LimitiLuminosita;
import it.epicode.enums.LimitiVolume;
import it.epicode.interfacce.Luminosita;
import it.epicode.interfacce.Riproducibile;
import it.epicode.interfacce.Volume;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Video extends ElementoMultimediale implements Riproducibile, Volume, Luminosita {
    public int durata;
    public int volume;
    public int luminosita;

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo);
        this.durata = durata;
        this.volume = Math.max(LimitiVolume.MIN.getValore(), Math.min(volume, LimitiVolume.MAX.getValore()));
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
@Override
    public void alzaVolume() {
        if (volume < LimitiVolume.MAX.getValore()) {
            volume++;
        }
        else System.out.println("Il volume e' gia' al massimo");
    }
@Override
    public void abbassaVolume() {
        if (volume > LimitiVolume.MIN.getValore()) {
            volume--;
        }
        else System.out.println("Il volume e' gia' al minimo");
    }
@Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo+ "!".repeat(volume) + "*".repeat(luminosita));

        }
    }
}
