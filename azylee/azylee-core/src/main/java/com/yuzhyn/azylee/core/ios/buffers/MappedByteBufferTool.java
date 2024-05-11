//package com.yuzhyn.azylee.core.ios.buffers;
//
//import java.lang.reflect.Method;
//import java.nio.MappedByteBuffer;
//import java.security.AccessController;
//import java.security.PrivilegedAction;
//
//public class MappedByteBufferTool {
//
//    /**
//     * 为MappedByteBuffer的map提供释放方法
//     * @param buffer 参数
//     */
//    public static void unmap(final MappedByteBuffer buffer) {
//        if (buffer == null) {
//            return;
//        }
//        AccessController.doPrivileged(new PrivilegedAction<Object>() {
//            @Override
//            public Object run() {
//                try {
//                    Method getCleanerMethod = buffer.getClass().getMethod("cleaner", new Class[0]);
//                    if (getCleanerMethod != null) {
//                        getCleanerMethod.setAccessible(true);
//                        Object cleaner = getCleanerMethod.invoke(buffer, new Object[0]);
//                        Method cleanMethod = cleaner.getClass().getMethod("clean", new Class[0]);
//                        if (cleanMethod != null) {
//                            cleanMethod.invoke(cleaner, new Object[0]);
//                        }
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }
//
//        });
//    }
//}
