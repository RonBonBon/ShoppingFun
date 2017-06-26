package com.arichafamily.shoppingfun.dialogs;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.arichafamily.shoppingfun.R;
import com.arichafamily.shoppingfun.models.UserList;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import mehdi.sakout.fancybuttons.FancyButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddListDialogFragment extends DialogFragment {


    @BindView(R.id.etListName)
    EditText etListName;
    @BindView(R.id.btnAddUserList)
    FancyButton btnAddUserList;
    Unbinder unbinder;

    public AddListDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_list_dialog, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnAddUserList)
    public void onAddListClicked() {
        //1) ref the user -> userID
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser == null)
        {
            Log.e("Tomer", "No User!");
            return; //No User -> No DB
        }
        //2) listID = ref UserListTable -> UID -> push
        DatabaseReference newUserListRowRef = FirebaseDatabase.getInstance()
                .getReference("UserLists")
                .child(currentUser.getUid())
                .push();
        //3) create a new UserList Model
        UserList list = new UserList();
        //4) ref.setValue(userList)
    }
}
