package br.com.cronograma.repository;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import br.com.cronograma.database.AppDatabase;
import br.com.cronograma.model.Disciplina;

public class DisciplinaRepository {
    private Context context;

    public DisciplinaRepository(Context context) {
        this.context = context;
    }

    public boolean insert(Disciplina disciplina) {
        try {
            return new Insert().execute(disciplina).get();
        } catch (Exception e) {
            Log.e("ERRO INSERT DISC REP", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertAll(List<Disciplina> disciplinas) {
        try {
            return new InsertAll().execute(disciplinas).get();
        } catch (Exception e) {
            Log.e("ERRO INSERT LDISC REP", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Disciplina disciplina) {
        try {
            return new Delete().execute(disciplina).get();
        } catch (Exception e) {
            Log.e("ERRO DELETE DISC REP", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Disciplina disciplina) {
        try {
            return new Update().execute(disciplina).get();
        } catch (Exception e) {
            Log.e("ERRO UPDATE DISC REP", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAll(List<Disciplina> disciplinas) {
        try {
            return new UpdateAll().execute(disciplinas).get();
        } catch (Exception e) {
            Log.e("ERRO UPDATE LDISC REP", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Disciplina> getAll() {
        try {
            return new GetAll().execute().get();
        } catch (Exception e) {
            Log.e("ERRO UPDATE LDISC REP", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private class Insert extends AsyncTask<Disciplina, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Disciplina... disciplinas) {
            try {
                AppDatabase.getAppDatabase(context).disciplinaDAO().insert(disciplinas[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO INSERT DISC ASYNC", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    private class InsertAll extends AsyncTask<List<Disciplina>, Void, Boolean> {

        @Override
        protected Boolean doInBackground(List<Disciplina>... lists) {
            try {
                AppDatabase.getAppDatabase(context).disciplinaDAO().insertAll(lists[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO INSERT LDISC ASYNC", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    private class Delete extends AsyncTask<Disciplina, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Disciplina... disciplinas) {
            try {
                AppDatabase.getAppDatabase(context).disciplinaDAO().delete(disciplinas[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO DELETE DISC ASYNC", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    private class Update extends AsyncTask<Disciplina, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Disciplina... disciplinas) {
            try {
                AppDatabase.getAppDatabase(context).disciplinaDAO().update(disciplinas[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO DELETE DISC ASYNC", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    private class UpdateAll extends AsyncTask<List<Disciplina>, Void, Boolean> {
        @Override
        protected Boolean doInBackground(List<Disciplina>... lists) {
            try {
                AppDatabase.getAppDatabase(context).disciplinaDAO().updateAll(lists[0]);
                return true;
            } catch (Exception e) {
                Log.e("ERRO DELETE DISC ASYNC", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    private class GetAll extends AsyncTask<Void, Void, List<Disciplina>> {
        @Override
        protected List<Disciplina> doInBackground(Void... voids) {
            try {
                return AppDatabase.getAppDatabase(context).disciplinaDAO().getAll();
            } catch (Exception e) {
                Log.e("ERRO DELETE DISC ASYNC", e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
    }
}
