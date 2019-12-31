package br.com.cronograma.dao;

import androidx.room.*;

import java.util.List;

import br.com.cronograma.model.Disciplina;

@Dao
public interface DisciplinaDAO {
    @Insert
    void insert(Disciplina Disciplina);

    @Insert
    void insertAll(List<Disciplina> Disciplinas);

    @Delete
    void delete(Disciplina Disciplina);

    @Update
    void update(Disciplina Disciplina);

    @Update
    void updateAll(List<Disciplina> Disciplinas);

    @Query("SELECT * FROM Disciplina ORDER BY id ASC")
    List<Disciplina> getAll();
}
