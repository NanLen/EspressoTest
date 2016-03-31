package com.espresso.test;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.espresso.test.CustomMatcher.withBookDesc;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static com.espresso.test.CustomMatcher.withBookTitle;


/**
 * Created by liyanan on 16/3/30.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ListActivityTest {
    private static final String BOOK_TITLE_6 = "book title 6";
    private static final String BOOK_DESC_6 = "book desc 6";
    @Rule
    public ActivityTestRule<ListTestActivity> mActivityRule = new ActivityTestRule<>(ListTestActivity.class);

    /**
     * 通过position查找item并点击
     */
    @Test
    public void testClickByPosition() {
        onData(anything()).atPosition(6).perform(click());
        onView(withId(R.id.tv_click_item)).check(matches(withText(BOOK_TITLE_6)));
    }

    /**
     * 通过title查找item并点击
     */
    @Test
    public void testClickWithTitle() {
        onData(allOf(is(instanceOf(Book.class)), withBookTitle(BOOK_TITLE_6))).perform(click());
        onView(withId(R.id.tv_click_item)).check(matches(withText(BOOK_TITLE_6)));
    }

    /**
     * 通过desc查找item并点击
     */
    @Test
    public void testClickWithDesc() {
        onData(allOf(is(instanceOf(Book.class)), withBookDesc(BOOK_DESC_6))).perform(click());
        onView(withId(R.id.tv_click_item)).check(matches(withText(BOOK_TITLE_6)));
    }

    /**
     * 找到item点击子view
     */
    @Test
    public void textItemButtonClick() {
        onData(allOf(is(instanceOf(Book.class)), withBookDesc(BOOK_DESC_6))).onChildView(withId(R.id.btn_click)).perform(click());
        onView(withId(R.id.tv_click_item)).check(matches(withText(BOOK_DESC_6)));
    }
}
