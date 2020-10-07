package com.example.libro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText isbn, nombre, autor;
    Button agregar;
    ListView listView;
    List<String> lista_libros = new ArrayList<>();
    ArrayAdapter<String> libros_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isbn = findViewById(R.id.edt_isbn);
        nombre = findViewById(R.id.edt_nombre);
        autor = findViewById(R.id.edt_autor);
        agregar = findViewById(R.id.btn_agregar);
        listView = findViewById(R.id.listview);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_agregar:
                String isbn_libro = isbn.getText().toString();
                String nombre_libro = nombre.getText().toString();
                String autor_libro=autor.getText().toString();

                if(TextUtils.isEmpty(isbn.getText().toString()) ||  TextUtils.isEmpty(nombre.getText().toString())
                        ||  TextUtils.isEmpty(autor.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Ingrese Todos los Datos!!!", Toast.LENGTH_LONG).show();
                }else if(isbn_libro.matches("[0-9]*")){

                lista_libros.add("isbn: " + isbn_libro + "\nnombre: " + nombre_libro + "\nautor: " + autor_libro);
                libros_adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista_libros);
                listView.setAdapter(libros_adapter);

                isbn.setText("");
                nombre.setText("");
                autor.setText("");

            }else {
                Toast.makeText(getApplicationContext(), "ISBN debe ser Numerico", Toast.LENGTH_LONG).show();
            }
        }
    }
}