package my.snacksquad.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private List<dishh> cartItems;
    private Context context;
    private Cart cart;
    private TextView totalPriceTextView; // TextView to update the total price

    public CartAdapter(List<dishh> cartItems, Cart cart, TextView totalPriceTextView) {
        this.cartItems = cartItems;
        this.cart = cart;
        this.totalPriceTextView = totalPriceTextView; // Initialize total price TextView
    }
    public void updateCartItems(List<dishh> items) {
        cartItems = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.cart_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        dishh item = cartItems.get(position);
        holder.imageView.setImageResource(item.getId());
        holder.price.setText(item.getPrice());
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.quantity.setText(String.valueOf(item.getQuantity()));
        holder.removeFromCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cart != null) {
                    cart.removeFromCart(item);
                    if (position >= 0 && position < cartItems.size()) {
                        cartItems.remove(position);
                        notifyItemRemoved(position);
                        double totalPrice = cart.getTotalPrice();
                        totalPriceTextView.setText("Total Price: " + totalPrice);
                    }
                }
            }
        });
        holder.increaseQuantityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentQuantity = item.getQuantity();
                item.setQuantity(currentQuantity + 1);
                holder.quantity.setText(String.valueOf(item.getQuantity()));
                double totalPrice = cart.getTotalPrice();
                totalPriceTextView.setText("Total Price: " + totalPrice);
            }
        });
        holder.decreaseQuantityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentQuantity = item.getQuantity();
                if (currentQuantity > 1) {
                    item.setQuantity(currentQuantity - 1);
                    holder.quantity.setText(String.valueOf(item.getQuantity()));
                    double totalPrice = cart.getTotalPrice();
                    totalPriceTextView.setText("Total Price: " + totalPrice);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, price, description;
        Button removeFromCartButton;
        Button increaseQuantityButton;
        Button decreaseQuantityButton;
        TextView quantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            price = itemView.findViewById(R.id.price);
            name = itemView.findViewById(R.id.det_name);
            description = itemView.findViewById(R.id.det_des);
            removeFromCartButton = itemView.findViewById(R.id.removeFromCartButton);
            increaseQuantityButton = itemView.findViewById(R.id.increaseQuantityButton);
            decreaseQuantityButton = itemView.findViewById(R.id.decreaseQuantityButton);
            quantity = itemView.findViewById(R.id.quantity);
        }
    }
}
