package demo.impl

import kotlin.random.Random

class Task(
    private val name: String,
    private val employee1: Employee,
    private val employee2: Employee,
    private val difficulty: Int
) {
    val outcome: Boolean by lazy {
        (employee1.totalSkill + employee2.totalSkill > totalDifficulty)
            .also {
                printTaskMessage(it)
            }
    }

    private val totalDifficulty by lazy {
        val rand = Random.nextDouble()
        val bugProbability = (difficulty.toDouble() / BUG_THRESHOLD.toDouble())
        if (bugProbability > rand) difficulty + BUG_PENALTY else difficulty
    }

    private fun printTaskMessage(success: Boolean) {
        println(
            "-------------------------------------------------------------------\n" +
                    "Task '$name' ${if (success) "was completed successfully" else "failed"}\n" +
                    "${employee1.name} total skill: ${employee1.totalSkill}\n" +
                    "${employee2.name} total skill: ${employee2.totalSkill}\n" +
                    "task total difficulty: $totalDifficulty\n" +
                    "-------------------------------------------------------------------\n"
        )
    }
}

