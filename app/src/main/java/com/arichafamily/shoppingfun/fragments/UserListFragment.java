package com.arichafamily.shoppingfun.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arichafamily.shoppingfun.R;
import com.arichafamily.shoppingfun.dialogs.AddListDialogFragment;
import com.arichafamily.shoppingfun.models.UserList;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
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


    public static class UserListAdapter extends FirebaseRecyclerAdapter<UserList, UserListAdapter.UserListViewHolder> {
        Fragment fragment;

        @Override
        protected void populateViewHolder(UserListAdapter.UserListViewHolder viewHolder, UserList model, int position) {

        }
    }


    public static class UserListViewHolder extends RecyclerView.ViewHolder {
        ImageView ivProfile;
        TextView tvListName;
        FloatingActionButton fabShare;

        public UserListViewHolder(View itemView) {
            super(itemView);
            ivProfile = (ImageView) itemView.findViewById(R.id.ivProfile);
            tvListName = (TextView) itemView.findViewById(R.id.tvListName);
            fabShare = (FloatingActionButton) itemView.findViewById(R.id.fabShare);
        }
    }
}
