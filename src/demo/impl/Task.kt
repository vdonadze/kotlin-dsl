package demo.impl

import kotlin.random.Random

class Task(
    private val name: String,
    private val employee1: Employee,
    private val employee2: Employee,
    private val difficulty: Int
) {

    fun getResult(): Boolean = (employee1.totalSkill + employee2.totalSkill > calculateTotalDifficulty())

    private fun calculateTotalDifficulty(): Int {
        val rand = Random.nextDouble()
        val bugProbability = (difficulty.toDouble() / BUG_THRESHOLD.toDouble())
        return if (bugProbability > rand) difficulty + BUG_PENALTY else difficulty
    }

    fun printTaskMessage() {
        println(
            "-------------------------------------------------------------------\n" +
                    "Task '$name' ${if (getResult()) "was completed successfully" else "failed"}\n" +
                    "${employee1.name} total skill: ${employee1.totalSkill}\n" +
                    "${employee2.name} total skill: ${employee2.totalSkill}\n" +
                    "task total difficulty: ${calculateTotalDifficulty()}\n" +
                    "-------------------------------------------------------------------\n"
        )
    }
}

