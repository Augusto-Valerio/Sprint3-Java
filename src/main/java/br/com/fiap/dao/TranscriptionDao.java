package br.com.fiap.dao;

import br.com.fiap.entities.Transcription;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TranscriptionDao extends FactoryDao {
    public TranscriptionDao() throws SQLException, ClassNotFoundException {
        super();
    }

    public int createTranscription(Transcription transcription) throws SQLException {
        insert(
                "INSERT INTO TRANSCRICAO (ID_REUNIAO, CONTEUDO, STATUS_PROCESSAMENTO) VALUES (?, ?, ?)",
                transcription.getMeetingId(),
                transcription.getContent(),
                transcription.getProcessingStatus()
        );

        ResultSet rs = select(
                "SELECT ID_TRANSCRICAO FROM TRANSCRICAO WHERE ID_REUNIAO = ?",
                transcription.getMeetingId()
        );

        int id = 0;

        if (rs.next()) {
            id = rs.getInt("ID_TRANSCRICAO");
        }

        rs.close();
        return id;
    }

    public Transcription findTranscriptionById(int id) throws SQLException {
        ResultSet rs = select(
                "SELECT ID_TRANSCRICAO, ID_REUNIAO, CONTEUDO, STATUS_PROCESSAMENTO FROM TRANSCRICAO WHERE ID_TRANSCRICAO = ?",
                id
        );

        if (rs.next()) {
            Transcription transcription = new Transcription(
                    rs.getInt("ID_TRANSCRICAO"),
                    rs.getInt("ID_REUNIAO"),
                    rs.getString("CONTEUDO"),
                    rs.getString("STATUS_PROCESSAMENTO")
            );

            rs.close();
            return transcription;
        }

        rs.close();
        return null;
    }

    public ArrayList<Transcription> listTranscriptions() throws SQLException {
        ArrayList<Transcription> transcriptions = new ArrayList<>();

        ResultSet rs = select(
                "SELECT ID_TRANSCRICAO, ID_REUNIAO, CONTEUDO, STATUS_PROCESSAMENTO FROM TRANSCRICAO ORDER BY ID_TRANSCRICAO"
        );

        while (rs.next()) {
            Transcription transcription = new Transcription(
                    rs.getInt("ID_TRANSCRICAO"),
                    rs.getInt("ID_REUNIAO"),
                    rs.getString("CONTEUDO"),
                    rs.getString("STATUS_PROCESSAMENTO")
            );

            transcriptions.add(transcription);
        }

        rs.close();

        return transcriptions;
    }

    public void updateTranscription(Transcription transcription) throws SQLException {
        update(
                "UPDATE TRANSCRICAO SET CONTEUDO = ?, STATUS_PROCESSAMENTO = ? WHERE ID_TRANSCRICAO = ?",
                transcription.getContent(),
                transcription.getProcessingStatus(),
                transcription.getTranscriptionId()
        );
    }

    public void deleteTranscription(int id) throws SQLException {
        delete(
                "DELETE FROM TRANSCRICAO WHERE ID_TRANSCRICAO = ?",
                id
        );

    }
}
