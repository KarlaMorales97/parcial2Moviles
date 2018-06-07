
package com.morales.parcial2moviles.News;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.morales.parcial2moviles.R;

public class Book_Activity extends AppCompatActivity {

    private TextView txttittle, txtcategoru,txtdescription;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_);


        txttittle = (TextView) findViewById(R.id.titleBook);
        txtcategoru = (TextView) findViewById(R.id.categoryBook);
        txtdescription = (TextView) findViewById(R.id.descriptionBook);
        img = (ImageView) findViewById(R.id.bookThumball);


        //RECIBIR DAATOS
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String tittle = (String) bundle.getString("Karla");
            String category = (String) bundle.getString("Beatriz");
            String description = (String) bundle.getString("Morales");
            int image = bundle.getInt("Thumball");

            txttittle.setText(tittle);
            txtcategoru.setText(category);
            txtdescription.setText(description);
            img.setImageResource(image);
        }


    }
}
