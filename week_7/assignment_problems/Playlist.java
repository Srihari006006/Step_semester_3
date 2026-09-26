package week_7.assignment_problems;

class Playlists {
    private String[] songs;
    private int count;

    Playlists(int size) {
        songs = new String[size];
        count = 0;
    }

    void addSong(String song) {
        if (count < songs.length) {
            songs[count] = song;
            count++;
        }
    }

    String[] getSongs() {
        String[] copy = new String[count];

        for (int i = 0; i < count; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    int getSongCount() {
        return count;
    }
}

public class Playlist {
    public static void main(String[] args) {

        Playlists p = new Playlists(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        copy[0] = "Hacked";

        System.out.println(p.getSongs()[0]);
        System.out.println("Song count: " + p.getSongCount());
    }
}