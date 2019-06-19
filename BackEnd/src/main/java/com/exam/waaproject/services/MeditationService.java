package com.exam.waaproject.services;

import com.exam.waaproject.domain.Meditation;

import java.util.List;

public interface MeditationService {
    public Meditation save(Meditation record);

    public Iterable<Meditation> saveAll(List<Meditation> meditations);

    public boolean isNotExist(Meditation meditation);
}
