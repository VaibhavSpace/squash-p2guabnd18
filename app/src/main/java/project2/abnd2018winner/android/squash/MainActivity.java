package project2.abnd2018winner.android.squash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int scoreHome, scoreVisitor,scoreGames; // Variables to track scores fro Home, Visitor and Games
    TextView scoreHomeView, scoreVisitorView, scoreGamesView; //TextView variable to display scores fro Home, Visitor and Games

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        displayForHome(scoreHome);
        displayForVisitor(scoreVisitor);
        displayForGames(scoreGames);

        scoreHomeView = findViewById(R.id.textView_score_home);
        scoreVisitorView = findViewById(R.id.textView_score_visitor);
        scoreGamesView = findViewById(R.id.textView_score_game);
    }

    /**
     * Retains scores values in the case of screen rotation.
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("scoreHomeKey", scoreHome);
        savedInstanceState.putInt("scoreVisitorKey", scoreVisitor);
        savedInstanceState.putInt("scoreGameKey", scoreGames);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        scoreHome = savedInstanceState.getInt("scoreHomeKey");
        scoreVisitor = savedInstanceState.getInt("scoreVisitorKey");
        scoreGames = savedInstanceState.getInt("scoreGameKey");

        TextView scoreHomeTextView = findViewById(R.id.textView_score_home);
        scoreHomeTextView.setText(String.valueOf(scoreHome));

        TextView scoreVisitorTextView = findViewById(R.id.textView_score_visitor);
        scoreVisitorTextView.setText(String.valueOf(scoreVisitor));

        TextView scoreGameTextView = findViewById(R.id.textView_score_game);
        scoreGameTextView.setText(String.valueOf(scoreGames));
    }

    /**
     * Displays the given score for Home.
     */
    public void displayForHome(int score) {
        scoreHomeView = findViewById(R.id.textView_score_home);
        scoreHomeView.setText(String.valueOf(score));
    }

    /**
     * Increase the score for Home by 1 point.
     */
    public void addOneForHome(View v) {
        scoreHome = scoreHome + 1;
        displayForHome(scoreHome);
    }

    /**
     * Displays the given score for Visitor.
     */
    public void displayForVisitor(int score) {
        scoreVisitorView = findViewById(R.id.textView_score_visitor);
        scoreVisitorView.setText(String.valueOf(score));
    }

    /**
     * Increase the score for Visitor by 1 point.
     */
    public void addOneForVisitor(View v) {
        scoreVisitor = scoreVisitor + 1;
        displayForVisitor(scoreVisitor);
    }

    /**
     * Displays the given score for Games.
     */
    public void displayForGames(int score) {
        scoreGamesView = findViewById(R.id.textView_score_game);
        scoreGamesView.setText(String.valueOf(score));
    }

    /**
     * Increase the score for Game by 1 point.
     */
    public void addOneForGame(View v) {
        scoreGames = scoreGames + 1;
        displayForGames(scoreGames);
    }

    /**
     * Reset the Home and Visitor scores.
     */
    public void resetScore(View v) {
        scoreHome = 0;
        scoreVisitor = 0;
        displayForHome(scoreHome);
        displayForVisitor(scoreVisitor);
    }

    /**
     * Reset the Games.
     */
    public void resetGame(View v) {
        scoreGames = 0;
        displayForGames(scoreGames);
    }

    /**
     * Radio Button for service selection.
     */
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButton_home:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radioButton_visitor:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}
