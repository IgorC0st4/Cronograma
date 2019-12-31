package br.com.cronograma.dao;

import androidx.room.*;

import java.util.List;

import br.com.cronograma.model.Cronograma;

@Dao
public interface CronogramaDAO {
    @Insert
    void insert(Cronograma Cronograma);

    @Insert
    void insertAll(List<Cronograma> Cronogramas);

    @Delete
    void delete(Cronograma Cronograma);

    @Update
    void update(Cronograma Cronograma);

    @Update
    void updateAll(List<Cronograma> Cronogramas);

    @Query("SELECT * FROM Cronograma ORDER BY id ASC")
    List<Cronograma> getAll();
}
