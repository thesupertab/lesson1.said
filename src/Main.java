

class ComplexType {
    private String value;

    public ComplexType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

// Создадим enum для сложного типа поля
enum Color {
    RED, GREEN, BLUE;
}

// Создадим 1-й уровень иерархии
class FirstLevel {
    private String field1;
    private ComplexType complexField;

    public FirstLevel(String field1, ComplexType complexField) {
        this.field1 = field1;
        this.complexField = complexField;
    }

    public String getField1() {
        return field1;
    }

    public ComplexType getComplexField() {
        return complexField;
    }
}

// Создадим 2-й уровень иерархии
class SecondLevel extends FirstLevel {
    private String field2;

    public SecondLevel(String field1, ComplexType complexField, String field2) {
        super(field1, complexField);
        this.field2 = field2;
    }

    public String getField2() {
        return field2;
    }

    public String overloadedMethod(String param1, String param2) {
        return "Overloaded method in SecondLevel with " + param1 + " and " + param2;
    }

    public final String nonOverridableMethod() {
        return "This method cannot be overridden";
    }
}

// Создадим 3-й уровень иерархии (не наследуемый)
class ThirdLevel {
    private String field3;
    private Color color;

    public ThirdLevel(String field1, ComplexType complexField, String field2, String field3, Color color) {
        this.field3 = field3;
        this.color = color;
    }

    public String getField3() {
        return field3;
    }

    public String overriddenMethod() {
        return "This method is overridden in ThirdLevel";
    }
}

public class Main {
    public static void main(String[] args) {
        ComplexType complexObj = new ComplexType("Some value");
        SecondLevel objectA = new SecondLevel("Field1A", complexObj, "Field2A");
        ThirdLevel objectB = new ThirdLevel("Field1B", complexObj, "Field2B", "Field3B", Color.RED);
        ThirdLevel objectC = new ThirdLevel("Field1C", complexObj, "Field2C", "Field3C", Color.GREEN);

        System.out.println("ObjectA:");
        System.out.println(objectA.getField1());
        System.out.println(objectA.getComplexField().getValue());
        System.out.println(objectA.getField2());
        System.out.println(objectA.overloadedMethod("Param1", "Param2"));
        System.out.println(objectA.nonOverridableMethod());

        System.out.println("ObjectB:");
        System.out.println(objectB.getField3());
        System.out.println(objectB.overriddenMethod());

        System.out.println("ObjectC:");
        System.out.println(objectC.getField3());
        System.out.println(objectC.overriddenMethod());
    }
}