package com.example.mycourses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycourses.course_topics.Topic
import com.example.mycourses.ui.theme.MyCoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCoursesTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    GridPreview()
                }
            }
        }
    }
}



@Composable
fun GridLayout(modifier: Modifier = Modifier) {

}

@Composable
fun GridItem(CourseTopic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier
        .fillMaxSize()
    ) {
            Column {
                Image(
                    painter = painterResource(CourseTopic.iconId),
                    contentDescription = stringResource(CourseTopic.courseNameId),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(194.dp),
                    contentScale = ContentScale.Crop
                )

                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_grain), // Use ic_grain
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(194.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = LocalContext.current.getString(CourseTopic.numberOfCoursesId),
                    modifier = modifier
                )
            }
        }
    }


@Preview
@Composable
private fun GridPreview() {
    GridItem(Topic(R.string.architecture, 58, R.drawable.architecture))
}