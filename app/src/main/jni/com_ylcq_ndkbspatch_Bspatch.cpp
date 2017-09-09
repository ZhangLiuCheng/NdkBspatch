//
// Created by zhangliucheng on 2017/9/9.
//
#include "com_ylcq_ndkbspatch_Bspatch.h"
#include "bspatch.h"
#include <jni.h>
#include <stddef.h>


JNIEXPORT void JNICALL Java_com_ylcq_ndkbspatch_Bspatch_patch
        (JNIEnv *env, jclass type, jstring oldFile_, jstring newFile_, jstring patchFile_) {

    const char *oldFile = env->GetStringUTFChars(oldFile_, NULL);
    const char *newFile = env->GetStringUTFChars(newFile_, NULL);
    const char *patchFile = env->GetStringUTFChars(patchFile_, NULL);

    int argc = 4;
    char *argv[4];

    argv[0] = (char *)"bspatch";
    argv[1] = const_cast<char *>(oldFile);
    argv[2] = const_cast<char *>(newFile);
    argv[3] = const_cast<char *>(patchFile);

    bspatch_main(4, argv);
    env->ReleaseStringUTFChars(oldFile_, oldFile);
    env->ReleaseStringUTFChars(newFile_, newFile);
    env->ReleaseStringUTFChars(patchFile_, patchFile);
}