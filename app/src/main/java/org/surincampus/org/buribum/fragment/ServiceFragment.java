package org.surincampus.org.buribum.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import org.json.JSONArray;
import org.json.JSONObject;
import org.surincampus.org.buribum.R;
import org.surincampus.org.buribum.utility.FoodAdapter;
import org.surincampus.org.buribum.utility.GetAllData;
import org.surincampus.org.buribum.utility.MyConstant;

public class ServiceFragment extends android.support.v4.app.Fragment {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Create List View

        createListView();


    }// Main Method

    private void createListView() {
        ListView listView = getView().findViewById(R.id.listViewFood);

        MyConstant myConstant = new MyConstant();


        try {

            GetAllData getAllData = new GetAllData(getActivity());
            getAllData.execute(myConstant.getUrlGetAllFood());

            String jsonString = getAllData.get();

            JSONArray jsonArray = new JSONArray(jsonString);
            String[] foodStrings = new String[jsonArray.length()];
            String[] priceStrings = new String[jsonArray.length()];
            String[] detailStrings = new String[jsonArray.length()];
            String[] imageStrings = new String[jsonArray.length()];

            for(int i = 0; i < jsonArray.length();i++){

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                foodStrings[i] = jsonObject.getString("NameFood");  // name have to be the same with Database
                priceStrings[i] = jsonObject.getString("Price");
                detailStrings[i] = jsonObject.getString("Detail");
                imageStrings[i] = jsonObject.getString("ImagePath");

            }

            FoodAdapter foodAdapter = new FoodAdapter(getActivity(),imageStrings,foodStrings,priceStrings,detailStrings);  //check parameter
            listView.setAdapter(foodAdapter);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service, container, false);
        return view;
    }
}
