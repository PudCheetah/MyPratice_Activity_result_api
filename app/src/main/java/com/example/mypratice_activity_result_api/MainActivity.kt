package com.example.mypratice_activity_result_api

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mypratice_activity_result_api.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // registerForActivityResult() 必須在 onCreate/onViewCreated 期間呼叫。
        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            // 處理回傳的結果，根據不同的結果碼來進行操作
            when(result.resultCode){
                RESULT_OK -> {    // 處理成功
                    if(result.data != null){    // 處理成功且有夾帶資料的回乎結果
                        binding.tvResultCallBackValue.text = result.resultCode.toString()
                        Toast.makeText(this, "ResultCode: ${result.resultCode}", Toast.LENGTH_SHORT).show()
                    }else{    // 處理成功且沒有夾帶資料的回乎結果
                        binding.tvResultCallBackValue.text = result.resultCode.toString()
                        Toast.makeText(this, "ResultCode: ${result.resultCode}", Toast.LENGTH_SHORT).show()
                    }
                }
                RESULT_CANCELED -> {    // 處理失敗
                    binding.tvResultCallBackValue.text = result.resultCode.toString()
                    Toast.makeText(this, "ResultCode: ${result.resultCode}", Toast.LENGTH_SHORT).show() }
                else -> {    // 處理其他狀況
                    binding.tvResultCallBackValue.text = result.resultCode.toString()
                    Toast.makeText(this, "ResultCode: ${result.resultCode}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.btnJump.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            activityResultLauncher.launch(intent)
        }
        setContentView(binding.root)
    }


}