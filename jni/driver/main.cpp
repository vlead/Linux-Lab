#include <jni.h>
#include <android/log.h>

#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

#define  LOG_TAG    "LinuxLab"
#define  LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)


static void nativeChangeDir(JNIEnv* env, jclass cls, jstring cmdstr)
{
	const char *cmd= env->GetStringUTFChars(cmdstr, NULL);

	int res = ::chdir(cmd);

	LOGD("chdir %s-- %d\n", cmd, res);
	env->ReleaseStringUTFChars(cmdstr, cmd);
}

JNIEXPORT jint JNICALL
JNI_OnLoad(JavaVM *jvm, void *reserved)
{
	JNIEnv *env = NULL;
	jclass cls = NULL;

	JNINativeMethod methods[1] = {
		{ "nativeChangeDir", "(Ljava/lang/String;)V",  (void *) nativeChangeDir},
	};

	if (jvm->GetEnv((void **)&env, JNI_VERSION_1_2)) {
		return JNI_ERR; /* JNI version not supported */
	}

	cls = env->FindClass("edu/vlabs/vlead/JNIHelper");
	env->RegisterNatives(cls, methods, 1);

	return JNI_VERSION_1_2;
}

