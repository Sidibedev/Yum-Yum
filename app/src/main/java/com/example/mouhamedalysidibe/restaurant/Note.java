package com.example.mouhamedalysidibe.restaurant;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by mouhamed aly sidibe on 07/06/2017.
 */
public class Note extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note);

        Button note = (Button) findViewById(R.id.buttonnoter);
        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final AlertDialog yes = new AlertDialog.Builder(Note.this).create();
                yes.setTitle("YUM_YUM");

                yes.setMessage("YUM_YUM vous remercie !");
                yes.setButton(AlertDialog.BUTTON_NEUTRAL,"OK",new  DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        yes.cancel();
                    }
                });
                yes.show();

            }
        });

    }


}
