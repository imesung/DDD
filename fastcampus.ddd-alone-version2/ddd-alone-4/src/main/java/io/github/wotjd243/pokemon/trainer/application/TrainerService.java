package io.github.wotjd243.pokemon.trainer.application;

import io.github.wotjd243.pokemon.trainer.domain.Trainer;
import io.github.wotjd243.pokemon.trainer.domain.TrainerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }
    
    @Transactional
    public Trainer join(final String id) {
        return trainerRepository.save(new Trainer(id));
    }
}
