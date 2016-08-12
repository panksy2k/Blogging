package com.pankaj.platform.dto;


import com.pankaj.platform.domain.Blog;

/**
 * Created by pankajpardasani on 17/07/2016.
 */
public class APIOptions {

    private final Blog blogEntry;

    private APIOptions(APIOptionsBuilder builder) {
        blogEntry = builder.blog;
    }

    public Blog getBlogEntry() {
        return blogEntry;
    }

    public static class APIOptionsBuilder {
        private Blog blog;

        public APIOptionsBuilder() {

        }

        public APIOptionsBuilder withBlogEntry(Blog blogEntry) {
            this.blog = blogEntry;
            return this;
        }
    }
}
