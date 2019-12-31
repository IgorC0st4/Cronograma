package br.com.cronograma.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.cronograma.R;
import br.com.cronograma.model.Disciplina;

public class DisciplinaAdapter extends BaseAdapter {
    private Activity activity;
    private Context context;
    private List<Disciplina> disciplinas;

    @Override
    public int getCount() {
        return disciplinas.size();
    }

    @Override
    public Object getItem(int position) {
        return disciplinas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return disciplinas.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = convertView;
        /*if (convertView == null)
            view = inflater.inflate(R.layout.list_layout, parent, false);

        TextView txtNome = view.findViewById(R.id.txt_nome);

        txtNome.setText(disciplinas.get(position).getNome());
*/
        return view;
    }
}
