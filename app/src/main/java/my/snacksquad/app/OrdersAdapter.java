package my.snacksquad.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ViewHolder> {

    private List<dishh> items;
    private TextView totalPriceTextView;

    public OrdersAdapter(List<dishh> items, TextView totalPriceTextView) {
        this.items = items;
        this.totalPriceTextView = totalPriceTextView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        dishh item = items.get(position);
        holder.nameTextView.setText(item.getName());
        holder.priceTextView.setText(item.getPrice());
        holder.quantityTextView.setText(String.valueOf(item.getQuantity()));
        holder.description.setText(item.getDescription());
        holder.imageView.setImageResource(item.getId());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void updateCartItems(List<dishh> updatedItems) {
        items.clear();
        items.addAll(updatedItems);
        notifyDataSetChanged();
        double totalPrice = calculateTotalPrice();
        totalPriceTextView.setText("Total Price: " + totalPrice);
    }

    private double calculateTotalPrice() {
        double totalPrice = 0.0;

        for (dishh item : items) {
            double itemPrice = Double.parseDouble(item.getPrice());
            totalPrice += itemPrice * item.getQuantity();
        }

        return totalPrice;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        ImageView imageView;
        TextView priceTextView, description;
        TextView quantityTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.det_name);
            priceTextView = itemView.findViewById(R.id.price);
            quantityTextView = itemView.findViewById(R.id.quantity);
            description = itemView.findViewById(R.id.det_des);
            imageView = itemView.findViewById(R.id.img);
        }
    }
}
