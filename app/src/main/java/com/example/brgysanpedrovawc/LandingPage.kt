package com.example.brgysanpedrovawc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun LandingPage(navController: NavHostController) {
    val scrollState = rememberScrollState()
    val purpleBackground = Color(0xFFA855F7)
    val pinkCard = Color(0xFFFF2DD5)
    val roundedCorner20 = RoundedCornerShape(20.dp)
    val roundedCorner15 = RoundedCornerShape(15.dp)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(purpleBackground)
            .verticalScroll(scrollState)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Barangay logo and welcome message
        Image(
            painter = painterResource(id = R.drawable.sanpedro1),
            contentDescription = "Barangay Logo",
            modifier = Modifier.size(100.dp)
        )

        Text(
            text = "We are here for you",
            fontSize = 18.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp)
        )

        // Top message card
        InfoCard(
            text = "You are not alone. We, The Barangay San Pedro are here for you. Violence against women and children should never be ignored, and no one deserves to suffer in silence. If you or someone you know is experiencing abuse, know that help and support are available. You have the strength within you to rise above the pain, to reclaim your voice, and to build a life free from fear. Together, we can break the cycle, seek justice, and create a safer, brighter future. Speak up, reach out, and remember—there is hope, there is healing, and you are never alone. You deserve to be heard. You deserve to be safe. And most importantly, you deserve to be free.",
            imageRes = R.drawable.sanpedro4,
            backgroundColor = pinkCard,
            shape = roundedCorner20
        )

        // Center Icon
        Image(
            painter = painterResource(id = R.drawable.sanpedro9),
            contentDescription = "VAWC Icon",
            modifier = Modifier.size(280.dp)
        )

        // Section title
        Text(
            text = "Violence Against Women and their Children",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 12.dp)
        )

        // VAWC description card
        InfoCard(
            text = "The Violence Against Women and their Children (VAWC) platform is a dedicated initiative aimed at combating all forms of abuse and exploitation against women and children. This platform seeks to raise awareness, provide protection, and empower survivors to reclaim their rights and dignity. Through comprehensive support systems, legal assistance, counseling services, and public education, the VAWC platform strives to break the cycle of violence and build safer communities. It emphasizes the importance of speaking out, seeking justice, and fostering a culture of respect and equality where every woman and child can live free from fear and harm.",
            imageRes = R.drawable.sanpedro8,
            backgroundColor = pinkCard,
            shape = roundedCorner20
        )

        // Third quote
        Text(
            text = "When you're ready, we're here to listen.",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 12.dp)
        )

        // File a Complaint Button — with navigation
        ActionImageButton(
            text = "You can File a Complaint",
            imageRes = R.drawable.sanpedro10,
            shape = roundedCorner15,
            onClick = {
                navController.navigate("filing_of_complaint")
            }
        )

        // Call for Help Button — placeholder
        ActionImageButton(
            text = "You can Call for Help",
            imageRes = R.drawable.sanpedro11,
            shape = roundedCorner15,
            onClick = {
                // navController.navigate("call_help_screen") // optional
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Footer message
        Text(
            text = "Everyone Deserves Kindness, Care, and Compassion",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        Image(
            painter = painterResource(id = R.drawable.sanpedro12),
            contentDescription = "Floral Footer",
            modifier = Modifier.height(150.dp)
        )
    }
}

@Composable
fun InfoCard(text: String, imageRes: Int, backgroundColor: Color, shape: RoundedCornerShape) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor, shape)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.height(120.dp)
        )
    }
}

@Composable
fun ActionImageButton(text: String, imageRes: Int, shape: RoundedCornerShape, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        shape = shape,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = text, color = Color.Black, fontSize = 14.sp)
        }
    }
}
