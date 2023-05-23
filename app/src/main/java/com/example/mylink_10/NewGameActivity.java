package com.example.mylink_10;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.example.mylink_10.gameRelated.Game;
import com.example.mylink_10.gameRelated.GameConf;
import com.example.mylink_10.gameRelated.GameView;
import com.example.mylink_10.util.SoundPlayer;

import org.java_websocket.client.WebSocketClient;

public class NewGameActivity extends AppCompatActivity implements View.OnClickListener{

    private GameView gameView;
    private Game game;
    private static WebSocketClient webSocketClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        init();
        findViewById(R.id.btn_standalone).setOnClickListener(this);
        findViewById(R.id.btn_online).setOnClickListener(this);
        findViewById(R.id.btn_challenge).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_standalone:
                break;
            case R.id.btn_online:
                break;
            case R.id.challenge:
                break;
        }
    }



    /**
     * 游戏初始化
     */
    private void init() {
        GameConf.init(this, getApplicationContext());
        game = new Game();
        gameView = findViewById(R.id.gv);
        gameView.start(game);
    }

}