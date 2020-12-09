package demo.draft

private enum class Profession {
    DEVELOPER,
    MANAGER
}

private data class Employee(
    val name: String,
    val profession: Profession,
    val experience: Int,
    val technicalSkills: List<TechnicalSkill>,
    val softSkills: List<SoftSkill>
)

private data class TechnicalSkill(
    val skill: String,
    val level: Int
)

private data class SoftSkill(
    val skill: String,
    val level: Int
)

private data class Task(
    val name: String,
    val employee1: Employee,
    val employee2: Employee,
    val difficulty: Int,
    val result: Boolean
)

private data class Project(
    val name: String,
    val tasks: List<Task>,
    val threshold: Double,
    val result: Boolean
)