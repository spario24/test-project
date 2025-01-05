package com.android.paginationverticalscroll;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.paginationverticalscroll.fragments.CorouselFragment1;
import com.android.paginationverticalscroll.fragments.CorouselFragment2;
import com.android.paginationverticalscroll.fragments.MainFragment;
import com.android.paginationverticalscroll.fragments.StarUpFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.container, new MainFragment())
//                .replace(R.id.container, new StarUpFragment())
//                .replace(R.id.container, new CorouselFragment1())
                .replace(R.id.container, new CorouselFragment2())
                .commit();
    }
}