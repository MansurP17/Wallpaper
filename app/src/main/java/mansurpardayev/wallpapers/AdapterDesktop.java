package mansurpardayev.wallpapers;

import static android.content.Context.DOWNLOAD_SERVICE;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

public class AdapterDesktop extends RecyclerView.Adapter<AdapterDesktop.DesktopViewHolder>{

    ArrayList<Model> arrayList;
    Context context;

    public AdapterDesktop(ArrayList<Model> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public DesktopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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
                downloadImage("DesktopWallpaper", model.getImageURL());
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

            Toast.makeText(context, "Downloading image. Check your notification.", Toast.LENGTH_SHORT).show();

        }
        catch (Exception e){
            Toast.makeText(context, "Downloading fail.", Toast.LENGTH_SHORT).show();
        }
    }
}
