package com.ucb.menu_gerolaga;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.appcompat.app.AlertDialog;
import android.widget.Toast;

public class DialogFragmentExample extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Dialog Title")
                .setMessage("Do you want to navigate to the first fragment or exit the app?")
                .setPositiveButton("First Fragment", (dialog, id) -> {
                    ((MainActivity)getActivity()).goToFirstFragment();
                })
                .setNegativeButton("Exit", (dialog, id) -> {
                    ((MainActivity)getActivity()).exitApp();
                });

        return builder.create();
    }
}
