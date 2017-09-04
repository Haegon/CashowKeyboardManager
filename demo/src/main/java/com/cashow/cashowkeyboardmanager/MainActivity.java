package com.cashow.cashowkeyboardmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.cashow.library.KeyboardListener;
import com.cashow.library.KeyboardManager;

public class MainActivity extends AppCompatActivity implements KeyboardListener {

    private TextView text;

    private KeyboardManager keyboardManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text);

        keyboardManager = new KeyboardManager();
    }

    @Override
    protected void onResume() {
        super.onResume();
        keyboardManager.addKeyboardHeightListener(this, this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        keyboardManager.removeKeyboardHeightListener();
    }

    @Override
    public void onShowKeyboard() {
        // 在这里处理软键盘弹出的回调
        text.setText("onShowKeyboard : keyboardHeight = " + keyboardManager.getKeyboardHeight());
    }

    @Override
    public void onHideKeyboard() {
        // 在这里处理软键盘收回的回调
        text.setText("onHideKeyboard");
    }
}
