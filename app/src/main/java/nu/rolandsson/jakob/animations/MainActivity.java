package nu.rolandsson.jakob.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import nu.rolandsson.jakob.animations.resources.ViewId;
import nu.rolandsson.jakob.animations.resources.ViewResource;

public abstract class MainActivity extends AppCompatActivity {
    @ViewId(ViewResource.BTN_DRAW_ACTIVITY)
    private Button drawActivityBtn;

    @ViewId(ViewResource.BTN_INTERACTION_ACTIVITY)
    private Button interactionActivityBtn;

    @ViewId(ViewResource.BTN_ANIMATION_ACTIVITY)
    private Button animationActivityBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewResource.setViews(this, MainActivity.class);

        setupListeners();
    }

    protected abstract void setupListeners();

    public Button getDrawActivityBtn() {
        return drawActivityBtn;
    }

    public Button getInteractionActivityBtn() {
        return interactionActivityBtn;
    }

    public Button getAnimationActivityBtn() {
        return animationActivityBtn;
    }
}
