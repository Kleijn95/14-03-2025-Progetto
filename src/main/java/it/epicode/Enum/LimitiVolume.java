package it.epicode.Enum;

import lombok.Getter;

@Getter
public enum LimitiVolume {
    MAX(10), MIN(0);

    private final int valore;

    LimitiVolume(int valore) {
        this.valore = valore;
    }
}
