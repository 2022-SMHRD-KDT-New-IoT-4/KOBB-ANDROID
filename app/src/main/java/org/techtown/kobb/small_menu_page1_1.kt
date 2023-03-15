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

class small_menu_page1_1 : AppCompatActivity() {
    class Main_menu : View.OnClickListener {
        override fun onClick(p0: View?) {
            TODO("Not yet implemented")
        }

    }
    lateinit var manager: STTManager
    //류
     lateinit var ryu:String
    lateinit var tv_Hot_Cold_ryu : TextView
    //매장명
    lateinit var user_shop_name : String
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
    fun handles1Click() {
        //커피먹고가기
        voice = "아메리카노를 선택하셨습니다.차갑게 드실려면1번.따뜻하게 드실려면2번"
        choice_menu="아메리카노"
        if(voice != null){
            Log.d("TAG", "onCreate: 음성출력")
            ttsSpeak(voice!!)
        }
        val intent = Intent(this@small_menu_page1_1,Hot_cold_page::class.java)
        intent.putExtra("매장명",user_shop_name)
        intent.putExtra("먹포",eat)
        intent.putExtra("cnt1",cnt)
        intent.putExtra("choice_menu",choice_menu)
        startActivity(intent)
        manager.stop()
        manager.start()
    }
    fun handles2Click() {
        //커피먹고가기
        voice ="에스프레소를 선택하셨습니다.차갑게 드실려면1번.따뜻하게 드실려면2번"
        choice_menu="에스프레소"
        // voice = "커피 라떼 메뉴를 선택하셨습니다. 아메리카노는 1번. 카페라떼는 2번"
        if(voice != null){
            Log.d("TAG", "onCreate: 음성출력")
            ttsSpeak(voice!!)
        }
        val intent = Intent(this@small_menu_page1_1,Hot_cold_page::class.java)
        intent.putExtra("매장명",user_shop_name)
        intent.putExtra("먹포",eat)
        intent.putExtra("cnt2",cnt)
        intent.putExtra("choice_menu",choice_menu)
        startActivity(intent)
        manager.stop()
        manager.start()

    }
    fun handles3Click() {
        voice = "바닐라라떼를 선택하셨습니다.차갑게 드실려면1번.따뜻하게 드실려면2번"
        choice_menu="바닐라라떼"
        if(voice != null){
            Log.d("TAG", "onCreate: 음성출력")
            ttsSpeak(voice!!)
        }
        val intent = Intent(this@small_menu_page1_1,Hot_cold_page::class.java)
        intent.putExtra("매장명",user_shop_name)
        intent.putExtra("먹포",eat)
        intent.putExtra("cnt1",cnt)
        intent.putExtra("choice_menu",choice_menu)
        startActivity(intent)
        manager.stop()
        manager.start()


    }
    fun handles4Click() {
        voice ="카페라떼를 선택하셨습니다.차갑게 드실려면1번.따뜻하게 드실려면2번"
        choice_menu="카페라떼"
        // voice = "커피 라떼 메뉴를 선택하셨습니다. 아메리카노는 1번. 카페라떼는 2번"
        if(voice != null){
            Log.d("TAG", "onCreate: 음성출력")
            ttsSpeak(voice!!)
        }
        val intent = Intent(this@small_menu_page1_1,Hot_cold_page::class.java)
        intent.putExtra("매장명",user_shop_name)
        intent.putExtra("먹포",eat)
        intent.putExtra("cnt2",cnt)
        intent.putExtra("choice_menu",choice_menu)
        startActivity(intent)
        manager.stop()
        manager.start()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_small_menu_page1_1)

        Handler().postDelayed({
            manager = STTManager(context = applicationContext)
            manager.setBtn1ClickListener {
                handles1Click()
            }
            manager.setBtn2ClickListener {
                handles2Click()
            }
//            manager.setBtn3ClickListener {
//                handles3Click()
//            }
//            manager.setBtn4ClickListener {
//                handles4Click()
//
//            }
            manager.start()

        },1000)


        Log.d("넘어와?" , intent.getStringExtra("ryu")!!)
       val  btn_Hot_cold_page1 = findViewById<Button>(R.id.btn_Hot_cold_page1)
       val btn_Hot_cold_page2 = findViewById<Button>(R.id.btn_Hot_cold_page2)

        //상호명
        val small_menu_name = findViewById<TextView>(R.id.user_shop_name)
        //받아온 매장명
        user_shop_name = intent.getStringExtra("매장명")!!
        //상호명에 받아온 매장명 담아주기
       small_menu_name.text = user_shop_name

        //먹고가기 포장하기
        eat = intent.getStringExtra("먹포")!!
        //음성출력
        tts = TextToSpeech(this, TextToSpeech.OnInitListener {
            if (it != TextToSpeech.ERROR){
                tts.language = Locale.KOREAN
            }
        })

