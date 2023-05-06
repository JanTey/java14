package ru.netology.quamid59;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepositoryTest {

    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(5, "Product1", 530);
    Product product2 = new Product(9, "Product 2", 7_500);
    Product product3 = new Product(14, "Product 3", 34_800);
    Product product4 = new Product(52, "Product 4", 27_140);
    Product product5 = new Product(99, "Product 5", 1201);

    @BeforeEach
    public void setup() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
    }

    @Test
    public void shouldAddProduct() {
        Product newProduct = new Product(28, "New Product", 47000);
        repo.add(newProduct);

        Product[] expected = {product1, product2, product3, product4, product5, newProduct};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldExceptionRemoveById() {

        Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(26));
    }

    @Test
    public void shouldSaveProduct() {
        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldExceptionSaveProduct() {

        Assertions.assertThrows(AlreadyExistsException.class, () -> repo.save(product5));
    }

}
