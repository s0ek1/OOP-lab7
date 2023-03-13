package io;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import processor.*;
import java.io.*;
import java.util.*;
public class IOProcessor implements IO {
    @Override
    public void writeToTXT(ProductsList products, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(products.getProducts());
            System.out.println("File write success!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Product> readFromTXT(String fileName) {


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            System.out.println("File read success!");
            return (List<Product>) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void writeToJson(ProductsList products, String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            List<Product> product = products.getProducts();
            objectMapper.writeValue(new File(fileName), product);
            System.out.println("File write success!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Product> readFromJson(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.findAndRegisterModules();
        try {
            System.out.println("File read success!");
            return objectMapper.readValue(new File(fileName), new TypeReference<List<Product>>(){});
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        } catch (IOException e) {
            System.out.println("File Read ERROR!");
        }
        return null;
    }
}