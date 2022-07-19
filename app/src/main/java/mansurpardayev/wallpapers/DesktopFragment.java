package mansurpardayev.wallpapers;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DesktopFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Model> arrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_desktop, container, false);
        setImages();
        recyclerView = view.findViewById(R.id.desktop_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(container.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        AdapterDesktop adapter = new AdapterDesktop(arrayList, container.getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void setImages() {
        arrayList = new ArrayList<>();
        arrayList.add(new Model("https://telegra.ph/file/48cb8c1bf7ce871415006.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/181a213d03459d193af55.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/afec289bb36906fd5d729.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/f608f4cbd8699ecbe31ca.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/74f602addbe2e914a08b6.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/919f00e8d8d621050ab84.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/563405cd107008fbfbc55.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/04453844da49f79ad6c37.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/74f5e99b240cf6fc1c37e.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/f0371efdc13f84c8f2240.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/99162d1115eb05c67c289.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/30ef7d0b88cfded81dad6.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/6937317d5afb6eeed72d0.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/53e2ed56a32f3945686f9.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/5b01a3dd3ec73ec4e14b5.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/d4f1f88f99a20a15a3724.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/c0f89cfa5817a56e7a2a9.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/5e7952fe639f37de0c3be.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/94061d8df6b1c69abc036.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/80c07b4e7b5a8b0338b0b.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/4806b50637c6673ad5364.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/07e68a04a4a8064c60c1c.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/f24978798daa18442413a.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/62e986129241d539f2ec2.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/325945528f3df4170e680.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/662136981cbf6687ac2cd.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/a142fed39db2013089fc5.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/1df16584657f77927d5f9.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/ab301544d03dcdb2bdabf.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/f0856943fa0714b797892.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/7f8363b65f6dffd90c156.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/0af2cb843f02b66a8b161.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/3ebec986d31a9ee6d4924.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/44ec4e9243664f594803b.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/1bcb06d1668e0ad73f997.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/9542bdb6f6cdcc03af288.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/49fd671fdd17d70fb81f9.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/a40db070d22315efdf588.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/b248b5b58379f4c91db06.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/cf3a749b34b3d72b55905.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/fd03e57977c5c073d3711.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/6d789d9ce42fd2e5114f2.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/ee60726ce5088b6651f4d.png"));
        arrayList.add(new Model("https://telegra.ph/file/12544cddc801bc6e26803.png"));
        arrayList.add(new Model("https://telegra.ph/file/4ea364c5db9f9f88d2973.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/9814866debf2c0b3c0c84.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/2767cc3692c688bd0e1b2.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/94ff3fa1fb8d3efacc124.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/0ae39e95e1e6aa442b579.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/6050f46799d44d15c0a68.gif"));
        arrayList.add(new Model("https://telegra.ph/file/fad3f5251cfbfc4bf6403.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/0630c7b0a3b84f06aeb03.jpg"));
    }
}
// https://telegra.ph/Wallpaper-Desktop-07-12
