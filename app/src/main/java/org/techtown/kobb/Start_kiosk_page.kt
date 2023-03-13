package org.techtown.kobb

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import java.util.*

class Start_kiosk_page : AppCompatActivity() {

    lateinit var text : String
    lateinit var tts :TextToSpeech
    lateinit var user_shop_name : String

    lateinit var  voice : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_kiosk_page)

        tts = TextToSpeech(this, TextToSpeech.OnInitListener {
            if (it != TextToSpeech.ERROR){
                tts.language = Locale.KOREAN
            }
        })
        initTextToSpeech()

        voice = "시각 장애인 이시면 아래 점자를 읽고 버튼을 눌러주세요. 드시고 가실려면 1번, 포장 하시려면 2번을 눌러주세요"

        // 영업시작
       val btn_Customer_main_page = findViewById<Button>(R.id.btn_Customer_main_page)
        // 매장명 문구
        val textView71 = findViewById<TextView>(R.id.textView71)
        //Choice에서 넘어온 이름 값
        user_shop_name = intent.getStringExtra("매장명")!!

        // 개인정보 수정 페이지 버튼
        var btn_User_info_page = findViewById<ImageButton>(R.id.btn_User_info_page)

        // 뒤로가기 버튼
        var btn_Choice_mode_page = findViewById<Button>(R.id.btn_Choice_mode_page)

        // 모드 전환 버튼
        var btn_change_mode_page = findViewById<Button>(R.id.btn_change_mode_page)


        // 사람 버튼 눌렀을 때 개인정보 수정 페이지 이동
        btn_User_info_page.setOnClickListener{
            val intent = Intent(this,User_info_page::class.java)
            startActivity(intent)
        }

        // 뒤로 가기 버튼을 눌렀을 때 이전페이지인 Choice_mode_page 로 이동
        btn_Choice_mode_page.setOnClickListener {
            val intent = Intent(this, Choice_mode_page::class.java)
            startActivity(intent)
        }

        // 모든 전환 실행 시 Choice_mode_page 로 이동
        btn_change_mode_page.setOnClickListener {
            val intent = Intent(this, Choice_mode_page::class.java)
            startActivity(intent)
        }


        textView71.text= user_shop_name
        //영업시작을 눌렀을 때
        btn_Customer_main_page.setOnClickListener {
            //음성
            if(voice != null){
                Log.d("TAG", "onCreate: 음성출력")
                ttsSpeak(voice!!)
            }
            val intent = Intent(this, Customer_main_page::class.java)
            // 매장명 보내기
            intent.putExtra("매장명",user_shop_name)
            startActivity(intent)
        }
    }   //onCreate밖
        //음성
    private fun initTextToSpeech(){
        Log.d("tag", "initTextToSpeech: 함수실행")
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
            return
        }
        tts = TextToSpeech(applicationContext, TextToSpeech.OnInitListener {
            if(it == TextToSpeech.SUCCESS){
                var result = tts?.setLanguage(Locale.KOREA)
                if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                    return@OnInitListener
                }
            }
        })
    }

    private fun ttsSpeak(text : String){
        tts?.speak(text,TextToSpeech.QUEUE_ADD, null, null)
    }


}