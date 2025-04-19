@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.brgysanpedrovawc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun FilingOfComplaintScreen() {
    val scrollState = rememberScrollState()
    val purple = Color(0xFFFF2DD5)
    val grayBackground = Color(0xFFE0E0E0)

    var selectedSex by remember { mutableStateOf("") }
    var selectedRespSex by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = purple),
            shape = MaterialTheme.shapes.medium
        ) {
            Text("File Your Complaint", color = Color.White, fontSize = 16.sp)
        }

        Spacer(Modifier.height(10.dp))

        SectionHeader("Complainant")

        FormTextField("Your Last Name")
        FormTextField("Your First Name")
        FormTextField("Your Middle Name")

        Text("Sex")
        Row {
            listOf("Male", "Female").forEach { option ->
                RadioOption(
                    label = option,
                    selected = selectedSex == option,
                    onClick = { selectedSex = option }
                )
            }
        }

        FormTextField("Contact No.", keyboardType = KeyboardType.Number)
        FormTextField("San Pedro Pagadian City")

        Text("Purok")
        DropdownSelector("Select Purok", (1..14).map { "Purok $it" })

        Text("Civil Status")
        DropdownSelector("Select Civil Status", listOf("Single", "Live-in", "Separated", "Married", "Widowed", "Unknown"))

        DatePickerField("Birthdate")

        FormTextField("Age", keyboardType = KeyboardType.Number)
        FormTextField("Religion")
        FormTextField("Nationality")
        FormTextField("Occupation")

        Spacer(Modifier.height(16.dp))

        SectionHeader("Respondent Details")
        FormTextField("Last Name")
        FormTextField("First Name")
        FormTextField("Middle Name")
        FormTextField("Alias")

        Text("Sex")
        Row {
            listOf("Male", "Female").forEach { option ->
                RadioOption(
                    label = option,
                    selected = selectedRespSex == option,
                    onClick = { selectedRespSex = option }
                )
            }
        }

        Text("Civil Status")
        DropdownSelector("Select Civil Status", listOf("Single", "Live-in", "Separated", "Married", "Widowed", "Unknown"))

        DatePickerField("Birthdate")

        FormTextField("Age", keyboardType = KeyboardType.Number)
        FormTextField("Religion")
        FormTextField("Contact No.", keyboardType = KeyboardType.Number)
        FormTextField("Nationality")
        FormTextField("Occupation")

        Spacer(Modifier.height(16.dp))

        Text("Relationship to Complainant")
        DropdownSelector("Select Relationship", listOf(
            "Current Spouse/Partner", "Former Fiance/Dating Relationship", "Teacher/Instructor/Professor",
            "Neighbors/Peers/Co-Workers/Classmates", "Former Spouse/Partner", "Employer/Manager/Supervisor",
            "Coach/Trainer", "Stranger", "Current Fiance/Dating Relationship", "Agent of the Employer",
            "People of Authority/Service Provider", "Family", "Other Relatives", "Other (please specify)"
        ))

        FormTextField("Specify relationship")

        SectionHeader("Complaint Details")

        DatePickerField("Incident Date")

        Text("Place of the Incident")
        DropdownSelector("Select Place", listOf(
            "Home", "Religious Institutions", "Brothels and Similar Establishments", "Work", "Place of Medical Treatment",
            "School", "Transportation and Connecting Sites", "Commercial Places", "No Response", "Agent of the Employer",
            "Others"
        ))

        FormTextField("Purok")
        FormTextField("Barangay")
        FormTextField("City")
        FormTextField("Province")
        FormTextField("Region")

        Text("Complaint Details", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(grayBackground),
            placeholder = { Text("Enter details here...") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* File Now */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("File Now", color = Color.White)
        }

        Button(
            onClick = { /* Cancel */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Text("Cancel", color = Color.White)
        }
    }
}

// Reusable UI Components

@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
        fontSize = 16.sp,
        modifier = Modifier.padding(top = 12.dp, bottom = 4.dp)
    )
}

@Composable
fun FormTextField(placeholder: String, keyboardType: KeyboardType = KeyboardType.Text) {
    TextField(
        value = "",
        onValueChange = {},
        placeholder = { Text(placeholder) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    )
}

@Composable
fun RadioOption(label: String, selected: Boolean, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(end = 16.dp)
    ) {
        RadioButton(selected = selected, onClick = onClick)
        Text(text = label)
    }
}

@Composable
fun DropdownSelector(title: String, options: List<String>) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = {},
            readOnly = true,
            label = { Text(title) },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
            }
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        selectedText = option
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun DatePickerField(label: String) {
    var pickedDate by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = pickedDate,
            onValueChange = {},
            readOnly = true,
            label = { Text(label) },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { showDialog = true }) {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
            }
        )

        if (showDialog) {
            DatePickerDialog(
                onDismissRequest = { showDialog = false },
                onDateChange = { date ->
                    pickedDate = date
                    showDialog = false
                }
            )
        }
    }
}

@Composable
fun DatePickerDialog(
    onDismissRequest: () -> Unit,
    onDateChange: (String) -> Unit
) {
    val datePickerState = rememberDatePickerState()

    AlertDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {
            TextButton(
                onClick = {
                    val millis = datePickerState.selectedDateMillis
                    if (millis != null) {
                        val formatted = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                            .format(Date(millis))
                        onDateChange(formatted)
                    }
                }
            ) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text("Cancel")
            }
        },
        title = { Text("Select a Date") },
        text = {
            DatePicker(state = datePickerState)
        }
    )
}
