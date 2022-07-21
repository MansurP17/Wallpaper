package mansurpardayev.wallpapers.activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

import mansurpardayev.wallpapers.R;
import mansurpardayev.wallpapers.fragments.DesktopFragment;
import mansurpardayev.wallpapers.fragments.PhoneFragment;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> bottomItems;
    BottomNavigationView bottomNavigationView;

    Handler handler = new Handler();

    FloatingActionButton fab;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkInternet();
        handler.postDelayed(runnable, 10000);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        fab = findViewById(R.id.info_fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Info.class));
            }
        });

        bottomNavigationView.setBackground(null);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new PhoneFragment()).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.phoneMenu) {
                    checkInternet();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame, new PhoneFragment())
                            .addToBackStack(null)
                            .commit();

                    Toast.makeText(MainActivity.this, "Phone size", Toast.LENGTH_SHORT).show();

                    bottomItems.add(R.id.phoneMenu);



                }
                if (item.getItemId() == R.id.desktopMenu) {
                    InterstitialAd();
                    checkInternet();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame, new DesktopFragment())
                            .addToBackStack(null)
                            .commit();

                    Toast.makeText(MainActivity.this, "Desktop size", Toast.LENGTH_SHORT).show();

                    bottomItems.add(R.id.desktopMenu);
                }
                return true;
            }
        });


        bottomItems = new ArrayList<>();
        bottomItems.add(R.id.phoneMenu);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if (bottomItems.size() <= 1) return;

        bottomItems.remove(bottomItems.size() - 1);

        int item = bottomItems.get(bottomItems.size() - 1);

        if (item == R.id.phoneMenu) {
            bottomNavigationView.getMenu().getItem(0).setChecked(true);
        }

        if (item == R.id.desktopMenu) {
            bottomNavigationView.getMenu().getItem(1).setChecked(true);
            InterstitialAd();
        }
    }

    public void checkInternet(){
        ConnectivityManager connectivityManager = null;
        connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected() || !networkInfo.isAvailable()) {
            View dialogView = getLayoutInflater().inflate(R.layout.nointernet, null);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(dialogView);
            builder.setCancelable(false);
            AlertDialog dialog = builder.create();
            dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().getAttributes().windowAnimations = android.R.style.Animation_Dialog;
            Button button = dialogView.findViewById(R.id.retry);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.cancel();
                }
            });
            dialog.show();
        }
    }
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            checkInternet();
            handler.postDelayed(runnable, 10000);
        }
    };

    public void InterstitialAd (){

        // ca-app-pub-3940256099942544/1033173712

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
//  test: ca-app-pub-3940256099942544/1033173712
        InterstitialAd.load(this,"ca-app-pub-1474206512654633/9615300170", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        mInterstitialAd = null;
                    }
                });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(MainActivity.this);
                }
            }
        },1000);
    }
}