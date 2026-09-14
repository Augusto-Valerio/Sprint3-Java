package br.com.fiap.dao;

import br.com.fiap.entities.TotvsEmployee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TotvsEmployeeDao extends FactoryDao {

    public TotvsEmployeeDao() throws SQLException, ClassNotFoundException {
        super();
    }

    public int createEmployee(TotvsEmployee employee) throws SQLException {
        insert(
                "INSERT INTO FUNCIONARIO_TOTVS (USER_ID, NOME, EMAIL, CARGO) VALUES (?, ?, ?, ?)",
                employee.getUserId(),
                employee.getName(),
                employee.getEmail(),
                employee.getRole()
        );

        ResultSet rs = select(
                "SELECT ID_FUNCIONARIO FROM FUNCIONARIO_TOTVS WHERE EMAIL = ?",
                employee.getEmail()
        );

        int id = 0;

        if (rs.next()) {
            id = rs.getInt("ID_FUNCIONARIO");
        }

        rs.close();

        return id;
    }

    public TotvsEmployee findEmployeeByUserId(int userId) throws SQLException {
        ResultSet rs = select(
                "SELECT ID_FUNCIONARIO, USER_ID, NOME, EMAIL, CARGO FROM FUNCIONARIO_TOTVS WHERE USER_ID = ?",
                userId
        );

        if (rs.next()) {
            TotvsEmployee employee = new TotvsEmployee(
                    rs.getInt("ID_FUNCIONARIO"),
                    rs.getInt("USER_ID"),
                    rs.getString("NOME"),
                    rs.getString("EMAIL"),
                    rs.getString("CARGO")
            );

            rs.close();
            return employee;
        }

        rs.close();
        return null;
    }
}
