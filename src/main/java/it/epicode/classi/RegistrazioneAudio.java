package it.epicode.classi;

import it.epicode.enums.LimitiVolume;
import it.epicode.interfacce.Riproducibile;
import it.epicode.interfacce.Volume;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RegistrazioneAudio extends ElementoMultimediale implements Riproducibile, Volume {
    private int durata;
    private int volume;

    public RegistrazioneAudio(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = Math.max(LimitiVolume.MIN.getValore(), Math.min(volume, LimitiVolume.MAX.getValore()));
    }
@Override
    public void abbassaVolume() {
        if (volume > LimitiVolume.MIN.getValore()) {
            volume--;
        }
        else System.out.println("Il volume e' gia' al minimo");
    }
@Override
    public void alzaVolume() {
        if (volume < LimitiVolume.MAX.getValore()) {
            volume++;
        }
        else System.out.println("Il volume e' gia' al massimo");
    }
@Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo+ "!".repeat(volume));

        }
    }

}
