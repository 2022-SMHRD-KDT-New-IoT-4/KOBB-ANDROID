package org.techtown.kobb

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
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

        //영업시작
       val btn_Choice_mode_page = findViewById<Button>(R.id.btn_Choice_mode_page)
        //문구
        val textView71 = findViewById<TextView>(R.id.textView71)
        //Choice에서 넘어온 이름 값
        user_shop_name = intent.getStringExtra("매장명")!!

        textView71.text= user_shop_name
        //영업시작을 눌렀을 때
        btn_Choice_mode_page.setOnClickListener {
            //음성
            if(voice != null){
                Log.d("TAG", "onCreate: 음성출력")
                ttsSpeak(voice!!)
            }
            val intent = Intent(this,Customer_main_page::class.java)
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