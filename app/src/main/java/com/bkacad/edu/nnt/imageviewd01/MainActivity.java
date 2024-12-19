package com.bkacad.edu.nnt.imageviewd01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Khai báo view
    private ImageView imgDog;
    private Button btnSwap;

    // Biến trạng thái
    private boolean isClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Bind ID:
        btnSwap = findViewById(R.id.btnSwap);
        imgDog = findViewById(R.id.imgDog);

        // Lắng nghe sự kiện
        btnSwap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isClicked == false){
                    isClicked = true;
                    imgDog.setImageDrawable(getDrawable(R.drawable.dog2));
                }
                else {
                    isClicked = false;
                    imgDog.setImageDrawable(getDrawable(R.drawable.dog1));
                }
            }
        });
    }
}