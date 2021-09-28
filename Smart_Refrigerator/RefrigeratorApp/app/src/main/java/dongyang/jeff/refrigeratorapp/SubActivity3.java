package dongyang.jeff.refrigeratorapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SubActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub3);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
    public void inputButton1(View view){
        Intent intent = new Intent(getApplicationContext(),SubActivity4.class);
        startActivity(intent);
    }
    public void inputButton2(View view){
        Intent intent = new Intent(getApplicationContext(),SubActivity4.class);
        startActivity(intent);
    }
}