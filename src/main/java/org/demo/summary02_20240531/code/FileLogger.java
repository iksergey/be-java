package org.demo.summary02_20240531.code;


public class FileLogger implements Logger {
    public void information(String msg) {
        System.out.println(" записали в файл log.txt " + msg);
    }
}
