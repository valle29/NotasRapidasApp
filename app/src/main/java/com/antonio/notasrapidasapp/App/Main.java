package com.antonio.notasrapidasapp.App;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.abhijith.listview_snapshot.ListViewSnapshot;
import com.antonio.notasrapidasapp.Adapter.NotesAdapter;
import com.antonio.notasrapidasapp.R;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {

    private TextView txtNumNotas;
    private int N_Notas;
    private ListView listNotas;
    private AdaptadorNotas adaptadorNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        N_Notas = 12;

        txtNumNotas = (TextView) findViewById(R.id.txtNumNotas);
        txtNumNotas.setText("Usted tiene "+N_Notas+" notas");

        ArrayList<NotesAdapter> notesArray = new ArrayList<NotesAdapter>();

        adaptadorNotas = new AdaptadorNotas(getApplicationContext(),R.layout.row_notas,notesArray);

        notesArray.add(new NotesAdapter("Mi primer nota"));
        notesArray.add(new NotesAdapter("Mi segunda nota"));
        notesArray.add(new NotesAdapter("Mi tercera nota"));
        notesArray.add(new NotesAdapter("Mi cuarta nota"));
        notesArray.add(new NotesAdapter("Mi quinta nota"));
        notesArray.add(new NotesAdapter("Mi sexta nota"));
        notesArray.add(new NotesAdapter("Mi primer nota"));
        notesArray.add(new NotesAdapter("Mi segunda nota"));
        notesArray.add(new NotesAdapter("Mi tercera nota"));
        notesArray.add(new NotesAdapter("Mi cuarta nota"));
        notesArray.add(new NotesAdapter("Mi quinta nota"));
        notesArray.add(new NotesAdapter("Mi sexta nota"));
        notesArray.add(new NotesAdapter("Mi primer nota"));
        notesArray.add(new NotesAdapter("Mi segunda nota"));
        notesArray.add(new NotesAdapter("Mi tercera nota"));
        notesArray.add(new NotesAdapter("Mi cuarta nota"));
        notesArray.add(new NotesAdapter("Mi quinta nota"));
        notesArray.add(new NotesAdapter("Mi sexta nota"));

        listNotas = (ListView) findViewById(R.id.listNotas);
        listNotas = (ListView) findViewById(R.id.listNotas);
        listNotas.setItemsCanFocus(false);
        listNotas.setAdapter(adaptadorNotas);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    public class AdaptadorNotas extends ArrayAdapter<NotesAdapter>{

        Context context;
        int layoutResourceId;
        ArrayList<NotesAdapter> data = new ArrayList<NotesAdapter>();

        public AdaptadorNotas(Context context, int layoutResourceId, ArrayList<NotesAdapter> data){
            super(context, layoutResourceId, data);
            this.layoutResourceId = layoutResourceId;
            this.context = context;
            this.data = data;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View row = convertView;
            NoteHolder holder = null;

            if (row == null) {

                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(layoutResourceId, parent, false);
                holder = new NoteHolder();
                holder.txtTitulo = (TextView) row.findViewById(R.id.txtTitulo);
                //holder.txtTitulo.setTypeface(RobotoCondensed_Regular);

                row.setTag(holder);

                final NoteHolder finalHolder = holder;
                row.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Intent login = new Intent(Nav_Historial.this, Historial_Detalle.class);
                        //String request_id=finalHolder.txtIdHistorial.getText().toString();
                        //login.putExtra("request_id", request_id);
                        //startActivity(login);
                    }
                });
            } else {
                holder = (NoteHolder) row.getTag();
            }

            if (holder != null)
            {
                NotesAdapter nota = data.get(position);
                holder.txtTitulo.setText(nota.getTitulo());
            }

            return row;
        }
    }

    class NoteHolder {
        TextView txtTitulo;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
