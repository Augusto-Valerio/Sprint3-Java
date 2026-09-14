package br.com.fiap.dao;

import br.com.fiap.entities.Insight;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InsightDao extends FactoryDao {

    public InsightDao() throws SQLException, ClassNotFoundException {
        super();
    }

    public int createInsight(Insight insight) throws SQLException {
        insert(
                "INSERT INTO INSIGHT (ID_TRANSCRICAO, TIPO, DESCRICAO, SENTIMENTO, SUGESTAO_ACAO) VALUES (?, ?, ?, ?, ?)",
                insight.getTranscriptionId(),
                insight.getType(),
                insight.getDescription(),
                insight.getSentiment(),
                insight.getActionSuggestion()
        );

        ResultSet rs = select(
                "SELECT ID_INSIGHT FROM INSIGHT WHERE ID_TRANSCRICAO = ?",
                insight.getTranscriptionId()
        );

        int id = 0;

        if (rs.next()) {
            id = rs.getInt("ID_INSIGHT");
        }

        rs.close();
        return id;
    }

    public ArrayList<Insight> listInsights() throws SQLException {
        ArrayList<Insight> insights = new ArrayList<>();

        ResultSet rs = select(
                "SELECT ID_INSIGHT, ID_TRANSCRICAO, TIPO, DESCRICAO, SENTIMENTO, SUGESTAO_ACAO FROM INSIGHT ORDER BY ID_INSIGHT"
        );

        while (rs.next()) {
            Insight insight = new Insight(
                    rs.getInt("ID_INSIGHT"),
                    rs.getInt("ID_TRANSCRICAO"),
                    rs.getString("TIPO"),
                    rs.getString("DESCRICAO"),
                    rs.getString("SENTIMENTO"),
                    rs.getString("SUGESTAO_ACAO")
            );

            insights.add(insight);
        }

        rs.close();
        return insights;
    }
}
