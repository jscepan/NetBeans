package com.mycompany.lambdaizrazi;

@FunctionalInterface
public interface SabiranjeDvaBroja {

    //moze i ovako ali je bitno da ima samo JEDNU apstraktnu metodu
    public int saberi(int x, int y);

    default int poziv(int a, int b) {
        return saberi(a, b);
    }
}
