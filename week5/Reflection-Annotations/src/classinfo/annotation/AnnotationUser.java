package classinfo.annotation;

@ClassInfo(author="tony",related={String.class, Integer.class})
public class AnnotationUser {
    
    private int value;

    public AnnotationUser(int value) {
        setValue(value);
    }
    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public static void main(String[] args) {
        Class<AnnotationUser> classType = AnnotationUser.class;
        Class<ClassInfo> annotationType = ClassInfo.class;
        
        ClassInfo annotation = (ClassInfo) classType.getAnnotation(annotationType);
        
        System.out.println(annotation.author());
        System.out.println(annotation.revision());
        System.out.println(annotation.checked());
        
        Class<?>[] related = annotation.related();
        for (int i = 0; i < related.length; ++i) {
            System.out.println(related[i].toString());
        }
    }
    
}
