package ir.maktab.HW14.ataAccess;

import ir.maktab.HW14.model.Person;

import java.io.LineNumberInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class PersonDao extends BaseDao {
    public PersonDao() {
    }

    public int save(Person person) throws SQLException {
        if (connection != null) {
            if (findPersonByName(person.getName()) == null) {
                String sql = "INSERT INTO person(personName) VALUES (?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, person.getName());
                return statement.executeUpdate();
            }
        }
        return 0;
    }

    public List<Person> findAllPersons() throws SQLException {
        if (connection != null) {
            List<Person> personList = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * fom person");
            while (resultSet.next()) {
                String personName = resultSet.getString("personName");
                Person person = new Person(personName);
                personList.add(person);
            }
            return personList;
        }
        return Collections.emptyList();
    }

    public Person findPersonByName(String name) throws SQLException {
        Person findPerson = null;
        if (connection != null) {
            Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("select * from person where personNeme='" + name + "';");
            while (resultSet.next()) {
                String personName = resultSet.getString("personName");
                findPerson = new Person(personName);
            }
        }
        return findPerson;
    }
}

