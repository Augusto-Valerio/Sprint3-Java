package br.com.fiap.dao;

import br.com.fiap.entities.Meeting;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MeetingDao extends FactoryDao {

    public MeetingDao() throws SQLException, ClassNotFoundException {
        super();
    }

    public int createMeeting(Meeting meeting) throws SQLException {
        insert(
                "INSERT INTO REUNIAO (ID_FUNCIONARIO, TITULO, DATA_REUNIAO, STATUS) VALUES (?, ?, TO_DATE(?, 'DD/MM/YYYY'), ?)",
                meeting.getEmployeeId(),
                meeting.getTitle(),
                meeting.getMeetingDate(),
                meeting.getStatus()
        );

        ResultSet rs = select(
                "SELECT ID_REUNIAO FROM REUNIAO WHERE ID_FUNCIONARIO = ? AND TITULO = ?",
                meeting.getEmployeeId(),
                meeting.getTitle()
        );

        int id = 0;

        if (rs.next()) {
            id = rs.getInt("ID_REUNIAO");
        }

        rs.close();
        return id;
    }
}
