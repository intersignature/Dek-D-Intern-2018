package sirichai.dek_d_intern_2018;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowSpecificData extends Fragment {

    private String imgLink;
    private String title;
    private String message;
    private ImageView logoSpecImg;
    private TextView titleSpecTv;
    private TextView messageSpecTv;

    public ShowSpecificData() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_specific_data, container, false);

        logoSpecImg = view.findViewById(R.id.logoSpecImg);
        titleSpecTv = view.findViewById(R.id.titleSpecTv);
        messageSpecTv = view.findViewById(R.id.messageSpecTv);

        Bundle bundle = getArguments();

        imgLink = bundle.getString("specImgLink");
        title = bundle.getString("specTitle");
        message = bundle.getString("specMessage");

        try {
            Picasso.with(view.getContext()).load(imgLink).placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(logoSpecImg);
        } catch (Exception e) {
            Log.e("LoadLogoInSpecFragment", e.toString());
        }
        titleSpecTv.setText(title);
        messageSpecTv.setText(message);
        return view;
    }

}
