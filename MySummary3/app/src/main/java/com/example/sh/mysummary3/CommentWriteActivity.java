package com.example.sh.mysummary3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class CommentWriteActivity extends AppCompatActivity {

    RatingBar ratingBar;
    EditText contentsInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_write);

        ratingBar = (RatingBar)findViewById(R.id.ratingBar2);
        contentsInput = (EditText)findViewById(R.id.contentsInput);

        Button saveButton = (Button)findViewById(R.id.savebutton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMain();
            }
        });

        Intent intent = getIntent();
        processIntent(intent);
    }

    private void processIntent(Intent intent)
    {
        if(intent != null)
        {
            float rating = intent.getFloatExtra("rating",0.0f);
            ratingBar.setRating(rating);
        }
    }

    public void returnToMain()
    {
        String contents = contentsInput.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("contents",contents);

        setResult(RESULT_OK,intent);

        finish();
    }
}
