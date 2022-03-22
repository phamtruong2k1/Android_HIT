package com.example.phamtruong.haui.buoi6;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    static String url="https://huandeptrai.herokuapp.com/api/users";
    static String url_post="https://huandeptrai.herokuapp.com/api/users/param";
    String imgg="https://res.cloudinary.com/dlqdesqni/image/upload/v1647304560/aqgnkhgaqwn2a2gpjate.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        GetData();
//        PostData("truong10","1234","Truong");
//        PatchData(1);
        ImageView img = findViewById(R.id.img);

        Picasso.get().load(imgg).into(img);

        Picasso.get().load(imgg).fetch();
    }

    private void DeleteData(int i){
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        StringRequest jsonArrayRequest = new StringRequest(Request.Method.DELETE, url_post, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> param = new HashMap<>();

                param.put("id",i+"");

                return param;
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                String a;

                return super.getBody();
            }
        };
        requestQueue.add(jsonArrayRequest);
    }




    private void PatchData(int i){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id",1+"");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest jsonArrayRequest = new StringRequest(Request.Method.PATCH, url_post, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> param = new HashMap<>();

                param.put("id",i+"");

                return param;
            }

            @Override
            public byte[] getBody() throws AuthFailureError {

                return jsonObject.toString().getBytes(StandardCharsets.UTF_8);
            }
        };
        requestQueue.add(jsonArrayRequest);
    }



    private void PostData(String usernam , String pass, String name){
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        StringRequest jsonArrayRequest = new StringRequest(Request.Method.POST, url_post, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> param = new HashMap<>();

                param.put("username",usernam);
                param.put("password",pass);
                param.put("fullName",name);

                return param;
            }
        };
        requestQueue.add(jsonArrayRequest);
    }

    private void GetData(){
        List list = new ArrayList();
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonArrayRequest jon = new JsonArrayRequest(Request.Method.GET,url,null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                System.out.println(response);
                for (int i=0;i<response.length();i++){
                    try {
                        JSONObject object = response.getJSONObject(i);
                        Integer id = object.getInt("id");
                        String username = object.getString("username");
                        System.out.println(id+" "+username);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"Looix",Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jon);
    }
}