package br.com.cronograma.repository;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import br.com.cronograma.database.AppDatabase;
import br.com.cronograma.model.Cronograma;

public class CronogramaRepository {
    private Context context;

    public CronogramaRepository(Context context) {
        this.context = context;
    }

    public boolean insert(Cronograma cronograma) {
        try {
            return new Insert().execute(cronograma).get();
        } catch (Exception e) {
            Log.e("ERRO INSERT CRON REP", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertAll(List<Cronograma> cronogramas) {
        try {
            return new InsertAll().execute(cronogramas).get();
        } catch (Exception e) {
            Log.e("ERRO INSERT LCRON REP", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Cronograma cronograma) {
        try {
            return new Delete().execute(cronograma).get();
        } catch (Exception e) {
            Log.e("ERRO DELETE CRON REP", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Cronograma cronograma) {
        try {
            return new Update().execute(cronograma).get();
        } catch (Exception e) {
            Log.e("ERRO UPDATE CRON REP", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAll(List<Cronograma> cronogramas) {
        try {
            return new UpdateAll().execute(cronogramas).get();
        } catch (Exception e) {
            Log.e("ERRO UPDATE LCRON REP", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Cronograma> getAll() {
        try {
            return new GetAll().execute().get();
        } catch (Exception e) {
            Log.e("ERRO UPDATE LCRON REP", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private class Insert extends AsyncTask<Cronograma, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Cronograma... cronogramas) {
            try {
                AppDatabase.getAppDatabase(context).cronogramaDAO().insert(cronogramas[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO INSERT CRON ASYNC", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    private class InsertAll extends AsyncTask<List<Cronograma>, Void, Boolean> {

        @Override
        protected Boolean doInBackground(List<Cronograma>... lists) {
            try {
                AppDatabase.getAppDatabase(context).cronogramaDAO().insertAll(lists[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO INSERT LCRON ASYNC", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    private class Delete extends AsyncTask<Cronograma, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Cronograma... cronogramas) {
            try {
                AppDatabase.getAppDatabase(context).cronogramaDAO().delete(cronogramas[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO DELETE CRON ASYNC", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    private class Update extends AsyncTask<Cronograma, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Cronograma... cronogramas) {
            try {
                AppDatabase.getAppDatabase(context).cronogramaDAO().update(cronogramas[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO DELETE CRON ASYNC", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    private class UpdateAll extends AsyncTask<List<Cronograma>, Void, Boolean> {
        @Override
        protected Boolean doInBackground(List<Cronograma>... lists) {
            try {
                AppDatabase.getAppDatabase(context).cronogramaDAO().updateAll(lists[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO DELETE CRON ASYNC", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    private class GetAll extends AsyncTask<Void, Void, List<Cronograma>> {
        @Override
        protected List<Cronograma> doInBackground(Void... voids) {
            try {
                return AppDatabase.getAppDatabase(context).cronogramaDAO().getAll();
            } catch (Exception e) {
                Log.e("ERRO DELETE CRON ASYNC", e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
    }
}