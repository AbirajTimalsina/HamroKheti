package com.example.hamrokheti;

import android.os.SystemClock;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class WeatherTest {
    @Rule
    public ActivityScenarioRule<MordernDashboardActivity> activityRule =
            new ActivityScenarioRule(MordernDashboardActivity.class);

    @Test
    public void weathertest() {
        onView(withId(R.id.imgWheather)).perform(click());
        onView(withId(R.id.etSearch))
                .perform(typeText("kathmandu"))
                .perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.imgSearch)).perform(click());
        SystemClock.sleep(2000);
    }
}
