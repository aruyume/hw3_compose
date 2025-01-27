package com.example.hw3_compose.ui.screens.locations

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hw3_compose.model.LocationModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LocationsScreen(
    onNavigateToDetail: (Int) -> Unit,
    paddingValues: PaddingValues,
    locationsViewModel: LocationsViewModel = koinViewModel()
) {
    val locations = locationsViewModel.locations.collectAsState().value
    val isLoading = locationsViewModel.isLoading.collectAsState().value

    LaunchedEffect(Unit) {
        locationsViewModel.fetchAllLocations()
    }

    if (isLoading) {
        Text(text = "Loading...", modifier = Modifier.padding(16.dp))
    } else {
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(top = 10.dp)
        ) {
            items(locations) { location ->
                LocationItem(
                    location = location,
                    onItemClick = { onNavigateToDetail(location.id) })
            }
        }
    }
}

@Composable
fun LocationItem(location: LocationModel, onItemClick: (LocationModel) -> Unit) {
    Spacer(modifier = Modifier.height(16.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.LightGray)
            .clickable { onItemClick(location) }
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = location.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                maxLines = 1
            )
        }
    }
}