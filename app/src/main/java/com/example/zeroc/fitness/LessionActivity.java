package com.example.zeroc.fitness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.zeroc.fitness.adapter.VideosAdapter;
import com.example.zeroc.fitness.model.Videos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LessionActivity extends AppCompatActivity {

    private ListView lv1;
//    FirebaseDatabase database;
//    DatabaseReference myRef;
//    DatabaseReference allRef;
//    ArrayList<Item> arryList;
//    ListviewLessionAdapter adapter;
    private final String TAG = "LessionActivity";

   public static String API_KEY = "AIzaSyCTfRXNjQVbrrrqKxsZaRi1fMRbUqXAEHo";
    String listID = "PL_xM2_zr4dWKliSdpJdePY9fqmJq0Uq-6";
    String urlGetJson = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PL_xM2_zr4dWKliSdpJdePY9fqmJq0Uq-6&key=AIzaSyCTfRXNjQVbrrrqKxsZaRi1fMRbUqXAEHo&maxResults=50";

    ListView lvVideo;
    ArrayList<Videos> videos;
    VideosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_lession );

        lvVideo = findViewById( R.id.lv1 );
        videos = new ArrayList<>();
        adapter = new VideosAdapter( LessionActivity.this, R.layout.videos, videos );
        lvVideo.setAdapter( adapter );
        GetJsonYoutbe( urlGetJson );

        lvVideo.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent( LessionActivity.this, PlayYoutubeVideoActivity.class );
                intent.putExtra( "idVideo", videos.get( position ).getId() );
                startActivity( intent );
//
//                FragmentYoutubePlayer fragmentYoutubePlayer = new FragmentYoutubePlayer();
//                fragmentYoutubePlayer.show( getSupportFragmentManager() , "dialog" );
//
//                FragmentYoutubePlayer fragment = new FragmentYoutubePlayer();
//                FragmentManager manager = getSupportFragmentManager();
//                manager.beginTransaction()
//                        .replace(R.id.lv1, fragment)
//                        .commit();

            }
        } );
    }

    private void GetJsonYoutbe(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue( this );
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest( Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonItems = response.getJSONArray( "items" );
                    String title = "";
                    String urlJSON = "";
                    String videoId = "";
                    for (int i = 0; i < jsonItems.length(); i++) {
                        JSONObject jsonitem = jsonItems.getJSONObject( i );
                        JSONObject jsonSnippet = jsonitem.getJSONObject( "snippet" );

                        title = jsonSnippet.getString( "title" );

                        JSONObject jsonThump = jsonSnippet.getJSONObject( "thumbnails" );

                        JSONObject jsonMedium = jsonThump.getJSONObject( "medium" );

                        urlJSON = jsonMedium.getString( "url" );

                        JSONObject jsonResourceId = jsonSnippet.getJSONObject( "resourceId" );

                        videoId = jsonResourceId.getString( "videoId" );

                        videos.add( new Videos( title, urlJSON, videoId ) );

                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText( LessionActivity.this, response.toString(), Toast.LENGTH_SHORT ).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText( LessionActivity.this, "Failed", Toast.LENGTH_SHORT ).show();
            }
        } );
        requestQueue.add( jsonObjectRequest );
    }
}

