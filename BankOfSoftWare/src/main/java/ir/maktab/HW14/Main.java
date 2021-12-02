/*
package ir.maktab.HW14;

import ir.maktab.HW14.model.Disc;
import ir.maktab.HW14.model.Person;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        while (true) {
            System.out.println("********* wellcome **********\nenter user and passWord");
            String input = scanner.nextLine();
            String[] split = input.split(" ");
            if (split[0].equalsIgnoreCase("user") && (split[1]).equalsIgnoreCase("user")) {
                System.out.println("inter number of event and fines of each day late:");
                String eventFines = scanner.nextLine();
                final String[] split1 = eventFines.split(" ");
                //todo => check kon ke adad valid vared kone
                int event = Integer.parseInt(split1[0]);
                int finePerDay = Integer.parseInt(split1[1]);

                System.out.println("1.calculate Fines of each member\n2.a list of borrowed software");
                String choice = " ";
                choice = scanner.nextLine();
                while (!(choice.equals("1") || choice.equals("2"))) {
                    System.out.println("Enter true number : ");
                    choice = scanner.nextLine();
                }
                switch (choice.trim()) {
                    case "1":
                        //todo
                        break;
                    case "2":
                        //todo
                        break;
                }
            } else {
                System.out.println("invalid input....try again");
            }
        }

    }

    public static void list() {
        String input = scanner.nextLine();
        String[] split = input.split(" ");
        int event = Integer.parseInt(split[0]);
        int finePerDay = Integer.parseInt(split[1]);
        final Bank bank = new Bank();
        final List<Person> personList = bank.getPersonList();
        for (int i = 0; i < event; i++) {
            String list = scanner.nextLine();
            String[] split1 = list.split(" ");
            Date date = new Date(Integer.parseInt(split1[3]), Integer.parseInt(split1[2]), Integer.parseInt(split1[1]));//day month year
            Disc disc = new Disc(split1[5]);

       */
/*   if (!personList.stream().anyMatch(person -> person.equals(split1[4])) || personList == null) {
                final Person person = new Person(split1[4]);
              bank.addMember(person);
                person.borrow(disc, date);
                final BorrowOperation borrowOperation = new BorrowOperation(disc, date);

            }*//*

            if (personList != null) {
                for (Person person1 : personList) {
                    if (!split1[4].equalsIgnoreCase(person1.getName())) {
                        Person person = new Person(split1[4]);
                        personList.add(person);
                        person.borrow(disc, date);
                        final BorrowOperation borrowOperation = new BorrowOperation(disc, date);
                    }else {

                    }
                    List<Disc> discBorrow = person1.getDiscBorrow();
                    if (discBorrow.contains(disc)) {
                        person1.deliver(disc, date);
                        person1.getLateDays();
                    } else {
                        person1.borrow(disc, date);
                        // new BorrowOperation(disc.getName(), date);
                    }

                }


            } else {
                final Person person = new Person(split1[4]);
            }
        }

    }
}

*/
