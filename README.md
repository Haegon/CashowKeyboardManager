# CashowKeyboardManager

这是一个用来控制android软键盘的库。

详细说明请看：<http://cashow.github.io/android-get-keyboard-height.html>

### 接入说明

引入 library 库即可
```
compile 'com.cashow:cashowkeyboardmanager:1.0'
```

### 获取软键盘的显示状态

在 activity 的 onResume() 和 onPause() 里加上如下代码：
```java
@Override
protected void onResume() {
   keyboardManager.addKeyboardHeightListener(this, new KeyboardListener() {
        @Override
        public void onShowKeyboard() {
            // 在这里处理软键盘弹出的回调
        }

        @Override
        public void onHideKeyboard() {
            // 在这里处理软键盘收回的回调
        }
    });
}

@Override
protected void onPause() {
   keyboardManager.removeKeyboardHeightListener();
}
```

### 获取软键盘的高度

在调用了 `keyboardManager.addKeyboardHeightListener()` 并且成功收到 `onShowKeyboard()` 回调后，可以通过 `keyboardManager.getKeyboardHeight()` 获取软键盘的高度。

返回 -1 说明获取软键盘高度失败。

### 显示和隐藏软键盘

```java
// 显示软键盘
KeyboardManager.showSoftKeyBoard(activity, edittext);
// 隐藏软键盘
KeyboardManager.hideSoftKeyBoard(activity, edittext);
```
