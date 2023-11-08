package my.snacksquad.app;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyOrdersActivity extends AppCompatActivity {

    private SharedViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        List<dishh> cartItems = getIntent().getParcelableArrayListExtra("cartItems");
        RecyclerView recyclerView = findViewById(R.id.ordersRecyclerView);
        TextView totalPriceTextView = findViewById(R.id.totalPriceTextView);
        OrdersAdapter ordersAdapter = new OrdersAdapter(cartItems,totalPriceTextView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(ordersAdapter);
        viewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        StringBuilder cartItemsText = new StringBuilder();
        for (dishh item : cartItems) {
            cartItemsText.append(item.getName()).append(" - ").append(item.getPrice()).append("\n");
        }
        double totalPrice = getIntent().getDoubleExtra("totalPrice", 0.0);

        totalPriceTextView.setText("Total Price: " + totalPrice);
    }
}
