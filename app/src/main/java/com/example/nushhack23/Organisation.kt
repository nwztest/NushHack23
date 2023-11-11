package com.example.nushhack23

import android.app.DatePickerDialog
import android.os.Build
import android.util.Log
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.MaterialDialogState
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

data class Event(val date: Date, val name: String, )

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun OrganisationFragment() {
    val eventList = remember { mutableStateListOf<Event>() }
//    var showDialog by remember { mutableStateOf(false) }
//    if (showDialog) {
//        DialogThing(onDismissRequest = { showDialog = false }) {
//            showDialog = false
//
//        }
//    }
    var text by remember { mutableStateOf("") }
    var pickedDate by remember { mutableStateOf(LocalDate.now())}
    val formattedDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("MMM dd yyyy")
                .format(pickedDate)
        }
    }

    var dateString by remember{ mutableStateOf("")}
    val dateDialogState = rememberMaterialDialogState()
    Surface(Modifier) {
        Column {
            Row {
                Text(text = "Name")
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Name") }
                )
            }
            Row {
                Text(text = "Date")
                OutlinedTextField(
                    value=dateString,
                    onValueChange = {dateString=it},
                    label={Text("DD/MM/YYYY")}
                )
            }
            Button(onClick = {
                val dateSplit = dateString.split('/')
                try {
                    val day = dateSplit[0].toInt()
                    val month = dateSplit[1].toInt()
                    val year = dateSplit[2].toInt() - 1900
                    val date = Date(year, month, day)
                    val event = Event(date, text)
                    eventList.add(event)
                } catch (e: Exception) {
                    Log.i("Give up", e.message!!)
                }
                dateString=""
                text=""
                Log.i("Test", eventList.size.toString())
            }) {
                Text(text = "Add event")
            }

            LazyColumn(modifier=Modifier.size(400.dp, 400.dp), verticalArrangement = Arrangement.spacedBy(4.dp), contentPadding = PaddingValues(10.dp, 10.dp)) {
                items(eventList) { event ->
                    EventCard(event)
                }
            }
//            MaterialDialog(
//                dialogState = dateDialogState,
//                buttons = {
//                    positiveButton(text="OK") {
//
//                    }
//                }
//            ) {
//
//            }

        }
    }
}

@Composable
fun EventCard(event: Event) {
    val formatter = SimpleDateFormat("d/M/yyyy")
    Card(modifier=Modifier.fillMaxWidth()) {
        Column {
            Text(event.name, fontSize = 40.sp, lineHeight = 46.sp)
            Text(formatter.format(event.date), fontSize=24.sp)
        }
    }
}


//@Composable
//fun DialogThing(
//    onDismissRequest: () -> Unit,
//    onConfirmation: () -> Unit,
//) {
//    Dialog(onDismissRequest = { onDismissRequest() }) {
//        val state = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)
//        // Draw a rectangle shape with rounded corners inside the dialog
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(375.dp)
//                .padding(16.dp),
//            shape = RoundedCornerShape(16.dp),
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//            ) {
//                Text(
//                    text = "Name of event",
//                    modifier = Modifier.padding(16.dp),
//                )
//                DatePicker()
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    horizontalArrangement = Arrangement.Center,
//                ) {
//                    TextButton(
//                        onClick = { onDismissRequest() },
//                        modifier = Modifier.padding(8.dp),
//                    ) {
//                        Text("Dismiss")
//                    }
//                    TextButton(
//                        onClick = { onConfirmation() },
//                        modifier = Modifier.padding(8.dp),
//                    ) {
//                        Text("Confirm")
//                    }
//                }
//            }
//        }
//    }
//}