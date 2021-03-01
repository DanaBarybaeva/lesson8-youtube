package com.example.menular;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView choose,choose2;
    RadioButton radio1,radio2;
    CheckBox checkbox1,checkbox2;
    Button zhiberuButton;
    String oku, grant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        choose = findViewById(R.id.choose);
        registerForContextMenu(choose);

        choose2 = findViewById(R.id.choose2);
        registerForContextMenu(choose2);

        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        checkbox1 = findViewById(R.id.checkbox1);
        checkbox2 = findViewById(R.id.checkbox2);
        zhiberuButton = findViewById(R.id.zhiberubutton);

        zhiberuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radio1.isChecked()){
                    oku= "online";
                }
                else if(radio2.isChecked()){
                    oku="offline";
                }
                if(checkbox1.isChecked()){
                    grant= "grant";
                }
                if(checkbox2.isChecked()){
                    grant="paid base";
                }
                String result = "University: " + choose.getText()+"\n"
                        +"College: " + choose2.getText()
                        +"\n"+ "Documents: "
                        + oku+"\n"
                        +"Oku: "+grant;
                Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v == choose){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.uzakmenu, menu);
        }
        else if(v == choose2){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.uzakmenu2, menu);
        }

        super.onCreateContextMenu(menu, v, menuInfo);


    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.uib:
                choose2.setText("UIB");
                break;
            case R.id.ny:
                choose2.setText("NY university");
                break;
            case R.id.mit:
                choose2.setText("MIT");
                break;
            case R.id.sdu:
                choose2.setText("SDU");
                break;

            case R.id.ktl:
                choose.setText("KTl");
                break;
            case R.id.oxford:
                choose.setText("Oxford");
                break;
            case R.id.galaxy:
                choose.setText("Galaxy");
                break;
            case R.id.jic:
                choose.setText("JIHC");
                break;

        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.xmlmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                Toast.makeText(this, "basyldy", Toast.LENGTH_SHORT).show();
                break;

            case R.id.save:
                Toast.makeText(this, "save basyldy", Toast.LENGTH_SHORT).show();
                break;
            case R.id.leave:
                Toast.makeText(this, "leave basyldy", Toast.LENGTH_SHORT).show();
                break;

            case R.id.exist:
                Toast.makeText(this, "exist basyldy", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}