package ir.maktab.HW14.ataAccess;

public class Operation extends BaseDao {
    public Operation() {
    }

    public void search() {
        if (connection != null) {
            String sql = "SELECT id,personName,discName,date FROM operation\n" +
                    "inner join person \n" +
                    "on operation.personId=person.personId\n" +
                    "inner join disc \n" +
                    "on operation.discId=disc.discId;";
            
        }
    }
}
