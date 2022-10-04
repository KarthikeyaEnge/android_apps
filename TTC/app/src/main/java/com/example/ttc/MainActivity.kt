package com.example.ttc

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button
    private lateinit var reset: Button
    private lateinit var start: Button
    private lateinit var  play1:TextView
    private lateinit var play2:TextView
    private lateinit var player:MediaPlayer
    private lateinit var haptics:MediaPlayer

    var pl1=true
    var pl2=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       player=MediaPlayer.create(this,R.raw.music)

        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        reset=findViewById(R.id.reset)
        start=findViewById(R.id.start)
        play1=findViewById(R.id.pl1)
        play2=findViewById(R.id.pl2)

        reset.setOnClickListener{
            player.pause()
            one.text="_"
            two.text="_"
            three.text="_"
            four.text="_"
            five.text="_"
            six.text="_"
            seven.text="_"
            eight.text="_"
            nine.text="_"

            play1.text="0"
            play2.text="0"


        }

        start.setOnClickListener{

            player.start()
            one.text=""
            two.text=""
            three.text=""
            four.text=""
            five.text=""
            six.text=""
            seven.text=""
            eight.text=""
            nine.text=""

            play1.text="0"
            play2.text="0"



        }



            one.setOnClickListener{
                click(1)

            }
            two.setOnClickListener {
                click(2)
            }
            three.setOnClickListener {
                click(3)

            }
            four.setOnClickListener {
                click(4)

            }
            five.setOnClickListener {
                click(5)

            }
            six.setOnClickListener {
                click(6)

            }
            seven.setOnClickListener {
                click(7)
            }
            eight.setOnClickListener {
              click(8)

            }
            nine.setOnClickListener {
              click(9)
            }




    }


    fun click(k:Int){

        haptics=MediaPlayer.create(this,R.raw.click)
        haptics.start()
        if(pl1){
          if( player1(true,k)){
              pl1=!(pl1)
              pl2=!(pl2)
          }
        }

        else{
          if( player2(true,k)){
              pl1=!(pl1)
              pl2=!(pl2)
          }
        }


    }

    fun check(k:Int):Boolean{
        var t=false
        when(k){
            1->t=one.text.equals("")
            2->t=two.text.equals("")
            3->t=three.text.equals("")
            4->t=four.text.equals("")
            5->t=five.text.equals("")
            6->t=six.text.equals("")
            7->t=seven.text.equals("")
            8->t=eight.text.equals("")
            9->t=nine.text.equals("")


        }

        return t
    }



    fun player1(b:Boolean,k:Int):Boolean{
        var p:Boolean=false

        if(b && check(k)){

        when(k){
            1->one.text="X"
            2->two.text="X"
            3->three.text="X"
            4->four.text="X"
            5->five.text="X"
            6->six.text="X"
            7->seven.text="X"
            8->eight.text="X"
            9->nine.text="X"

        }
            var sc = play1.text.toString().toInt() + 1
            play1.text=(sc.toString())
            p=true

            if(sc>=3){
                winner(k,"X")
            }
        }

        return p
    }

    fun player2(b:Boolean,k:Int):Boolean{

        var p:Boolean=false
        if(b && check(k)){

            when(k){
                1->one.text="O"
                2->two.text="O"
                3->three.text="O"
                4->four.text="O"
                5->five.text="O"
                6->six.text="O"
                7->seven.text="O"
                8->eight.text="O"
                9->nine.text="O"
            }

            var sc = play2.text.toString().toInt() + 1
            play2.text=(sc.toString())
            p=true

            if(sc>=3){
                winner(k,"O")
            }

        }



        return p

    }


    fun winner(k:Int,s:String){
        if(rowcheck(k,s) || colcheck(k,s) || diagcheck(k,s)) {

            Toast.makeText(this,s+"is winner",Toast.LENGTH_LONG)
            val intent=Intent(this,playWin::class.java)
            startActivity(intent)

            intent.putExtra("winner",s)
            startActivity(intent)
        }

    }


    fun rowcheck(k:Int,s:String):Boolean {
        var b = false
        if (k == 1 || k == 2 || k == 3) {
            if (one.text.equals(s) && two.text.equals(s) && three.text.equals(s)) b = true
        }

        if (k == 4 || k == 5 || k == 6) {
            if (four.text.equals(s) && five.text.equals(s) && six.text.equals(s)) b = true
        }

        if (k == 7 || k == 8 || k == 9) {
            if (seven.text.equals(s) && eight.text.equals(s) && nine.text.equals(s)) b = true
        }
        return b
    }

    fun colcheck(k:Int,s:String):Boolean{
     var b=false

        if(k==1 || k==4 || k==7){
            if(one.text.equals(s) && four.text.equals(s) && seven.text.equals(s)) b=true
        }
        if(k==2 || k==5 || k==8){
            if(two.text.equals(s) && five.text.equals(s) && eight.text.equals(s)) b=true
        }

        if(k==3 || k==6 || k==9){
            if(three.text.equals(s) && six.text.equals(s) && nine.text.equals(s)) b=true
        }

        return b
    }

    fun diagcheck(k:Int,s:String):Boolean{
        var b=false
        if(k==1 || k==5 || k==9){
            if(one.text.equals(s) && five.text.equals(s) && nine.text.equals(s)) b=true
        }

        if(k==3 || k==5 || k==7){
            if(three.text.equals(s) && five.text.equals(s) && seven.text.equals(s)) b=true
        }

        return b
    }
}