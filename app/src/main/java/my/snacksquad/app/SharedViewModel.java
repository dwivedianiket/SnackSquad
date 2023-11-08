package my.snacksquad.app;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<List<dishh>> cartItemsLiveData = new MutableLiveData<>();
    private MutableLiveData<Double> totalLiveData = new MutableLiveData<>();

    public LiveData<List<dishh>> getCartItemsLiveData() {
        return cartItemsLiveData;
    }

    public LiveData<Double> getTotalLiveData() {
        return totalLiveData;
    }

    public void setCartItems(List<dishh> cartItems) {
        cartItemsLiveData.setValue(cartItems);
    }

    public void setTotal(double total) {
        totalLiveData.setValue(total);
    }
}

