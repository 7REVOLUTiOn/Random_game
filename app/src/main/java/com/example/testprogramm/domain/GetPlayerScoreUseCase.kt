package com.example.testprogramm.domain

class GetPlayerScoreUseCase(private val gameRepository: GameRepository) {

    fun getPlayerScore(player: Player):Int{
        return gameRepository.getPlayerScore(player)
    }
}