package org.techtown.kobb

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class Choice_pay_page : AppCompatActivity() {

    class Main_menu : View.OnClickListener {
        override fun onClick(p0: View?) {
            TODO("Not yet implemented")
        }

    }
    fun handlepp1Click() {
        voice = "카드결제를 선택하셨습니다, 하단의 단말기에 카드를 꽂아주세요"
        if(voice != null){
            Log.d("TAG", "onCreate: 음성출력")
            ttsSpeak(voice!!)
        }

        var intent = Intent(this,Pay_page::class.java)
        intent.putExtra("user_shop_name",shop_name.text)
        startActivity(intent)
        manager.stop()
    }

    lateinit var manager: STTManager
    lateinit var  voice : String
    lateinit var text : String
    lateinit var tts : TextToSpeech
    lateinit var shop_name : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice_pay_page)

        Handler().postDelayed({
            manager = STTManager(context = applicationContext)
            manager.setBtn1ClickListener {
                handlepp1Click()
            }
            manager.start()
        },1000)

        tts = TextToSpeech(this, TextToSpeech.OnInitListener {
            if (it != TextToSpeech.ERROR){
                tts.language = Locale.KOREAN
            }
        })
        initTextToSpeech()

        var btn_card = findViewById<Button>(R.id.btn_Customer_main_page)

         shop_name = findViewById<TextView>(R.id.user_shop_name)
        shop_name.text = intent.getStringExtra("user_shop_name")

        btn_card.setOnClickListener{
            handlepp1Click()
        }



    }
    //음성 함수
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
        tts?.speak(text, TextToSpeech.QUEUE_ADD, null, null)
    }
}