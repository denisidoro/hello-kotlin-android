package com.github.denisidoro.hellokotlin.helpers;

import android.support.annotation.IdRes;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class EspressoUtils {

    public static void isDisplayed (@IdRes int... ids) {
        for (int id : ids) {
            onView(withId(id)).check(matches(ViewMatchers.isDisplayed()));
        }
    }

    public static void isDisplayed (String... contents) {
        for (String content : contents) {
            try {
                onView(withText(content)).perform(ViewActions.scrollTo()).check(matches(ViewMatchers.isDisplayed()));
            } catch (Exception e) {
                onView(withText(content)).check(matches(ViewMatchers.isDisplayed()));
            }
        }
    }

    public static void clickWithoutScroll (int id) {
        onView(allOf(withId(id))).check(matches(ViewMatchers.isDisplayed())).perform(ViewActions.click());
    }

    public static void longClick (int id) {
        onView(allOf(withId(id))).check(matches(ViewMatchers.isDisplayed())).perform(ViewActions.longClick());
    }

    public static void click (View view) {
        click(view.getId());
    }

    public static void click (int id) {
        try {
            clickWithoutScroll(id);
        } catch (android.support.test.espresso.PerformException e) {
            onView(withId(id)).perform(ViewActions.scrollTo()).check(matches(ViewMatchers.isDisplayed())).perform(ViewActions.click());
        }
    }

    public static void click (String text) {
        try {
            onView(withText(text)).perform(ViewActions.scrollTo()).check(matches(ViewMatchers.isDisplayed())).perform(ViewActions.click());
        } catch (android.support.test.espresso.PerformException e) {
            onView(withText(text)).check(matches(ViewMatchers.isDisplayed())).perform(ViewActions.click());
        }
    }

}