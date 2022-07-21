package mansurpardayev.wallpapers.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import mansurpardayev.wallpapers.R;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ImageView tg = findViewById(R.id.tg);
        TextView privacy = findViewById(R.id.privacy);
        SpannableString content = new SpannableString("Read Privacy Policy.");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        privacy.setText(content);
        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // https://telegra.ph/Privacy-Policy-07-20-14
                String url = "https://telegra.ph/Privacy-Policy-07-20-14";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        tg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://t.me/Mansur_Blog";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }

    public void back(View view) {
        onBackPressed();
    }
}