package com.example.mypratice_activity_result_api

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mypratice_activity_result_api.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {
    private val binding by lazy {
        Activity2Binding.inflate(layoutInflater)
    }
    // 自訂狀態碼
    private val RESULT_ADD = RESULT_FIRST_USER + 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnJumpSuccessWithIntent.setOnClickListener { jumpAndCallBack_success_withIntent() }
        binding.btnJumpSuccessWithoutIntent.setOnClickListener { jumpAndCallBack_success_withoutIntent() }
        binding.btnJumpFail.setOnClickListener { jumpAndCallBack_fail() }
        binding.btnJumpCustom.setOnClickListener { jumpAndCallBack_custom() }
        binding.btnJumpJustFinish.setOnClickListener { jumpAndCallBack_justFinish() }

        setContentView(binding.root)
    }

    // 結束Activity並回傳成功且攜帶資料
    fun jumpAndCallBack_success_withIntent() {
        val intent = Intent().apply {
            putExtra("data", "成功並回傳資料")
        }
        setResult(RESULT_OK, intent)  // ResultCode = RESULT_OK，帶資料
        finish()                                         // 結束 ActivityB
    }
    // 結束Activity並回傳成功但不攜帶資料
    fun jumpAndCallBack_success_withoutIntent(){
        setResult(RESULT_OK)          // ResultCode = RESULT_OK，不帶資料
        finish()                      // 結束 ActivityB
    }
    // 結束Activity並回傳失敗且不攜帶資料
    fun jumpAndCallBack_fail(){
        setResult(RESULT_CANCELED)    // ResultCode = RESULT_CANCELED，不帶資料
        finish()                      // 結束 ActivityB
    }
    // 結束Activity並回傳自訂狀態且攜帶資料
    fun jumpAndCallBack_custom(){
        val intent = Intent().apply {
            putExtra("dataA", "自訂 ResultCodeA")
            putExtra("dataB", "自訂 ResultCodeB")
            putExtra("dataC", "自訂 ResultCodeC")
        }
        setResult(RESULT_ADD, intent) // 自訂 ResultCode = RESULT_ADD，帶資料
        finish()                      // 結束 ActivityB
    }
    // 單純的結束Activity
    fun jumpAndCallBack_justFinish(){
        finish()
    }
}