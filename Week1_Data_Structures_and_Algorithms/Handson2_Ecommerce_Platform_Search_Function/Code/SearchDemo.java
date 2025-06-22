import java.util.*;
public class SearchDemo {

    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products)
            if (p.productName.equalsIgnoreCase(name))
                return p;
        return null;
    }

    public static Product binarySearch(Product[] products, String name) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);
            if (cmp == 0) return products[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product[] products = {
            new Product(101, "iPhone", "Electronics"),
            new Product(102, "T-Shirt", "Fashion"),
            new Product(103, "Galaxy", "Electronics"),
            new Product(104, "Shoes", "Footwear"),
            new Product(105, "Watch", "Accessories")
        };

        System.out.print("Enter product name to search: ");
        String input = sc.nextLine();

        Product foundLinear = linearSearch(products, input);
        System.out.println("Linear Search result: " + (foundLinear != null ? foundLinear : "Product not found"));

        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
        Product foundBinary = binarySearch(products, input);
        System.out.println("Binary Search result: " + (foundBinary != null ? foundBinary : "Product not found"));

        sc.close();
    }
}