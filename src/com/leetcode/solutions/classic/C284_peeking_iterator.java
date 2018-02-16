package com.leetcode.solutions.classic;

import java.util.Iterator;

public class C284_peeking_iterator {
    class PeekingIterator implements Iterator<Integer> {

        private Integer cache = null;

        private final Iterator<Integer> iterator;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            if (iterator.hasNext())
                cache = iterator.next();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
//         if (!hasNext())
//             throw new RuntimeException("mistake");

//         if (cache == null)
//             cache = iterator.next();

            return cache;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
//         if (!hasNext())
//             throw new RuntimeException("mistake");

// 	    if (cache != null) {
//             Integer temp = cache;
//             if (iterator.hasNext())
//                 cache = iterator.next();

//             return temp;
//         } else {
//             cache = iterator.next();
//             return cache;
//         }

            Integer temp = cache;
            cache = iterator.hasNext() ? iterator.next() : null;
            return temp;
        }

        @Override
        public boolean hasNext() {
            // return cache != null || iterator.hasNext();
            return cache != null;
        }
    }
}
