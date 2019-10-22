package Domain;

import java.io.Serializable;

public class Client extends BaseEntity<Long> implements Serializable {
    private String name;
    private int age;
    private float pocketMoney;
    private String profession;

    public Client(String name, int age, float pocketMoney, String profession) {
        this.name = name;
        this.age = age;
        this.pocketMoney = pocketMoney;
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getPocketMoney() {
        return pocketMoney;
    }

    public void setPocketMoney(float pocketMoney) {
        this.pocketMoney = pocketMoney;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + this.getId() + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", pocketMoney=" + pocketMoney +
                ", profession='" + profession + '\'' +
                '}';
    }
}
