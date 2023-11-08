package my.snacksquad.app;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DishesAdapter extends RecyclerView.Adapter<DishesAdapter.ViewHolder> {
    private List<dishh> list;
    private OnItemClickListener listener;

    private Cart cart;

    public DishesAdapter(List<dishh> list) {
        this.list = list;
        this.cart = cart;

    }

    public interface OnItemClickListener {
        void onAddToCartClick(int position);

    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.dish, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        dishh item = list.get(position);

        holder.imageView.setImageResource(item.getId());
        holder.price.setText(item.getPrice());
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.rating.setText(item.getRating());
        holder.quantity.setText(String.valueOf(item.getQuantity()));

        holder.addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onAddToCartClick(position);
                }
            }
        });
        holder.increaseQuantityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentQuantity = item.getQuantity();
                item.setQuantity(currentQuantity + 1);
                holder.quantity.setText(String.valueOf(item.getQuantity()));
            }
        });

        holder.decreaseQuantityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentQuantity = item.getQuantity();
                if (currentQuantity > 1) {
                    item.setQuantity(currentQuantity - 1);
                    holder.quantity.setText(String.valueOf(item.getQuantity()));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, price, description, rating;
        Button addToCartButton;
        Button increaseQuantityButton;
        Button decreaseQuantityButton;
        TextView quantity;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            price = itemView.findViewById(R.id.price);
            name = itemView.findViewById(R.id.det_name);
            description = itemView.findViewById(R.id.det_des);
            rating = itemView.findViewById(R.id.rating);
            addToCartButton = itemView.findViewById(R.id.addToCartButton);
            increaseQuantityButton = itemView.findViewById(R.id.increaseQuantityButton);
            decreaseQuantityButton = itemView.findViewById(R.id.decreaseQuantityButton);
            quantity = itemView.findViewById(R.id.quantity);
        }
    }
}
