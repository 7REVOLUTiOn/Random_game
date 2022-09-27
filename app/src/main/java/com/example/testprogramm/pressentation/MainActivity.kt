package com.example.testprogramm.pressentation

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.testprogramm.R
import com.example.testprogramm.domain.Player

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var scoreTextView: TextView
    private lateinit var livesTextView: TextView
    private lateinit var gameExmple: TextView
    private lateinit var button: Button
    private lateinit var editText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val player: Player = Player(0, 3)
        initView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        observeViewModel(player)
        buttonClickLisner(player)
    }

    fun initView(){
        scoreTextView = findViewById(R.id.score)
        livesTextView = findViewById(R.id.lives)
        gameExmple = findViewById(R.id.exmple)
        button = findViewById(R.id.button)
        editText = findViewById(R.id.editText)
    }

    fun buttonClickLisner(player: Player){
        button.setOnClickListener() {

            if (viewModel.validateInput(editText.getText().toString())){
                val answer = editText.getText().toString()
                val value = Integer.valueOf(answer)

                if (value == viewModel.currentAnswer.value) {
                    player.score++
                    viewModel.currentScore.value = player.score
                    viewModel.getExample()
                    Log.d("Test", viewModel.getExample().toString())
                    updateActivity(player)
                } else {
                    player.lives--

                    if (player.lives == 0) {
                        livesTextView.setText("0")
                        gameExmple.setText("GameOver")
                        button.setText("Try again")
                        gameExmple.setTextColor(Color.RED)
                        button.setOnClickListener(){
                            /*val intent = Intent(this,MainActivity::class.java)
                            finish()
                            startActivity(intent)*/
                            recreate()
                        }
                    } else {
                        viewModel.currentLives.value = player.lives
                    }
                }
            }else{
                val toast = Toast.makeText(applicationContext,"Enter ansewer",Toast.LENGTH_SHORT)
                toast.show()
            }

        }
    }

    fun observeViewModel(player:Player){ //Не трогаем
        viewModel.currentScore.observe(this) {
            Log.d("Test", it.toString())
            scoreTextView.setText(it.toString())
        }
        viewModel.currentLives.observe(this) {

            livesTextView.setText(it.toString())
        }

        viewModel.currentExample.observe(this) {
            gameExmple.setText((it.toString()))

        }
        viewModel.currentAnswer.observe(this) {

        }
        updateActivity(player)
    }

    fun updateActivity(player: Player) { //Не трогаем
        viewModel.getPlayerScore(player)
        viewModel.getPlayerLives(player)
        viewModel.getExample()
        viewModel.getAnswer()
    }




}