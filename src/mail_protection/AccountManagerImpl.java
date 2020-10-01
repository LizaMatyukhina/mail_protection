package mail_protection;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountManagerImpl implements MailAccountManager{
    AttemptCounter count = AttemptCounter.getInstance();
    Data data = new Data();

    @Override
    public void registerNewAccount(String email, String password, Person person) throws DuplicateAccountException, IOException {
        String[] registerPerson = new String[]{person.toString() + ", " + email + ", " + password};
        for (String line : data.csvReader()){
            if (line.split(", ")[0].equals(person.getName())) {
                throw new DuplicateAccountException("Аккаунт уже существует!");
            }
        }
        data.csvWriter(Arrays.asList(registerPerson), true);
    }

    @Override
    public void removeAccount(String email, String password) throws IOException, WrongCredentialsException {
        List<String> persons = data.csvReader();
        String control = null;

        for (String i:persons) {
            if (i.split(", ")[2].equals(email) && i.split(", ")[3].equals(password)) {
                control = i;
            }
        }

        persons.remove(control);

        data.csvWriter(persons, false);


        if (control == null){
            throw new WrongCredentialsException("Введены неверные данные!");
        }

        System.out.println("Аккаунт " + control.split(", ")[0] + " успешно удален!");
    }

    @Override
    public boolean hasAccount(String email) throws IOException {
        boolean control = false;
        List<String> persons = data.csvReader();
        for (String person : persons){
            if (person.split(", ")[2].equals(email)) {
                control = true;
                break;
            }
        }

        return control;
    }

    @Override
    public Person getPerson(String email, String password) throws TooManyLoginAttemptsException, IOException, WrongCredentialsException {
        Person person = null;
        List<String> persons = data.csvReader();
        for (String account : persons){
            if (account.split(", ")[2].equals(email) && account.split(", ")[3].equals(password)){
                person = new Person(account.split(", ")[0], account.split(", ")[1]);
                count.setCount(0);
            }
        }
        if (person == null){
            throw new WrongCredentialsException("Введены неверные данные! Попытка: " + count.Counter());

        }
        return person;
    }

    @Override
    public int numOfAccounts() throws IOException {
        return data.csvReader().size();
    }

}
