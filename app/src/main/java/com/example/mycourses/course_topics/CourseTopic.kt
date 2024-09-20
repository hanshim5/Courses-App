package com.example.mycourses.course_topics

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val courseNameId: Int,   // Course name string resource
    val numberOfCoursesId: Int,     // Number of associated courses string resource
    @DrawableRes val iconId: Int       // Image drawable resource
)
