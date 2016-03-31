package com.espresso.test;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;


/**
 * 测试的基本原则:
 * 1 找到某个view
 * 2 执行某个动作
 * 3 检查执行的结果
 * Created by liyanan on 16/3/29.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class BasicActivityTest {
    public final static String CONTENT = "content";
    @Rule
    public ActivityTestRule<BasicTestActivity> mActivityRule = new ActivityTestRule<>(BasicTestActivity.class);

    @Test
    public void test_hint() {
        onView(withId(R.id.et_content)).check(matches(withHint(R.string.app_name)));
    }

    @Test
    public void test_error() {
        //点击button
        onView(withId(R.id.btn_complete)).perform(click());
        //显示error
        onView(withId(R.id.tv_error)).check(matches(isDisplayed()));
        //content处于隐藏
        onView(withId(R.id.tv_content)).check(matches(not(isDisplayed())));
    }

    @Test
    public void test_basic() {
        //给EditText输入文字,并关闭键盘
        onView(withId(R.id.et_content)).perform(typeText(CONTENT), closeSoftKeyboard());
        //点击button
        onView(withId(R.id.btn_complete)).perform(click());
        //显示content
        onView(withId(R.id.tv_content)).check(matches(isDisplayed()));
        //检测文字是否匹配
        onView(withId(R.id.tv_content)).check(matches(withText(CONTENT)));
        //error不显示
        onView(withId(R.id.tv_error)).check(matches(not(isDisplayed())));
    }
}
