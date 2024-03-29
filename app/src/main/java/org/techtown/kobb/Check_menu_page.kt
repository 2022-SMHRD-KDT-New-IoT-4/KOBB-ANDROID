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
import android.widget.Toast
import java.util.*

class Check_menu_page : AppCompatActivity() {
    class Main_menu : View.OnClickListener {
        override fun onClick(p0: View?) {
            TODO("Not yet implemented")
        }

    }
    fun handlec1Click() {
        voice = "메뉴를 장바구니에 담았습니다"
        if(voice != null){
            Log.d("TAG", "onCreate: 음성출력")
            ttsSpeak(voice!!)
        }
     //   voice = "장바구니에 담았습니다"
//        if(voice != null){
//            Log.d("TAG", "onCreate: 음성출력")
//            ttsSpeak(voice!!)
//        }
//        val intent = Intent(this@Check_menu_page,this::class.java)
//
//        startActivity(intent)
        Toast.makeText(this,"장바구니에 담았습니다" , Toast.LENGTH_LONG).show()
       // intent.putExtra("먹포",eat)
        manager.stop()
        Handler().postDelayed({
            manager = STTManager(context = applicationContext)
            manager.setBtn1ClickListener {
                handlec1Click()
            }
            manager.setBtn2ClickListener {
                handlec2Click()
            }
            manager.start()
        },1000)
    }
    fun handlec2Click() {
        voice = "결제를 하시려면 1번을 뒤로가시려면 2번을 눌러주세요"
        if(voice != null){
            Log.d("TAG", "onCreate: 음성출력")
            ttsSpeak(voice!!)
        }
        val intent = Intent(this@Check_menu_page,Cart_page::class.java)
        intent.putExtra("choice_menu",choice_menu)
        intent.putExtra("user_shop_name",user_shop_name)
        intent.putExtra("먹포",eat)
        startActivity(intent)
        manager.stop()
    }
    lateinit var manager: STTManager
    //매장명
    lateinit var user_shop_name : String
    //차갑게
    lateinit var cold: String
    //뜨겁게
    lateinit var hot : String
    //먹포
    lateinit var eat:String

    //음성
    lateinit var  voice : String
    lateinit var text : String
    lateinit var tts : TextToSpeech
    //메뉴 이름
    lateinit var choice_menu : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_menu_page)
        Handler().postDelayed({
            manager = STTManager(context = applicationContext)
            manager.setBtn1ClickListener {
                handlec1Click()
            }
            manager.setBtn2ClickListener {
                handlec2Click()
            }
            manager.start()
        },1000)
        // 주문내역 출력 - 메뉴명

        val check_menu_menu =findViewById<TextView>(R.id.check_menu_menu)
        // 안내문구 출력 - 메뉴명 
        val check_menu = findViewById<TextView>(R.id.tv_Hot_Cold_ryu)
        // 먹고가기 포장하기
        eat = intent.getStringExtra("먹포")!!
        // 안내문구 출력 - 차가운지 뜨거운지
        var check_tv1 = findViewById<TextView>(R.id.check_tv1)
        // 주문내역 출력 - 차가운지 뜨거운지
        var check_tv2 =findViewById<TextView>(R.id.check_tv2)
        if(intent.getStringExtra("COLD")!=null){
            cold = intent.getStringExtra("COLD")!!
            check_tv1.text = cold
            check_tv2.text = cold
        }else{
            hot =intent.getStringExtra("HOT")!!
            check_tv1.text = hot
            check_tv2.text = hot
        }
        choice_menu=intent.getStringExtra("choice_menu")!!
        check_menu_menu.text = choice_menu
        check_menu.text = choice_menu

        // 수량 증감 버튼
        var minbutton = findViewById<Button>(R.id.minbutton)
        var plusbutton = findViewById<Button>(R.id.plusbutton)
        val result = findViewById<TextView>(R.id.result)
        var number = 1;

        // 마이너스 버튼 선택시
        minbutton.setOnClickListener {
            number--
            result.setText(number.toString())
        }
        // 플러스 버튼 선택시
        plusbutton.setOnClickListener {
            number++
            result.setText(number.toString())
        }



        //음성출력
        tts = TextToSpeech(this, TextToSpeech.OnInitListener {
            if (it != TextToSpeech.ERROR){
                tts.language = Locale.KOREAN
            }
        })


        //장바구니 확인
        val btn_Cart_page1=findViewById<Button>(R.id.btn_Cart_page1)

        // 장바구니 담기 버튼
        val check_menu_add =findViewById<Button>(R.id.check_menu_add)
        //장바구니 담기를 눌렀을 때
        check_menu_add.setOnClickListener {
            handlec1Click()

        }
        //상호명
        var tvcname = findViewById<TextView>(R.id.user_shop_name)
        //받아온 매장명
        user_shop_name = intent.getStringExtra("user_shop_name")!!
        tvcname.text = user_shop_name


       // 장바구니 확인 버튼 눌렀을 때
        btn_Cart_page1.setOnClickListener {
            handlec2Click()
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