package br.com.cronograma.database;

import android.content.Context;

import androidx.room.*;

import br.com.cronograma.dao.*;
import br.com.cronograma.model.*;

@Database(entities = {Cronograma.class, Disciplina.class, Horario.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CronogramaDAO cronogramaDAO();

    public abstract DisciplinaDAO disciplinaDAO();

    public abstract HorarioDAO horarioDAO();

    private static AppDatabase INSTANCE;

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "manager")
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
