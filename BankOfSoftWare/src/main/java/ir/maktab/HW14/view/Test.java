package ir.maktab.HW14.view;

import ir.maktab.HW14.model.*;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Test {
    static Scanner scanner = new Scanner(System.in);
    static Bank bank = new Bank();
    static Manager manager = new Manager();

    public static void main(String[] args) {
        while (true) {
            System.out.println("********* wellcome **********\nenter user and passWord");
            String input = scanner.nextLine();
            String[] usePass = input.split(" ",2);
            if (usePass[0].equalsIgnoreCase(manager.getUser()) && (usePass[1]).equalsIgnoreCase(manager.getPassword())) {
                System.out.println("inter number of event and fines of each day late:");
                String eventFines = scanner.nextLine();
                final String[] split = eventFines.split(" ");

                int event = Integer.parseInt(split[0]);
                int finePerDay = Integer.parseInt(split[1]);
                // bank.setFine(finePerDay);
                Set<Disc> discSet = bank.getDiscSet();//لیست موجودی های دیسک بانک رو میگیره و داخل ست میریزه
                Set<Person> personSet = bank.getPersonSet();//لیست ادمای کتابخونه رو میگیره
                List<BorrowOperation> bankOperationList = bank.getBorrowOperationsList();//لیست تراکنش های بانک
                for (int i = 0; i < event; i++) {
                    String list = scanner.nextLine();
                    String[] info = list.split(" ");
                    int day = Integer.parseInt(info[0]);
                    int month = Integer.parseInt(info[1]);
                    int year = Integer.parseInt(info[2]);
                    String name = info[3];
                    String discName = info[4];
                    Date date = new Date(year, month, day);
                    Disc disc = null;
                    for (Disc foundDisk : discSet) {
                        if (foundDisk.getName().equalsIgnoreCase(discName)) {
                            disc = foundDisk;
                        }
                    }
                    outer:
                    if (personSet.size() != 0) {
                        Person foundPerson = null;
                        for (Person person : personSet) {
                            if (person.getName().equalsIgnoreCase(name)) {//شخص چندباره میاد
                                foundPerson = person;
                            }
                        }
                        if (foundPerson == null) {//شخص اول باره میاد
                            Person person = new Person(name);
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
                        } else {//شخص بار چندمین باره که داره میاد
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
                                Disc foundDisk = null;
                                for (Disc whichDiscToDeliver : borrowCart) {
                                    if (whichDiscToDeliver.getName().equalsIgnoreCase(disc.getName()))
                                        foundDisk = whichDiscToDeliver;
                                }
                                foundPerson.deliver(foundDisk, date);
                                BorrowOperation borrowOperation;
                                for (BorrowOperation bankBorrowOperation : bankOperationList) {
                                    if (bankBorrowOperation.getDiscName().equalsIgnoreCase(discName) && bankBorrowOperation.getStatus().equalsIgnoreCase("borrow")) {
                                        borrowOperation = bankBorrowOperation;
                                        borrowOperation.isLate(date);
                                        borrowOperation.setStatus("deliver");
                                    }
                                }
                                foundDisk.setCount(1);
                                if (borrowCart.size() == 0) {
                                    break outer;
                                }
                            }//deliver
                        }////شخص بار چندمین باره که داره میاد یا لیست پره
                        break outer;
                    } else {
                        Person person = new Person(name);
                        personSet.add(person);
                        bank.setPersonSet(personSet);
                        disc.setCount(0);
                        person.borrow(disc, date);
                        BorrowOperation borrowOperation = new BorrowOperation(discName, date);
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
                break;
            }else {
                System.out.println("invalid input....try again");
            }
        }
    }
}