          cnt = intent.getStringExtra("cnt")!!

           //류
           tv_Hot_Cold_ryu =findViewById(R.id.tv_Hot_Cold_ryu)
           ryu = intent.getStringExtra("ryu")!!
           tv_Hot_Cold_ryu.text = ryu


           //왼쪽 화면 버튼 눌렀을 때
           btn_Hot_cold_page1.setOnClickListener{
               handles1Click()

           }
           //오른쪽 화면 버튼 눌렀을 때
           btn_Hot_cold_page2.setOnClickListener{
               handles2Click()

           }

//       else if (intent.getStringExtra("cnt3")!=null){
//           cnt = intent.getStringExtra("cnt4")!!
//           //류
//           tv_Hot_Cold_ryu =findViewById(R.id.tv_Hot_Cold_ryu)
//           ryu = intent.getStringExtra("ryu")!!
//           tv_Hot_Cold_ryu.text = ryu
//           //왼쪽 화면 버튼 눌렀을 때
//           btn_Hot_cold_page1.setOnClickListener{
//               voice = "망고에이드를 선택하셨습니다.차갑게 드실려면1번.따뜻하게 드실려면2번"
//               choice_menu="망고에이드를 선택하셨습니다"
//               if(voice != null){
//                   Log.d("TAG", "onCreate: 음성출력")
//                   ttsSpeak(voice!!)
//               }
//               val intent = Intent(this@small_menu_page,Hot_cold_page::class.java)
//               intent.putExtra("매장명",user_shop_name)
//               intent.putExtra("먹포",eat)
//               intent.putExtra("cnt1",cnt)
//               intent.putExtra("choice_menu",choice_menu)
//               startActivity(intent)
//           }
//           //오른쪽 화면 버튼 눌렀을 때
//           btn_Hot_cold_page2.setOnClickListener{
//               voice ="레몬에이드를 선택하셨습니다.차갑게 드실려면1번.따뜻하게 드실려면2번"
//               choice_menu="레몬에이드를 선택하셨습니다"
//               if(voice != null){
//                   Log.d("TAG", "onCreate: 음성출력")
//                   ttsSpeak(voice!!)
//               }
//               val intent = Intent(this@small_menu_page,Hot_cold_page::class.java)
//               intent.putExtra("매장명",user_shop_name)
//               intent.putExtra("먹포",eat)
//               intent.putExtra("cnt2",cnt)
//               intent.putExtra("choice_menu",choice_menu)
//               startActivity(intent)
//           }
//
//
//       }else if (intent.getStringExtra("cnt4")!=null){
//           cnt = intent.getStringExtra("cnt5")!!
////           //류
//           tv_Hot_Cold_ryu =findViewById(R.id.tv_Hot_Cold_ryu)
//           ryu = intent.getStringExtra("ryu")!!
//           tv_Hot_Cold_ryu.text = ryu
//
//           //왼쪽 화면 버튼 눌렀을 때
//           btn_Hot_cold_page1.setOnClickListener{
//               voice = "딸기 요거트를 선택하셨습니다.차갑게 드실려면1번.따뜻하게 드실려면2번"
//               choice_menu="딸기 요거트를 선택하셨습니다"
//               if(voice != null){
//                   Log.d("TAG", "onCreate: 음성출력")
//                   ttsSpeak(voice!!)
//               }
//               val intent = Intent(this@small_menu_page,Hot_cold_page::class.java)
//               intent.putExtra("매장명",user_shop_name)
//               intent.putExtra("먹포",eat)
//               intent.putExtra("cnt1",cnt)
//               intent.putExtra("choice_menu",choice_menu)
//               startActivity(intent)
//           }
//           //오른쪽 화면 버튼 눌렀을 때
//           btn_Hot_cold_page2.setOnClickListener{
//               voice ="블루베리 요거트를 선택하셨습니다.차갑게 드실려면1번.따뜻하게 드실려면2번"
//               choice_menu="블루베리 요거트를 선택하셨습니다"
//               // voice = "커피 라떼 메뉴를 선택하셨습니다. 아메리카노는 1번. 카페라떼는 2번"
//               if(voice != null){
//                   Log.d("TAG", "onCreate: 음성출력")
//                   ttsSpeak(voice!!)
//               }
//               val intent = Intent(this@small_menu_page,Hot_cold_page::class.java)
//               intent.putExtra("매장명",user_shop_name)
//               intent.putExtra("먹포",eat)
//               intent.putExtra("cnt2",cnt)
//               intent.putExtra("choice_menu",choice_menu)
//               startActivity(intent)
//           }








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
        tts?.speak(text,TextToSpeech.QUEUE_ADD, null, null)
    }

}