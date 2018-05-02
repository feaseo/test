#include <stdio.h>
#include <stdlib.h>
#include <jni.h>

jstring Java_chen_junyu_mytest_util_TestJni_getStr(JNIEnv* env,jobject jobj) {
    char* text = "可以上传到gitHub的JNI测试Demo";
    return  (*env)->NewStringUTF(env,text);
}

