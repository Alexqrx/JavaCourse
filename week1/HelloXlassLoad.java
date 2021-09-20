package com.tgt.common.week01;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloXlassLoad extends ClassLoader{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 相关参数
        final String className = "Hello";
        final String methodName = "hello";
        // 创建类加载器
        ClassLoader classLoader = new HelloXlassLoad();
        // 加载类
        Class<?> clas = classLoader.loadClass(className);
        // 获取类对象
        Object instance = clas.getConstructor().newInstance();
        // 调用实例方法
        Method method = clas.getMethod(methodName);
        method.invoke(instance);
    }
    //重写ClassLoader的findClass方法，通过提供的Hello.xlass获取Hello.class
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Closeable res=null;
        String resourcePath = name.replace(".", "/");
        // 文件后缀名
        String suffix = ".xlass";
        String filepath=resourcePath+suffix;
        // 获取输入流
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filepath);
        try {
            // 读取数据
            int length = inputStream.available();
            System.out.println("文件内容长度："+length);
            byte[] byteArray = new byte[length];
            inputStream.read(byteArray);
            // 转换
            byte[] bytes = decode(byteArray);
            // 将Hello.class返回
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name, e);
        } finally {
            if (null != res) {
                try {
                    res.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // 将.xlass转成.class
    private static byte[] decode(byte[] bytes) {
        byte[] desbyte = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            desbyte[i] = (byte) (255 - bytes[i]);
        }
        return desbyte;
    }
}
