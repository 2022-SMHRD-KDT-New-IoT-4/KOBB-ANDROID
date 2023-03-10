package org.techtown.kobb

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import java.util.*

class Customer_main_page : AppCompatActivity(){
    lateinit var btn_Eat_main_menu_page : ImageButton
    lateinit var btn_TakeOut_main_menu_page : ImageButton
    lateinit var textToSpeech: TextToSpeech
    lateinit var text : String
    lateinit var tts :TextToSpeech
    //음성
    lateinit var  voice : String
    //매장명
    lateinit var user_shop_name : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_main_page)

        tts = TextToSpeech(this, TextToSpeech.OnInitListener {
            if (it != TextToSpeech.ERROR){
                tts.language = Locale.KOREAN
            }
        })
        initTextToSpeech()

        //텍스트 읽기
        btn_Eat_main_menu_page =findViewById(R.id.btn_Eat_main_menu_page)
        btn_TakeOut_main_menu_page =findViewById(R.id.btn_TakeOut_main_menu_page)


        //상호명
        val customer_main_name = findViewById<TextView>(R.id.customer_main_name)
        //받아온 매장명
       user_shop_name = intent.getStringExtra("매장명")!!
        //상호명에 받아온 매장명 적용
        customer_main_name.text =user_shop_name

        //음성전환
//       val intent : Intent = Intent()
//       intent.action = TextToSpeech.Engine.ACTION_CHECK_TTS_DATA
//       activityResult.launch(intent)

        //시각 장애인이 하드웨어 버튼을 눌렀을 때

        // 음성출력



        //먹고가기 버튼을 눌렀을 때
        btn_Eat_main_menu_page.setOnClickListener {
            voice = "먹고가기를 선택하셨습니다. 커피 1번.라떼 2번.차 3번.에이드 4번. 요거트 5번. 디저트6번"
            if(voice != null){
                Log.d("TAG", "onCreate: 음성출력")
                ttsSpeak(voice!!)
            }

            // intent.action = TextToSpeech.Engine.ACTION_CHECK_TTS_DATA
            //activityResult.launch(intent)

           val intent = Intent(this, Main_menu_page::class.java)
            //매장명
            intent.putExtra("매장명",user_shop_name)
            intent.putExtra("먹고가기","먹고가기")
            startActivity(intent)
//            a = "먹고 가시겠습니까?"
//            intent.putExtra("음성",a)
//           startActivity(intent)

        }
        //포장하기 눌렀을 때
        btn_TakeOut_main_menu_page.setOnClickListener {
            voice = "포장하기를 선택하셨습니다. 커피 1번. 라떼 2번. 차 3번. 에이드 4번. 요거트 5번. 디저트6번"
            if(voice != null){
                Log.d("TAG", "onCreate: 음성출력")
                ttsSpeak(voice!!)
            }
            intent.action = TextToSpeech.Engine.ACTION_CHECK_TTS_DATA
            // activityResult.launch(intent)
          val intent =Intent(this,Main_menu_page::class.java)
            intent.putExtra("매장명",user_shop_name)
            intent.putExtra("포장하기","포장하기")
            startActivity(intent)
//            a = "포장 하시겠습니까?"
//            intent.putExtra("음성",a)
//            startActivity(intent)
        }

    }
    //onCreate 밖

//    private  val activityResult: ActivityResultLauncher<Intent> = registerForActivityResult(
//        ActivityResultContracts.StartActivityForResult()){
//        if(it.resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS){
//            //음성전환 준비
//            // textToSpeech = TextToSpeech(this, this)
//        }else{//없다면 다운로드
//            //데이터 다운로드
//            val installIntent : Intent = Intent()
//            installIntent.action = TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA
//            startActivity(installIntent)
//        }
//    }
    //textToSpeech 엔진 초기화시 호출되는 함수
//    override fun onInit(status: Int) {
//        if(status==TextToSpeech.SUCCESS){
//            //언어 값
//            val languageStatus : Int = textToSpeech.setLanguage(Locale.KOREA)
//
//            //데이터 문제 없거나 지원할수 없으면
//            if(languageStatus ==TextToSpeech.LANG_MISSING_DATA ||
//                languageStatus ==TextToSpeech.LANG_NOT_SUPPORTED) {
//                Toast.makeText(this, "언어를 지원 x", Toast.LENGTH_LONG).show()
//            }else{//데이터 성공
//                //입력값 변수에 담기
//                val data :String = a
//
//                var speechStatus : Int = 0
//                //안드로이드 버전에 따른 조건 롤리팝보다 같거나 높다면
//                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
//                    speechStatus=textToSpeech.speak(data,TextToSpeech.QUEUE_FLUSH,null,null)
//                }else{
//                    speechStatus=textToSpeech.speak(data,TextToSpeech.QUEUE_FLUSH,null)
//                }
//
//                if(speechStatus==TextToSpeech.ERROR){
//                    Toast.makeText(this,"음성전환 에러 " ,Toast.LENGTH_LONG).show()
//                }
//            }
//        }else {//실패
//            Toast.makeText(this,"음성전환 에러 " ,Toast.LENGTH_LONG).show()
//        }
//
//
//    }
//fun speak(text:String){
//    textToSpeech = TextToSpeech(applicationContext,TextToSpeech.OnInitListener {
//        if (it != TextToSpeech.ERROR){
//
//            val result = textToSpeech.setLanguage(Locale.KOREAN)
//            if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA){
//                Log.e("TTS", "This Language is not supported");
//            }else{
//                textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
//
//            }
//
//            Toast.makeText(this@Customer_main_page, "성공", Toast.LENGTH_SHORT).show()
//        }else{
//            Toast.makeText(this@Customer_main_page, "실패", Toast.LENGTH_SHORT).show()
//
//        }
//    })
//}
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