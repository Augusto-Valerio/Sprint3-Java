package br.com.fiap.main;

import br.com.fiap.dao.ClientDao;
import br.com.fiap.entities.Client;

import java.util.ArrayList;

public class ClientDaoTest {

    public static void main(String[] args) {
        try {
            ClientDao clientDao = new ClientDao();

            Client client = new Client(
                    "ClienteTest",
                    "clienteDaoTeste@gmail.com",
                    "11988887777",
                    "Analista",
                    "Financeiro"
            );

            int id = clientDao.createClient(client);
            System.out.println("Cliente cadastrado com ID: " + id);

            Client foundClient = clientDao.findClientById(id);
            System.out.println("Cliente encontrado:");
            System.out.println(foundClient.showData());

            ArrayList<Client> clients = clientDao.listClients();
            System.out.println("Quantidade de clientes cadastrados: " + clients.size());

            String resultDelete = clientDao.deleteClient(id);
            System.out.println(resultDelete);

        } catch (Exception e) {
            System.out.println("Erro ao testar ClientDao: " + e.getMessage());
        }
    }
}