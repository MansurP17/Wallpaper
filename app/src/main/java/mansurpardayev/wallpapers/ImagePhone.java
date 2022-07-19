package mansurpardayev.wallpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImagePhone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_phone);
        ImageView imageView = findViewById(R.id.imageP);
        String url = getIntent().getStringExtra("imageP");
        Picasso.with(this)
                .load(url)
                .error(R.drawable.errorphone)
                .into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}