package com.xml.study.hello;

public class Main {

    public static void main(String[] args) {
        Hello h = new Hello();
        h.make( "Bonjour, madame", "fr" );
        h.make( "Hey, you", "en" );
        h.marshal();
    }
}
