package mansurpardayev.wallpapers.adaprers;

import static android.content.Context.DOWNLOAD_SERVICE;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

import mansurpardayev.wallpapers.activites.ImageDesktop;
import mansurpardayev.wallpapers.R;

public class AdapterDesktop extends RecyclerView.Adapter<AdapterDesktop.DesktopViewHolder>{

    private static RewardedAd mRewardedAd;
    private final String TAG = "MainActivity";

    ArrayList<Model> arrayList;
    Context context;

    public AdapterDesktop(ArrayList<Model> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public DesktopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        loadAd();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.desktop_item, parent, false);
        DesktopViewHolder viewHolder = new DesktopViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DesktopViewHolder holder, int position) {
        Model model = arrayList.get(position);
        Picasso.with(context)
                .load(model.getImageURL())
                .resize(500, 250)
                .error(R.drawable.errordesktop)
                .centerCrop()
                .into(holder.imageDesktop);


        holder.downloadDesktop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadRewardedAd(model.getImageURL());
            }
        });

        holder.imageDesktop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ImageDesktop.class).putExtra("imageD", model.getImageURL()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class DesktopViewHolder extends RecyclerView.ViewHolder {
        ImageView imageDesktop, downloadDesktop;
        public DesktopViewHolder(@NonNull View itemView) {
            super(itemView);

            imageDesktop = itemView.findViewById(R.id.imageDesktop);
            downloadDesktop = itemView.findViewById(R.id.downloadDesktop);
        }
    }

    private void downloadImage(String fileName, String url){
        try {
            DownloadManager downloadManager = null;
            downloadManager = (DownloadManager) context.getSystemService(DOWNLOAD_SERVICE);
            Uri uri = Uri.parse(url);
            DownloadManager.Request request = new DownloadManager.Request(uri);
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI
                            | DownloadManager.Request.NETWORK_MOBILE)
                    .setAllowedOverRoaming(false)
                    .setTitle(fileName)
                    .setMimeType("image/jpeg")
                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                    .setDestinationInExternalPublicDir(Environment.DIRECTORY_DCIM, File.separator+fileName+".jpg");
            downloadManager.enqueue(request);

            Toast.makeText(context, "Downloading image. Check your notification or DCIM.", Toast.LENGTH_SHORT).show();

        }
        catch (Exception e){
            Toast.makeText(context, "Downloading fail.", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadAd(){
        MobileAds.initialize(context, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });



        AdRequest adRequest = new AdRequest.Builder().build();

        // test: ca-app-pub-3940256099942544/5224354917
        RewardedAd.load(context, "ca-app-pub-1474206512654633/4525258042",
                adRequest, new RewardedAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error.
                        mRewardedAd = null;
                    }

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                        mRewardedAd = rewardedAd;


                        mRewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdClicked() {
                                // Called when a click is recorded for an ad.
                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                // Called when ad is dismissed.
                                // Set the ad reference to null so you don't show the ad a second time.
                                mRewardedAd = null;
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                // Called when ad fails to show.
                                mRewardedAd = null;
                            }

                            @Override
                            public void onAdImpression() {
                                // Called when an impression is recorded for an ad.
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                // Called when ad is shown.
                            }
                        });


                    }
                });
    }

    private void LoadRewardedAd(String url){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.download_dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();

        LinearLayout loadAd = view.findViewById(R.id.loadAD);
        LinearLayout loadAdError = view.findViewById(R.id.loadADError);

        if (mRewardedAd==null) {
            loadAd.setVisibility(View.GONE);
            loadAdError.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.cancel();
                }
            });
        }
        else loadAdError.setVisibility(View.GONE);

        loadAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mRewardedAd != null) {
                    Activity activityContext = dialog.getOwnerActivity();
                    mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                            // Handle the reward.
                            downloadImage("PhoneWallpaper", url);
                            int rewardAmount = rewardItem.getAmount();
                            String rewardType = rewardItem.getType();
                        }
                    });
                }
            }
        });
    }
}
