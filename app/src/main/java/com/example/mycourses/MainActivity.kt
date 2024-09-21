package com.example.mycourses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycourses.course_topics.Topic
import com.example.mycourses.ui.theme.MyCoursesTheme

import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.MaterialTheme
import com.example.mycourses.data.Data
import androidx.compose.ui.unit.dp as dp1


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCoursesTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GridLayout()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GridLayout(modifier: Modifier = Modifier) {
    LazyVerticalStaggeredGrid(
        contentPadding = PaddingValues(horizontal = 8.dp1, vertical = 8.dp1),
        horizontalArrangement = Arrangement.spacedBy(8.dp1),
        verticalItemSpacing = 8.dp1,
        columns = StaggeredGridCells.Fixed(2),
        modifier = modifier
    ) {
        // Displays each course topic using the GridItem Composable.
        items(Data.topics) { topic ->
            GridItem(topic)
        }
    }
}

@Composable
fun GridItem(courseTopic: Topic, modifier: Modifier = Modifier) {
    Card {
        // Wraps each course topic item in a Card.
        Row {
            Box {
                Image(
                    painter = painterResource(courseTopic.iconId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(68.dp1)
                        .aspectRatio(1f),
                contentScale = ContentScale.Crop
                )
            }
            Column {
                Text(
                    // Displays the course name.
                    text = stringResource(id = courseTopic.courseNameId),
                    modifier = Modifier
                        .padding(start = 16.dp1, top = 16.dp1, end = 16.dp1)
                )
                Row(
                    // Displays dotted icon beside the number of courses
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 8.dp1)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 16.dp1, end = 8.dp1)
                    )
                    Text(
                        text = courseTopic.numberOfCoursesId.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = modifier,
                    )
                }
            }
        }
    }
}


//@Preview
//@Composable
//private fun GridPreview() {
//    GridItem(Topic(R.string.architecture, 58, R.drawable.architecture))
//}