package com.example.handlepermissioncheckbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {
private Button button;
public static final int REQUEST_CODE=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String [] permission={Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(MainActivity.this,permission,REQUEST_CODE);

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull  String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
      if (grantResults[0]== PackageManager.PERMISSION_GRANTED){
          showtoast("Camera permission granted");
      }else if(grantResults[0]==PackageManager.PERMISSION_DENIED){
          showtoast("Camera permission denied");
          if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,permissions[0])){
              showtoast("Camera denied by clicking go to setting and enabled the permission");
          }
      }
    }

    private void showtoast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}