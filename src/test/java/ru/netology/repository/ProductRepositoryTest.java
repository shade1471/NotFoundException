package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.SmartPhone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    Book bookOne = new Book(1, "Ведьмак: Последнее желание", 420, "Сапковский А.");
    Book bookTwo = new Book(2, "Гиперион", 420, "Симмонс Д.");
    SmartPhone smartPhoneOne = new SmartPhone(3, "Mi 9T Pro", 26000, "Xiaomi");
    SmartPhone smartPhoneTwo = new SmartPhone(4, "Mi 11T Pro", 32500, "Xiaomi");

    @Test
    void shouldRemoveById() {
        repository.save(bookOne);
        repository.save(bookTwo);
        repository.save(smartPhoneOne);
        repository.save(smartPhoneTwo);
        repository.removeById(4);

        Product[] expected = {bookOne, bookTwo, smartPhoneOne};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdIfNotExistAndCatchException() {
        repository.save(bookOne);
        repository.save(bookTwo);
        repository.save(smartPhoneOne);
        repository.save(smartPhoneTwo);


        assertThrows(NotFoundException.class, () -> { repository.removeById(5); });
    }

    @Test
    void shouldFindById() {
        repository.save(bookOne);
        repository.save(bookTwo);
        repository.save(smartPhoneOne);
        repository.save(smartPhoneTwo);

        Product[] actual = repository.findById(1);
        Product[] expected = {bookOne};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByIdIfNotExist() {
        repository.save(bookOne);
        repository.save(bookTwo);
        repository.save(smartPhoneOne);
        repository.save(smartPhoneTwo);

        Product[] actual = repository.findById(5);

        assertArrayEquals(null, actual);
    }
}