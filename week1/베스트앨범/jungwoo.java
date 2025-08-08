import java.util.*;
import java.util.stream.*;

class Solution {
    class Song implements Comparable<Song> {
        int id;
        int play;
        String genre;

        public String getGenre() {
            return this.genre;
        }

        public int getPlay(){
            return this.play;
        }

        Song(int id, int play, String genre) {
            this.id = id;
            this.play = play;
            this.genre = genre;
        }

        @Override
        public int compareTo(Song s){
            return this.play - s.play;
        }
    }
    public int[] solution(String[] genres, int[] plays) {

        Map<String, List<Song>> genreToSong = IntStream.range(0, genres.length)
                .mapToObj(i -> new Song(i, plays[i], genres[i]))
                .collect(Collectors.groupingBy(Song::getGenre));

        return genreToSong.entrySet().stream()
                .sorted((a, b) -> getTotalPlay(b.getValue()) - getTotalPlay(a.getValue()))
                .flatMap(entry -> entry.getValue().stream()
                        .sorted(Comparator.reverseOrder())
                        .limit(2))
                .mapToInt(x->x.id).toArray();
    }

    int getTotalPlay(List<Song> songs){
        return songs.stream()
                .mapToInt(Song::getPlay)
                .reduce(0, (a, b) -> a + b);
    }
}