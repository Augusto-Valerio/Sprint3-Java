package br.com.fiap.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends FactoryDao{
    public UserDao() throws SQLException, ClassNotFoundException {
        super();
    }

    public int createUser(String userName, String userPassWord)throws SQLException {
        ResultSet rs = insert(
                "INSERT INTO USUARIO (USER_NAME, USER_PASSWORD) VALUES (?, ?)",
                userName,
                userPassWord
        );

        int id = 0;

        if (rs.next()) {
            id = rs.getInt("USER_ID");
        }

        rs.close();

        return id;
    }
}
