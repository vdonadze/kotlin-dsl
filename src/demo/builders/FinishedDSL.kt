package demo.builders

import demo.impl.*


fun project(block: ProjectBuilder.() -> Unit) = ProjectBuilder()
    .apply(block).build()

class ProjectBuilder {
    var name = ""
    var threshold: Double = 0.0
    private val tasks = mutableListOf<Task>()

    internal fun task(name: String, block: TaskBuilder.() -> Unit) {
        tasks.add(TaskBuilder(name).apply(block).build())
    }

    internal fun build() = Project(name, tasks, threshold)
}

class TaskBuilder(private val name: String) {
    var difficulty: Int = 0
    private var employee1: Employee = Employee()
    private var employee2: Employee = Employee()

    fun manager(name: String, block: EmployeeBuilder.() -> Unit) {
        employee1 = EmployeeBuilder(
            name,
            Profession.MANAGER
        ).apply(block).build()
    }

    fun developer(name: String, block: EmployeeBuilder.() -> Unit) {
        employee2 = EmployeeBuilder(
            name,
            Profession.DEVELOPER
        ).apply(block).build()

    }

    internal fun build() = Task(name, employee1, employee2, difficulty)
}

class EmployeeBuilder(private val name: String, private val profession: Profession) {
    var experience: Int = 1
    private val technicalSkills = mutableListOf<TechnicalSkill>()
    private val softSkills = mutableListOf<SoftSkill>()

    fun softSkills(block: SoftSkillsList.() -> Unit) {
        softSkills.addAll(SoftSkillsList().apply(block))
    }


    fun technicalSkills(block: TechnicalSkillsList.() -> Unit) {
        technicalSkills.addAll(TechnicalSkillsList().apply(block))
    }

    internal fun build() = Employee(name, profession, experience, technicalSkills, softSkills)
}

class TechnicalSkillsList : ArrayList<TechnicalSkill>() {
    internal infix fun String.level(level: Int) = add(TechnicalSkill(this, level))
}

class SoftSkillsList : ArrayList<SoftSkill>() {
    internal infix fun String.level(level: Int) = add(SoftSkill(this, level))
}
