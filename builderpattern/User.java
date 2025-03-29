package designpatterns.builderpattern;

public class User {

    private final int id;
    private final String name;
    private final String phoneNumber; // optional
    private final int age; // optional


    private User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.age = builder.age;
    }

    public static class Builder {
        private final int id;
        private final String name;
        private String phoneNumber; // optional
        private int age; // optional

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
            this.phoneNumber = "";
            this.age = 0;
        }

        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder age(int age) {
            if (age < 0)
                throw new IllegalArgumentException("Age must not be -ve");
            this.age = age;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }

}

// Rememeber these questions for this pattern
// - Why we did not solve it by using setters in the User class itself? - Because it will make variables we are setting using setters as non-final and in multi-threaded environments it is important to maintain immutability.
// - Why we declare the inner class as static? So that we can call it by User class itself and not have to make object. 
// - Why this pattern is needed? As there are many arguments and some optional arguments so there will be too many permutations of constructors which will not be sustainable.
// - Why are we using setter in inner class when it is a problem in outer class? - we are compromising the immutability of this secondary insider class instead of our primary class as this is a transient class.


