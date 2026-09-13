package br.com.fiap.jopanels;

import br.com.fiap.dao.ClientDao;
import br.com.fiap.entities.Client;
import br.com.fiap.utils.ApiResponse;
import br.com.fiap.utils.Jopt;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClientPanel {

    public void open() throws SQLException, ClassNotFoundException {
        boolean run = true;

        String[] options = {
                "Cadastrar Cliente",
                "Buscar Cliente por ID",
                "Listar Cliente",
                "Atualizar Cliente",
                "Excluir Cliente",
                "Voltar"
        };

        while (run) {
            int option = Jopt.showOption(options);

            if (option == 0) {
                createClient();

            } else if (option == 1) {
                findClientByID();

            } else if (option == 2) {
                listClients();

            } else if (option == 3) {
                updateClient();

            } else if (option == 4) {
                deleteClient();

            } else if (option == 5 || option == -1) {
                run = false;
            }
        }
    }

    private void createClient() throws SQLException, ClassNotFoundException {
        String name = Jopt.input("Informe o nome do cliente:");
        String email = Jopt.input("Informe o email do cliente:");
        String phone = Jopt.input("Informe o telefone do cliente:");
        String role = Jopt.input("Informe o cargo do cliente:");
        String department = Jopt.input("Informe o departamento do cliente:");

        Client client = new Client(name, email, phone, role, department);

        if (!client.validateName()) {
            throw new IllegalArgumentException("Nome do cliente não pode ficar vazio.");
        }

        if (!client.validateEmail()) {
            throw new IllegalArgumentException("Email inválido.");
        }

        if (!client.validatePhone()) {
            throw new IllegalArgumentException("Telefone do cliente não pode ficar vazio.");
        }

        ClientDao clientDao = new ClientDao();
        int id = clientDao.createClient(client);

        Jopt.showMessage(ApiResponse.clientCreateSuccess(id), "Cliente");
    }

    private void findClientByID() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(Jopt.input("Informe o ID do Cliente:"));

        ClientDao clientDao = new ClientDao();
        Client client = clientDao.findClientById(id);

        if (client == null) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }

        Jopt.showMessage(ApiResponse.clientFoundSuccess(client), "Cliente encontrado.");
    }

    private void listClients() throws SQLException, ClassNotFoundException {
        ClientDao clientDao = new ClientDao();
        ArrayList<Client> clients = clientDao.listClients();

        if (clients.isEmpty()) {
            Jopt.showMessage("Nenhum cliente cadastrado.", "Clientes");
            return;
        }

        Jopt.showMessage(ApiResponse.clientListSuccess(clients), "Clientes");
    }

    private void updateClient() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(Jopt.input("Informe o ID do cliente que deseja atualizar:"));

        ClientDao clientDao = new ClientDao();
        Client existingClient = clientDao.findClientById(id);

        if (existingClient == null) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }

        String name = Jopt.input("Informe o novo nome:");
        String email = Jopt.input("Informe o novo email:");
        String phone = Jopt.input("Informe o novo telefone:");
        String role = Jopt.input("Informe o novo cargo:");
        String department = Jopt.input("Informe o novo departamento:");

        Client updateClient = new Client(id, name, email, phone, role, department);

        clientDao.updateClient(updateClient);

        Jopt.showMessage(ApiResponse.clientUpdateSuccess(), "Cliente");
    }

    private void deleteClient() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(Jopt.input("Informe o ID do cliente que deseja excluir:"));

        ClientDao clientDao = new ClientDao();
        Client client = clientDao.findClientById(id);

        if (client == null) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }

        clientDao.deleteClient(id);

        Jopt.showMessage(ApiResponse.clientDeleteSuccess(), "Cliente");
    }
}