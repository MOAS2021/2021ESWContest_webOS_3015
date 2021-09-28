package dongyang.jeff.refrigeratorapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SubActivity1 extends AppCompatActivity {
    Intent intent1, intent2;
    Bundle extras1,extras2;
    public final static String PRODUCT = "제품 코드";
    public final static String IFNUM = "제품 개수";
    public final static String IFNAME = "제품 이름";
    public final static String IFDB = "제품 유통기한";
    String productName=" ";
    String strBeer="맥주", strEgg="달걀", strGreenonion="파", strIcecream="아이스크림", strMeat="고기", strMilk="우유", strTomato="토마토";
    int productNumber, expirationDate, count=-1;
    int oneStart = value.onStart;
    Drawable beer, egg, greenonnion, icecream, meat, milk, tomato;
    ImageView productImage0, productImage1, productImage2, productImage3, productImage4, productImage5, productImage6,
            backView0, backView1, backView2, backView3, backView4, backView5, backView6;
    TextView productText0, productText1, productText2, productText3, productText4, productText5, productText6,
            productNum0, productNum1, productNum2, productNum3, productNum4, productNum5, productNum6,
         plus0,plus1,plus2,plus3,plus4,plus5,plus6,minus0,minus1,minus2,minus3,minus4,minus5,minus6;
    ImageView productImage[]={productImage0,productImage1,productImage2,productImage3,productImage4,productImage5,productImage6};
    ImageView backView[]={backView0,backView1,backView2,backView3,backView4,backView5,backView6};
    TextView productText[]={productText0,productText1,productText2,productText3,productText4,productText5,productText6};
    TextView productNum[]={productNum0,productNum1,productNum2,productNum3,productNum4,productNum5,productNum6};
    TextView plusBotton[]={plus0,plus1,plus2,plus3,plus4,plus5,plus6};
    TextView minusButton[]={minus0,minus1,minus2,minus3,minus4,minus5,minus6};
    String ifName[]={strBeer,strEgg,strGreenonion,strIcecream,strMeat,strMilk,strTomato};

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference conditionRef = mRootRef.child("Refrigerator");
    DatabaseReference firebaseCount = conditionRef.child("COUNT");
    DatabaseReference RefrigeratorRef[]= {
            conditionRef.child("PRODUCT0"),
            conditionRef.child("PRODUCT1"),
            conditionRef.child("PRODUCT2"),
            conditionRef.child("PRODUCT3"),
            conditionRef.child("PRODUCT4"),
            conditionRef.child("PRODUCT5"),
            conditionRef.child("PRODUCT6")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        productText[0] = findViewById(R.id.productText0);
        productText[1] = findViewById(R.id.productText1);
        productText[2] = findViewById(R.id.productText2);
        productText[3] = findViewById(R.id.productText3);
        productText[4] = findViewById(R.id.productText4);
        productText[5] = findViewById(R.id.productText5);
        productText[6] = findViewById(R.id.productText6);

        productImage[0] = findViewById(R.id.productImage0);
        productImage[1] = findViewById(R.id.productImage1);
        productImage[2] = findViewById(R.id.productImage2);
        productImage[3] = findViewById(R.id.productImage3);
        productImage[4] = findViewById(R.id.productImage4);
        productImage[5] = findViewById(R.id.productImage5);
        productImage[6] = findViewById(R.id.productImage6);

        productNum[0] = findViewById(R.id.productNum0);
        productNum[1] = findViewById(R.id.productNum1);
        productNum[2] = findViewById(R.id.productNum2);
        productNum[3] = findViewById(R.id.productNum3);
        productNum[4] = findViewById(R.id.productNum4);
        productNum[5] = findViewById(R.id.productNum5);
        productNum[6] = findViewById(R.id.productNum6);

        backView[0] = findViewById(R.id.backView0);
        backView[1] = findViewById(R.id.backView1);
        backView[2] = findViewById(R.id.backView2);
        backView[3] = findViewById(R.id.backView3);
        backView[4] = findViewById(R.id.backView4);
        backView[5] = findViewById(R.id.backView5);
        backView[6] = findViewById(R.id.backView6);

        plusBotton[0] = findViewById(R.id.plus0);
        plusBotton[1] = findViewById(R.id.plus1);
        plusBotton[2] = findViewById(R.id.plus2);
        plusBotton[3] = findViewById(R.id.plus3);
        plusBotton[4] = findViewById(R.id.plus4);
        plusBotton[5] = findViewById(R.id.plus5);
        plusBotton[6] = findViewById(R.id.plus6);

        minusButton[0] = findViewById(R.id.minus0);
        minusButton[1] = findViewById(R.id.minus1);
        minusButton[2] = findViewById(R.id.minus2);
        minusButton[3] = findViewById(R.id.minus3);
        minusButton[4] = findViewById(R.id.minus4);
        minusButton[5] = findViewById(R.id.minus5);
        minusButton[6] = findViewById(R.id.minus6);

        beer = getResources().getDrawable(R.drawable.beer);
        egg = getResources().getDrawable(R.drawable.egg);
        greenonnion = getResources().getDrawable(R.drawable.greenonion);
        icecream = getResources().getDrawable(R.drawable.icecream);
        meat = getResources().getDrawable(R.drawable.meat);
        milk = getResources().getDrawable(R.drawable.milk);
        tomato = getResources().getDrawable(R.drawable.tomato);
        Drawable imege[] ={beer,egg,greenonnion,icecream,meat,milk,tomato};
        if (oneStart==1){
            intent2 = getIntent();
            extras2 =intent2.getExtras();
            productName = extras2.getString(SubActivity4.PRODUCT_NAME);
            productNumber = extras2.getInt(SubActivity4.PRODUCT_NUMBER);
            expirationDate = extras2.getInt(SubActivity4.EXPIRATION_DATE);
            count= extras2.getInt(SubActivity4.COUNT);
            if (productName.equals("beer")){value.ifproduct[count]=0;}
            else if (productName.equals("egg")){value.ifproduct[count]=1;}
            else if (productName.equals("greenonion")){value.ifproduct[count]=2;}
            else if (productName.equals("icecream")){value.ifproduct[count]=3;}
            else if (productName.equals("meat")){value.ifproduct[count]=4;}
            else if (productName.equals("milk")){value.ifproduct[count]=5;}
            else if (productName.equals("tomato")){value.ifproduct[count]=6;}
            value.ifNum[count]=productNumber;
            value.ifED[count]=expirationDate;
            for (int i = 0; i<=count; i++){
                productImage[i].setVisibility(View.VISIBLE);
                backView[i].setVisibility(View.VISIBLE);
                productText[i].setVisibility(View.VISIBLE);
                productNum[i].setVisibility(View.VISIBLE);
                plusBotton[i].setVisibility(View.VISIBLE);
                minusButton[i].setVisibility(View.VISIBLE);
                productImage[i].setImageDrawable(imege[value.ifproduct[i]]);
                productText[i].setText(ifName[value.ifproduct[i]]);
                productNum[i].setText(value.ifNum[i]+"개");
                FirebaseSet(i);
            }
        }
        firebaseCount.setValue(count);
    }

    public void plusBotton0(View view){ pp(0); }
    public void plusBotton1(View view){ pp(1); }
    public void plusBotton2(View view){ pp(2); }
    public void plusBotton3(View view){ pp(3); }
    public void plusBotton4(View view){ pp(4); }
    public void plusBotton5(View view){ pp(5); }
    public void plusBotton6(View view){ pp(6); }

    public void minusBotton0(View view){ mm(0); }
    public void minusBotton1(View view){ mm(1); }
    public void minusBotton2(View view){ mm(2); }
    public void minusBotton3(View view){ mm(3); }
    public void minusBotton4(View view){ mm(4); }
    public void minusBotton5(View view){ mm(5); }
    public void minusBotton6(View view){ mm(6); }

    public void listZero(View view){
        av2(0);
    }

    public void listOne(View view){
        av2(1);
    }

    public void listTwo(View view){
        av2(2);
    }

    public void listThree(View view){
        av2(3);
    }

    public void listFour(View view){
        av2(4);
    }

    public void listFive(View view){
        av2(5);
    }

    public void listSix(View view){
        av2(6);
    }
    public void plusButton(View view){
        value.onStart=1;
        intent2 = new Intent(getApplicationContext(),SubActivity4.class);
        startActivity(intent2);
    }
    public void av2(int num){
        intent1 = new Intent(getApplicationContext(),SubActivity2.class);
        extras1 = new Bundle();
        extras1.putString(IFNAME,ifName[value.ifproduct[num]]);
        extras1.putInt(PRODUCT,value.ifproduct[num]);
        extras1.putInt(IFNUM,value.ifNum[num]);
        extras1.putInt(IFDB,value.ifED[num]);
        intent1.putExtras(extras1);
        startActivity(intent1);}

    public void pp(int num){
        DatabaseReference numf = RefrigeratorRef[num].child("num");
        if (value.ifNum[num]<1000){
            value.ifNum[num]+=1;
            productNum[num].setText(value.ifNum[num]+"개");
            numf.setValue(value.ifNum[num]);}
    }

    public void mm(int num){
        DatabaseReference numf = RefrigeratorRef[num].child("num");
        if (value.ifNum[num]>0){
            value.ifNum[num]-=1;
            productNum[num].setText(value.ifNum[num]+"개");
            numf.setValue(value.ifNum[num]);}
    }
    public void FirebaseSet(int id){
        DatabaseReference date = RefrigeratorRef[id].child("date");
        DatabaseReference name = RefrigeratorRef[id].child("name");
        DatabaseReference num = RefrigeratorRef[id].child("num");
        date.setValue(value.ifED[id]);
        name.setValue(ifName[value.ifproduct[id]]);
        num.setValue(value.ifNum[id]);
    }
}

