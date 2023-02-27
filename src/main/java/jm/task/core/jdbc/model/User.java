package jm.task.core.jdbc.model;

import javax.persistence.*;

@Entity //эта аннотация перед классом укажет Hibernate, что это специальный класс, объекты которого нужно хранить в базе данных.
@Table //задает имя таблицы в базе, с которой будет связан данный класс.
        (name = "users")
public class User {
    @Id////Каждая Entity-сущность в Hibernate должна иметь поле, которое будет первичным ключом: содержать уникальное значение для всех объектов данного класса
    @GeneratedValue(strategy = GenerationType.IDENTITY)/* можно присваивать id твоим новым объектам самостоятельно,
    или отдать это на откуп Hibernate. Для того чтобы Hibernate лучше понимал, как присваивать ID твоим объектам, у него есть
    @GeneratedValue. Этой аннотацией обычно помечается то же поле, что и аннотацией @Id. У нее есть 4 возможных стратегии
    присвоения ID: AUTO, IDENTITY, SEQUENCE, TABLE
    */
    @Column (name = "id")//сопоставляет поля данных  источника и связанных с ними полей данных в другом месте назначения.
    //пишется не только у полей, но и методов: у геттеров или сеттеров
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "lastName")
    private String lastName;

    @Column (name = "age")
    private Byte age;

    public User() {

    }

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

}
