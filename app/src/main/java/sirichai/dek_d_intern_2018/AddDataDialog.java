package sirichai.dek_d_intern_2018;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by atomiz on 22/2/2561.
 */

public class AddDataDialog extends DialogFragment {

    private EditText mImgUrlInput;
    private EditText mTitleInput;
    private EditText mMessageInput;
    private AddDataDialogListener addDataDialogListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_data_dialog, null);
        mImgUrlInput = view.findViewById(R.id.imgUrlInput);
        mTitleInput = view.findViewById(R.id.titleInput);
        mMessageInput = view.findViewById(R.id.messageInput);

        builder.setView(view)
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String imgUrl = mImgUrlInput.getText().toString();
                        String title = mTitleInput.getText().toString();
                        String message = mMessageInput.getText().toString();
                        addDataDialogListener.getInputData(imgUrl, title, message);
//                        if (imgUrl.equals("") || title.equals("") || message.equals("")) {
//                            Toast.makeText(getActivity(), "Please fill in the blank", Toast.LENGTH_SHORT).show();
//                        } else {
//                            addDataDialogListener.getInputData(imgUrl, title, message);
//                        }
                    }
                });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            addDataDialogListener = (AddDataDialogListener) getTargetFragment();
        } catch (ClassCastException e) {
            Log.e("addDataDialogListener", e.toString());
        }

    }

    public interface AddDataDialogListener {
        void getInputData(String imgUrl, String title, String message);
    }
}
