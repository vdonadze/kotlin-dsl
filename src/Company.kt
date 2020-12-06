import demo.impl.*
import demo.builders.*

fun main() {
    val project = Project(
        name = "Kotlin DSL",
        tasks = listOf(
            Task(
                "task 1",
                Employee(
                    name = "John",
                    profession = Profession.MANAGER,
                    experience = 7,
                    softSkills = listOf(
                        SoftSkill("Leadership", 6),
                        SoftSkill("Problem-solving", 9)
                    ),
                    technicalSkills = listOf(
                        TechnicalSkill("Java", 5),
                        TechnicalSkill("Kotlin", 5)
                    )
                ),
                Employee(
                    name = "Mike",
                    profession = Profession.DEV,
                    experience = 3,
                    softSkills = listOf(
                        SoftSkill("Teamwork", 5),
                        SoftSkill("Critical thinking", 7)
                    ),
                    technicalSkills = listOf(
                        TechnicalSkill("Java", 7),
                        TechnicalSkill("Kotlin", 9),
                        TechnicalSkill("Spring", 8)

                    )
                ),
                difficulty = 700
            ),
            Task(
                "task 2",
                Employee(
                    name = "Jane",
                    profession = Profession.MANAGER,
                    experience = 5,
                    softSkills = listOf(
                        SoftSkill("Leadership", 6),
                        SoftSkill("Problem-solving", 5),
                        SoftSkill("Critical thinking", 6)

                    ),
                    technicalSkills = listOf(
                        TechnicalSkill("Java", 6),
                        TechnicalSkill("Spring", 6)

                    )
                ),
                Employee(
                    name = "Paul",
                    profession = Profession.DEV,
                    experience = 3,
                    softSkills = listOf(
                        SoftSkill("Teamwork", 7)
                    ),
                    technicalSkills = listOf(
                        TechnicalSkill("C#", 6),
                        TechnicalSkill("MVC", 6),
                        TechnicalSkill(".NET", 7)

                    )
                ),
                difficulty = 900
            )
        ),
        threshold = 0.5
    )

    val projectWithDsl = project {
        name = "Kotlin DSL"
        tasks {
            task("task 1") {
                manager("John") {
                    experience = 7
                    soft {
                        "Leadership" level 6
                        "Problem-solving" level 9
                    }
                    technicals {
                        "Java" level 5
                        "Kotlin" level 5
                    }
                }
                dev("Mike") {
                    experience = 3
                    soft {
                        "Teamwork" level 5
                        "Critical thinking" level 7
                    }
                    technicals {
                        "Java" level 7
                        "Kotlin" level 9
                        "Spring" level 8
                    }
                }
                difficulty = 700
            }
        }
        threshold = 0.5
    }

    project.outcome
    projectWithDsl.outcome
}
