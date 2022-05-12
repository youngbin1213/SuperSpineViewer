package com.SoarCraft.SuperSpineViewer;

import java.io.InputStream;
import java.net.URL;

public class ResourcesLoader {
    public static URL LoadURL(String path) {
        return ResourcesLoader.class.getResource(path);
    }

    public static String Load(String path) {
        return LoadURL(path).toString();
    }

    public static InputStream LoadStream(String name) {
        return ResourcesLoader.class.getResourceAsStream(name);
    }
}
