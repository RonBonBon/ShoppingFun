package com.arichafamily.shoppingfun.models;

import com.google.firebase.auth.FirebaseUser;

/**
 * Created by hackeru on 22/06/2017.
 */

public class User {

    private String uid;
    private String displayName;
    private String profileImage = "https://www.gstatic.com/mobilesdk/160503_mobilesdk/logo/2x/firebase_28dp.png";

    public User() {

    }

    public User(FirebaseUser user) {
        this.uid = user.getUid();
        this.displayName = user.getDisplayName();
        if (user.getPhotoUrl() != null) {
            this.profileImage = user.getPhotoUrl().toString();
        }
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", displayName='" + displayName + '\'' +
                ", profileImage='" + profileImage + '\'' +
                '}';
    }
}
