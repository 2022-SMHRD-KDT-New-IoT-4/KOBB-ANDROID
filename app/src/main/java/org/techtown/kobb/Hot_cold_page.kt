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

class Hot_cold_page : AppCompatActivity() {
    class Main_menu : View.OnClickListener {
        override fun onClick(p0: View?) {
            TODO("Not yet implemented")
        }

    }

    lateinit var manager: STTManager
    //매장명
    lateinit var user_shop_name : String

    lateinit var cold : String
    lateinit var hot : String
    //먹포
    lateinit var eat:String

    //음성
    lateinit var  voice : String
    lateinit var text : String
    lateinit var tts : TextToSpeech
    //음성cnt값
    lateinit var cnt:String

    //메뉴 이름
    lateinit var choice_menu : String
    fun handleh1Click() {
        voice = "차갑게를 선택하셨습니다 장바구니에 담으시려면 1번, 장바구니를 확인하시려면 2번을 눌러주세요"
        if(voice != null){
            Log.d("TAG", "onCreate: 음성출력")
            ttsSpeak(voice!!)
        }
        val intent = Intent(this@Hot_cold_page,Check_menu_page::class.java)
        intent.putExtra("user_shop_name",user_shop_name)
        intent.putExtra("먹포",eat)
        intent.putExtra("COLD","차갑게")
        intent.putExtra("choice_menu",choice_menu)
        startActivity(intent)
        manager.stop()
    }
    fun handleh2Click() {
        voice = "따뜻하게를 선택하셨습니다 장바구니에 담으시려면 1번, 장바구니를 확인하시려면 2번을 눌러주세요"
        if(voice != null){
            Log.d("TAG", "onCreate: 음성출력")
            ttsSpeak(voice!!)
        }
        val intent = Intent(this@Hot_cold_page,Check_menu_page::class.java)
        intent.putExtra("user_shop_name",user_shop_name)
        intent.putExtra("먹포",eat)
        intent.putExtra("HOT","뜨겁게")
        intent.putExtra("choice_menu",choice_menu)
        startActivity(intent)
        manager.stop()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hot_cold_page)

        Handler().postDelayed({
            manager = STTManager(context = applicationContext)
            manager.setBtn1ClickListener {
                handleh1Click()
            }
            manager.setBtn2ClickListener {
                handleh2Click()
            }
            manager.start()
        },1000)


        //cnt1 차갑게
        if(intent.getStringExtra("cnt1")!=null){
            cnt = intent.getStringExtra("cnt1")!!

       }else if(intent.getStringExtra("cnt2")!=null){
           //cnt2따뜻하게
            cnt = intent.getStringExtra("cnt2")!!
        }
        Log.d("cnt",cnt)

        val tv_Hot_Cold_ryu = findViewById<TextView>(R.id.tv_Hot_Cold_ryu)

        choice_menu = intent.getStringExtra("choice_menu")!!
        tv_Hot_Cold_ryu.text = choice_menu
        //음성출력
        tts = TextToSpeech(this, TextToSpeech.OnInitListener {
            if (it != TextToSpeech.ERROR){
                tts.language = Locale.KOREAN
            }
        })
        //먹고가기 포장하기
        eat = intent.getStringExtra("먹포")!!

        //상호명
        val hot_cold_name = findViewById<TextView>(R.id.user_shop_name)

        //받아온 매장명
        user_shop_name = intent.getStringExtra("user_shop_name")!!
        hot_cold_name.text = user_shop_name


        //차갑게
        val btn_Check_menu_page =findViewById<Button>(R.id.btn_Check_menu_page)
        //따듯하게
        val btn_btn_Check_menu_page =findViewById<Button>(R.id.btn_btn_Check_menu_page)

        //차갑게 눌렀을 때
        btn_Check_menu_page.setOnClickListener {
            handleh1Click()
        }
        //따뜻하게 눌렀을 때
        btn_btn_Check_menu_page.setOnClickListener {
            handleh2Click()
        }

        // page 19 온도결정 페이지 (하하 테스트에요)

        // 차갑게 버튼 : btn_Check_menu_page -> 메뉴확인 페이지로 이동
        // 따뜻하게 버튼 : btn_btn_Check_menu_page -> 메뉴확인 페이지로 이동
        // 장바구니 버튼 : btn_Cart_page3 -> 장바구니 페이지로 이동
        // 뒤로 가기 버튼 : btn_Small_menu_page -> 소메뉴 내 이전페이지로 이동 / 어떤 소메뉴에 있었는지 기억하고 그 페이지로 이동이 가능할까?





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