# BankOfSoftWare
Its about a bank in a univercity that borrow studrnt cd or dvd of a software
the manager of the bank input a list of information of students that include : name , name of software , date
(imagin that there are not duplicate name and 1 number of each software available)
we shouil have 5 class include:
Person
Borrow
Date
Disc
Bank


these classes have tgese methode :

Borrow class that used for borroingOperation:

Borrow (string disc, Date date);

Date getDate();

bool isLate(Date deliveryDate);

string getDiscName()


Person class used to save information of student:
Person (string name);
 string getName();
 int getLateDays();
 void borrow(Disc* disc, Date date);
 void deliver (Disc* disc, Date date);                                                                                                                                                                            

design tgese program with the best designPatern and method test for each methods
have luck
