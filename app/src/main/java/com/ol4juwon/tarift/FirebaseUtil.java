package com.ol4juwon.tarift;

import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.firebase.ui.auth.AuthUI;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirebaseUtil {
    private static final int RC_SIGN_IN = 123;
    public static FirebaseDatabase mfirebaseDatabase;
    public static DatabaseReference mDatabaseReference;
    private static FirebaseUtil firebaseUtil;
    public static FirebaseAuth mFirebaseAuth;
    public static FirebaseStorage mStorage;
    public static StorageReference mStorageRef;
    public static FirebaseAuth.AuthStateListener mAuthListener;
   // public static ArrayList<TravelDeal> mDeals;
    private static MainActivity caller;
    private FirebaseUtil(){ };
    public static boolean isAdmin;

    public static void openFbReference(){

    }


    // TODO create a login function to tarift
    public static void signIn(){
        mFirebaseAuth = FirebaseAuth.getInstance();


    }


    public static void connectDB(){
        mStorage = FirebaseStorage.getInstance();
        mStorageRef = mStorage.getReference().child("user_pictures");

    }


    // TODO create a sign up function to tarift

    // TODO create a reset password function to tarift


    // TODO create a face id login for tarift


    // Todo retrieve profile pictures from firebase

}
