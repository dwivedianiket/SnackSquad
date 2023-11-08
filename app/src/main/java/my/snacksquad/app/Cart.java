package my.snacksquad.app;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class Cart {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String price;
    private int id;
    private static Cart instance;
    private List<dishh> cartItems;
    private MutableLiveData<List<dishh>> cartLiveData = new MutableLiveData<>();
    private Cart() {
        cartItems = new ArrayList<>();
    }

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }
    public void addToCart(dishh item) {
        // Check if the item is already in the cart
        boolean isItemInCart = false;

        for (dishh cartItem : cartItems) {
            if (cartItem.getId() == item.getId()) {
                isItemInCart = true;
                break;
            }
        }

        if (!isItemInCart) {
            item.setQuantity(1);
            cartItems.add(item);
        }

        notifyCartChanged();
    }

    public void removeFromCart(dishh item) {
        cartItems.remove(item);
        notifyCartChanged();
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;

        for (dishh item : cartItems) {
            try {
                double itemPrice = Double.parseDouble(item.getPrice());
                totalPrice += itemPrice * item.getQuantity();
            } catch (NumberFormatException e) {
            }
        }

        return totalPrice;
    }

    public LiveData<List<dishh>> getCartLiveData() {
        return cartLiveData;
    }

    public List<dishh> getCartItems() {
        return cartItems;
    }

    private void notifyCartChanged() {
        // Notify LiveData observers of changes
        cartLiveData.setValue(new ArrayList<>(cartItems));
    }
}
