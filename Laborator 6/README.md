Homework 6:

Am implementat modul direct pentru crearea si afisarea tablei de joc
Am initializat jocul generând stick-uri aleatorii pe care le-am plasat pe tablă. Stick-urile au fost salvate ca si muchii intr-un graf, ale carui noduri sunt intersectiile.

Am implemetat logica jocului folosindu-ma de o matrice de tip bool, care ma ajuta sa cunosc intersectiile colorate.M-am folosit de metoda isAdjacent pentru a verifica daca colorarea anterioara este adiacenta (am stick intre intersectii) cu colorarea pe care vreau sa o fac. M-am folosit de metoda isNode pentru a verifica daca locul unde vreau sa colorez este intr-o intersectie si nu pe muchii sau in patratelele formate, dar si pentru a verifica daca nu cumva am mai colorat aceeasi intersectie. Când jucătorul apasa cu mouse-ul , o piatră trebuie să fie desenată în locația mouse-ului: roșu sau albastru, în funcție de rândul cui este.M-am folosit de o variabila player pentru a sti randul carui jucator este. Functia isWinner face toate verificarile pentru a afisa castigatorul cand nu mai exista mutari posibile care sa respecte regulile.

Putem crea o tabla de dimensiune noua schimband dimensiunile din partea de sus a paginii de joc si apasand butonul "create"

Am exportat imaginea curentă a tablei de joc într-un fișier PNG.Imaginea tablei se salveaza atunci cand apasam butonul "save".

Am utilizat serializarea obiectelor pentru a salva starea curentă a jocului.Aceasta se realizeaza apasand butonul "load"
