package com.example.lfq002;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lfq002.util.DateUtil;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class bbs extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener {
    private TextView textView;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbs);

        textView = findViewById(R.id.textView);
        textView.setOnClickListener(this);
        textView.setOnLongClickListener(this);
        textView2 = findViewById(R.id.textView2);
        textView2.setOnClickListener(this);
        textView2.setOnLongClickListener(this);

        textView2.setMovementMethod(new ScrollingMovementMethod());
    }
    ////
    private String[] mChatStr = {"你吃饭了吗","不，我没吃，你呢","我也不想吃","那我们一起去吃吧","不，我要一个人吃",};
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.textView || v.getId() == R.id.textView2) {
            int random = (int) (Math.random() * 10) % 5;
            String newStr = String.format("%s\n%s %s", textView2.getText().toString(),DateUtil.getNowTime(), mChatStr[random]);
            textView2.setText(newStr);
        }
    }
    @Override
    public boolean onLongClick(View v) {
        if (v.getId() == R.id.textView || v.getId() == R.id.textView2) {
            textView2.setText("");
        }
        return true;
    }
}