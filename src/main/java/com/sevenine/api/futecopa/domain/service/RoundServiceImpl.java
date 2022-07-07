package com.sevenine.api.futecopa.domain.service;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.RoundData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.RoundRepository;
import com.sevenine.api.futecopa.domain.model.Round;
import com.sevenine.api.futecopa.domain.port.service.RoundService;
import com.sevenine.api.futecopa.mapper.RoundMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoundServiceImpl implements RoundService {

    private final RoundRepository repository;

    @Override
    public List<Round> rounds() {
        List<RoundData> roundsData = repository.findAll();

        return RoundMapper.INSTANCE.toRounds(roundsData);
    }

}
