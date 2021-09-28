package dongyang.jeff.refrigeratorapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SubActivity4 extends AppCompatActivity {
    EditText date0, date1, date2;
    Intent intent;
    Bundle extras;
    public final static String PRODUCT_NAME = "제품 이름";
    public final static String EXPIRATION_DATE = "유통기한";
    public final static String PRODUCT_NUMBER = "제품 개수";
    public final static String COUNT = "카운트";
    String productName, expirationDate, productNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub4);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        date0=findViewById(R.id.date0);
        date1=findViewById(R.id.date1);
        date2=findViewById(R.id.date2);


    }

    public void inputButton(View view){
        intent = new Intent(getApplicationContext(),SubActivity1.class);
        extras = new Bundle();
        productName = date0.getText().toString();
        expirationDate = date1.getText().toString();
        productNumber = date2.getText().toString();
        if (productName.equals("맥주")||productName.equals("8801097250048")){ productName="beer";}
        if (productName.equals("우유")||productName.equals("8806011616047")){ productName="milk";}
        if (productName.equals("달걀")||productName.equals("계란")){ productName="egg";}
        if (productName.equals("파")){ productName="greenonion";}
        if (productName.equals("아이스크림")){ productName="icecream";}
        if (productName.equals("고기")){ productName="meat";}
        if (productName.equals("토마토")){ productName="tomato";}

        if (productName.equals("beer")||productName.equals("egg")||productName.equals("greenonion")||productName.equals("icecream")||
                productName.equals("meat")||productName.equals("milk")||productName.equals("tomato")){
        value.count+=1;
        extras.putString(PRODUCT_NAME,productName);
        extras.putInt(EXPIRATION_DATE,Integer.parseInt(expirationDate));
        extras.putInt(PRODUCT_NUMBER,Integer.parseInt(productNumber));
        extras.putInt(COUNT,value.count);
        intent.putExtras(extras);
        startActivity(intent);}
        else {
            Toast toast = Toast.makeText(getApplicationContext(),productName+"는(은) 등록되지않은 제품입니다.",Toast.LENGTH_SHORT);toast.show();
        }
    }
}