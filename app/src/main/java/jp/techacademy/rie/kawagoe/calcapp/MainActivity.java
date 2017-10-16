package jp.techacademy.rie.kawagoe.calcapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.InputType;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);
    }


    @Override
    public void onClick(View v) {
        try {
            double etext1 = Double.parseDouble(mEditText1.getText().toString());
            double etext2 = Double.parseDouble(mEditText2.getText().toString());

            Intent intent = new Intent(this, SecondActivity.class);

            if (v.getId() == R.id.button1) {
                intent.putExtra("VALUE1", etext1 + etext2);
            } else if (v.getId() == R.id.button2) {
                intent.putExtra("VALUE1", etext1 - etext2);
            } else if (v.getId() == R.id.button3) {
                intent.putExtra("VALUE1", etext1 * etext2);
            } else if (v.getId() == R.id.button4) {
                intent.putExtra("VALUE1", etext1 / etext2);
            }

            startActivity(intent);
        } catch (
                NumberFormatException e)

        {
            showAlertDialog();
        }
    }


    private void showAlertDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // Setting Dialog Title
        alertDialogBuilder.setTitle("Alert Dialog");

        // Setting Dialog Message
        alertDialogBuilder.setMessage("数値が入力されていません");


        // Setting OK Button
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                mEditText1.getEditableText().clear();
                mEditText2.getEditableText().clear();
                mEditText1.requestFocus();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        // Showing Alert Message
        alertDialog.show();
    }
}

