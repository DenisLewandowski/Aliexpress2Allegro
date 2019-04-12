package pl.dlewandowski.database;

import pl.dlewandowski.model.User;

import java.sql.*;

public class MySqlAcces {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public MySqlAcces() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/aliexpress_to_allegro?useJDBCCompliantTimezoneShift=true" +
                            "&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "admin");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int id) {
        User user = new User();
        try {
            resultSet = statement.executeQuery("SELECT * FROM user WHERE id=1");
            resultSet.next();
            user.setId(resultSet.getLong("id"));
            user.setLogin(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResultSet();
        }
        return user;
    }

    public User getUserByName(String name) {
        User user = new User();
        try {
            resultSet = statement.executeQuery("SELECT * FROM user WHERE name='" + name + "'");
            resultSet.next();
            user.setId(resultSet.getLong("id"));
            user.setLogin(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResultSet();
        }
        return user;
    }

    private void closeResultSet() {
        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
