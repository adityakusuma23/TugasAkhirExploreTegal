package net.aditkus.exploretegal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }


    public void pesantiket(View view) {
        Intent webIntent = new Intent(android.content.Intent.ACTION_VIEW);
        webIntent.setData(Uri.parse("https://kai.id/"));
        startActivity(webIntent);
    }

    public void wiskul(View view) {
        Intent intent = new Intent(Home.this,ListKuliner.class);
        startActivity(intent);
    }
    public void goInstagram(View view) {
        Intent webIntent = new Intent(android.content.Intent.ACTION_VIEW);
        webIntent.setData(Uri.parse("https://www.instagram.com/exploretegal"));
        startActivity(webIntent);
    }

    public void Logout(View view) {
        Intent intent = new Intent(Home.this,MainActivity.class);
        startActivity(intent);
    }

    public void goNomor(View view) {
        Intent intent = new Intent(Home.this,NomorDarurat.class);
        startActivity(intent);
    }


}
