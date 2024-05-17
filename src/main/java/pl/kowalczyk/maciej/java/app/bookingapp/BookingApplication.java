package pl.kowalczyk.maciej.java.app.bookingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookingApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookingApplication.class, args);
    }
}

// TODO: 28.03.2024 Dokończyć implementację brancha dao-refactor-interface (commit-push=pull request)
// TODO: 28.03.2024 Będąc na branchu adding-service-layer zrobić ręczny merge z branchem main
// TODO: 28.03.2024 Dokończyć implementację serviców

// TODO: 02.04.2024 https://bootsnipp.com/snippets/PEZZ7 - kalendarz

// TODO: 19.04.2024 Stworzyć widok z listą rezerwacji, który bedzie zawierał link do rental,
//  zamaiana reservation na rental poprzez akceptacje rezerwacj, bądz odrzucenie reserwacji
// Dodać status dla rezerwacji

// TODO: 23.04.2024 Dodać link do "zmiany statusu rezerwacji" NEW -> CANCELED
// TODO: 23.04.2024 Zamiana rezerwacji na rental

// TODO: 26.04.2024 Dokończyć test integracyjny
// TODO: 26.04.2024 Stworzyć widok z listą rentals i zaimplementować niezbędne warstwy

// TODO: 04.05.2024 Dodać obsługę użytkownika i role (UserDetailService) i skonfigurować w WebSecurityConfig
// TODO: 04.05.2024 Sprawdzić i poprawić 2 niedziałające testy z rental, createFromReservation() i read()

// TODO: 10.05.2024 Użyć navbar z booststrap w postaci fragmentu thymeleaf (navbar dostępny na górze każdej strony) https://getbootstrap.com/docs/5.3/components/navbar/#how-it-works https://www.thymeleaf.org/doc/articles/springsecurity.html
// TODO: 10.05.2024 Dodać ekran umożliwiający dodawanie użytkownika (sing in screen)
// TODO: 10.05.2024 Napisać test dla user repository - z pobieraniem i bez pobierania ról