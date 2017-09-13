package edu.matc.persistence;

import edu.matc.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.*;

/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {

    private final Logger logger = Logger.getLogger(this.getClass());

    public List<User> getAllUsers() {

        String sql = "SELECT * FROM users";
        logger.info("Get All Users run test");
        return executeQuery(sql);
    }


    public List<User> getUsersByLastName(String lastName) {
        String sql = "SELECT * FROM users WHERE last_name like '%" + lastName + "%'";
        return executeQuery(sql);
    }

    private List<User> executeQuery(String sql) {

            List<User> users = new ArrayList<User>();
            Database database = Database.getInstance();
            Connection connection = null;

            try {
                database.connect();
                connection = database.getConnection();
                Statement selectStatement = connection.createStatement();
                ResultSet results = selectStatement.executeQuery(sql);
                while (results.next()) {
                    User employee = createUserFromResults(results);
                    users.add(employee);
                }
                database.disconnect();
            } catch (SQLException e) {
                logger.info("SearchUser.getAllUsers()...SQL Exception: " + e);
            } catch (Exception e) {
                logger.info("SearchUser.getAllUsers()...Exception: " + e);
            }
            return users;
    }
    //TODO add a method or methods to return a single user based on search criteria

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setLastName(results.getString("last_name"));
        user.setFirstName(results.getString("first_name"));
        user.setUserid(results.getString("id"));
        user.setDateOfBirth(results.getDate("date_of_birth").toLocalDate());
        // TODO map the remaining fields
        return user;
    }

}