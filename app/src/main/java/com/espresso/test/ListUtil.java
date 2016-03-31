package com.espresso.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyanan on 16/3/30.
 */
public class ListUtil {

    public static List<Book> buildData() {
        List<Book> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Book book = new Book();
            book.setTitle("book title " + i);
            book.setDesc("book desc " + i);
            list.add(book);
        }
        return list;
    }

}
