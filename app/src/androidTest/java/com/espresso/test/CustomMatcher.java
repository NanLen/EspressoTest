package com.espresso.test;

import android.support.test.espresso.matcher.BoundedMatcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

/**
 * Created by liyanan on 16/3/30.
 */
public class CustomMatcher {

    public static Matcher<Object> withBookTitle(final String title) {
        return new BoundedMatcher<Object, Book>(Book.class) {
            @Override
            protected boolean matchesSafely(Book item) {
                return title.equals(item.getTitle());
            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }

    public static Matcher<Object> withBookDesc(final String desc) {
        return new BoundedMatcher<Object, Book>(Book.class) {
            @Override
            protected boolean matchesSafely(Book item) {
                return desc.equals(item.getDesc());
            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }

}
