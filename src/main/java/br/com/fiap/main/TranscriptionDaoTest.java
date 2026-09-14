package br.com.fiap.main;

import br.com.fiap.dao.InsightDao;
import br.com.fiap.dao.MeetingDao;
import br.com.fiap.dao.TotvsEmployeeDao;
import br.com.fiap.dao.TranscriptionDao;
import br.com.fiap.entities.Insight;
import br.com.fiap.entities.Meeting;
import br.com.fiap.entities.TotvsEmployee;
import br.com.fiap.entities.Transcription;
import br.com.fiap.services.InsightService;

import java.util.ArrayList;

public class TranscriptionDaoTest {
    public static void main(String[] args) {
        try {
            TotvsEmployeeDao employeeDao = new TotvsEmployeeDao();
            TotvsEmployee employee = employeeDao.findEmployeeByUserId(1);

            if (employee == null){
                System.out.println("Funcionario de teste não encontrado.");
                return;
            }

            MeetingDao meetingDao = new MeetingDao();

            Meeting meeting = new Meeting(
                    employee.getEmployeeId(),
                    "Reuniao teste Dao",
                    "13/09/2026",
                    "CONCLUIDO"
            );

            int meetingID = meetingDao.createMeeting(meeting);
            System.out.println("Reunião cadastrada com ID: " + meetingID);

            TranscriptionDao transcriptionDao = new TranscriptionDao();

            Transcription transcription = new Transcription(
                    meetingID,
                    "Estamos com problema no processo de atendimento e queremos melhorar o acompanhamento das solicitações."
            );

            int transcriptionId = transcriptionDao.createTranscription(transcription);
            System.out.println("Transcricao realizada com ID: " + transcriptionId);

            Transcription foundTranscription = transcriptionDao.findTranscriptionById(transcriptionId);

            if (foundTranscription != null){
                System.out.println("Transcrição encontrada: " + foundTranscription.getContent());
            }

            InsightService insightService = new InsightService();
            Insight insight = insightService.generateInsight(transcriptionId, transcription.getContent());

            InsightDao insightDao = new InsightDao();
            int insightId = insightDao.createInsight(insight);
            System.out.println("Insight cadastrado com ID: " + insightId);

            ArrayList<Transcription> transcriptions = transcriptionDao.listTranscriptions();
            System.out.println("Quantidade de transcrições cadastradas: " + transcriptions.size());

            insightDao.deleteInsightByTranscriptionId(transcriptionId);
            transcriptionDao.deleteTranscription(transcriptionId);

            System.out.println("Transcrição de teste excluída com sucesso.");

        } catch (Exception e) {
            System.out.println("Erro ao testar TranscriptionDao." + e .getMessage());
        }
    }
}
