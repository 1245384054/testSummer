package com.bytedance.videoplayer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private Button mBt,mBt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ImageView imageView = findViewById(R.id.imageView);
        String url = "https://s3.pstatp.com/toutiao/static/img/logo.271e845.png";
        //Glide.with(this).load(url).into(imageView);
        mBt2 = findViewById(R.id.button2);

        mBt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkPermissionAllGranted(mPermissionsArrays)){
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                        requestPermissions(mPermissionsArrays, REQUEST_PERMISSION);
                    }
                    else {
                        Toast.makeText(MainActivity.this,"已获取所有权限",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Intent intent = new Intent(MainActivity.this, VideoViewActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
    private String[] mPermissionsArrays = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.RECORD_AUDIO
    };

    private final static int REQUEST_PERMISSION = 123;

    private Boolean checkPermissionAllGranted(String[] permissions){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return true;
        }
        for(String permission : permissions){
            if(checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_PERMISSION){
            Toast.makeText(this,"已授权" + Arrays.toString(permissions),Toast.LENGTH_LONG).show();

        }
    }
}
