import java.util.LinkedHashMap;
import java.util.Map;

public class RecentlyPlayedStore {
    private int capacity;
    private Map<String, String> store;

    public RecentlyPlayedStore(int capacity) {
        this.capacity = capacity;
        this.store = new LinkedHashMap<String,String>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > RecentlyPlayedStore.this.capacity;
            }
        };
    }

    public void playSong(String user, String song) {
        store.put(user, song);
    }

    public void printRecentlyPlayed(String user) {
        String[] songs = store.values().toArray(new String[0]);
        for (int i = songs.length - 1; i >= 0; i--) {
            System.out.print(songs[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RecentlyPlayedStore store = new RecentlyPlayedStore(3);
        store.playSong("user", "S1");
        store.playSong("user", "S2");
        store.playSong("user", "S3");
        store.printRecentlyPlayed("user");

        store.playSong("user", "S4");
        store.printRecentlyPlayed("user");

        store.playSong("user", "S2");
        store.printRecentlyPlayed("user");

        store.playSong("user", "S1");
        store.printRecentlyPlayed("user");
    }
}
