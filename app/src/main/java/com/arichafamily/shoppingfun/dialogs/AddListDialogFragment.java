package com.arichafamily.shoppingfun.dialogs;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arichafamily.shoppingfun.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddListDialogFragment extends DialogFragment {


    public AddListDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_list_dialog, container, false);
    }

}
