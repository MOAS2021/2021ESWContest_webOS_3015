package dongyang.jeff.refrigeratorapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SubActivity2 extends AppCompatActivity {
    Intent intent;
    Bundle extras;
    ImageView productImage;
    TextView producText, expirationDate1,expirationDate2;
    Drawable beer, egg, greenonnion, icecream, meat, milk, tomato;
    String name;
    int ed, num, code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        productImage=findViewById(R.id.productImage);
        producText=findViewById(R.id.producText);
        expirationDate1=findViewById(R.id.expirationDate1);
        expirationDate2=findViewById(R.id.expirationDate2);
        beer = getResources().getDrawable(R.drawable.beer);
        egg = getResources().getDrawable(R.drawable.egg);
        greenonnion = getResources().getDrawable(R.drawable.greenonion);
        icecream = getResources().getDrawable(R.drawable.icecream);
        meat = getResources().getDrawable(R.drawable.meat);
        milk = getResources().getDrawable(R.drawable.milk);
        tomato = getResources().getDrawable(R.drawable.tomato);
        Drawable imege[] ={beer,egg,greenonnion,icecream,meat,milk,tomato};

        intent = getIntent();
        extras =intent.getExtras();
        name = extras.getString(SubActivity1.IFNAME);
        code = extras.getInt(SubActivity1.PRODUCT);
        num = extras.getInt(SubActivity1.IFNUM);
        ed = extras.getInt(SubActivity1.IFDB);

        productImage.setImageDrawable(imege[code]);
        producText.setText(name);
        expirationDate1.setText(Integer.toString(ed));
        expirationDate2.setText(num+"개");
    }
}