package com.ojooculto.ojooculto;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

import static android.provider.ContactsContract.CommonDataKinds.Phone.NUMBER;


public class MainActivity extends WearableActivity {
    private static final int GALLERY_INTENT_CODE = 1023 ;
    TextView fullName;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    Button resendCode;
    Button resetPassLocal,changeProfileImage;
    FirebaseUser user;
    //StorageReference storageReference;

    //TextView = fullName;

    private TextView mTextView;
    private Button Activacion;
    String NUMBER = "+523322444649";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bClock = (Button) findViewById(R.id.btn2);
        bClock.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
               sendSMS();
            }
        });

        /*fullName = findViewById(R.id.profileName);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


        userId = fAuth.getCurrentUser().getUid();
        user = fAuth.getCurrentUser();

        if(!user.isEmailVerified()){

            resendCode.setVisibility(View.VISIBLE);

            resendCode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {

                    user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(v.getContext(), "Verification Email Has been Sent.", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("tag", "onFailure: Email not sent " + e.getMessage());
                        }
                    });
                }
            });

        }




        DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if(documentSnapshot.exists()){

                    fullName.setText(documentSnapshot.getString("fName"));

                }else {
                    Log.d("tag", "onEvent: Document do not exists");
                }
            }
        });*/
    }
    //**************************************************************************************************************
    //TODO FUNCION PARA ENVIAR MENSAJES
    //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void sendSMS() {
        try {
            //NUMBER = fullName.getText().toString();
            SmsManager smr = SmsManager.getDefault();
            smr.sendTextMessage(NUMBER, null,"Estoy en peligro!!! \n", null, null);
            //TODO Enviar 10 mensajes con imagen
            //TODO ya la active y nada
            //TODO este bundle con el numero no me convence
            /*Bundle configOverrides = new Bundle();
            configOverrides.putString("destinationAddress",NUMBER);
            if (direccones != null) {
                if (direccones.size() > 0) {
                    for (String url : direccones) {
                        Log.e("urlo",url);
                        try {
                            smr.sendMultimediaMessage(
                                    getApplicationContext(),
                                    Uri.parse(url),
                                    null,
                                    configOverrides,
                                    null
                            );
                        } catch (Exception ex ) {
                            Log.e("Ex", ex.toString());
                        }
                    }

                } else {
                    Log.e("A","Algo fallo");
                }
            } else {
                Log.e("asd","DASDAS");
            }*/
            //smr.sendTextMessage(phoneNo, null,"HOLA \nEstoy en peligro!!! \n"+Text, null, null);
            Toast.makeText(MainActivity.this, "SMS Enviado Satisfactoriamente", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(MainActivity.this, "SMS No enviado, intenta de nuevo!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}









