package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Willy Nyawira")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName=myName
       // setContentView(R.layout.activity_main)

//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            addNickname(it)
        binding.doneButton.setOnClickListener {
            addNickname(it) }
        }

    private fun addNickname(view:View){
//        val editText=findViewById<EditText>(R.id.nickname_edit)
//        val nicknameTextView=findViewById<TextView>(R.id.nickname_text)
        binding.apply {this
            //nicknameText.text = binding.nicknameEdit.text
            myName?.nickname=nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        //hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}