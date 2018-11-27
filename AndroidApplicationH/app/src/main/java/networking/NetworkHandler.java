package networking;


import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class NetworkHandler {

    private static NetworkHandler mInstance = null;
    private RequestQueue mRequestQueue;
    private Context mContext;

    private NetworkHandler(Context context) {
        this.mContext = context;
        mRequestQueue = Volley.newRequestQueue(mContext);
    }

    public static NetworkHandler getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new NetworkHandler(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        return this.mRequestQueue;
    }

}

