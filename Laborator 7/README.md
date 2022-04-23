Homework 7:


Am pus atat numarul de puncte cat si numarul de litere in doi vectori, iar cu ajutorul acestora am creat o lista si un map.
   
Am creat un dictionar citind cuvintele dintr-un fisier "words.txt" pe care le-am salvat intr-o lista de cuvinte. Cuvintele sunt salvate cu majuscule deoarce fiecare jucator va trebui sa introduca cuvinte de la tastatura folosind majuscule dupa care se va face o verificare a caracterelor introduse astfel incat acestea sa se regaseasca in cele extrase. Daca cel putin un caracter nu face parte din cele extrase atunci trebuie introdus un alt cuvant.

Pentru fiecare cuvant corect introdus se va verifica daca acesta se afla in dictionar, iar daca da se va face o suma a punctelor pentru fiecare litera si se va inmulti cu lungimea cuvantului introdus. Aceasta punctaj se va adauga la punctajul deja existent al jucatorului.Daca cuvantul nu se afla in dictionar punctajul va ramane neschimbat. La final, dupa ce nu mai avem litere (lista si map-ul devin goale) se va apela functia ce va afisa castigatorul(jucatorul cu cel mai mare punctaj)

Am implementat un thread de cronometrare de tip daemon ce va afisa la inceput durata jocului si va opri jocul dupa expirarea timpului.