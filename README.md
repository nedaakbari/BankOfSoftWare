# BankOfSoftWare
Its about a bank in a univercity that borrow studrnt cd or dvd of a software
the manager of the bank input a list of information of students that include : name , name of software , date
(imagin that there are not duplicate name and 1 number of each software available)


we should have 5 class include:

1)Person

2)Borrow

3)Date

4)Disc

5)Bank




these classes have tgese methode :

**Borrow class that used for borroingOperation:

Borrow (string disc, Date date);

Date getDate();

bool isLate(Date deliveryDate);

string getDiscName()


**Person class used to save information of student:

Person (string name);
 string getName();
 int getLateDays();
 void borrow(Disc* disc, Date date);
 void deliver (Disc* disc, Date date);  



design this program with the best designPatern and method test for each methods

printLn("************* have luck ***************")
