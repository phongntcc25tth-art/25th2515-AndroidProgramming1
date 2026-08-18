package com.phongntcc25tth.appcong_2

import android.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.phongntcc25tth.appcong_2.ui.theme.Appcong2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Appcong2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Appcong2Theme {
        Greeting("Android")
    }
}
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Bước 1: Khai báo các biến điều khiển
    var edtSoThuNhat: EditText? = null
    var edtSoThuHai: EditText? = null
    var btnTinhTong: Button? = null
    var tvKetQua: TextView? = null

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bước 2: Tìm các điều khiển theo id
        edtSoThuNhat = findViewById(R.id.edt_num1)
        edtSoThuHai = findViewById(R.id.edt_num2)
        btnTinhTong = findViewById(R.id.btn_calculate)
        tvKetQua = findViewById(R.id.tv_result)

        // Bước 3: Gắn trình lắng nghe sự kiện nhấn nút (OnClick)
        btnTinhTong.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                // Bước 4: Lấy dữ liệu từ 2 ô nhập
                val strSo1 = edtSoThuNhat.getText().toString().trim { it <= ' ' }
                val strSo2 = edtSoThuHai.getText().toString().trim { it <= ' ' }

                // Kiểm tra người dùng đã nhập đủ chưa
                if (strSo1.isEmpty() || strSo2.isEmpty()) {
                    Toast.makeText(
                        this@MainActivity,
                        "Vui lòng nhập đủ 2 số!",
                        Toast.LENGTH_SHORT
                    ).show()
                    return
                }

                try {
                    // Bước 5: Chuyển sang kiểu số nguyên & tính tổng
                    val so1 = strSo1.toInt()
                    val so2 = strSo2.toInt()
                    val tong = so1 + so2

                    // Bước 6: Hiển thị kết quả
                    tvKetQua.setText("Kết quả: " + so1 + " + " + so2 + " = " + tong)
                } catch (e: NumberFormatException) {
                    Toast.makeText(
                        this@MainActivity,
                        "Dữ liệu không hợp lệ!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }
}