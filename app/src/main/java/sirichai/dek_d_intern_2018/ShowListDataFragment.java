package sirichai.dek_d_intern_2018;


import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sirichai.dek_d_intern_2018.controller.ListDataRecyclerAdapter;
import sirichai.dek_d_intern_2018.model.ListData;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowListDataFragment extends Fragment implements AddDataDialog.AddDataDialogListener, View.OnClickListener {

    private TextView showJsonTv;
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
        FloatingActionButton fab = v.findViewById(R.id.fab);
        showJsonTv = v.findViewById(R.id.showJsonTv);
        fab.setOnClickListener(this);
        listDataRecycler = v.findViewById(R.id.dataRecyclerView);
        listDataRecycler.setHasFixedSize(true);
        listDataRecycler.setLayoutManager(new LinearLayoutManager(v.getContext()));
        if (savedInstanceState == null) {
            listDatas = new ArrayList<>();
        } else {
            listDatas = savedInstanceState.getParcelableArrayList("key");
        }

        listDataRecyclerAdapter = new ListDataRecyclerAdapter(listDatas, v.getContext(), showJsonTv);
        listDataRecycler.setAdapter(listDataRecyclerAdapter);
        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("dfssdf", listDatas.toString());
        outState.putParcelableArrayList("key", (ArrayList<? extends Parcelable>) listDatas);
    }

    private void openInputDialog() {
        AddDataDialog addDataDialog = new AddDataDialog();
        addDataDialog.setTargetFragment(ShowListDataFragment.this, 1);
        addDataDialog.show(getFragmentManager(), "");
    }

    @Override
    public void getInputData(String imgUrl, String title, String message) {
        ListData newLisetDataInput = new ListData(imgUrl, title, message);
        listDatas.add(0, newLisetDataInput);
        listDataRecyclerAdapter = new ListDataRecyclerAdapter(listDatas, getActivity(), showJsonTv);
        listDataRecycler.setAdapter(listDataRecyclerAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                openInputDialog();
        }
    }
}
