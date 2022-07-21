package mansurpardayev.wallpapers.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import mansurpardayev.wallpapers.adaprers.Model;
import mansurpardayev.wallpapers.R;
import mansurpardayev.wallpapers.adaprers.AdapterPhone;

public class PhoneFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Model> arrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_phone, container, false);
        setImages();
        recyclerView = view.findViewById(R.id.phone_recycler);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(container.getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        AdapterPhone adapter = new AdapterPhone(arrayList, container.getContext());
        recyclerView.setAdapter(adapter);


        return view;
    }

    public void setImages() {
        arrayList = new ArrayList<>();
        arrayList.add(new Model("https://telegra.ph/file/f347c5412f50828b93d43.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/fe3fa00582e8eac8cd0b3.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/a1d614ffb3003eb10691b.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/8978531eaf12362be9be9.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/5fcb247611e7872e7c8dc.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/161b1f533247160d4d662.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/9958fe4ef97b0e0f1ad2d.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/efadc029da708ba77f2f6.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/1e8f319e95c852ced84e1.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/635c66a1d693f51da22fe.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/be58240157d4de9752672.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/f5fc9041f7f517c38f204.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/20e0e4a2eee491ce8e686.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/924d4d922795931544c5c.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/d65078df015c281296d93.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/1578666f7099dbea482fe.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/b9b0cc93ca5a642e17dec.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/c997d17751825aa998fdc.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/4776703be7354f53c00a5.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/cafaf9fb57d90d1a6c218.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/08d2da710f171e91f14e6.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/d02913267ada993c955af.jpg"));
        ////
        arrayList.add(new Model("https://telegra.ph/file/89573c33005b1fbac1ca7.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/eefbf78bab7aa64608c2f.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/b8c4c563243670c383c26.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/e6afcff8f772e1d077286.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/03796a2b888d3767349b2.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/1122a570aa10745e3a1a7.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/b1a9b14ae3bb2bff4ba0c.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/9dec6ed0db3cb21ba53c1.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/f15029b06b0552ef2f641.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/690fad44fe2067a8d27cd.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/2ee44ce2d35eb181caeeb.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/337fbc52e98fcc7b9478d.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/c252eb9794ef8ec43ea22.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/6bd1758cb34d3eaa0fc77.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/196b0e99274dfa9b6520e.png"));
        arrayList.add(new Model("https://telegra.ph/file/2c863213d5f67e3c7cc88.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/36d25b65219f510d976b7.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/8c1625eeb7f0e1d08cb8d.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/82704cc9da5f576806a76.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/10ba3989929aa2bfee3ad.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/43e2db1a0d7e6fb3010a2.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/7150f85b0aa151cf17cc0.jpg"));
        ////
        arrayList.add(new Model("https://telegra.ph/file/ed470cebd156cf848c5b9.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/c1cffd30ecc03ddb89fb0.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/6ae9142c8ef96bfe8dd8c.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/48a08c411a32f00eb6302.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/7ab08140d344069215ae5.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/5d940063f9c8c2860102e.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/9ff1c8fea7f31a6b39333.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/1fe7e95e366f22aa93e53.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/f2431856cccde73c63168.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/a72cdb231cfe270e6dd3c.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/cd01b231b6ad57ad76d3d.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/37d623aef34b3da198ea2.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/7dca873ddbe3c829ed1aa.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/f673beab0443409803a7b.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/bdc60909be57eae64df33.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/2fbb5402f629215f2d47f.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/7777aafb4f5d320d29d0b.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/1d95e20c532fe691cc7ad.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/004eb70b9c94bf353f29b.jpg"));
        arrayList.add(new Model("https://telegra.ph/file/b8a43ab3878d04eaa9223.jpg"));

        //


        arrayList.add(new Model("https://telegra.ph/file/4ccf12a12e08ea5d091bd.png"));
        arrayList.add(new Model("https://telegra.ph/file/a36ecc7bd19a669deabdb.png"));
        arrayList.add(new Model("https://telegra.ph/file/80bed3bb4ab1e063f38ce.png"));
        arrayList.add(new Model("https://telegra.ph/file/49cc5d91123d056252a6f.png"));
        arrayList.add(new Model("https://telegra.ph/file/c37b4013afcd8e67c85f2.png"));
        arrayList.add(new Model("https://telegra.ph/file/6ae9b7c1303c8de0673bb.png"));
        arrayList.add(new Model("https://telegra.ph/file/e781ab7af2813451bae5b.png"));
        arrayList.add(new Model("https://telegra.ph/file/a8c5b2a42d7865f869c6c.png"));
        arrayList.add(new Model("https://telegra.ph/file/d32a41c12e0af6008253b.png"));
        arrayList.add(new Model("https://telegra.ph/file/ee137036feb8f2f073854.png"));
        arrayList.add(new Model("https://telegra.ph/file/8879a0b08219db680b849.png"));
        arrayList.add(new Model("https://telegra.ph/file/ffb0ac6c009d3a9344e5a.png"));
        arrayList.add(new Model("https://telegra.ph/file/f2428f67717de8f8fdec7.png"));
    }

}
// https://telegra.ph/Wallpaper-07-10-2
