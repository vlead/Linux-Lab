LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_ARM_MODE := arm

LOCAL_SRC_FILES:= \
    main.cpp \
    

#LOCAL_CPPFLAGS += -DHAVE_OT -DHAVE_UCDN -DHB_NO_MT

LOCAL_LDLIBS += -llog

LOCAL_C_INCLUDES += \
	$(LOCAL_PATH)/../include \
#	$(LOCAL_PATH)/../harfbuzz/src \


#LOCAL_C_INCLUDES += \
#	$(LOCAL_PATH)/../freetype2/include \
#	$(LOCAL_PATH)/../harfbuzz/src \

#
# DO NOT swap the order of the libraries mentioned below.
# most dependent must appear first!  
#
#LOCAL_STATIC_LIBRARIES := libharfbuzz libft2

LOCAL_MODULE:= libLinuxLab

include $(BUILD_SHARED_LIBRARY)
