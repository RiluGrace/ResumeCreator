package com.rilu.resumecreator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartActivity extends AppCompatActivity {

    @BindView(R.id.fresh_btn)
    Button fresh;

    @BindView(R.id.exp_btn)
    Button exp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ButterKnife.bind(this);


    }

    public void fresh(View v)

    {
        Intent i = new Intent(StartActivity.this,MainActivity.class);
        startActivity(i);

    }

    public void experienced(View v)

    {
        Intent i = new Intent(StartActivity.this,MainActivity.class);
        startActivity(i);
    }


/*  @OnClick(R.id.fresh_btn)
    public void click(View v)
  {

      Intent i = new Intent(StartActivity.this,MainActivity.class);
      startActivity(i);
  }*/


}
