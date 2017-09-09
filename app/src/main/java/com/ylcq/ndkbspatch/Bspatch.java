package com.ylcq.ndkbspatch;

/**
 * http://www.daemonology.net/bsdiff/
 * http://www.bzip.org
 */
public class Bspatch {

    static {
        System.loadLibrary("bspatch");
    }

    public native static void patch(String oldFile, String newFile, String patchFile);
}
