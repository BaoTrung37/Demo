package com.example.nguyenbaotrung_android43_buoi4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvBaoCao;
    ArrayList<BaoCao> baoCaoArrayList;
//    View headerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        lvBaoCao = findViewById(R.id.listBaoCao);
        baoCaoArrayList = new ArrayList<>();
//        headerView = getLayoutInflater().inflate(R.layout.header,lvBaoCao,false);
//        lvBaoCao.addHeaderView(headerView,null,false);
        baoCaoArrayList.add(new BaoCao("14/11/2018",
                "VFMVFB","600,000,123","600,000,123","0.00%"));
        baoCaoArrayList.add(new BaoCao("18/10/2018",
                "VFMVF1","45,169,614","44,669,147","-1.04%"));
        baoCaoArrayList.add(new BaoCao("05/11/2018",
                "VFMVF2","19,999,951","21,065,919","5.33%"));
        baoCaoArrayList.add(new BaoCao("06/11/2018",
                "VFMVF1","10,000,166","10,533,156","5.33%"));
        baoCaoArrayList.add(new BaoCao("07/11/2018",
                "VFMVF1","14,999,945","14,999,945","0.00%"));
        baoCaoArrayList.add(new BaoCao("08/11/2018",
                "VFMVF2","25,000,172","25,000,172","0.00%"));
        baoCaoArrayList.add(new BaoCao("09/11/2018",
                "VFMVF4","505,752,431","1,112,166,457","121.88%"));
        baoCaoArrayList.add(new BaoCao("14/11/2018",
                "VFMVFB","600,000,123","600,000,123","0.00%"));
        baoCaoArrayList.add(new BaoCao("18/10/2018",
                "VFMVF1","45,169,614","44,669,147","-1.04%"));
        baoCaoArrayList.add(new BaoCao("05/11/2018",
                "VFMVF2","19,999,951","21,065,919","5.33%"));
        baoCaoArrayList.add(new BaoCao("06/11/2018",
                "VFMVF1","10,000,166","10,533,156","5.33%"));
        baoCaoArrayList.add(new BaoCao("07/11/2018",
                "VFMVF1","14,999,945","14,999,945","0.00%"));
        baoCaoArrayList.add(new BaoCao("08/11/2018",
                "VFMVF2","25,000,172","25,000,172","0.00%"));
        baoCaoArrayList.add(new BaoCao("09/11/2018",
                "VFMVF4","505,752,431","1,112,166,457","121.88%"));
        BaoCaoAdapter adapter = new BaoCaoAdapter(baoCaoArrayList);
        lvBaoCao.setAdapter(adapter);
    }
}