package demo.impl

class Project(
    val name: String,
    val tasks: List<Task>,
    val threshold: Double
) {
    val outcome: Boolean by lazy {

        val taskCount = tasks.size
        val succeededTaskCount = tasks.count { task -> task.outcome }
        val projectResult = succeededTaskCount / taskCount.toDouble()
        (if (succeededTaskCount < 1) false else projectResult >= threshold)
            .also {
                println(
                    "-----------------------------------------------------------------------------\n" +
                            "There ${if (taskCount > 1) "were" else "was"} $taskCount task in project\n" +
                            "$succeededTaskCount ${if (succeededTaskCount > 1) "were" else "was"} completed successfully\n" +
                            "resulting in $projectResult% project completion\n" +
                            "project threshold was $threshold%\n" +
                            "final result: ${if (it) "PROJECT SUCCESSFULLY COMPLETED" else "PROJECT FAILED"}\n" +
                            "-----------------------------------------------------------------------------\n"
                )
            }
    }
}