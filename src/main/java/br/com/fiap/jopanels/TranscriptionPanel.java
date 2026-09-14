package br.com.fiap.jopanels;

import br.com.fiap.dao.MeetingDao;
import br.com.fiap.dao.TotvsEmployeeDao;
import br.com.fiap.dao.TranscriptionDao;
import br.com.fiap.entities.Meeting;
import br.com.fiap.entities.TotvsEmployee;
import br.com.fiap.entities.Transcription;
import br.com.fiap.entities.User;
import br.com.fiap.utils.ApiResponse;
import br.com.fiap.utils.Jopt;

import java.sql.SQLException;
import java.util.ArrayList;

public class TranscriptionPanel {
    public void open(User userLogged) throws SQLException, ClassNotFoundException {
        TotvsEmployeeDao employeeDao = new TotvsEmployeeDao();
        TotvsEmployee employee = employeeDao.findEmployeeByUserId(userLogged.getUserId());

        if (employee == null) {
            throw new IllegalArgumentException("Funcionário não encontrado");
        }

        boolean run = true;

        String[] options = {
                "Cadastrar Transcrição",
                "Buscar Transcrição por ID",
                "Listar Transcrições",
                "Atualizar Transcrição",
                "Excluir Transcrição",
                "Voltar"
        };

        while (run) {
            int option = Jopt.showOption(options);

            try {
                if (option == 0) {
                    createTranscription(employee);

                } else if (option == 1) {
                    findTranscriptionById();

                } else if (option == 2) {
                    listTranscriptions();

                } else if (option == 3) {
                    updateTranscription();

                } else if (option == 4) {
                    deleteTranscription();

                } else if (option == 5 || option == -1) {
                    run = false;
                }
            } catch (Exception e) {
                Jopt.showError(ApiResponse.error(e.getMessage()));
            }

        }
    }

    private void createTranscription(TotvsEmployee employee) throws SQLException, ClassNotFoundException {
        String title = Jopt.input("Informe o título da reunião:");
        String meetingDate = Jopt.input("Informe a data da reunião (DD/MM/YYYY):");
        String status = Jopt.input("Informe o status da reunião:");
        String content = Jopt.input("Informe a transcrição da reunião:");

        Meeting meeting = new Meeting(employee.getEmployeeId(), title, meetingDate, status);

        if (!meeting.validateTitle()) {
            throw new IllegalArgumentException("Título da reunião não pode ficar vazio.");
        }

        if (!meeting.validateDate()) {
            throw new IllegalArgumentException("Data inválida. Use o formato DD/MM/YYYY.");
        }

        MeetingDao meetingDao = new MeetingDao();
        int meetingId = meetingDao.createMeeting(meeting);

        Transcription transcription = new Transcription(meetingId, content, "PENDENTE");

        if (!transcription.validateContent()) {
            throw new IllegalArgumentException("Transcrição não pode ficar vazia.");
        }

        TranscriptionDao transcriptionDao = new TranscriptionDao();
        int transcriptionId = transcriptionDao.createTranscription(transcription);

        Jopt.showMessage(ApiResponse.transcriptionCreateSuccess(transcriptionId), "Transcrição");
    }

    private void findTranscriptionById() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(Jopt.input("Informe o ID da transcrição:"));

        TranscriptionDao transcriptionDao = new TranscriptionDao();
        Transcription transcription = transcriptionDao.findTranscriptionById(id);

        if (transcription == null) {
            throw new IllegalArgumentException("Transcrição não encontrada.");
        }

        Jopt.showMessage(ApiResponse.transcriptionFoundSuccess(transcription), "Transcrição");
    }

    private void listTranscriptions() throws SQLException, ClassNotFoundException {
        TranscriptionDao transcriptionDao = new TranscriptionDao();
        ArrayList<Transcription> transcriptions = transcriptionDao.listTranscriptions();

        if (transcriptions.isEmpty()) {
            Jopt.showMessage("Nenhuma transcrição cadastrada.", "Transcrições");
            return;
        }

        Jopt.showMessage(ApiResponse.transcriptionListSuccess(transcriptions), "Transcrições");
    }

    private void updateTranscription() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(Jopt.input("Informe o ID da transcrição que deseja atualizar:"));

        TranscriptionDao transcriptionDao = new TranscriptionDao();
        Transcription existingTranscription = transcriptionDao.findTranscriptionById(id);

        if (existingTranscription == null) {
            throw new IllegalArgumentException("Transcrição não encontrada.");
        }

        String content = Jopt.input("Informe a nova transcrição:");
        String status = Jopt.input("Informe o novo status do processamento:");

        Transcription updatedTranscription = new Transcription(
                id,
                existingTranscription.getMeetingId(),
                content,
                status
        );

        if (!updatedTranscription.validateContent()) {
            throw new IllegalArgumentException("Transcrição não pode ficar vazia.");
        }

        transcriptionDao.updateTranscription(updatedTranscription);

        Jopt.showMessage(ApiResponse.transcriptionUpdateSuccess(), "Transcrição");
    }

    private void deleteTranscription() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(Jopt.input("Informe o ID da transcrição que deseja excluir:"));

        TranscriptionDao transcriptionDao = new TranscriptionDao();
        Transcription transcription = transcriptionDao.findTranscriptionById(id);

        if (transcription == null) {
            throw new IllegalArgumentException("Transcrição não encontrada.");
        }

        transcriptionDao.deleteTranscription(id);

        Jopt.showMessage(ApiResponse.transcriptionDeleteSuccess(), "Transcrição");
    }
}