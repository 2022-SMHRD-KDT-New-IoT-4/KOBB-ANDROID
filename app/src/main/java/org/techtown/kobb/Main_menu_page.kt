package org.techtown.kobb

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import java.util.*

class Main_menu_page : AppCompatActivity(), TextToSpeech.OnInitListener {

    lateinit var textToSpeech: TextToSpeech
    lateinit var  a : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu_page)

        //customer 에서 넘어온 음성 값
         a = intent.getStringExtra("음성")!!
        //음성 출력
        val intent : Intent = Intent()
        intent.action = TextToSpeech.Engine.ACTION_CHECK_TTS_DATA
        activityResult.launch(intent)
        Log.d("음성 값",a)


    }

    private  val activityResult: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS){
            //음성전환 준비
            textToSpeech = TextToSpeech(this, this)
        }else{//없다면 다운로드
            //데이터 다운로드
            val installIntent : Intent = Intent()
            installIntent.action = TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA
            startActivity(installIntent)
        }
    }
    //textToSpeech 엔진 초기화시 호출되는 함수
    override fun onInit(status: Int) {
        if(status== TextToSpeech.SUCCESS){
            //언어 값
            val languageStatus : Int = textToSpeech.setLanguage(Locale.KOREA)

            //데이터 문제 없거나 지원할수 없으면
            if(languageStatus == TextToSpeech.LANG_MISSING_DATA ||
                languageStatus == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(this, "언어를 지원 x", Toast.LENGTH_LONG).show()
            }else{//데이터 성공
                //입력값 변수에 담기
                val data :String = a

                var speechStatus : Int = 0
                //안드로이드 버전에 따른 조건 롤리팝보다 같거나 높다면
                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
                    speechStatus=textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH,null,null)
                }else{
                    speechStatus=textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH,null)
                }

                if(speechStatus== TextToSpeech.ERROR){
                    Toast.makeText(this,"음성전환 에러 " , Toast.LENGTH_LONG).show()
                }
            }
        }else {//실패
            Toast.makeText(this,"음성전환 에러 " , Toast.LENGTH_LONG).show()
        }


    }


}