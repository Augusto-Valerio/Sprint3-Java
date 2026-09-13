package br.com.fiap.dao;

import br.com.fiap.entities.TotvsEmployee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TotvsEmployeeDao extends FactoryDao{

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
}
