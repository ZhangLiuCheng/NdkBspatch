# Android studio使用jni
android.useDeprecatedNdk=true  这样jni里面才有自动提示功能

sourceSets {
        main {
            jniLibs.srcDir 'src/main/libs'
            jni.srcDirs = []
        }
    }

linux编译bsdiff生产so文件
gcc -fPIC -shared bsdiff/bsdiff.c bzip2/bzlib.c bzip2/decompress.c bzip2/randtable.c bzip2/huffman.c bzip2/compress.c bzip2/unzcrash.c bzip2/crctable.c -o bsdiff.so


apk安装路径在 ／data/app/base.apk