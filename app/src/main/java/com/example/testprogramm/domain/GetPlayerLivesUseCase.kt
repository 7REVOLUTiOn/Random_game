package com.example.testprogramm.domain

class GetPlayerLivesUseCase(private val gameRepository: GameRepository) {

    fun getPlayerLives(player: Player): Int{
        return gameRepository.getPlayerLives(player)
    }

}