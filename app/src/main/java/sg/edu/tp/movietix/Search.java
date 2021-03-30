package sg.edu.tp.movietix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class Search extends AppCompatActivity {
    //array of movie lists
    String movienames[] = new String[] {"black panther", "wreck it ralph", "antman"};

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        EditText movietitle = (EditText)findViewById(R.id.searchFilter);
        ListView movielist = (ListView)findViewById(R.id.listofmovies);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, movienames);
        movielist.setAdapter(adapter);

        movietitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (Search.this).adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        //intent based on the positon of the array to intent to respective pages
        movielist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long postionofmovietitle) {
                if (postionofmovietitle==0){
                    Intent intent = new Intent(view.getContext(),ReviewBlackPanther.class);
                    startActivityForResult(intent,0);
                }

                if (postionofmovietitle==1){
                    Intent intent = new Intent(view.getContext(),ReviewWreckItRalph.class);
                    startActivityForResult(intent,1);
                }
                if (postionofmovietitle==2){
                    Intent intent = new Intent(view.getContext(),ReviewAntman.class);
                    startActivityForResult(intent,2);
                }
            }
        });
    }
}
