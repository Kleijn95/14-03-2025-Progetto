package it.epicode.classi;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class ElementoMultimediale {
    protected String titolo;

    public ElementoMultimediale(String titolo) {
        this.titolo = titolo;
    }

}
