package br.com.cronograma.dao;

import androidx.room.*;

import java.util.List;

import br.com.cronograma.model.Horario;

@Dao
public interface HorarioDAO {

    @Insert
    void insert(Horario horario);

    @Insert
    void insertAll(List<Horario> horarios);

    @Delete
    void delete(Horario horario);

    @Update
    void update(Horario horario);

    @Update
    void updateAll(List<Horario> horarios);

    @Query("SELECT * FROM horario ORDER BY id ASC")
    List<Horario> getAll();
}
