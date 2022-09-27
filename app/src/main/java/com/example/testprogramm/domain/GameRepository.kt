package com.example.testprogramm.domain

interface GameRepository {

    fun getPlayerLives(player: Player): Int

    fun getPlayerScore(player: Player):Int

    fun getGameExample(): String

    fun getGameAnswer():Int
}