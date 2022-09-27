package com.example.testprogramm.domain

class GetAnswerUseCase (private val gameRepository: GameRepository){
    fun getAnswer():Int{
        return gameRepository.getGameAnswer()
    }
}