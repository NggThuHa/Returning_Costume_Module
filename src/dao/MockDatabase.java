package dao;

import model.Client;
import model.Costume;
import model.Damage;
import model.DepositItem;
import model.RentedCostume;
import model.RentedDeposit;
import model.RentedReceipt;
import model.ReturnedCostume;
import model.ReturnedReceipt;
import model.Store;
import model.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MockDatabase {
    private static final MockDatabase INSTANCE = new MockDatabase();

    private final List<User> users = new ArrayList<>();
    private final List<Client> clients = new ArrayList<>();
    private final List<Costume> costumes = new ArrayList<>();
    private final List<Damage> damages = new ArrayList<>();
    private final List<RentedReceipt> rentedReceipts = new ArrayList<>();
    private final List<ReturnedReceipt> returnedReceipts = new ArrayList<>();

    private MockDatabase() {
        seed();
    }

    public static MockDatabase getInstance() {
        return INSTANCE;
    }

    private void seed() {
        User cashier = new User(1, "A", "a@123", "Nguyen Van A", "cashier");
        users.add(cashier);

        Client c1 = new Client(123, "Nguyen Van B", "b@gmail.com", "0123456789", "Ha Noi", "");
        Client c2 = new Client(124, "Nguyen Van B", "bv2@gmail.com", "0987654321", "Hai Phong", "");
        clients.add(c1);
        clients.add(c2);

        Store store = new Store(1, "CNPM Store", "Demo store", "Ha Noi", "0249999999");

        Costume cs1 = new Costume(1, "123", "Ao dai cach tan den nu size XL", "Den", "XL", "", 1000, 10, "A1");
        Costume cs2 = new Costume(2, "124", "Ao dai cach tan trang nu size L", "Trang", "L", "", 900, 8, "A2");
        Costume cs3 = new Costume(3, "125", "Ao dai truyen thong do nu size M", "Do", "M", "", 750, 6, "A3");
        cs1.setStore(store);
        cs2.setStore(store);
        cs3.setStore(store);
        store.getCostumes().add(cs1);
        store.getCostumes().add(cs2);
        store.getCostumes().add(cs3);
        costumes.add(cs1);
        costumes.add(cs2);
        costumes.add(cs3);

        Damage defaultDamage = new Damage(1, "Rach", "Vai bi rach", 40000, "");
        damages.add(defaultDamage);

        RentedCostume rc1 = new RentedCostume(1, 10, 2, 0, cs1);
        rc1.setRentedAt(dateOf(2026, Calendar.MARCH, 10));
        RentedCostume rc2 = new RentedCostume(2, 10, 3, 0, cs2);
        rc2.setRentedAt(dateOf(2026, Calendar.MARCH, 11));
        RentedCostume rc3 = new RentedCostume(3, 15, 2, 0, cs3);
        rc3.setRentedAt(dateOf(2026, Calendar.MARCH, 12));

        DepositItem depositItem = new DepositItem(123, "Tien mat", 1000000, "");
        RentedDeposit rd1 = new RentedDeposit(123, 1, false, "", depositItem);

        RentedReceipt receipt = new RentedReceipt();
        receipt.setId(1);
        receipt.setBarcode("RR-123");
        receipt.setRentedAt(dateOf(2026, Calendar.MARCH, 1));
        receipt.setSaleoff(0);
        receipt.setStatus("Dang thue");
        receipt.setClient(c1);
        receipt.setUser(cashier);
        receipt.getListRentedCostume().add(rc1);
        receipt.getListRentedCostume().add(rc2);
        receipt.getListRentedCostume().add(rc3);
        receipt.getListRentedDeposit().add(rd1);
        rentedReceipts.add(receipt);

        Costume returnedBaseCostume = new Costume(4, "123", "Ao dai cach tan den nu size M", "Den", "M", "", 1000, 2, "A1");
        RentedCostume oldRented = new RentedCostume(4, 11428.57f, 2, 0, returnedBaseCostume);
        oldRented.setRentedAt(dateOf(2026, Calendar.MARCH, 1));
        ReturnedCostume returnedCostume = new ReturnedCostume();
        returnedCostume.setId(1);
        returnedCostume.setRentedCostume(oldRented);
        returnedCostume.setQuantity(2);
        returnedCostume.setReturnedAt(dateOf(2026, Calendar.MARCH, 8));

        ReturnedReceipt returnedReceipt = new ReturnedReceipt();
        returnedReceipt.setId(1);
        returnedReceipt.setBarcode("RT-123");
        returnedReceipt.setReturnedAt(dateOf(2026, Calendar.MARCH, 8));
        returnedReceipt.setClient(c1);
        returnedReceipt.setUser(cashier);
        returnedReceipt.getListReturnedCostume().add(returnedCostume);
        returnedReceipt.calculateTotalReceipt(returnedReceipt.getListReturnedCostume());
        returnedReceipts.add(returnedReceipt);
    }

    private Date dateOf(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Costume> getCostumes() {
        return costumes;
    }

    public List<Damage> getDamages() {
        return damages;
    }

    public List<RentedReceipt> getRentedReceipts() {
        return rentedReceipts;
    }

    public List<ReturnedReceipt> getReturnedReceipts() {
        return returnedReceipts;
    }
}

