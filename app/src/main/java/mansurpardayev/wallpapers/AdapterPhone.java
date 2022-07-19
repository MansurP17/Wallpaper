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

public class AdapterPhone extends RecyclerView.Adapter<AdapterPhone.PhoneViewHolder>{
    ArrayList<Model> arrayList;
    Context context;

    public AdapterPhone(ArrayList<Model> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public PhoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.phone_item, parent, false);
        PhoneViewHolder viewHolder = new PhoneViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneViewHolder holder, int position) {
        Model model = arrayList.get(position);

        Picasso.with(context)
                .load(model.getImageURL())
                .resize(150, 300)
                .error(R.drawable.errorphone)
                .into(holder.imagePhone);

        holder.downloadPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadImage("PhoneWallpaper", model.getImageURL());
            }
        });

        holder.imagePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ImagePhone.class).putExtra("imageP", model.getImageURL()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class PhoneViewHolder extends RecyclerView.ViewHolder {
        ImageView imagePhone, downloadPhone;
        public PhoneViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePhone = itemView.findViewById(R.id.imagePhone);
            downloadPhone = itemView.findViewById(R.id.downloadPhone);
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
