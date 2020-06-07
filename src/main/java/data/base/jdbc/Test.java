package data.base.jdbc;
/**
 * Zad2
 * utwórz w bazie danych tabelę people
 * tabela ma kolumny id, first_name, last_name, age, gender
 * wstaw do tabeli przykładowe dane
 * z aplikacji jawowej:
 * wylistuj wszystkich mężczyzn po 40-ce
 * wylistuj wszystkie kobiety po 16-ce
 * zmień imię osobie o id = 3
 * zmień nazwiska osób o nazwisku 'Kowalski'
 * wylistuj wszystkie osoby (id, imię, nazwisko)
 * Zad3
 * obok tabeli people dodaj tabelę phones
 * telefon ma kolumny: id, number, person_id
 * person_id to klucz obcy relacji
 * każdy telefon musi mieć właściciela
 * dodaj kilka telefonów do bazy danych
 * wylistuj osoby, które mają numer telefonu (razem z numerem)
 * zmień wiek osoby, znając jej numer telefonu
 * usuń osobę, która ma numer telefonu
 * skorzystaj z transakcji, żeby obsłużyć problematyczne sytuacje
 */
public class Test {
    public static void main(String[] args) {
        ConnectDB connection = new ConnectDB();
        connection.startConnection();

//        connection.printPeopleAboveAgeWithGender(50,"M");
//        connection.printPeopleAboveAgeWithGender(16,"F");
//        connection.printPeopleWithId(2);
//        connection.printAll();
//        connection.changeSurname("xxx", "NewJa");
//        connection.changeSurnameOnId(4, "yyyy");
//        connection.printAll();
//        connection.printAllWithPhone();
//        connection.setAgePeopleWithPhoneNumber("123222",13);
        connection.printAllWithPhone();
        connection.deletePersonById(1);
        connection.printAllWithPhone();
        connection.closeConnection();



    }


}
