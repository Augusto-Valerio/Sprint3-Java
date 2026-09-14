package br.com.fiap.services;

import br.com.fiap.entities.Insight;

public class InsightService {


    public Insight generateInsight(int transcriptionId, String content) {
        String sentiment = "NEUTRO";

        if (content.toLowerCase().contains("problema") || content.toLowerCase().contains("erro")) {
            sentiment = "NEGATIVO";
        } else if (content.toLowerCase().contains("melhorar") || content.toLowerCase().contains("oportunidade")) {
            sentiment = "POSITIVO";
        }

        return new Insight(
                transcriptionId,
                "OPORTUNIDADE",
                "A conversa possui pontos que podem indicar uma oportunidade para a TOTVS.",
                sentiment,
                "Analisar a transcrição e avaliar uma proposta de melhoria para a empresa atendida."
        );
    }
}
