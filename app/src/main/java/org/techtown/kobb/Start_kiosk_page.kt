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

        // 음성출력
        tts = TextToSpeech(this, TextToSpeech.OnInitListener {
            if (it != TextToSpeech.ERROR){
                tts.language = Locale.KOREAN
            }
        })
        initTextToSpeech()

        voice = "시각 장애인 이시면 아래 점자를 읽고 버튼을 눌러주세요. 드시고 가실려면 1번, 포장 하시려면 2번을 눌러주세요"

        //영업시작
       val btn_Customer_main_page = findViewById<Button>(R.id.btn_Customer_main_page)

        //문구
        val user_shop_name = findViewById<TextView>(R.id.user_shop_name)
        //Choice에서 넘어온 이름 값
        user_shop_name.text = intent.getStringExtra("user_shop_name")!!

        //영업시작을 눌렀을 때
        btn_Customer_main_page.setOnClickListener {
            //음성
            if(voice != null){
                Log.d("TAG", "onCreate: 음성출력")
                ttsSpeak(voice!!)
            }
            val intent = Intent(this,Customer_main_page::class.java)
            // 매장명 보내기
            intent.putExtra("user_shop_name",user_shop_name.text)
            startActivity(intent)
        }



        // 영업 시작 전 다음 페이지에서 쓰일 카메라 권한 설정하기
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            // 권한이 허용이라면
//            if (checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
//                val intent = Intent(this,Customer_main_page::class.java)
//                intent.putExtra("permission","허용")
//                // intent 에 허용 값을 넣어서 다음 페이지에 전송한다.
//            } else {
//                Log.d("test", "권한 설정 요청")
//                ActivityCompat.requestPermissions(this, arrayOf<String?>(android.Manifest.permission.CAMERA,android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
//            }
//        }


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