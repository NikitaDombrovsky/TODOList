//package com.example.todolist.data.storage.Test.ui
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.viewModels
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import androidx.room.Room
//import com.example.roomkt.ContactDatabase
//import com.example.todolist.data.storage.Test.ui.ContactViewModel
//import com.example.roomkt.ui.theme.RoomKTTheme
//
//class MainActivity : ComponentActivity() {
//    private val db by lazy {
//        Room.databaseBuilder(
//            applicationContext,
//            ContactDatabase::class.java,
//            "contacts.db"
//        ).build()
//    }
//    private val viewModel by viewModels<ContactViewModel>(
//        factoryProducer = {
//            object : ViewModelProvider.Factory{
//                override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                    return ContactViewModel(db.dao) as T
//                }
//            }
//        }
//    )
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            RoomKTTheme {
//                val state by viewModel.state.collectAsState()
//                ContactScreen(state = state, onEvent = viewModel::onEvent)
///*                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                    //https://www.youtube.com/watch?v=bOd3wO0uFr8
//                }*/
//            }
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    RoomKTTheme {
//        Greeting("Android")
//    }
//}