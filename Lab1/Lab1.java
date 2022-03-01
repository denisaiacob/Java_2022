package com.company;

public class Lab1 {
    public static void main(String[] args) {
        Lab1 lab1 = new Lab1();
        lab1.compulsory();
        lab1.homework(args);
    }

    void compulsory() {
       /* System.out.println("Hello World");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);
        System.out.println( "Numarul generat:" + n );
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
        System.out.println( "Willy-nilly, this semester I will learn " + languages[n]);
*/

    }

    private String createRandomWord(int len,char[] alphabet){
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int k = (int) (Math.random() * alphabet.length);
            word.append(alphabet[k]);
        }//generam pana la dimensiunea data cate o litera randoom din alfabet
        return word.toString();
    } //functia apelata pentru generarea cuvintelor

    void homework(String[] args) {

        Lab1 app = new Lab1();
        long t1 = System.nanoTime(); //de aici incepem masurarea timpului de executie

        if (args.length < 3) {
            System.out.println("Not enough arguments!");
            System.exit(-1);
        } //am verificat daca avem suficiente argumente

        int n = Integer.parseInt(args[0]); //atribuim lui n primul argument
        int p = Integer.parseInt(args[1]); //atribuim lui p al doilea argument
        int m = args.length - 2; // atribuim lui m dimensiunea alfabetului care este lungimea sirului citit -n-p
        char[] alphabet = new char[m];
        for (int i = 0; i < m; i++) {
            alphabet[i] = args[i + 2].charAt(0);} //am citit alfabetul
        System.out.println("\n");
        String[] words = new String[n]; // vectorul pentru cuvinte
        for (int j = 0; j < n; j++) {
            words[j] = app.createRandomWord(p, alphabet);
            System.out.println(words[j]);
        } //generam random cuvintele

        boolean[][] neighbors = new boolean[n][n]; //matricea de adiacenta
       int ok;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) { // luam primul cuvant si il verificam cu toate celelalte cuvinte
                ok=0;
                for (int k = 0; k < m; k++) { // cautam fiecare litera din alfabet atat in ccuvantul i cat si in cuvantul j
                    if (words[i].indexOf(alphabet[k]) != -1 && words[j].indexOf(alphabet[k]) != -1) {
                            if (ok == 0) { // daca litera se gaseste in ambele cuvinte si suntem la prima litera comuna adaugam adiacenta
                                neighbors[i][j] = true;
                                ok = 1;
                            }
                    }
                    else {
                            if (ok == 0) { // daca nu avem potrivire nici acum si nici anterior atunci false
                                neighbors[i][j] = false;
                            }
                    }
                }
            }
        }

        String[] aNeighbors = new String[n]; // vectorul de vecini
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(neighbors[i][j]==true){ //pentru fiecare adiacenta
                    if(i!=j) { // daca sunt cuvinte diferite
                        if (aNeighbors[i] == null) { // daca suntem la primul vecin
                            aNeighbors[i] = words[j]; // il adaugam in vector la pozitia cuvantului
                            aNeighbors[i] += " "; // concatenam un spatiu
                        } else { // daca nu suntem la primul vecin
                            aNeighbors[i] += words[j]; // concatenam noul vecin
                            aNeighbors[i] += " ";
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Vecinii cuvantului " + words[i] + " sunt: " + aNeighbors[i]);
        }// afisam pentru fiecare cuvant vecinii

         long t2 = System.nanoTime();// aici se sfarseste masurarea timului de executie
         System.out.println("\n" + "Timpul de executie in nanaosecunde:" + (t2 - t1)); // afisam timpul de executie in nanosecunde

      //////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////BONUS///////////////////////////////////////////////////////


    }
}

