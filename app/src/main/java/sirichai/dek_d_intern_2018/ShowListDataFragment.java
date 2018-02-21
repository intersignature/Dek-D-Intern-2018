package sirichai.dek_d_intern_2018;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import sirichai.dek_d_intern_2018.controller.ListDataRecyclerAdapter;
import sirichai.dek_d_intern_2018.model.ListData;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowListDataFragment extends Fragment {

    private RecyclerView listDataRecycler;
    private RecyclerView.Adapter listDataRecyclerAdapter;

    private List<ListData> listDatas;

    public ShowListDataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_show_list_data, container, false);

        listDataRecycler = v.findViewById(R.id.dataRecyclerView);
        listDataRecycler.setHasFixedSize(true);
        listDataRecycler.setLayoutManager(new LinearLayoutManager(v.getContext()));

        listDatas = new ArrayList<>();
        for (int i=0; i<=10;i++){
            ListData listData = new ListData("https://www.androidcentral.com/sites/androidcentral.com/files/styles/large/public/postimages/9274/lloyd_thumbs.jpg","topic"+i,"des"+i);
            listDatas.add(listData);
        }

        listDataRecyclerAdapter = new ListDataRecyclerAdapter(listDatas, v.getContext());
        listDataRecycler.setAdapter(listDataRecyclerAdapter);
        return v;
    }

}
