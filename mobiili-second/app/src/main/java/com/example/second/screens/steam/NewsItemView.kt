import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import com.example.second.data.model.NewsItem

@Composable
fun NewsItemView(item: NewsItem) {
    val context = LocalContext.current
    val cleanText = item.contents.replace(Regex("<[^>]+>"), "")

    Column(modifier = Modifier.padding(16.dp).clickable {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
        context.startActivity(intent)
    }) {
        Text(text = item.title)
        Text(text = cleanText)
        Text(text = "[ Read more ... ]")
    }
}