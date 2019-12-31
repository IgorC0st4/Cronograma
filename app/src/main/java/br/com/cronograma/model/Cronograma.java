package br.com.cronograma.model;

import androidx.annotation.NonNull;
import androidx.room.*;

import java.io.Serializable;

@Entity(tableName = "cronograma",
        indices = {@Index(value = {"id"}, unique = true)})
public class Cronograma implements Serializable {

    @NonNull
    @PrimaryKey
    private long id;

    @NonNull
    private int horariosDia;

    @NonNull
    private int qtdeDias;

    public Cronograma() {
    }

    @Ignore
    public Cronograma(long id, int horariosDia, int qtdeDias) {
        this.id = id;
        this.horariosDia = horariosDia;
        this.qtdeDias = qtdeDias;
    }

    @NonNull
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public int getHorariosDia() {
        return horariosDia;
    }

    public void setHorariosDia(int horariosDia) {
        this.horariosDia = horariosDia;
    }

    @NonNull
    public int getQtdeDias() {
        return qtdeDias;
    }

    public void setQtdeDias(int qtdeDias) {
        this.qtdeDias = qtdeDias;
    }

    @Override
    public String toString() {
        return "Cronograma{" +
                "id=" + id +
                ", horariosDia=" + horariosDia +
                ", qtdeDias=" + qtdeDias +
                '}';
    }
}
