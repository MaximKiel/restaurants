package ru.election.repository;

import ru.election.model.Vote;

import java.util.List;

public interface VoteRepository extends BaseRepository<Vote> {

    Vote get(int id);

    List<Vote> getAll();
}
