package my.snacksquad.app;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class dishes extends AppCompatActivity {
    RecyclerView recyclerView;
    DishesAdapter dishesAdapter;
    private Cart cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dishes);
        cart = Cart.getInstance();
        recyclerView = findViewById(R.id.det_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<dishh> dishhList = new ArrayList<>();
        dishhList.add(new dishh(R.drawable.biryani, "Biryani", "Description", "5", "349"));
        dishhList.add(new dishh(R.drawable.chicken, "Chicken Grilled", "Description", "4.9", "349"));
        dishhList.add(new dishh(R.drawable.pizza, "Pizza", "Description", "4", "649"));
        dishhList.add(new dishh(R.drawable.burger, "Burger", "Description", "5", "149"));
        dishhList.add(new dishh(R.drawable.bunmaska, "Bun Maska", "Description", "4.1", "49"));
        dishhList.add(new dishh(R.drawable.drinks, "Drinks", "Description", "5", "99"));
        dishhList.add(new dishh(R.drawable.gulabjamun, "Sweets", "Description", "4.7", "49"));
        dishhList.add(new dishh(R.drawable.cakes, "Cake", "Description", "5", "249"));
        dishhList.add(new dishh(R.drawable.cbuttermasala, "Butter Chicken", "Description", "5", "449"));
        dishhList.add(new dishh(R.drawable.samoseeeee, "Samosa", "Description", "4.9", "15"));
        dishhList.add(new dishh(R.drawable.rajma, "Rajma Masala", "Description", "4", "199"));

        dishesAdapter = new DishesAdapter(dishhList);
        dishesAdapter.setOnItemClickListener(new DishesAdapter.OnItemClickListener() {
            @Override
            public void onAddToCartClick(int position) {
                dishh selectedDish = dishhList.get(position);
                cart.addToCart(selectedDish);
                Toast.makeText(dishes.this, "Added to Cart: " + selectedDish.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(dishesAdapter);
    }
}
