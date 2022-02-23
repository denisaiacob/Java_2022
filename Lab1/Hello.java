package com.company;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello World");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);
        System.out.println( "\nNumarul generat:" + n );
        n = n * 3;
        System.out.println( n );  // am afisat n la fiecare pas pentru a verifica corectitudinea operatiilor
        n = n + 0b10101;
        System.out.println( n );
        n = n + 0xFF;
        System.out.println( n );
        n = n * 6;

        System.out.println( n );

        while (n > 9 )
        {
            int s = 0;
            while( n > 0 )
           {
            s = s + n % 10;
            n = n / 10;
           }
            n = s;

        }
        System.out.println( n );
        System.out.println("\n");
        System.out.println( "Willy-nilly, this semester I will learn " + languages[n]);


    }

}
