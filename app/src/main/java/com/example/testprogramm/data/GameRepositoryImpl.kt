package com.example.testprogramm.data

import com.example.testprogramm.domain.GameRepository
import com.example.testprogramm.domain.Player

object GameRepositoryImpl : GameRepository {

    var randomChislo1 = (0..10).random()
    var randomChislo2 = (0..10).random()
    var answer: Int = 0

    override fun getPlayerLives(player: Player): Int {
        return player.lives
    }

    override fun getPlayerScore(player: Player): Int {
        return player.score
    }

    override fun getGameExample(): String {
        return "$randomChislo1 + $randomChislo2 = ?"
    }

    override fun getGameAnswer(): Int {
        answer = randomChislo1 + randomChislo2
        randomChislo1 = (0..10).random()
        randomChislo2 = (0..10).random()

        return answer
    }

}