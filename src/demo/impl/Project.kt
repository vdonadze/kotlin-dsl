package demo.impl

class Project(
    val name: String,
    val tasks: List<Task>,
    val threshold: Double
) {

    private var taskCount = 0
    private var succeededTaskCount = 0
    private var projectResult = 0.0

    fun getResult(): Boolean {
        taskCount = tasks.size
        succeededTaskCount = tasks.count { task -> task.getResult() }
        projectResult = succeededTaskCount / taskCount.toDouble()
        return if (succeededTaskCount < 1) false else projectResult >= threshold
    }

    fun printProjectMessage() {
        println(
            "-----------------------------------------------------------------------------\n" +
                    "Final result: ${if (getResult()) "PROJECT SUCCESSFULLY COMPLETED" else "PROJECT FAILED"}.\n" +
                    "There ${if (taskCount > 1) "were" else "was"} $taskCount task in project '$name'\n" +
                    "$succeededTaskCount ${if (succeededTaskCount > 1) "were" else "was"} completed successfully\n" +
                    "resulting in $projectResult% project completion\n" +
                    "project threshold was $threshold%\n" +
                    "-----------------------------------------------------------------------------\n"
        )
    }
}