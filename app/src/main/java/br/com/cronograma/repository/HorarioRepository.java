package br.com.cronograma.repository;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import br.com.cronograma.database.AppDatabase;
import br.com.cronograma.model.Horario;

public class HorarioRepository {
    private Context context;

    public HorarioRepository(Context context) {
        this.context = context;
    }

    public boolean insert(Horario horario) {
        try {
            return new Insert().execute(horario).get();
        } catch (Exception e) {
            Log.e("ERRO INSERT HOR REP", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertAll(List<Horario> horarios) {
        try {
            return new InsertAll().execute(horarios).get();
        } catch (Exception e) {
            Log.e("ERRO INSERT LHOR REP", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Horario horario) {
        try {
            return new Delete().execute(horario).get();
        } catch (Exception e) {
            Log.e("ERRO DELETE HOR REP", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Horario horario) {
        try {
            return new Update().execute(horario).get();
        } catch (Exception e) {
            Log.e("ERRO UPDATE HOR REP", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAll(List<Horario> horarios) {
        try {
            return new UpdateAll().execute(horarios).get();
        } catch (Exception e) {
            Log.e("ERRO UPDATE LHOR REP", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Horario> getAll() {
        try {
            return new GetAll().execute().get();
        } catch (Exception e) {
            Log.e("ERRO UPDATE LHOR REP", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private class Insert extends AsyncTask<Horario, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Horario... horarios) {
            try {
                AppDatabase.getAppDatabase(context).horarioDAO().insert(horarios[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO INSERT HOR ASYNC", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    private class InsertAll extends AsyncTask<List<Horario>, Void, Boolean> {

        @Override
        protected Boolean doInBackground(List<Horario>... lists) {
            try {
                AppDatabase.getAppDatabase(context).horarioDAO().insertAll(lists[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO INSERT LHOR ASYNC", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    private class Delete extends AsyncTask<Horario, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Horario... horarios) {
            try {
                AppDatabase.getAppDatabase(context).horarioDAO().delete(horarios[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO DELETE HOR ASYNC", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    private class Update extends AsyncTask<Horario, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Horario... horarios) {
            try {
                AppDatabase.getAppDatabase(context).horarioDAO().update(horarios[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO DELETE HOR ASYNC", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    private class UpdateAll extends AsyncTask<List<Horario>, Void, Boolean> {
        @Override
        protected Boolean doInBackground(List<Horario>... lists) {
            try {
                AppDatabase.getAppDatabase(context).horarioDAO().updateAll(lists[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO DELETE HOR ASYNC", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    private class GetAll extends AsyncTask<Void, Void, List<Horario>> {
        @Override
        protected List<Horario> doInBackground(Void... voids) {
            try {
                return AppDatabase.getAppDatabase(context).horarioDAO().getAll();
            } catch (Exception e) {
                Log.e("ERRO DELETE HOR ASYNC", e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
    }
}