package nu.rolandsson.jakob.animations;

import android.os.Handler;
import android.os.Looper;
import android.view.View;

/**
 * Created by Martin on 2018-04-08.
 */

public class MainContext extends MainActivity {
    @Override
    protected void setupListeners() {
        getDrawActivityBtn().setOnClickListener(this::startDrawActivity);
        getInteractionActivityBtn().setOnClickListener(this::startInteractionActivity);
        getAnimationActivityBtn().setOnClickListener(this::startAnimationActivity);
    }

    private void startDrawActivity(View view) {

    }

    private void startInteractionActivity(View view) {
        InteractionView interactionView = new InteractionView(this);
        setContentView(interactionView);
    }

    private void startAnimationActivity(View view) {
        AnimationView animationView = new AnimationView(this);
        setContentView(animationView);
    }
}
