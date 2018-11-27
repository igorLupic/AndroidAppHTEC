package activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;


import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import networking.NetworkConstants;
import networking.NetworkHandler;
import com.example.igor.androidapplicationh.R;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import adapters.ItemAdapter;
import models.ItemModel;

public class MainActivity extends AppCompatActivity{
    private List<ItemModel> itemModelList1 = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private ItemAdapter mItemAdapter;
    private JsonArrayRequest mRequest;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        mProgressBar = findViewById(R.id.progress_bar);
        setSupportActionBar(toolbar);

        mRecyclerView = findViewById(R.id.recycler_view);

        jsonrequest();


        mItemAdapter = new ItemAdapter(itemModelList1, this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mItemAdapter);

        // Line decoration

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

    }

    // Json requesting

    private void jsonrequest() {
        mRequest = new JsonArrayRequest(NetworkConstants.mBaseUrl, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {

                    try {
                        jsonObject = response.getJSONObject(i);
                        ItemModel itemModel = new ItemModel();
                        itemModel.setmImage(jsonObject.getString("image"));
                        itemModel.setmDescription(jsonObject.getString("description"));
                        itemModel.setmTitle(jsonObject.getString("title"));

                        itemModelList1.add(itemModel);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                mProgressBar.setVisibility(View.GONE);
                setUpRecyclerView(itemModelList1);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mProgressBar.setVisibility(View.GONE);
            }
        });

        NetworkHandler.getInstance(this).getRequestQueue().add(mRequest);

    }

    private void setUpRecyclerView(List<ItemModel> itemModelList1) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mItemAdapter);

    }
}
