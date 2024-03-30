package com.thuonght.lab5api;
import android.content.Context;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class VolleyFn2 {
    String strJSON="";
    public void getAllDataFromAPI(Context context, TextView textView)
    {
        RequestQueue queue= Volley.newRequestQueue(context);
        String url="https://65dcb181e7edadead7ecb752.mockapi.io/sanPham";
        JsonArrayRequest request=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {

            public void onResponse(JSONArray response) {

                for(int i=0;i<response.length();i++)
                {
                    try {
                        JSONObject person=response.getJSONObject(i);
                        String id=person.getString("id");
                        String name=person.getString("name");
                        String email=person.getString("email");
                        strJSON +="Id: "+id+"\n";
                        strJSON +="name: "+name+"\n";
                        strJSON +="email: "+email+"\n";
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                textView.setText(strJSON);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        });
        queue.add(request);//thuc thi request
    }
}

