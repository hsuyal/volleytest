package com.example.volleytest;

import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	 private ImageView mImageView; 
	    private NetworkImageView mNetworkImageView; 
	    @Override 
	    protected void onCreate(Bundle savedInstanceState) { 
	        super.onCreate(savedInstanceState); 
	        setContentView(R.layout.activity_main); 
	        init(); 
	    } 
	       
	    private void init(){ 
	        mImageView=(ImageView) findViewById(R.id.imageView); 
	        mNetworkImageView=(NetworkImageView)findViewById(R.id.networkImageView); 
	        getJSONByVolley(); 
	        loadImageByVolley(); 
	        showImageByNetworkImageView(); 
	    } 
	   
	    /**
	     * ����Volley��ȡJSON����
	     */ 
	    private void getJSONByVolley() { 
	        RequestQueue requestQueue = Volley.newRequestQueue(this); 
	        String JSONDataUrl = "http://pipes.yahooapis.com/pipes/pipe.run?_id=giWz8Vc33BG6rQEQo_NLYQ&_render=json"; 
	        final ProgressDialog progressDialog = ProgressDialog.show(this, "This is title", "...Loading..."); 
	   
	        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest( 
	                Request.Method.GET,  
	                JSONDataUrl,  
	                null, 
	                new Response.Listener<JSONObject>() { 
	                    @Override 
	                    public void onResponse(JSONObject response) { 
	                        System.out.println("response="+response); 
	                        if (progressDialog.isShowing()&&progressDialog!=null) { 
	                            progressDialog.dismiss(); 
	                        } 
	                    } 
	                },  
	                new Response.ErrorListener() { 
	                    @Override 
	                    public void onErrorResponse(VolleyError arg0) { 
	                           System.out.println("sorry,Error"); 
	                    } 
	                }); 
	        requestQueue.add(jsonObjectRequest); 
	    } 
	       
	       
	    /**
	     * 不同三个参数getImageListener(ImageView view, int defaultImageResId, int errorImageResId)
	     * 使用单例模式，通过Volley加载图片
	     * 不含参数，采用自定义形式，LRUCache的实现方式
	     * getImageListener有三个参数(ImageView view, int defaultImageResId, int errorImageResId)
	     */ 
	    private void loadImageByVolley(){ 
		//模拟删除一东西
	      //  String imageUrl="http://avatar.csdn.net/6/6/D/1_lfdfhl.jpg"; 
	        RequestQueue requestQueue = Volley.newRequestQueue(this); 
	        final LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(20); 
	        ImageCache imageCache = new ImageCache() { 
	            @Override 
	            public void putBitmap(String key, Bitmap value) { 
	                lruCache.put(key, value); 
	            } 
	   
	            @Override 
	            public Bitmap getBitmap(String key) { 
	                return lruCache.get(key); 
	            } 
	        }; 
	        ImageLoader imageLoader = new ImageLoader(requestQueue, imageCache); 

	     // 采用系统自定义的方式

	        ImageListener listener = ImageLoader.getImageListener(mImageView, R.drawable.ic_launcher,R.drawable.ic_launcher); 
	        imageLoader.get(imageUrl, listener); 
	    } 
	       
	    /**
		
	     * 显示到ImageView，使用单例模式进行使用，有一个请求队列
	     */ 
	    private void showImageByNetworkImageView(){ 
	        String imageUrl="http://avatar.csdn.net/6/6/D/1_lfdfhl.jpg"; 
	        RequestQueue requestQueue = Volley.newRequestQueue(this); 
	        final LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(20); 
	        ImageCache imageCache = new ImageCache() { 
	            @Override 
	            public void putBitmap(String key, Bitmap value) { 
	                lruCache.put(key, value); 
	            } 
	   
	            @Override 
	            public Bitmap getBitmap(String key) { 
	                return lruCache.get(key); 
	            } 
	        }; 
	        ImageLoader imageLoader = new ImageLoader(requestQueue, imageCache); 
	        mNetworkImageView.setTag("url"); 
	        mNetworkImageView.setImageUrl(imageUrl,imageLoader); 
	        
	    } 
	    
	  
}
