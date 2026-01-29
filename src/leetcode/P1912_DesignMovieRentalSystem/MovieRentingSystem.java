package leetcode.P1912_DesignMovieRentalSystem;

import java.util.*;

public class MovieRentingSystem {

    // Key: Shop, Movie. Value: Price
    private Map<Integer, Map<Integer, Integer>> shopMoviePrice;

    // Key: Movie. Value: Set of unrented entries (price, shop)
    private Map<Integer, TreeSet<Entry>> unrented;

    // Set of all rented entries (price, shop, movie)
    private TreeSet<RentedEntry> rented;

    public MovieRentingSystem(int n, int[][] entries) {
        shopMoviePrice = new HashMap<>();
        unrented = new HashMap<>();
        rented = new TreeSet<>();

        for (int[] e : entries) {
            int shop = e[0];
            int movie = e[1];
            int price = e[2];

            shopMoviePrice.computeIfAbsent(shop, k -> new HashMap<>()).put(movie, price);
            unrented.computeIfAbsent(movie, k -> new TreeSet<>()).add(new Entry(price, shop));
        }
    }

    public List<Integer> search(int movie) {
        if (!unrented.containsKey(movie))
            return Collections.emptyList();

        List<Integer> result = new ArrayList<>();
        TreeSet<Entry> set = unrented.get(movie);
        int count = 0;
        for (Entry e : set) {
            result.add(e.shop);
            count++;
            if (count == 5)
                break;
        }
        return result;
    }

    public void rent(int shop, int movie) {
        int price = shopMoviePrice.get(shop).get(movie);

        // Remove from unrented
        unrented.get(movie).remove(new Entry(price, shop));

        // Add to rented
        rented.add(new RentedEntry(price, shop, movie));
    }

    public void drop(int shop, int movie) {
        int price = shopMoviePrice.get(shop).get(movie);

        // Remove from rented
        rented.remove(new RentedEntry(price, shop, movie));

        // Add to unrented
        unrented.get(movie).add(new Entry(price, shop));
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;
        for (RentedEntry e : rented) {
            result.add(Arrays.asList(e.shop, e.movie));
            count++;
            if (count == 5)
                break;
        }
        return result;
    }

    // Helper Classes
    static class Entry implements Comparable<Entry> {
        int price;
        int shop;

        Entry(int price, int shop) {
            this.price = price;
            this.shop = shop;
        }

        @Override
        public int compareTo(Entry other) {
            if (this.price != other.price)
                return Integer.compare(this.price, other.price);
            return Integer.compare(this.shop, other.shop);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Entry entry = (Entry) o;
            return price == entry.price && shop == entry.shop;
        }

        @Override
        public int hashCode() {
            return Objects.hash(price, shop);
        }
    }

    static class RentedEntry implements Comparable<RentedEntry> {
        int price;
        int shop;
        int movie;

        RentedEntry(int price, int shop, int movie) {
            this.price = price;
            this.shop = shop;
            this.movie = movie;
        }

        @Override
        public int compareTo(RentedEntry other) {
            if (this.price != other.price)
                return Integer.compare(this.price, other.price);
            if (this.shop != other.shop)
                return Integer.compare(this.shop, other.shop);
            return Integer.compare(this.movie, other.movie);
        }

        @Override
        public boolean equals(Object o) { // Crucial for removal
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            RentedEntry that = (RentedEntry) o;
            return price == that.price && shop == that.shop && movie == that.movie;
        }

        @Override
        public int hashCode() {
            return Objects.hash(price, shop, movie);
        }
    }
}
