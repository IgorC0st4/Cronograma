package br.com.cronograma.model;

import androidx.annotation.NonNull;
import androidx.room.*;

import java.io.Serializable;

@Entity(tableName = "disciplina",
        indices = {@Index(value = {"id"}, unique = true)})
public class Disciplina implements Serializable {

    @NonNull
    @PrimaryKey
    private long id;

    @NonNull
    private String nome;

    public Disciplina() {
    }

    @Ignore
    public Disciplina(long id, @NonNull String nome) {
        this.id = id;
        this.nome = nome;
    }

    @NonNull
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
