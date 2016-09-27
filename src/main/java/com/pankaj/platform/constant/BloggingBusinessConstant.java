package com.pankaj.platform.constant;

import com.pankaj.platform.common.DefaultEntry;

import java.util.function.Supplier;

/**
 * Created by pankajpardasani on 14/09/2016.
 */
public interface BloggingBusinessConstant {
    public static final Supplier<DefaultEntry<String, String>> DOCUMENTMETAINFO = () -> new DefaultEntry<>("documentName", "PankajCV");
    public static final String CANDIDATE_NAME = "Pankaj Pardasani";
}

