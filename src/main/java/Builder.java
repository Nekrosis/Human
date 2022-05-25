public class Builder {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Helena")
                .setSurname("Fox")
                .setAge(32)
                .setAddress("New York,Hansel street 24")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Max")
                .build();
        System.out.println(mom + " have a son " + son);
        Person dad = new PersonBuilder()
                .setName("Bill")
                .setSurname("Fox")
                .setAge(33)
                .setAddress("New York,Hansel street 24")
                .build();
        System.out.println(dad);
        System.out.println("До изменения адреса -> " + mom.hasAddress());
        mom.setAddress("California");
        System.out.println(mom);
        System.out.println("Изменение адреса -> " + mom.hasAddress());
        System.out.println("До др -> " + mom.hasAge());
        mom.happyBirthday();
        System.out.println(mom);
        System.out.println("После др -> " + mom.hasAge());
        try {
            new PersonBuilder().
                    setName(null).
                    setSurname(null).
                    setAddress(null).
                    build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        try {
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
