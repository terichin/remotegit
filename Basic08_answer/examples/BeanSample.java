import java.io.Serializable;

class BeanSample implements Serializable {
    private String name;
    private int age;
    
    public BeanSample() {
        // �R���X�g���N�^
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}