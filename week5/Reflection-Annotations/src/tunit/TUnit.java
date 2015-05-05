package tunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TUnit {
    
    public static void runTUnit(Class<?> testClass) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException {
        Method[] methods = testClass.getMethods();
        
        List<Method> testCaseMethods = new ArrayList<>();
        List<Method> beforeMethods = new ArrayList<>();
        List<Method> afterMethods = new ArrayList<>();
        
        for (Method method : methods) {
            if (null != method.getAnnotation(TestCase.class)) {
                testCaseMethods.add(method);
            } else if (null != method.getAnnotation(Before.class)) {
                beforeMethods.add(method);
            } else if (null != method.getAnnotation(After.class)) {
                afterMethods.add(method);
            }
        }
        
        Object testClassInstance = testClass.getConstructor().newInstance();
        
        for (Method method : beforeMethods) {
            method.invoke(testClassInstance);
        }
        
        for (Method method : testCaseMethods) {
            method.invoke(testClassInstance);
        }
        
        for (Method method : afterMethods) {
            method.invoke(testClassInstance);
        }
    }
    
    public static void main(String[] args) {
        try {
            TUnit.runTUnit(test.TestUser.class);
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
}
