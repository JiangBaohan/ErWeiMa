package com.sevenheaven.zxingdemo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    ImageView qrcode1;
    ImageView qrcode2;
    private EditText ed;
    private Button but;
    private EditText ed1;
    private Button but1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed = (EditText) findViewById(R.id.et);
        but = (Button) findViewById(R.id.button);
        ed1 = (EditText) findViewById(R.id.et1);
        but1 = (Button) findViewById(R.id.button1);
        qrcode1 = (ImageView) findViewById(R.id.qrcode1);
        qrcode2 = (ImageView) findViewById(R.id.qrcode2);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrcode1.setImageBitmap(QRCode.createQRCodeWithLogo2(ed.getText().toString(), 500, drawableToBitmap(getResources().getDrawable(R.drawable.ic_010))));
            }
        });
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        qrcode2.setImageBitmap(QRCode.createQRCodeWithLogo3(ed1.getText().toString(), 500, drawableToBitmap(getResources().getDrawable(R.drawable.ic_016))));
            }
        });}

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }
}
