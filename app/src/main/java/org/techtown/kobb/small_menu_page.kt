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

class small_menu_page : AppCompatActivity() {
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_small_menu_page)
        //음성출력
        tts = TextToSpeech(this, TextToSpeech.OnInitListener {
            if (it != TextToSpeech.ERROR){
                tts.language = Locale.KOREAN
            }
        })
       if(intent.getStringExtra("cnt1")!=null){
          cnt = intent.getStringExtra("cnt1")!!
           //먹고가기 포장하기
           eat = intent.getStringExtra("먹포")!!

           //상호명
           var tvname = findViewById<TextView>(R.id.tvname)
           //받아온 매장명
           user_shop_name = intent.getStringExtra("매장명")!!
           //상호명에 받아온 매장명 담아주기
           tvname.text = user_shop_name

           var btn_Hot_cold_page1 = findViewById<ImageButton>(R.id.btn_Hot_cold_page1)
           var btn_Hot_cold_page2 = findViewById<ImageButton>(R.id.btn_Hot_cold_page2)
           //왼쪽 화면 버튼 눌렀을 때
           btn_Hot_cold_page1.setOnClickListener{
               voice = "아메리카노"
               if(voice != null){
                   Log.d("TAG", "onCreate: 음성출력")
                   ttsSpeak(voice!!)
               }
               val intent = Intent(this@small_menu_page,Hot_cold_page::class.java)
               intent.putExtra("매장명",user_shop_name)
               intent.putExtra("먹포",eat)
               intent.putExtra("cnt1",cnt)
               startActivity(intent)
           }
           //오른쪽 화면 버튼 눌렀을 때
           btn_Hot_cold_page2.setOnClickListener{
               voice ="에스프레소"
               // voice = "커피 라떼 메뉴를 선택하셨습니다. 아메리카노는 1번. 카페라떼는 2번"
               if(voice != null){
                   Log.d("TAG", "onCreate: 음성출력")
                   ttsSpeak(voice!!)
               }
               val intent = Intent(this@small_menu_page,Hot_cold_page::class.java)
               intent.putExtra("매장명",user_shop_name)
               intent.putExtra("먹포",eat)
               intent.putExtra("cnt2",cnt)
               startActivity(intent)
           }


       }else if (intent.getStringExtra("cnt2")!=null){
           cnt = intent.getStringExtra("cnt2")!!
           //먹고가기 포장하기
           eat = intent.getStringExtra("먹포")!!

           //상호명
           var tvname = findViewById<TextView>(R.id.tvname)
           //받아온 매장명
           user_shop_name = intent.getStringExtra("매장명")!!
           //상호명에 받아온 매장명 담아주기
           tvname.text = user_shop_name

           var btn_Hot_cold_page1 = findViewById<ImageButton>(R.id.btn_Hot_cold_page1)
           var btn_Hot_cold_page2 = findViewById<ImageButton>(R.id.btn_Hot_cold_page2)
           //왼쪽 화면 버튼 눌렀을 때
           btn_Hot_cold_page1.setOnClickListener{
               voice = "바닐라라떼"
               if(voice != null){
                   Log.d("TAG", "onCreate: 음성출력")
                   ttsSpeak(voice!!)
               }
               val intent = Intent(this@small_menu_page,Hot_cold_page::class.java)
               intent.putExtra("매장명",user_shop_name)
               intent.putExtra("먹포",eat)
               intent.putExtra("cnt1",cnt)
               startActivity(intent)
           }
           //오른쪽 화면 버튼 눌렀을 때
           btn_Hot_cold_page2.setOnClickListener{
               voice ="카페라떼"
               // voice = "커피 라떼 메뉴를 선택하셨습니다. 아메리카노는 1번. 카페라떼는 2번"
               if(voice != null){
                   Log.d("TAG", "onCreate: 음성출력")
                   ttsSpeak(voice!!)
               }
               val intent = Intent(this@small_menu_page,Hot_cold_page::class.java)
               intent.putExtra("매장명",user_shop_name)
               intent.putExtra("먹포",eat)
               intent.putExtra("cnt2",cnt)
               startActivity(intent)
           }


       }else if (intent.getStringExtra("cnt3")!=null){
           cnt = intent.getStringExtra("cnt3")!!
           //먹고가기 포장하기
           eat = intent.getStringExtra("먹포")!!

           //상호명
           var tvname = findViewById<TextView>(R.id.tvname)
           //받아온 매장명
           user_shop_name = intent.getStringExtra("매장명")!!
           //상호명에 받아온 매장명 담아주기
           tvname.text = user_shop_name

           var btn_Hot_cold_page1 = findViewById<ImageButton>(R.id.btn_Hot_cold_page1)
           var btn_Hot_cold_page2 = findViewById<ImageButton>(R.id.btn_Hot_cold_page2)
           //왼쪽 화면 버튼 눌렀을 때
           btn_Hot_cold_page1.setOnClickListener{
               voice = "차차차"
               if(voice != null){
                   Log.d("TAG", "onCreate: 음성출력")
                   ttsSpeak(voice!!)
               }
               val intent = Intent(this@small_menu_page,Hot_cold_page::class.java)
               intent.putExtra("매장명",user_shop_name)
               intent.putExtra("먹포",eat)
               intent.putExtra("cnt1",cnt)
               startActivity(intent)
           }
           //오른쪽 화면 버튼 눌렀을 때
           btn_Hot_cold_page2.setOnClickListener{
               voice ="칡 차"
               // voice = "커피 라떼 메뉴를 선택하셨습니다. 아메리카노는 1번. 카페라떼는 2번"
               if(voice != null){
                   Log.d("TAG", "onCreate: 음성출력")
                   ttsSpeak(voice!!)
               }
               val intent = Intent(this@small_menu_page,Hot_cold_page::class.java)
               intent.putExtra("매장명",user_shop_name)
               intent.putExtra("먹포",eat)
               intent.putExtra("cnt2",cnt)
               startActivity(intent)
           }


       }else if (intent.getStringExtra("cnt4")!=null){
           cnt = intent.getStringExtra("cnt4")!!
           //먹고가기 포장하기
           eat = intent.getStringExtra("먹포")!!

           //상호명
           var tvname = findViewById<TextView>(R.id.tvname)
           //받아온 매장명
           user_shop_name = intent.getStringExtra("매장명")!!
           //상호명에 받아온 매장명 담아주기
           tvname.text = user_shop_name

           var btn_Hot_cold_page1 = findViewById<ImageButton>(R.id.btn_Hot_cold_page1)
           var btn_Hot_cold_page2 = findViewById<ImageButton>(R.id.btn_Hot_cold_page2)
           //왼쪽 화면 버튼 눌렀을 때
           btn_Hot_cold_page1.setOnClickListener{
               voice = "망고에이드"
               if(voice != null){
                   Log.d("TAG", "onCreate: 음성출력")
                   ttsSpeak(voice!!)
               }
               val intent = Intent(this@small_menu_page,Hot_cold_page::class.java)
               intent.putExtra("매장명",user_shop_name)
               intent.putExtra("먹포",eat)
               intent.putExtra("cnt1",cnt)
               startActivity(intent)
           }
           //오른쪽 화면 버튼 눌렀을 때
           btn_Hot_cold_page2.setOnClickListener{
               voice ="레몬에이드"
               // voice = "커피 라떼 메뉴를 선택하셨습니다. 아메리카노는 1번. 카페라떼는 2번"
               if(voice != null){
                   Log.d("TAG", "onCreate: 음성출력")
                   ttsSpeak(voice!!)
               }
               val intent = Intent(this@small_menu_page,Hot_cold_page::class.java)
               intent.putExtra("매장명",user_shop_name)
               intent.putExtra("먹포",eat)
               intent.putExtra("cnt2",cnt)
               startActivity(intent)
           }


       }else if (intent.getStringExtra("cnt5")!=null){
           cnt = intent.getStringExtra("cnt5")!!
           //먹고가기 포장하기
           eat = intent.getStringExtra("먹포")!!

           //상호명
           var tvname = findViewById<TextView>(R.id.tvname)
           //받아온 매장명
           user_shop_name = intent.getStringExtra("매장명")!!
           //상호명에 받아온 매장명 담아주기
           tvname.text = user_shop_name

           var btn_Hot_cold_page1 = findViewById<ImageButton>(R.id.btn_Hot_cold_page1)
           var btn_Hot_cold_page2 = findViewById<ImageButton>(R.id.btn_Hot_cold_page2)
           //왼쪽 화면 버튼 눌렀을 때
           btn_Hot_cold_page1.setOnClickListener{
               voice = "딸기요거트"
               if(voice != null){
                   Log.d("TAG", "onCreate: 음성출력")
                   ttsSpeak(voice!!)
               }
               val intent = Intent(this@small_menu_page,Hot_cold_page::class.java)
               intent.putExtra("매장명",user_shop_name)
               intent.putExtra("먹포",eat)
               intent.putExtra("cnt1",cnt)
               startActivity(intent)
           }
           //오른쪽 화면 버튼 눌렀을 때
           btn_Hot_cold_page2.setOnClickListener{
               voice ="블루베리 요거트"
               // voice = "커피 라떼 메뉴를 선택하셨습니다. 아메리카노는 1번. 카페라떼는 2번"
               if(voice != null){
                   Log.d("TAG", "onCreate: 음성출력")
                   ttsSpeak(voice!!)
               }
               val intent = Intent(this@small_menu_page,Hot_cold_page::class.java)
               intent.putExtra("매장명",user_shop_name)
               intent.putExtra("먹포",eat)
               intent.putExtra("cnt2",cnt)
               startActivity(intent)
           }


       }else if (intent.getStringExtra("cnt6")!=null){
           cnt = intent.getStringExtra("cnt6")!!
           //먹고가기 포장하기
           eat = intent.getStringExtra("먹포")!!

           //상호명
           var tvname = findViewById<TextView>(R.id.tvname)
           //받아온 매장명
           user_shop_name = intent.getStringExtra("매장명")!!
           //상호명에 받아온 매장명 담아주기
           tvname.text = user_shop_name

           var btn_Hot_cold_page1 = findViewById<ImageButton>(R.id.btn_Hot_cold_page1)
           var btn_Hot_cold_page2 = findViewById<ImageButton>(R.id.btn_Hot_cold_page2)
           //왼쪽 화면 버튼 눌렀을 때
           btn_Hot_cold_page1.setOnClickListener{
               voice = "케이크"
               if(voice != null){
                   Log.d("TAG", "onCreate: 음성출력")
                   ttsSpeak(voice!!)
               }
               val intent = Intent(this@small_menu_page,Hot_cold_page::class.java)
               intent.putExtra("매장명",user_shop_name)
               intent.putExtra("먹포",eat)
               intent.putExtra("cnt1",cnt)
               startActivity(intent)
           }
           //오른쪽 화면 버튼 눌렀을 때
           btn_Hot_cold_page2.setOnClickListener{
               voice ="류승주"
               // voice = "커피 라떼 메뉴를 선택하셨습니다. 아메리카노는 1번. 카페라떼는 2번"
               if(voice != null){
                   Log.d("TAG", "onCreate: 음성출력")
                   ttsSpeak(voice!!)
               }
               val intent = Intent(this@small_menu_page,Hot_cold_page::class.java)
               intent.putExtra("매장명",user_shop_name)
               intent.putExtra("먹포",eat)
               intent.putExtra("cnt2",cnt)
               startActivity(intent)
           }


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
        tts?.speak(text,TextToSpeech.QUEUE_ADD, null, null)
    }

}