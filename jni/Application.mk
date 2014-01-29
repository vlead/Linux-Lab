
APP_ABI := armeabi

ifneq ($(ARCH_ARM_HAVE_VFP),true)
	APP_CFLAGS += -DSK_SOFTWARE_FLOAT
endif

ifeq ($(ARCH_ARM_HAVE_NEON),true)
	APP_CFLAGS += -D__ARM_HAVE_NEON
	APP_ABI += armeabi-v7a
endif

#NDK_TOOLCHAIN_VERSION=clang3.1

