package student;

import java.io.Serializable;

public class Student implements  Serializable {
    public static Long INDEX = Long.valueOf(0);

    private int id;

    private String name;

    private int age;

    private String address;

    private float gpaMaths;
    private float gpaPhysics;
    private float gpaChemistry;

    private float gpa;

    private String rank;

    public Student() {
    }

    public Student( String name, int age, String address,float gpaMaths,float gpaPhysics,float gpaChemistry) {
        this.id = Integer.parseInt(String.valueOf(++INDEX));
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpaMaths = gpaMaths;
        this.gpaPhysics = gpaPhysics;
        this.gpaChemistry =gpaChemistry;
        setupGPA();
        setupRank();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getGpaMaths() {
        return gpaMaths;
    }

    public void setGpaMaths(float gpaMaths) {
        this.gpaMaths = gpaMaths;
    }

    public float getGpaPhysics() {
        return gpaPhysics;
    }

    public void setGpaPhysics(float gpaPhysics) {
        this.gpaPhysics = gpaPhysics;
    }

    public float getGpaChemistry() {
        return gpaChemistry;
    }

    public void setGpaChemistry(float gpaChemistry) {
        this.gpaChemistry = gpaChemistry;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setupGPA(){
        gpa = (getGpaMaths() + getGpaPhysics() + getGpaChemistry()) /3;
    }

    public void setupRank() {
        //tinh rank va return rank
        if (getGpa() > 8.5) {
            setRank("Excellent");
        } else if (getGpa() > 7.0) {
            setRank("Good");
        } else if (getGpa() > 5.5) {
            setRank("Fairly good");
        } else if (getGpa() > 4.0) {
            setRank("Average");
        } else {
            setRank("Weak");
        }

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gpaMaths=" + gpaMaths +
                ", gpaPhysics=" + gpaPhysics +
                ", gpaChemistry=" + gpaChemistry +
                ", gpa=" + gpa +
                ", rank='" + rank + '\'' +
                '}';
    }
}
