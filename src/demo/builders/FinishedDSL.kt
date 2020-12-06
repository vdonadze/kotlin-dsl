package demo.builders

import demo.impl.*


fun project(block: ProjectBuilder.() -> Unit) = ProjectBuilder()
    .apply(block).build()

class ProjectBuilder {
    var name = ""
    var threshold: Double = 0.0
    private val tasks = mutableListOf<Task>()

    fun tasks(block: TasksList.() -> Unit) {
        tasks.addAll(TasksList().apply(block))
    }

    fun build() = Project(name, tasks, threshold)
}

class TaskBuilder(private val name: String) {
    var difficulty: Int = 0
    private var employee1: Employee = Employee()
    private var employee2: Employee = Employee()

    fun manager(name: String, block: EmployBuilder.() -> Unit) {
        employee1 = EmployBuilder(
            name,
            Profession.MANAGER
        ).apply(block).build()
    }

    fun dev(name: String, block: EmployBuilder.() -> Unit) {
        employee2 = EmployBuilder(
            name,
            Profession.DEV
        ).apply(block).build()

    }

    fun build() = Task(name, employee1, employee2, difficulty)
}

class EmployBuilder(private val name: String, private val profession: Profession) {
    var experience: Int = 1
    private val technicalSkills = mutableListOf<TechnicalSkill>()
    private val softSkills = mutableListOf<SoftSkill>()

    fun soft(block: SoftSkillsList.() -> Unit) {
        softSkills.addAll(SoftSkillsList().apply(block))
    }

    fun technicals(block: TechnicalSkillsList.() -> Unit) {
        technicalSkills.addAll(TechnicalSkillsList().apply(block))
    }

    fun build() = Employee(name, profession, experience, technicalSkills, softSkills)
}

class TasksList : ArrayList<Task>() {
    fun task(name: String, block: TaskBuilder.() -> Unit) {
        add(TaskBuilder(name).apply(block).build())
    }
}

class TechnicalSkillsList : ArrayList<TechnicalSkill>() {
    infix fun String.level(level: Int) {
        add(TechnicalSkill(this, level))
    }
}

class SoftSkillsList : ArrayList<SoftSkill>() {
    infix fun String.level(level: Int) = add(SoftSkill(this, level))
}
