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
class Main_menu : View.OnClickListener {
    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

}
class Main_menu_page : AppCompatActivity() {

    lateinit var textToSpeech: TextToSpeech
    lateinit var  a : String
    //매장명
    lateinit var user_shop_name : String
    lateinit var eat:String
    //음성
    lateinit var  voice : String
    lateinit var text : String
    lateinit var tts :TextToSpeech
    lateinit var cnt :String
    lateinit var manager: STTManager

//    //류
    lateinit var ryu: String

    fun handlecoffeClick() {
        //커피먹고가기
        //현재 페이지에서 버튼을 눌렀을 때 출력되는 음성

        cnt = "커피"
        ryu="커피류"
        val voice_text: String = "커피 메뉴를 선택하셨습니다. 아메리카노 1번. 에스프레소 2번"
        Log.d("TAG", "onCreate: 음성출력")
        ttsSpeak(voice_text)
        val intent = Intent(this@Main_menu_page,small_menu_page1_1::class.java)
        intent.putExtra("매장명",user_shop_name)
        intent.putExtra("먹포",eat)
        intent.putExtra("cnt",cnt)
        intent.putExtra("ryu",ryu)
        startActivity(intent)
        manager.stop()
        manager.start()
    }
    fun handleLatteClick(){

        cnt = "라떼"
        ryu="라떼류"
        val voice_text: String = "라떼 메뉴를 선택하셨습니다. 바닐라라떼 1번. 카페라떼는 2번"
        Log.d("TAG", "onCreate: 음성출력")
        ttsSpeak(voice_text)
        val intent = Intent(this@Main_menu_page,small_menu_page1_1::class.java)
        intent.putExtra("매장명",user_shop_name)
        intent.putExtra("먹포",eat)
        intent.putExtra("cnt",cnt)
        intent.putExtra("ryu",ryu)
        startActivity(intent)
        manager.stop()
        manager.start()
    }
    fun handleAdeClick(){

        cnt = "에이드"
        ryu="에이드류"
        val voice_text: String = "에이드 메뉴를 선택하셨습니다. 망고에이드는  1번. 레몬에이드는 2번"
        Log.d("TAG", "onCreate: 음성출력")
        ttsSpeak(voice_text)
        val intent = Intent(this@Main_menu_page,small_menu_page1_1::class.java)
        intent.putExtra("매장명",user_shop_name)
        intent.putExtra("먹포",eat)
        intent.putExtra("cnt",cnt)
        intent.putExtra("ryu",ryu)
        startActivity(intent)
        manager.stop()
        manager.start()
    }
    fun handleYogurtClick(){

        cnt="요거트"
        ryu="요거트류"
        val voice_text: String = "요거트 메뉴를 선택하셨습니다. 딸기요거트는 1번. 블루베리요거트는 2번"
        Log.d("TAG", "onCreate: 음성출력")
        ttsSpeak(voice_text)
        val intent = Intent(this@Main_menu_page,small_menu_page1_1::class.java)
        intent.putExtra("매장명",user_shop_name)
        intent.putExtra("먹포",eat)
        intent.putExtra("cnt",cnt)
        intent.putExtra("ryu",ryu)
        startActivity(intent)
        manager.stop()
        manager.start()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu_page)
        //다른페이지 복붙


        //다른페이지 복붙
    Handler().postDelayed({
        manager = STTManager(context = applicationContext)
        manager.setBtn1ClickListener {
            handlecoffeClick()
        }
        manager.setBtn2ClickListener {
            handleLatteClick()
        }
        manager.setBtn3ClickListener {
            handleAdeClick()
        }
        manager.setBtn4ClickListener {
            handleYogurtClick()

        }
        manager.start()

    },1000)




        //음성출력
        tts = TextToSpeech(this, TextToSpeech.OnInitListener {
            if (it != TextToSpeech.ERROR){
                tts.language = Locale.KOREAN
            }
        })
        initTextToSpeech()

        //먹고가기 포장하기
        if(intent.getStringExtra("먹고가기")!=null){
            eat = intent.getStringExtra("먹고가기")!!

        }else{
            eat =intent.getStringExtra("포장하기")!!
        }


        //상호명
        val main_menu_name= findViewById<TextView>(R.id.user_shop_name)
        //받아온 매장명
        user_shop_name = intent.getStringExtra("매장명")!!
        //상호명에 받아온 매장명 담아주기
        main_menu_name.text = user_shop_name
        // 6개 버튼 소메뉴 페이지(small_menu_page) 로 이동
        var btn_small_menu_page1 = findViewById<Button>(R.id.btn_small_menu_page1)
        var btn_small_menu_page2 = findViewById<Button>(R.id.btn_small_menu_page2)
        var btn_small_menu_page4 = findViewById<Button>(R.id.btn_small_menu_page4)
        var btn_small_menu_page5 = findViewById<Button>(R.id.btn_small_menu_page5)

        //커피 버튼
        btn_small_menu_page1.setOnClickListener{
            handlecoffeClick()


        }
        //라떼 버튼
        btn_small_menu_page2.setOnClickListener{
            handleLatteClick()
        }
        //에이드
        btn_small_menu_page4.setOnClickListener{
            handleAdeClick()

        }
        //요거트
        btn_small_menu_page5.setOnClickListener{
            handleYogurtClick()
        }

        //customer 에서 넘어온 음성 값
       //  a = intent.getStringExtra("음성")!!
        //음성 출력
//        val intent : Intent = Intent()
//        intent.action = TextToSpeech.Engine.ACTION_CHECK_TTS_DATA
//        activityResult.launch(intent)
//        Log.d("음성 값",a)

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

//    private  val activityResult: ActivityResultLauncher<Intent> = registerForActivityResult(
//        ActivityResultContracts.StartActivityForResult()){
//        if(it.resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS){
//            //음성전환 준비
//            textToSpeech = TextToSpeech(this, this)
//        }else{//없다면 다운로드
//            //데이터 다운로드
//            val installIntent : Intent = Intent()
//            installIntent.action = TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA
//            startActivity(installIntent)
//        }
//    }
    //textToSpeech 엔진 초기화시 호출되는 함수
//    override fun onInit(status: Int) {
//        if(status== TextToSpeech.SUCCESS){
//            //언어 값
//            val languageStatus : Int = textToSpeech.setLanguage(Locale.KOREA)
//
//            //데이터 문제 없거나 지원할수 없으면
//            if(languageStatus == TextToSpeech.LANG_MISSING_DATA ||
//                languageStatus == TextToSpeech.LANG_NOT_SUPPORTED) {
//                Toast.makeText(this, "언어를 지원 x", Toast.LENGTH_LONG).show()
//            }else{//데이터 성공
//                //입력값 변수에 담기
//                val data :String = a
//
//                var speechStatus : Int = 0
//                //안드로이드 버전에 따른 조건 롤리팝보다 같거나 높다면
//                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
//                    speechStatus=textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH,null,null)
//                }else{
//                    speechStatus=textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH,null)
//                }
//
//                if(speechStatus== TextToSpeech.ERROR){
//                    Toast.makeText(this,"음성전환 에러 " , Toast.LENGTH_LONG).show()
//                }
//            }
//        }else {//실패
//            Toast.makeText(this,"음성전환 에러 " , Toast.LENGTH_LONG).show()
//        }
//
//
//    }


}