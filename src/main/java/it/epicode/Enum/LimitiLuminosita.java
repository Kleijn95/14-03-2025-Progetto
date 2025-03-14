package it.epicode.Enum;

import lombok.Getter;

@Getter
public enum LimitiLuminosita {
    MAX(100), MIN(0);

    private final int valore;

    LimitiLuminosita(int valore) {
        this.valore = valore;
    }

}

