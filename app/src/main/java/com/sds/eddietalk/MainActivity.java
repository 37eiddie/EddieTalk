package com.sds.eddietalk;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, IntroActivity.class));

        Typeface font = Typeface.createFromAsset(getAssets(), "TmonMonsori.otf");
        TextView galleryText = (TextView)findViewById(R.id.gallery_text);
        TextView callText = (TextView)findViewById(R.id.call_text);
        TextView sendMsgText = (TextView)findViewById(R.id.send_text);
        TextView moneyText = (TextView)findViewById(R.id.send_money_text);

        galleryText.setTypeface(font);
        callText.setTypeface(font);
        sendMsgText.setTypeface(font);
        moneyText.setTypeface(font);

        View galleryButton = findViewById(R.id.gallery_container);
        View callButton = findViewById(R.id.call_container);
        View sendTextButton = findViewById(R.id.send_text_container);
        View moneyButton = findViewById(R.id.money_container);

        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GalleryActivity.class));
            }
        });

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-4055-3384"));
                startActivity(intent);
            }
        });

        sendTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:010-4055-3384"));
                intent.putExtra("sms_body", "자니...?");
                startActivity(intent);
            }
        });

        moneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipData cd = ClipData.newPlainText("text", "전형배님이 우리은행 010-4055-3384으로 28원 송금을 요청하셨습니다.");

                ClipboardManager cm = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setPrimaryClip(cd);

                Intent intent = getApplicationContext().getPackageManager().getLaunchIntentForPackage("viva.republica.toss");
                startActivity(intent);
            }
        });
    }
}
