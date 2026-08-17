package com.phongntcc25tth.appcong2_1;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Bước 1: Tìm các điều khiển trên giao diện
        EditText num1 = findViewById(R.id.edt_num1);
        EditText num2 = findViewById(R.id.edt_num2);
        TextView result = findViewById(R.id.txt_result);
        Button btnSum = findViewById(R.id.btn_calculate);

// Bước 2: Gắn trình lắng nghe sự kiện nhấn nút
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Bước 3: Lấy & chuyển đổi dữ liệu
                int a = Integer.parseInt(num1.getText().toString());
                int b = Integer.parseInt(num2.getText().toString());

                // Bước 4: Tính tổng
                int sum = a + b;

                // Bước 5: Hiển thị kết quả
                result.setText("Kết quả: " + sum);
            }
        });
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.phongntcc25tth.appcong2_1", appContext.getPackageName());
    }

}