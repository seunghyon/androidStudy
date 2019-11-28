package com.example.retrofittest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText idEditText;
    private EditText nickNameEditText;
    //private Button addButton;
   // private Button updateButton;
    private TextView resultTextView;

    private String ed_id, ed_nickname;

    private JsonHolderApi service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idEditText = findViewById(R.id.idEditText);
        nickNameEditText = findViewById(R.id.nickNameEditText);
       // addButton = findViewById(R.id.addButton);
        resultTextView = findViewById(R.id.resultTextView);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JsonHolderApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(JsonHolderApi.class);
    }

    public void AddUser(View view) {
        resultTextView.setText("클릭");
        ed_id = idEditText.getText().toString();
        ed_nickname = nickNameEditText.getText().toString();

        service.login(ed_id,ed_nickname).enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()){
                    resultTextView.setText("Code: "+ response.code());
                    return;
                }
                List<Post> posts = response.body();

                for (Post post:posts){
                    String content = "";
                    content += "Id: "+post.getId()+"\n";
                    content += "nickName: "+post.getNickName() +"\n\n";

                    resultTextView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                resultTextView.setText(t.getMessage());
            }
        });





    }

    public void UpdateUser(View view) {
        resultTextView.setText("클릭");
        ed_id = idEditText.getText().toString();
        ed_nickname = nickNameEditText.getText().toString();

        service.update(ed_id,ed_nickname).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()){
                    resultTextView.setText("Code: "+ response.code());
                    return;
                }

                Post post = response.body();
                if(post.getResult().equals("ok")){
                    resultTextView.setText("성공");
                }else{
                    resultTextView.setText("실패");
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                resultTextView.setText(t.getMessage());
            }
        });
    }
}
