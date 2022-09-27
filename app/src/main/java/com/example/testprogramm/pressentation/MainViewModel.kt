package com.example.testprogramm.pressentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testprogramm.data.GameRepositoryImpl
import com.example.testprogramm.domain.*

class MainViewModel : ViewModel() {


    private val repository =
        GameRepositoryImpl //Не правильно т.к presentation слой не может взаимодействовать с data

    private val getPlayerLivesUseCase = GetPlayerLivesUseCase(repository)
    private val getPlayerScoreUseCase = GetPlayerScoreUseCase(repository)
    private val getExampleUseCase = GetExampleUseCase(repository)
    private val getAnswerUseCase = GetAnswerUseCase(repository)

    var currentScore = MutableLiveData<Int>()
    var currentLives = MutableLiveData<Int>()
    var currentExample = MutableLiveData<String>()
    var currentAnswer = MutableLiveData<Int>()


    fun getPlayerScore(player: Player) {
        val score = getPlayerScoreUseCase.getPlayerScore(player)
        currentScore.value = score
    }

    fun getPlayerLives(player: Player) {
        val lives = getPlayerLivesUseCase.getPlayerLives(player)
        currentLives.value = lives
    }

    fun getExample() {
        val example = getExampleUseCase.getExample()
        currentExample.value = example
    }

    fun getAnswer() {
        val answer = getAnswerUseCase.getAnswer()
        currentAnswer.value = answer
    }

    fun validateInput(number:String):Boolean{
        if (number.isBlank()){
            return false
        }else{
            return true
        }
    }

    /*Тоже самое что и:
    var currentScore:MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    var currentLiveData:MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }*/


}