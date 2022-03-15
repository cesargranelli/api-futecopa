package com.sevenine.api.futecopa.interactors;

import com.sevenine.api.futecopa.datasources.sofascore.SofascoreClient;
import com.sevenine.api.futecopa.datasources.sofascore.dto.Round;
import com.sevenine.api.futecopa.datasources.sofascore.dto.SofascoreEventsResponse;
import com.sevenine.api.futecopa.datasources.sofascore.response.RoundResponse;
import com.sevenine.api.futecopa.entities.Rodada;
import com.sevenine.api.futecopa.interactors.mapper.RodadaMapper;
import com.sevenine.api.futecopa.repositories.RodadaRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RodadaService {

    private final SofascoreClient client;
    private final RodadaRepository repository;

    public void executar() {
        RoundResponse rounds = client.getRounds();

        if (rounds.getRounds().size() > 0) {
            Round currentRound = rounds.getCurrentRound();
            rounds.getRounds().forEach(round -> {
                StringBuilder sbRoundPath = new StringBuilder();
                if (StringUtils.isEmpty(round.getSlug())) {
                    sbRoundPath.append(round.getRound());
                } else {
                    sbRoundPath.append(round.getRound()).append("/slug/").append(round.getSlug());
                }
                SofascoreEventsResponse eventsByRound =
                        client.getEventsByRound(sbRoundPath.toString());

                Rodada rodada = RodadaMapper.INSTANCE.convertRoundToRodada(round, currentRound);
                rodada.setEventos(RodadaMapper.INSTANCE.convertEventsToEventos(eventsByRound.getEvents()));

                repository.atualizar(rodada);
            });
        } else {
            System.out.println(rounds);
        }
    }

}
