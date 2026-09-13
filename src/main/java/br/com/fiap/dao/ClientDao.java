package br.com.fiap.dao;

import br.com.fiap.entities.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDao extends FactoryDao {

    public ClientDao() throws SQLException, ClassNotFoundException {
        super();
    }

    public int createClient(Client client) throws SQLException {
        insert(
                "INSERT INTO CLIENTE (NOME, EMAIL, TELEFONE, CARGO, DEPARTAMENTO) VALUES (?, ?, ?, ?, ?)",
                client.getName(),
                client.getEmail(),
                client.getPhone(),
                client.getRole(),
                client.getDepartment()
        );

        ResultSet rs = select(
                "SELECT ID_CLIENTE FROM CLIENTE WHERE EMAIL = ?",
                client.getEmail()
        );

        int id = 0;

        if (rs.next()) {
            id = rs.getInt("ID_CLIENTE");
        }

        rs.close();

        return id;
    }

    public Client findClientById(int clientId) throws SQLException {
        ResultSet rs = select(
                "SELECT ID_CLIENTE, NOME, EMAIL, TELEFONE, CARGO, DEPARTAMENTO FROM CLIENTE WHERE ID_CLIENTE = ?",
                clientId
        );

        if (rs.next()) {
            Client cliente = new Client(
                    rs.getInt("ID_CLIENTE"),
                    rs.getString("NOME"),
                    rs.getString("EMAIL"),
                    rs.getString("TELEFONE"),
                    rs.getString("CARGO"),
                    rs.getString("DEPARTAMENTO")
            );

            rs.close();
            return cliente;
        }

        rs.close();
        return null;
    }

    public ArrayList<Client> listClients() throws SQLException {
        ArrayList<Client> clients = new ArrayList<>();

        ResultSet rs = select(
                "SELECT ID_CLIENTE, NOME, EMAIL, TELEFONE, CARGO, DEPARTAMENTO FROM CLIENTE ORDER BY ID_CLIENTE"
        );

        while (rs.next()) {
            Client client = new Client(
                    rs.getInt("ID_CLIENTE"),
                    rs.getString("NOME"),
                    rs.getString("EMAIL"),
                    rs.getString("TELEFONE"),
                    rs.getString("CARGO"),
                    rs.getString("DEPARTAMENTO")
            );

            clients.add(client);
        }

        rs.close();

        return clients;
    }

    public String updateClient(Client client) throws SQLException {
        update(
                "UPDATE CLIENTE SET NOME = ?, EMAIL = ?, TELEFONE = ?, CARGO = ?, DEPARTAMENTO = ? WHERE ID_CLIENTE = ?",
                client.getName(),
                client.getEmail(),
                client.getPhone(),
                client.getRole(),
                client.getDepartment(),
                client.getClientId()
        );

        return "Cliente atualizado com sucesso!";
    }

    public String deleteClient(int clientId) throws SQLException {
        delete(
                "DELETE FROM CLIENTE WHERE ID_CLIENTE = ?",
                clientId
        );

        return "Cliente excluido com sucesso!";
    }

}
