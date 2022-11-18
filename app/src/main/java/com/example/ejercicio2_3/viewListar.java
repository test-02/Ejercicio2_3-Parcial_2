package com.example.ejercicio2_3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicio2_3.Modelo.Photograph;
import com.example.ejercicio2_3.configuraciones.SQLiteConexion;
import com.example.ejercicio2_3.configuraciones.Transacciones;

import java.util.ArrayList;

public class viewListar extends AppCompatActivity {
    Button btnNuevaImagen;

    SQLiteConexion conexion;
    RecyclerView.Adapter adapter;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Photograph> imagenList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_listar);

        btnNuevaImagen = (Button) findViewById(R.id.btnNuevaImagen);

        conexion = new SQLiteConexion(this,  Transacciones.NameDatabase,null,1);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        imagenList = new ArrayList<>();
        listarImagenes();

        adapter = new Adapter(imagenList);
        recyclerView.setAdapter(adapter);

        btnNuevaImagen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void listarImagenes() {
        SQLiteDatabase db = conexion.getReadableDatabase();

        Photograph imagenes = null;

        Cursor cursor = db.rawQuery("SELECT * FROM "+ Transacciones.tablaPhotograph,null);

        while (cursor.moveToNext()) {
            imagenes = new Photograph();
            imagenes.setId(cursor.getInt(0));
            imagenes.setDescripcion(cursor.getString(1));
            imagenes.setImagen(cursor.getString(2));

            imagenList.add(imagenes);
        }
    }

}