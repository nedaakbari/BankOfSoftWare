package ir.maktab.HW14;

import ir.maktab.HW14.model.*;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Test2 {
    static Scanner scanner = new Scanner(System.in);
    static Bank bank = new Bank();

    public static void main(String[] args) {
        String eventFines = scanner.nextLine();
        final String[] split = eventFines.split(" ");
        //todo => check kon ke adad valid vared kone
        int event = Integer.parseInt(split[0]);
        int finePerDay = Integer.parseInt(split[1]);
        Set<Disc> discSet = bank.getDiscSet();//لیست موجودی های دیسک بانک رو میگیره و داخل ست میریزه
        Set<Person> personSet = bank.getPersonSet();//لیست ادمای کتابخونه رو میگیره
        List<BorrowOperation> bankOperationList = bank.getBorrowOperationsList();//لیست تراکنش های بانک

        for (int i = 0; i < event; i++) {
            String list = scanner.nextLine();
            String[] info = list.split(" ");
            Date date = new Date(Integer.parseInt(info[2]), Integer.parseInt(info[1]), Integer.parseInt(info[0]));//day month year
            Disc disc = null;
            for (Disc foundDisk : discSet) {
                if (foundDisk.getName().equalsIgnoreCase(info[4])) {
                    disc = foundDisk;
                }
            }
            outer:
            if (personSet.size() != 0) {
                for (Person foundPerson : personSet) {
                    if (!info[3].equalsIgnoreCase(foundPerson.getName())) {// اگر سایزش صفره یا شخص اول بار میادش
                        Person person = new Person(info[3]);
                        personSet.add(person);
                        bank.setPersonSet(personSet);
                        disc.setCount(0);
                        person.borrow(disc, date);
                        BorrowOperation borrowOperation = new BorrowOperation(info[4], date);
                        borrowOperation.setPerson(person);
                        borrowOperation.setStatus("borrow");
                        bankOperationList.add(borrowOperation);
                        bank.setBorrowOperationsList(bankOperationList);
                        borrowOperation.setPerson(person);
                    } else {//شخص بار چندمین باره که داره میاد یا لیست پره
                        List<Disc> borrowCart = foundPerson.getDiscBorrow();//لیست سی دی هایی که دستشه
                        if (borrowCart.size() == 0 || disc.getCount() == 1) {//borrow
                            foundPerson.borrow(disc, date);
                            disc.setCount(0);
                            BorrowOperation borrowOperation = new BorrowOperation(disc.getName(), date);
                            borrowOperation.setPerson(foundPerson);
                            borrowOperation.setStatus("borrow");
                            bankOperationList.add(borrowOperation);
                            bank.setBorrowOperationsList(bankOperationList);

                        } else {//deliver
                            for (Disc foundDisk : borrowCart) {
                                if (foundDisk.getName().equalsIgnoreCase(info[4])) {
                                    foundPerson.deliver(disc, date);
                                    BorrowOperation borrowOperation;
                                    for (BorrowOperation bankBorrowOperation : bankOperationList) {
                                        if (bankBorrowOperation.getDiscName().equalsIgnoreCase(info[4]) && bankBorrowOperation.getStatus().equalsIgnoreCase("borrow")) {
                                            borrowOperation = bankBorrowOperation;
                                            borrowOperation.isLate(date);
                                            borrowOperation.setStatus("deliver");
                                        }
                                    }
                                    disc.setCount(1);
                                }
                                if (borrowCart.size() == 0) {
                                    break outer;
                                }
                            }// foundDisk of borrow cart
                        }//deliver
                    }////شخص بار چندمین باره که داره میاد یا لیست پره
                    break outer;
                }//for found person
            } else {
                Person person = new Person(info[3]);
                personSet.add(person);
                bank.setPersonSet(personSet);
                disc.setCount(0);
                person.borrow(disc, date);
                BorrowOperation borrowOperation = new BorrowOperation(info[4], date);
                borrowOperation.setPerson(person);
                borrowOperation.setStatus("borrow");
                bankOperationList.add(borrowOperation);
                bank.setBorrowOperationsList(bankOperationList);
                borrowOperation.setPerson(person);
            }
        }
        Set<Person> bankPersonList = bank.getPersonSet();
        System.out.println("Fines:");
        bankPersonList.forEach(person -> System.out.println(person.getName() + ":" + person.getLateDays() * finePerDay));
        System.out.println("Borrowed Discs");
        Set<Disc> discs = bank.getDiscSet();
        discs.stream().filter(disc -> disc.getCount() == 0).forEach(disc -> System.out.println(disc.getName()));
    }
}

