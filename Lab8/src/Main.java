import java.util.*;

// Клас Product представляє продукт із назвою та рекомендованою ціною
class Product {
    private String name;
    private double recommendedPrice;

    // Конструктор для ініціалізації продукту
    public Product(String name, double recommendedPrice) {
        this.name = name;
        this.recommendedPrice = recommendedPrice;
    }

    // Повертає назву продукту
    public String getName() {
        return name;
    }

    // Повертає рекомендовану ціну продукту
    public double getRecommendedPrice() {
        return recommendedPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.recommendedPrice, recommendedPrice) == 0 &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, recommendedPrice);
    }
}

// Клас Store представляє магазин з набором продуктів та їх цінами
class Store {
    private String name;
    private Set<Product> products; // Набір продуктів у магазині
    private Map<Product, Double> productPrices; // Карта продуктів і цін

    // Конструктор для ініціалізації магазину
    public Store(String name) {
        this.name = name;
        this.products = new HashSet<>();
        this.productPrices = new HashMap<>();
    }

    // Повертає назву магазину
    public String getName() {
        return name;
    }

    // Додає продукт до магазину з його ціною
    public void addProduct(Product product, double price) {
        products.add(product);
        productPrices.put(product, price);
    }

    // Повертає набір продуктів у магазині
    public Set<Product> getProducts() {
        return products;
    }

    // Повертає карту продуктів і їхніх цін
    public Map<Product, Double> getProductPrices() {
        return productPrices;
    }
}

// Клас ProductSearchService реалізує логіку пошуку продуктів у магазинах
class ProductSearchService {
    private Set<Store> stores; // Набір магазинів

    // Конструктор для створення сервісу пошуку
    public ProductSearchService() {
        this.stores = new HashSet<>();
    }

    // Додає магазин до сервісу пошуку
    public void addStore(Store store) {
        stores.add(store);
    }

    // Знаходить мінімальну ціну на заданий товар
    public double findMinimumPrice(String productName) {
        double minPrice = Double.MAX_VALUE;
        for (Store store : stores) {
            for (Map.Entry<Product, Double> entry : store.getProductPrices().entrySet()) {
                if (entry.getKey().getName().equals(productName)) {
                    minPrice = Math.min(minPrice, entry.getValue());
                }
            }
        }
        return minPrice == Double.MAX_VALUE ? -1 : minPrice;
    }

    // Знаходить магазини з мінімальною ціною на товар
    public List<String> findStoresWithMinimumPrice(String productName) {
        double minPrice = findMinimumPrice(productName);
        List<String> result = new ArrayList<>();
        for (Store store : stores) {
            for (Map.Entry<Product, Double> entry : store.getProductPrices().entrySet()) {
                if (entry.getKey().getName().equals(productName) && entry.getValue() == minPrice) {
                    result.add(store.getName());
                    break;
                }
            }
        }
        return result;
    }

    // Знаходить магазин, де всі товари дешевші за рекомендовану ціну
    public String findStoreAllProductsCheaperThanRecommended() {
        for (Store store : stores) {
            boolean allCheaper = true;
            for (Map.Entry<Product, Double> entry : store.getProductPrices().entrySet()) {
                if (entry.getValue() >= entry.getKey().getRecommendedPrice()) {
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

// Головний клас для запуску програми
public class Main {
    public static void main(String[] args) {
        ProductSearchService service = new ProductSearchService();

        // Створення продуктів
        Product product1 = new Product("Ноутбук", 1000);
        Product product2 = new Product("Телефон", 700);
        Product product3 = new Product("Планшет", 500);

        // Створення магазинів і додавання продуктів
        Store store1 = new Store("Магазин A");
        store1.addProduct(product1, 950);
        store1.addProduct(product2, 750);

        Store store2 = new Store("Магазин B");
        store2.addProduct(product1, 1050);
        store2.addProduct(product3, 510);

        Store store3 = new Store("Магазин C");
        store3.addProduct(product2, 680);
        store3.addProduct(product3, 490);

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
