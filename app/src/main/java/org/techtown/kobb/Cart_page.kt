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

class Cart_page : AppCompatActivity() {
    class Main_menu : View.OnClickListener {
        override fun onClick(p0: View?) {
            TODO("Not yet implemented")
        }

    }

    fun handlecp1Click() {

        voice = "카드결제는 1번, 현금결제는 2번, 카카오페이 결제는 3번, 페이코 결제는 4번 뒤로가시려면 5번을 눌러주세요"
        if(voice != null){
            Log.d("TAG", "onCreate: 음성출력")
            ttsSpeak(voice!!)
        }
        val intent = Intent(this, Choice_pay_page::class.java)
        intent.putExtra("user_shop_name",shop_name.text)
        startActivity(intent)
        manager.stop()
    }
    lateinit var  voice : String
    lateinit var text : String
    lateinit var tts : TextToSpeech
    //매장명
    lateinit var user_shop_name : String
    lateinit var manager: STTManager
    lateinit var shop_name : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_page)
        tts = TextToSpeech(this, TextToSpeech.OnInitListener {
            if (it != TextToSpeech.ERROR){
                tts.language = Locale.KOREAN
            }
        })

        Handler().postDelayed({
            manager = STTManager(context = applicationContext)
            manager.setBtn1ClickListener {
                handlecp1Click()
            }
            manager.start()
        },1000)


        //상호명
        val shop_name = findViewById<TextView>(R.id.user_shop_name)
        //받아온 매장명
        user_shop_name = intent.getStringExtra("user_shop_name")!!
        shop_name.text = user_shop_name

        // 결제하기 버튼 : btn_Choice_pay_page


        var pay_page = findViewById<Button>(R.id.btn_Choice_pay_page)

        pay_page.setOnClickListener{
            handlecp1Click()

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