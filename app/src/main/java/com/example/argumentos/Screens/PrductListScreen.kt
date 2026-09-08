package com.example.argumentos.Screens

import androidx.compose.foundation.clickable  // ← Agregar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column  // ← Agregar
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row  // ← Agregar
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.argumentos.Models.Producto

val SampleProducts = listOf(
    Producto(1, "Auriculares Bluetooth", 59.99, "Cancelación de ruido activa, 30h de batería.",""),
    Producto(2, "Smartwatch Pro", 129.99, "GPS, monitor de salud y resistencia al agua.",""),
    Producto(3, "Teclado Mecánico", 89.99, "Switches rojos, RGB y reposamuñecas.",""),
    Producto(4, "Mouse Inalámbrico", 34.99, "Ergonómico, 6 botones programables.",""),
    Producto(5, "Monitor 4K 27'' ", 299.99, "144Hz, HDR400, panel IPS.","")
)

@Composable
fun ProductListScreen(
    onProductClick: (Producto) -> Unit,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(SampleProducts) { product ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onProductClick(product) },
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = product.name,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "$${product.price}",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                        Text(text = "Next ->")
                    }
                }
            }
        }

        Button(
            onClick = { onBack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Default.ArrowBackIosNew, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Regresar....")
        }
    }
}

fun onProductClick(product: Int) {

}

@Preview
@Composable
fun PreviewList() {
    ProductListScreen({}, {})
}