package activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.igor.androidapplicationh.R;
import com.squareup.picasso.Picasso;

import models.ItemModel;


public class ItemDetailsActivity extends Activity {

    public TextView mDescription, mTitle;
    public ImageView mImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details_layout);

        Intent intent = getIntent();
        ItemModel itemModel =(ItemModel) intent.getSerializableExtra("itemObject");

        mImage = findViewById(R.id.image);
        mDescription = findViewById(R.id.description);
        mTitle = findViewById(R.id.title);

        Picasso.get().load(itemModel.getmImage()).into(mImage);
        mTitle.setText(itemModel.getmTitle());
        mDescription.setText(itemModel.getmDescription());

    }
}
