package jp.techacademy.takumi.nakamura.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText mEditText1;

    EditText mEditText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        Intent intent = new Intent(this, SecondActivity.class);
        try {
            double value1 = Double.parseDouble(mEditText1.getText().toString());
            double value2 = Double.parseDouble(mEditText2.getText().toString());
            intent.putExtra("VALUE2", value1);
            intent.putExtra("VALUE2", value2);
            if (v.getId() == R.id.button1) {
                intent.putExtra("result", value1 + value2);

            } else if (v.getId() == R.id.button2) {
                intent.putExtra("result", value1 - value2);

            } else if (v.getId() == R.id.button3) {
                intent.putExtra("result", value1 * value2);

            } else if (v.getId() == R.id.button4 && value2 == 0) {
                Toast.makeText(MainActivity.this,
                        "0で割らないでください",
                        Toast.LENGTH_LONG).show();

            } else if (v.getId() == R.id.button4) {
                intent.putExtra("result", value1 / value2);
            }
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this,
                    "数字を入力してください",
                    Toast.LENGTH_LONG).show();


        }


        startActivity(intent);


    }
}



