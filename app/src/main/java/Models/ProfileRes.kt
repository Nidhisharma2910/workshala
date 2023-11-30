package Models

data class ProfileRes(
        val id: Int,
        val title: String,
        val readOnly: Boolean,
        val fullname: String,
        val fullNameTitle: String,
        val fullNameMaxLength: Int,
        val fullNameMinLength: Int,
        val bio: String,
        val bioTitle: String,
        val isBioNullable: Boolean,
        val phoneNumber: String,
        val phoneNumberTitle: String,
        val phoneNumberMaxLength: Int,
        val isPhoneNumberNullable: Boolean,
        val address: String,
        val addressTitle: String,
        val isAddressNullable: Boolean,
        val skills: String,
        val skillsTitle: String,
        val skillsMaxLength: Int,
        val isSkillsNullable: Boolean,
        val experience: String,
        val experienceTitle: String,
        val isExperienceNullable: Boolean,
        val user: Int,
        val userTitle: String

)