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
                "INSERT INTO TRANSCRICAO (ID_REUNIAO, CONTEUDO) VALUES (?, ?)",
                transcription.getMeetingId(),
                transcription.getContent()
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
                "SELECT ID_TRANSCRICAO, ID_REUNIAO, CONTEUDO FROM TRANSCRICAO WHERE ID_TRANSCRICAO = ?",
                id
        );

        if (rs.next()) {
            Transcription transcription = new Transcription(
                    rs.getInt("ID_TRANSCRICAO"),
                    rs.getInt("ID_REUNIAO"),
                    rs.getString("CONTEUDO")
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
                "SELECT ID_TRANSCRICAO, ID_REUNIAO, CONTEUDO FROM TRANSCRICAO ORDER BY ID_TRANSCRICAO"
        );

        while (rs.next()) {
            Transcription transcription = new Transcription(
                    rs.getInt("ID_TRANSCRICAO"),
                    rs.getInt("ID_REUNIAO"),
                    rs.getString("CONTEUDO")
            );

            transcriptions.add(transcription);
        }

        rs.close();

        return transcriptions;
    }

    public void updateTranscription(Transcription transcription) throws SQLException {
        update(
                "UPDATE TRANSCRICAO SET CONTEUDO = ? WHERE ID_TRANSCRICAO = ?",
                transcription.getContent(),
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
