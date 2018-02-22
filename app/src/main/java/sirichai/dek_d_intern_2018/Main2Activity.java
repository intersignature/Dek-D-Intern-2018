package sirichai.dek_d_intern_2018;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener, AddDataDialog.AddDataDialogListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                openInputDialog();
        }

    }

    private void openInputDialog() {
        AddDataDialog addDataDialog = new AddDataDialog();
        addDataDialog.show(getSupportFragmentManager(), "");
    }

    @Override
    public void getInputData(String imgUrl, String title, String message) {

    }
}
