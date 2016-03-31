package com.espresso.test;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.AdapterView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.espresso.test.CustomMatcher.withBookTitle;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by liyanan on 16/3/31.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ViewPagerActivityTest {
    private static final String BOOK_TITLE_6 = "book title 6";
    private static final String BOOK_DESC_6 = "book desc 6";
    @Rule
    public ActivityTestRule<ViewPagerTestActivity> mActivityRule = new ActivityTestRule<>(ViewPagerTestActivity.class);

    @Test
    public void test_title() {
        onData(withBookTitle(BOOK_TITLE_6)).inAdapterView(allOf(withId(R.id.lv_data), isDisplayed())).perform(click());
        onView(withId(R.id.tv_click_item)).check(matches(withText("tab 0 " + BOOK_TITLE_6)));
    }

    @Test
    public void test_desc() {
        onData(withBookTitle(BOOK_TITLE_6)).inAdapterView(allOf(isAssignableFrom(AdapterView.class), isDisplayed()))
                .onChildView(withId(R.id.btn_click))
                .perform(click());
        onView(withId(R.id.tv_click_item)).check(matches(withText("tab 0 " + BOOK_DESC_6)));
    }

    @Test
    public void test_left1() {
        onView(withId(R.id.pager)).perform(swipeLeft());

    }

    @Test
    public void test_left2() {
        onView(withId(R.id.pager)).perform(swipeLeft());
        onView(withId(R.id.pager)).perform(swipeLeft());
    }
}
