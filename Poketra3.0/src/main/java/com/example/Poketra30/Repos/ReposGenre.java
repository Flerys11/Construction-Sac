package com.example.Poketra30.Repos;

import com.example.Poketra30.Model.ClientModel;
import com.example.Poketra30.Model.GenreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReposGenre extends JpaRepository<GenreModel, Integer> {
    @Query(value = "select * from genreClient", nativeQuery = true)
    public List<GenreModel> findone();
}
