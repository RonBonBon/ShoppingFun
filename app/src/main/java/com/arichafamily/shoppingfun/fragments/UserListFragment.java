package com.arichafamily.shoppingfun.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arichafamily.shoppingfun.R;
import com.arichafamily.shoppingfun.dialogs.AddListDialogFragment;
import com.arichafamily.shoppingfun.models.UserList;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserListFragment extends Fragment {


    @BindView(R.id.fabAddUserList)
    FloatingActionButton fabAddUserList;
    @BindView(R.id.rvUserList)
    RecyclerView rvUserList;
    Unbinder unbinder;

    public UserListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.fabAddUserList)
    public void onFabAddUserClicked() {
        AddListDialogFragment dialog = new AddListDialogFragment();
        dialog.show(getChildFragmentManager(), "AddUserListDialog");
    }
}
