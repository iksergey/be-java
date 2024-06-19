package org.demo.seminar09_20240619.JavaException;

import java.io.FileNotFoundException;

public class Program {
    public static void main(String[] args) throws Exception {
        try {
            foo();
        } catch (MyException e) {
            System.out.println("Что-то пошло не так 1");
        } catch (FileNotFoundException e) {
            System.out.println("Что-то пошло не так 2");
        } catch (MyRuntimeException e) {
            System.out.println("Что-то пошло не так 3");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так 1");
        } finally {
            System.out.println("+++");
        }
    }

    public static void foo() throws FileNotFoundException, MyRuntimeException, MyException {
        bar();
        throw new MyRuntimeException("my msg exp"); //
    }

    public static void bar() throws MyException {
        doo();
        throw new ArithmeticException("my msg exp");
    }

    public static void doo() throws MyException {
        throw new MyException("my msg exp");
    }
}

class MyException extends Exception {
    public MyException(String msg) {
        super(msg);
    }
}

class MyRuntimeException extends RuntimeException {
    public MyRuntimeException(String msg) {
        super(msg);
    }
}
