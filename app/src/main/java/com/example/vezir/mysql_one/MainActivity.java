package com.example.vezir.mysql_one;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText edittextone,edittexttou,edittextthree;
    String url = "http://192.168.1.136/android-one.php";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        edittextone = findViewById(R.id.edittextone);
        edittexttou = findViewById(R.id.edittexttou);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verileriyolla();
            }
        });
    }
    public void verileriyolla(){



            final String username=edittextone.getText().toString();
            final String password=edittexttou.getText().toString();

            if(username.equals("")==false && password.equals("")==false)
            {
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

                String url = "http://192.168.1.136/android-one.php";    // Post atılan adres.
                StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();
                                Toast.makeText(getApplicationContext(), "BAŞARILI", Toast.LENGTH_LONG).show();

                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MainActivity.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
                                Toast.makeText(getApplicationContext(), "HATALI", Toast.LENGTH_LONG).show();
                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<String, String>();
                        params.put("username", username);
                        params.put("password", password);

                        return params;
                    }
                };
                queue.add(postRequest);
            }
            else
            {
                Toast.makeText(MainActivity.this,"Lütfen Gerekli Alanları Doldurun",Toast.LENGTH_LONG).show();
            }

        }




}
