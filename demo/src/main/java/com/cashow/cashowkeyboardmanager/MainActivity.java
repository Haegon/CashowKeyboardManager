package com.cashow.cashowkeyboardmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cashow.library.KeyboardListener;
import com.cashow.library.KeyboardManager;

public class MainActivity extends AppCompatActivity implements KeyboardListener {

    private TextView text;
    private Button buttonShowKeyboard;
    private Button buttonHideKeyboard;
    private EditText edittext;

    private KeyboardManager keyboardManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        buttonShowKeyboard = findViewById(R.id.button_show_keyboard);
        buttonHideKeyboard = findViewById(R.id.button_hide_keyboard);
        edittext = findViewById(R.id.edittext);

        keyboardManager = new KeyboardManager();

        buttonShowKeyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyboardManager.showSoftKeyBoard(edittext);
            }
        });
        buttonHideKeyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyboardManager.hideSoftKeyBoard(edittext);
            }
        });
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
        text.setText("onShowKeyboard : keyboardHeight = " + keyboardManager.getKeyboardHeight() + "\nisShowKeyboard : " + keyboardManager.isShowKeyboard());
    }

    @Override
    public void onHideKeyboard() {
        // 在这里处理软键盘收回的回调
        text.setText("onHideKeyboard" + "\nisShowKeyboard : " + keyboardManager.isShowKeyboard());
    }
}
