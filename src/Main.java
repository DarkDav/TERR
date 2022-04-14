import java.io.*;
import java.util.Arrays;

public class Main {
    public static void serializeAnimalArray(Animal ... animals) {

        try {
            FileOutputStream fos = new FileOutputStream("Animal.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeInt(animals.length);

            for (Animal animal : animals) {
                oos.writeObject(animal);
            }

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Animal[] deserializeAnimalArray(byte[] data) {
        try {
            ByteArrayInputStream input = new ByteArrayInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(input);

            Animal [] animals = new Animal[ois.readInt()];
            for(int i = 0; i<animals.length; i++){
                animals[i] = (Animal) ois.readObject();
            } input.close();
            return animals;

        } catch (NegativeArraySizeException |IOException  |ClassCastException | SecurityException | ClassNotFoundException e){
            throw new IllegalArgumentException(e);
        }

    }
    public static void main(String[] args) {
        byte[] intermediate = null;
        try (
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(output)) {

            oos.writeInt(3);
            oos.writeObject(new Animal("Pig"));
            oos.writeObject(new Animal("Cat"));
            oos.writeObject(new Animal("Mouse"));

            output.flush();
            intermediate = output.toByteArray();

        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(intermediate));
        Animal[] animals = deserializeAnimalArray(intermediate);
        System.out.println(Arrays.toString(animals));

    }
}
