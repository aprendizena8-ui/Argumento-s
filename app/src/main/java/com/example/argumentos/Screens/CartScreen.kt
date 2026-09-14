package com.example.argumentos.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.argumentos.Models.Producto
import com.example.argumentos.R

@Composable
fun CartScreen(
    cartItems: List<Producto>,
    totalPrice: Double,
    onRemoveItem: (Producto) -> Unit,
    onClearCart: () -> Unit,
    onCheckout: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (cartItems.isEmpty()) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.productocarrito),
                contentDescription = "Carrito Vacío",
                modifier = Modifier
                    .size(120.dp)
                    .padding(16.dp)
            )
            Text(
                text = "Tu carrito está vacío",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        return
    }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = "Carrito",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(cartItems) { product ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = product.imageRes),
                            contentDescription = product.name,
                            modifier = Modifier.size(50.dp)
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(modifier = Modifier.weight(1f)) {
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

                        Text(
                            text = "✕",
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.error,
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .clickable { onRemoveItem(product) }
                        )
                    }
                }
            }
        }

        Surface(
            modifier = Modifier.fillMaxWidth(),
            tonalElevation = 3.dp,
            shadowElevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Total",
                            style = MaterialTheme.typography.labelLarge
                        )
                        Text(
                            text = "$${String.format("%.2f", totalPrice)}",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedButton(onClick = onClearCart) {
                            Text("Vaciar")
                        }
                        Button(onClick = onCheckout) {
                            Text("Pagar")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCartScreen() {
    val productos = listOf(
        Producto(
            id = 1,
            name = "Mouse",
            price = 80000.0,
            description = "Mouse óptico",
            imageRes = R.drawable.productocarrito
        ),
        Producto(
            id = 2,
            name = "Auriculares Bluetooth",
            price = 59.99,
            description = "Auriculares inalámbricos",
            imageRes = R.drawable.productocarrito
        ),
        Producto(
            id = 3,
            name = "Monitor 4K",
            price = 350.0,
            description = "Monitor de 27 pulgadas",
            imageRes = R.drawable.productocarrito
        )
    )
    CartScreen(
        cartItems = productos,
        totalPrice = 80409.99,
        onRemoveItem = {},
        onClearCart = {},
        onCheckout = {}
    )
}