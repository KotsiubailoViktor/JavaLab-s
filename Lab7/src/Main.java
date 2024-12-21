import java.util.*;

class Product {
    private String name;
    private double recommendedPrice;

    // Конструктор для ініціалізації продукту
    public Product(String name, double recommendedPrice) {
        this.name = name;
        this.recommendedPrice = recommendedPrice;
    }

    public String getName() {
        return name;
    }

    public double getRecommendedPrice() {
        return recommendedPrice;
    }
}

class Store {
    private String name;
    private List<Product> products;
    private List<Double> prices;

    // Конструктор для ініціалізації магазину
    public Store(String name) {
        this.name = name;
        this.products = new ArrayList<>();
        this.prices = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addProduct(Product product, double price) {
        products.add(product);
        prices.add(price);
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Double> getPrices() {
        return prices;
    }
}

class ProductSearchService {
    private List<Store> stores;

    // Конструктор для створення сервісу пошуку товарів
    public ProductSearchService() {
        this.stores = new ArrayList<>();
    }

    public void addStore(Store store) {
        stores.add(store);
    }

    // Знаходить мінімальну ціну на заданий товар
    public double findMinimumPrice(String productName) {
        double minPrice = Double.MAX_VALUE;
        // Використання типізованого ітератора для проходження списку магазинів
        Iterator<Store> storeIterator = stores.iterator();
        while (storeIterator.hasNext()) {
            Store store = storeIterator.next();
            List<Product> products = store.getProducts();
            List<Double> prices = store.getPrices();
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getName().equals(productName)) {
                    minPrice = Math.min(minPrice, prices.get(i));
                }
            }
        }
        return minPrice == Double.MAX_VALUE ? -1 : minPrice;
    }

    // Знаходить магазини з мінімальною ціною на товар
    public List<String> findStoresWithMinimumPrice(String productName) {
        double minPrice = findMinimumPrice(productName);
        List<String> result = new ArrayList<>();
        // Використання типізованого циклу for-each для проходження списку магазинів
        for (Store store : stores) {
            List<Product> products = store.getProducts();
            List<Double> prices = store.getPrices();
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getName().equals(productName) && prices.get(i) == minPrice) {
                    result.add(store.getName());
                    break;
                }
            }
        }
        return result;
    }

    // Перевіряє, чи є магазин, де всі товари дешевші за рекомендовану ціну, і повертає його назву
    public String findStoreAllProductsCheaperThanRecommended() {
        // Використання нетипізованого ітератора для проходження списку магазинів
        for (Iterator<Store> storeIterator = stores.iterator(); storeIterator.hasNext();) {
            Store store = storeIterator.next();
            boolean allCheaper = true;
            List<Product> products = store.getProducts();
            List<Double> prices = store.getPrices();
            for (int i = 0; i < products.size(); i++) {
                if (prices.get(i) >= products.get(i).getRecommendedPrice()) {
                    allCheaper = false;
                    break;
                }
            }
            if (allCheaper) {
                return store.getName();
            }
        }
        return "Немає магазину, де всі товари дешевші за рекомендовану ціну";
    }
}

public class Main {
    public static void main(String[] args) {
        ProductSearchService service = new ProductSearchService();

        // Створення товарів
        Product product1 = new Product("Ноутбук", 1000);
        Product product2 = new Product("Телефон", 700);
        Product product3 = new Product("Планшет", 500);

        // Створення магазинів та додавання товарів
        Store store1 = new Store("Магазин A");
        store1.addProduct(product1, 950);
        store1.addProduct(product2, 750); // Ціна вища за рекомендовану

        Store store2 = new Store("Магазин B");
        store2.addProduct(product1, 1050); // Ціна вища за рекомендовану
        store2.addProduct(product3, 510); // Ціна вища за рекомендовану

        Store store3 = new Store("Магазин C");
        store3.addProduct(product2, 680); // Ціна нижча за рекомендовану
        store3.addProduct(product3, 490); // Ціна нижча за рекомендовану

        // Додавання магазинів до сервісу пошуку
        service.addStore(store1);
        service.addStore(store2);
        service.addStore(store3);

        // Виведення результатів
        System.out.println("Мінімальна ціна на Ноутбук: " + service.findMinimumPrice("Ноутбук"));
        System.out.println("Магазини з мінімальною ціною на Ноутбук: " + service.findStoresWithMinimumPrice("Ноутбук"));
        System.out.println("Магазин, де всі товари дешевші за рекомендовану ціну: " + service.findStoreAllProductsCheaperThanRecommended());
    }
}
