package my.kravczek.d0307.dao;

import my.kravczek.d0307.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private static final String URL = "jdbc:mysql://localhost:3308/first_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "s1111";

    //    static{
//        try {
//            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//    private List<Person> people;
////it is new
//    {
//        people = new ArrayList<>();
//
//        people.add(new Person(++PEOPLE_COUNT, "Tom",21,"kr1@gmail.com"));
//        people.add(new Person(++PEOPLE_COUNT, "Bob",22,"kr2@gmail.com"));
//        people.add(new Person(++PEOPLE_COUNT, "Mike",23,"kr3@gmail.com"));
//        people.add(new Person(++PEOPLE_COUNT, "Katy",24,"kr4@gmail.com"));
//    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Class.forName("org.postgresql.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
     //   Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        String SQL = "SELECT * FROM person";
        ResultSet resultSet = connection.createStatement().executeQuery(SQL);
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }
    }
    public List<Person> index() throws SQLException {
        List<Person> people = new ArrayList<>();

        try {
         //   Class.forName("org.postgresql.Driver");
            //Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
           // Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/first_db", "root", "s1111");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String SQL = "SELECT * FROM person1";
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
                people.add(person);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return people;
    }

    public Person show(int id) {
//        Person result = null;
//        for (Person idividual : people) {
//
//            if (id == idividual.getId()) {
//                result = idividual;
//            }
//        }
//        return result;
        return null;
    }

    public static void save(Person person)  throws ClassNotFoundException, SQLException  {
//        person.setId(++PEOPLE_COUNT);
//        people.add(person);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/first_db", "root", "s1111");
           Statement statement=connection.createStatement();
            String SQL= "INSERT INTO person1 VALUES("+1+",'"+person.getName()+"','"+person.getAge()+"','"+person.getEmail()+"')";
            statement.executeUpdate(SQL);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
       }
    }

    public void update(int id, Person updatedPerson) {
//        Person toBeUpdatePerson = show(id);
//        toBeUpdatePerson.setName(updatedPerson.getName());
    }

    public void delete(int id) {
//        people.removeIf(p -> p.getId() == id);
    }

}
// INSERT INTO person VALUES (1,'test',15,'test@mail.ru'); DROP TABLE person;