package my.snacksquad.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {
    private SharedViewModel viewModel;

    private RecyclerView cartRecyclerView;
    private CartAdapter cartAdapter;
    private Button placeOrderButton;
    private TextView totalPriceTextView;
    private Button myorderbutton;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);


        cartRecyclerView = view.findViewById(R.id.cartRecyclerView);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        totalPriceTextView = view.findViewById(R.id.totalPriceTextView);

        cartAdapter = new CartAdapter(Cart.getInstance().getCartItems(), Cart.getInstance(), totalPriceTextView);
        cartRecyclerView.setAdapter(cartAdapter);

        Cart.getInstance().getCartLiveData().observe(getViewLifecycleOwner(), new Observer<List<dishh>>() {
            @Override
            public void onChanged(List<dishh> cartItems) {
                cartAdapter.updateCartItems(cartItems);
                double totalPrice = Cart.getInstance().getTotalPrice();
                totalPriceTextView.setText("Total Price: " + totalPrice);
            }
        });
        myorderbutton = view.findViewById(R.id.myorderbutton);
        myorderbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<dishh> cartItems = Cart.getInstance().getCartItems();
                double totalPrice = Cart.getInstance().getTotalPrice();
                Intent intent = new Intent(requireContext(), MyOrdersActivity.class);
                intent.putParcelableArrayListExtra("cartItems", new ArrayList<>(cartItems));
                intent.putExtra("totalPrice", totalPrice);
                startActivity(intent);
            }
        });

        placeOrderButton = view.findViewById(R.id.placeOrderButton);

        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOrderPlacedAnimation();
            }
        });

        return view;
    }

    private void showOrderPlacedAnimation() {
        // You can use animations to provide visual feedback for order placement.
        // For example, you can use a Toast message for a simple animation:
        Toast.makeText(requireContext(), "Order Placed", Toast.LENGTH_SHORT).show();
    }
}
