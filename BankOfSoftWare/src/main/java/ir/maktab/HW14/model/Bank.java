package ir.maktab.HW14.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bank {
    private List<BorrowOperation> borrowOperationsList = new ArrayList<>();
    private Set<Person> personSet = new HashSet<>();
    public Set<Disc> discSet = Set.of(DiscType.office, DiscType.gparted, DiscType.pes, DiscType.ubuntu);


    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }

    public Set<Disc> getDiscSet() {
        return discSet;
    }

    public void setDiscSet(Set<Disc> discSet) {
        this.discSet = discSet;
    }

    public List<BorrowOperation> getBorrowOperationsList() {
        return borrowOperationsList;
    }

    public void setBorrowOperationsList(List<BorrowOperation> borrowOperationsList) {
        this.borrowOperationsList = borrowOperationsList;
    }
    //end region getter & setter

 /*   public void calculateEveryFine(){
        personSet.stream().forEach(person -> System.out.println(person.getName()+": "+person.getLateDays()*fine));
        discSet.stream().filter(disc -> disc.getCount() == 0).forEach(disc -> System.out.println(disc.getName()));
    }*/
    @Override
    public String toString() {
        return "Bank{" +
                "borrowOperationsList=" + borrowOperationsList +
                ", personSet=" + personSet +
                ", discSet=" + discSet +
                '}';
    }
}
