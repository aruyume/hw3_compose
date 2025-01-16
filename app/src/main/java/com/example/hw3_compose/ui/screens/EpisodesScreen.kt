package com.example.hw3_compose.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hw3_compose.model.MockData

@Composable
fun EpisodesScreen(paddingValues: PaddingValues) {
    LazyColumn(
        modifier = Modifier.padding(paddingValues), contentPadding = PaddingValues(top = 10.dp)
    ) {
        items(MockData.episodes) { episode ->
            Text(
                text = episode.episode,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}