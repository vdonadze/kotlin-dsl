package demo.impl

data class Employee(
    val name: String = "",
    val profession: Profession = Profession.DEV,
    val experience: Int = 1,
    val technicalSkills: List<TechnicalSkill> = mutableListOf(),
    val softSkills: List<SoftSkill> = mutableListOf()
) {
    val totalSkill: Int
        get() = EXPERIENCE_BONUS * experience * (totalTechSkill + totalSoftSkill)

    private val totalSoftSkill: Int by lazy {
        when {
            softSkills.isEmpty() -> 0
            else -> softSkills
                .map { it.level * softSkillMultiplier }
                .reduce { acc, skillLevel -> acc + skillLevel }
        }
    }

    private val totalTechSkill: Int by lazy {
        when {
            technicalSkills.isEmpty() -> 0
            else -> technicalSkills
                .map { it.level * techSkillMultiplier }
                .reduce { acc, skillLevel -> acc + skillLevel }
        }
    }

    private val techSkillMultiplier: Int
        get() = if (profession == Profession.DEV) SKILL_BONUS else 1

    private val softSkillMultiplier: Int
        get() = if (profession == Profession.MANAGER) SKILL_BONUS else 1
}