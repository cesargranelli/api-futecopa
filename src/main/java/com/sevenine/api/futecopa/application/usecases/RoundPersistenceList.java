package com.sevenine.api.futecopa.application.usecases;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.RoundData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.RoundRepository;
import com.sevenine.api.futecopa.application.domain.entities.Round;
import com.sevenine.api.futecopa.application.domain.ports.persistence.RoundPersistence;
import com.sevenine.api.futecopa.mapper.RoundMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoundPersistenceList implements RoundPersistence<Object, List<Round>> {

    private final RoundRepository repository;

    @Override
    public List<Round> execute(Object object) {
        List<RoundData> roundsData = repository.findAll();

        return RoundMapper.INSTANCE.toRounds(roundsData);
    }

}
