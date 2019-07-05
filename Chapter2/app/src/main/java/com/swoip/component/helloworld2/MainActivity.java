package com.swoip.component.helloworld2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText mEt;
    private Button mBt;
    private TextView mTv;
    private CheckBox mCb;
    private ImageView mIv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBt = findViewById(R.id.button3);
        mEt = findViewById(R.id.editText);
        mTv = findViewById(R.id.textView);
        mIv = findViewById(R.id.imageView);
        mCb = findViewById(R.id.checkBox);
        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "button on click");
                //mTv.setText(iText+mEt.getText());
                String mText = getResources().getString(R.string.TestViewName);
                mText += mEt.getText();
                mTv.setText(mText);
            }
        });
        Log.e(TAG,"some error");

        mCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                   // mIv.setVisibility();
                }
                else{

                }
            }
        });

        mCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });

    }
}
