package br.com.cronograma.model;

import androidx.annotation.NonNull;
import androidx.room.*;

import java.io.Serializable;

@Entity(tableName = "horario",
        foreignKeys = {@ForeignKey(entity = Disciplina.class,
                parentColumns = "id",
                childColumns = "id_disciplina",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE)},
        indices = {@Index(value = {"id"}, unique = true),
                @Index(value = {"id_disciplina"})})
public class Horario implements Serializable {

    @NonNull
    @PrimaryKey
    private long id;

    @NonNull
    private int ordem;

    @NonNull
    @ColumnInfo(name = "id_disciplina")
    private long id_disciplina;

    @NonNull
    private int dia;

    public Horario() {
    }

    @Ignore
    public Horario(long id, int ordem, long id_disciplina, int dia) {
        this.id = id;
        this.ordem = ordem;
        this.id_disciplina = id_disciplina;
        this.dia = dia;
    }

    @NonNull
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    @NonNull
    public long getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(long id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    @NonNull
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "id=" + id +
                ", ordem=" + ordem +
                ", id_disciplina=" + id_disciplina +
                ", dia=" + dia +
                '}';
    }
}
