package my.snacksquad.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.models.SlideModel;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.ImageSlider;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ArrayList<SlideModel> imageList = new ArrayList<>();

        imageList.add(new SlideModel(R.drawable.abcd, ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.banner2, ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.bann3, ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.ban44, ScaleTypes.CENTER_CROP));

        ImageSlider imageSlider = view.findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);
        setupRestaurantRecyclerView(view);

        return view;
    }

    private void setupRestaurantRecyclerView(View view) {
        List<Restaurant> restaurantList = new ArrayList<>();
        restaurantList.add(new Restaurant(R.drawable.rest, "Chaar Samosee"));
        restaurantList.add(new Restaurant(R.drawable.rest1, "Delicious Dhaba"));
        restaurantList.add(new Restaurant(R.drawable.rest2, "Food Corner"));
        restaurantList.add(new Restaurant(R.drawable.rest3, "Moms Kitchen"));
        restaurantList.add(new Restaurant(R.drawable.rest4, "Fresh House"));
        restaurantList.add(new Restaurant(R.drawable.rest5, "Tastilicious"));
        restaurantList.add(new Restaurant(R.drawable.rest6, "Ram Dhaba"));
        restaurantList.add(new Restaurant(R.drawable.rest7, "Chicken House"));
        restaurantList.add(new Restaurant(R.drawable.rest8, "Kaathi Foods"));
        restaurantList.add(new Restaurant(R.drawable.rest9, "The Last Stop"));
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        RestaurantAdapter adapter = new RestaurantAdapter(getActivity(), restaurantList);
        recyclerView.setAdapter(adapter);
    }
}

