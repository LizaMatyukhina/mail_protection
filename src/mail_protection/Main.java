package mail_protection;


import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        AccountManagerImpl manager = new AccountManagerImpl();

        Person masha = new Person("Masha", "01.02.1998");
        Person ivan = new Person("Ivan", "01.02.1990");
        Person kolya = new Person("Kolya", "01.02.1899");
        Person sveta = new Person("Sveta", "01.02.1997");
        Person misha = new Person("Misha", "01.02.1997");
        Person vadim = new Person("Vadim", "01.02.1997");
        Person nata = new Person("Nata", "01.02.1997");


        try {
            manager.registerNewAccount("Masha@gmail.com", "password", masha);
            manager.registerNewAccount("Ivan@gmail.com", "1234", ivan);
            manager.registerNewAccount("Kolya@gmail.com", "2345", kolya);
            manager.registerNewAccount("Sveta@gmail.com", "2345678", sveta);
            manager.registerNewAccount("Misha@gmail.com", "password", misha);
            manager.registerNewAccount("Vadim@gmail.com", "password", vadim);
            manager.registerNewAccount("Nata@gmail.com", "password", nata);


        } catch (DuplicateAccountException | IOException e) {
            System.out.println(e.getMessage());
        }


        try {
            manager.removeAccount("Ivan@gmail.com", "1234");
            manager.removeAccount("Kolya@gmail.com", "2345");

            manager.removeAccount("Olya@gmail.com", "2345");
        } catch (WrongCredentialsException | IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Аккаунт существует/не существует (true/false): " + manager.hasAccount("Olya"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Всего аккаунтов: " + manager.numOfAccounts());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(manager.getPerson("Li", "12"));
        } catch (WrongCredentialsException | TooManyLoginAttemptsException | IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(manager.getPerson("Za", "23"));
        } catch (WrongCredentialsException | TooManyLoginAttemptsException | IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(manager.getPerson("Ma", "123"));
        } catch (WrongCredentialsException | TooManyLoginAttemptsException | IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(manager.getPerson("Misha@gmail.com", "password"));
        } catch (WrongCredentialsException | TooManyLoginAttemptsException | IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(manager.getPerson("Mash", "232"));
        }catch (WrongCredentialsException | TooManyLoginAttemptsException | IOException e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(manager.getPerson("Mash", "232"));
        }catch (WrongCredentialsException | TooManyLoginAttemptsException | IOException e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(manager.getPerson("Mash", "232"));
        }catch (WrongCredentialsException | TooManyLoginAttemptsException | IOException e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(manager.getPerson("Mash", "232"));
        }catch (WrongCredentialsException | TooManyLoginAttemptsException | IOException e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(manager.getPerson("Mash", "232"));
        }catch (WrongCredentialsException | TooManyLoginAttemptsException | IOException e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(manager.getPerson("Mash", "232"));
        }catch (WrongCredentialsException | TooManyLoginAttemptsException | IOException e){
            System.out.println(e.getMessage());
        }

    }
}

