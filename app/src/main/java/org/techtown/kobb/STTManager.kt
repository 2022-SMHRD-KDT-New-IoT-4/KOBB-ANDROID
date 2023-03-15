package org.techtown.kobb

import android.R
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class STTManager {
    private lateinit var _context: Context;
    private lateinit var _requestQueue: RequestQueue;
    private val _url = "http://119.206.166.38:8081/KOBB/buttonAndroid.do?serial_no=1"
    private var btn1ClickListener: Runnable? = null
    private var btn2ClickListener: Runnable? = null
    private var btn3ClickListener: Runnable? = null
    private var btn4ClickListener: Runnable? = null
    private var btn5ClickListener: Runnable? = null

    fun setBtn1ClickListener(listener: Runnable) {
        btn1ClickListener = listener
    }

    fun setBtn2ClickListener(listener: Runnable) {
        btn2ClickListener = listener
    }

    fun setBtn3ClickListener(listener: Runnable) {
        btn3ClickListener = listener
    }
    fun setBtn4ClickListener(listener: Runnable) {
        btn3ClickListener = listener
    }
    fun setBtn5ClickListener(listener: Runnable) {
        btn3ClickListener = listener
    }


    constructor(context: Context) {
        _context = context
        _requestQueue = Volley.newRequestQueue(_context)
    }

    private fun createRequest(): StringRequest {
        return StringRequest(
            Request.Method.GET,
            _url,
            { response ->
                Log.d(
                    "리스폰스",
                    String(response.toString().toByteArray(Charsets.ISO_8859_1), Charsets.UTF_8)
                )
                var btn1 = response.subSequence(0, response.indexOf(','))

                if (btn1 == "1") {
                    btn1ClickListener?.run()
                    Log.d("쪼갠 btn1", btn1.toString())
                }
                var btn2 = response.subSequence(response.indexOf(',') + 1, response.indexOf('.'))
                if (btn2 == "1") {
                    btn2ClickListener?.run()
                    Log.d("쪼갠 btn2", btn2.toString())
                }

                var btn3 = response.subSequence(response.indexOf('.') + 1, response.indexOf('/'))
                if (btn3 == "1") {
                    btn3ClickListener?.run()
                    Log.d("쪼갠 btn3", btn3.toString())
                }

                var btn4 = response.subSequence(response.indexOf('/')+1,response.indexOf('_'))
                if(btn4 == "1"){
                    btn4ClickListener?.run()
                    Log.d("쪼갠 btn4", btn4.toString())
                }

                var btn5= response.subSequence(response.indexOf('_')+1,response.length)

                if(btn5=="1"){
                    btn5ClickListener?.run()
                    Log.d("쪼갠 btn5", btn5.toString())
                }
                _requestQueue.add(createRequest())
            },
            { error ->
                Log.d("톻신에러", error.printStackTrace().toString());
                //Toast.makeText(_context, "통신실패", Toast.LENGTH_SHORT).show()
                _requestQueue.add(createRequest())
            }
        )
    }

    fun start() {

        _requestQueue.add(createRequest())
    }
    fun stop() {

        _requestQueue.stop()
    }
}