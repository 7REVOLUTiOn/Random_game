package com.example.testprogramm.domain

class GetExampleUseCase(private val gameRepository: GameRepository) {
    fun getExample():String{
        return gameRepository.getGameExample()
    }
}