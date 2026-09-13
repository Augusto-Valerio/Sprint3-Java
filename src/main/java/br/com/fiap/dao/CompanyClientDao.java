package br.com.fiap.dao;

import br.com.fiap.entities.CompanyClient;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyClientDao extends FactoryDao {

    public CompanyClientDao() throws SQLException, ClassNotFoundException {
        super();
    }

    public int createCompany(CompanyClient company) throws SQLException {
        insert(
                "INSERT INTO EMPRESA_CLIENTE (NOME, CNPJ, SEGMENTO) VALUES (?, ?, ?)",
                company.getName(),
                company.getCnpj(),
                company.getSegment()
        );

        ResultSet rs = select(
                "SELECT ID_EMPRESA FROM EMPRESA_CLIENTE WHERE CNPJ = ?",
                company.getCnpj()
        );

        int id = 0;

        if (rs.next()) {
            id = rs.getInt("ID_EMPRESA");
        }

        rs.close();

        return id;
    }
}
