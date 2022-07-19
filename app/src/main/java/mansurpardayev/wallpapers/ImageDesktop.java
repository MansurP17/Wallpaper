package mansurpardayev.wallpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageDesktop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_desktop);
        ImageView imageView = findViewById(R.id.imageD);
        String url = getIntent().getStringExtra("imageD");
        Picasso.with(this)
                .load(url)
                .error(R.drawable.errordesktop)
                .into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}