package human;

import collection.Condition;
import java.util.Comparator;
import java.util.Objects;
import tools.Util;

public class Person implements Comparable<Person> {
    
    private static int nextId;
    private final int id;
    private final Gender sex;
    protected String firstname;
    protected String lastname;

    public Condition<Person> getLastnameMatch() {
        return new Condition<Person>() {
            @Override 
            public boolean isTrue(Person p) { 
                return lastname.equals(p.lastname);
            }
        };
    }
    public Condition<Person> getFirstnameMatch() {
        return p -> firstname.equals(p.firstname); // lambda expression
    }
    
    private static class FirstnameComparator implements Comparator<Person> {
        @Override
        public int compare(Person p0, Person p1) {
            return p0.firstname.compareTo(p1.firstname);
        }
    }
    
    public static final Comparator<Person> FIRSTNAME_COMPARATOR = new FirstnameComparator();
    public static final Comparator<Person> XLASTNAME_COMPARATOR = 
            (p0, p1) -> p0.lastname.compareTo(p1.lastname);
    
    public Person(Gender sex, String firstname, String lastname) {
        this.sex = Objects.requireNonNull(sex, "Person's gender cannot be null.");
        this.firstname = Util.isValid(firstname) ? firstname : Util.BLANK;
        this.lastname = Util.isValid(lastname) ? lastname : Util.BLANK;
        this.id = nextId++;
    }
    @Override
    public String toString() {
        return String.format("%s[id:%d,sex:%s,name:%s,%s]",
                this.getClass().getSimpleName(),id,sex,firstname,lastname);
    }
    @Override
    public boolean equals(Object o) {
        return this == o;
        /*
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final var p = (Person) o;
        return this.id == p.id && this.firstname.equals(p.firstname) && this.lastname.equals(p.lastname);
        */
    }
    
    @Override 
    public int compareTo(Person p) {
        return this.id - p.id;
    }

    public Gender getSex() { return sex; }
}
