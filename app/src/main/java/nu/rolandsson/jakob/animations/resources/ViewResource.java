package nu.rolandsson.jakob.animations.resources;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import nu.rolandsson.jakob.animations.R;

/**
 * Created by Martin on 2018-04-08.
 */

public enum ViewResource {
    BTN_DRAW_ACTIVITY {
        @Override
        protected int fetchViewId() {
            return R.id.btn_simple_draw_activity;
        }
    }, BTN_INTERACTION_ACTIVITY {
        @Override
        protected int fetchViewId() {
            return R.id.btn_interaction_activity;
        }
    }, BTN_ANIMATION_ACTIVITY {
        @Override
        protected int fetchViewId() {
            return R.id.btn_animation_activity;
        }
    };

    /*  public static final int BTN_DRAW_ACTIVITY = R.id.btn_simple_draw_activity;
    public static final int BTN_INTERACTION_ACTIVITY = R.id.btn_interaction_activity;
    public static final int BTN_ANIMATION_ACTIVITY = R.id.btn_animation_activity;
*/

    protected abstract int fetchViewId();

    public static void setViews(Activity activity, Class clazz) {
        Log.v("ViewResource", "setting views");
        for(Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Log.v("ViewResource", field.getName());
            if(field.isAnnotationPresent(ViewId.class)) {
                ViewId viewId = field.getAnnotation(ViewId.class);
                Log.v("ViewResource", viewId.value().name());
                try {
                    field.set(activity, find(activity, viewId.value()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static <T extends View> T find(Activity activity, ViewResource viewResource) {
        return activity.findViewById(viewResource.fetchViewId());
    }
}
