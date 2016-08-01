package id.or.codelabs.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView name;
    TextView email;
    public static final String PREFERENCE = "pref";
    public static final String NAME_KEY = "name";
    public static final String EMAIL_KEY = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        name = (EditText)findViewById(R.id.txt_name);
        email = (EditText)findViewById(R.id.txt_email);
        sharedPreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);

        if (sharedPreferences.contains(NAME_KEY)){
            name.setText(sharedPreferences.getString(NAME_KEY, ""));
        }
        if(sharedPreferences.contains(EMAIL_KEY)){
            email.setText(sharedPreferences.getString(EMAIL_KEY, ""));
        }
    }

    public void save(View view){
        String n = name.getText().toString();
        String e = email.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAME_KEY, n);
        editor.putString(EMAIL_KEY, e);
        editor.commit();
    }

    public void clear(View view){
        name = (EditText)findViewById(R.id.txt_name);
        email = (EditText)findViewById(R.id.txt_email);
        name.setText("");
        email.setText("");
    }

    public void retrieve(View view){
        name = (EditText)findViewById(R.id.txt_name);
        email = (EditText)findViewById(R.id.txt_email);
        sharedPreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);

        if (sharedPreferences.contains(NAME_KEY)){
            name.setText(sharedPreferences.getString(NAME_KEY, ""));
        }
        if(sharedPreferences.contains(EMAIL_KEY)){
            email.setText(sharedPreferences.getString(EMAIL_KEY, ""));
        }
    }
}
