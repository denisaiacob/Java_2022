Homework 4:
Am creat o clasă care descrie orașul.
Am afisat toate străzile care sunt mai lungi decât o valoare specificată data ca parametru și unește cel puțin 3 străzi.
In main am facut o functie cu care am generat nume false aleatorii pentru intersecții și străzi folosind java Faker.
Am utilijat JGraphT pentru a crea graful(functia createGraph din Main), dupa care cu ajutorul algoritmului lui Prim (functia primAlg) am parcurs varfurile si muchiile pentru a gasi arborele minim de acoperire. Am afisat atat nodurile, cat si muchiile in ordinea in care au fost parcurse de catre algoritm.

Bonus 4:
Am implementat un algoritm care determină traseul mașinii folosind Metric-TSP. Func'ia se afla in main si foloseste si functia algoritmului Prim din homework.

Am creat un generator de probleme aleatoare, asigurându-mă că lungimile dintre intersecții satisfac inegalitatea triunghiului.Pentru aceasta m-am folosit de o clasa Edge pentru capetele muchiei. Randomizarea numarului de noduri si muchii este in clasa RandomProblemGenerator.