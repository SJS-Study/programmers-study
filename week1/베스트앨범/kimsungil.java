import java.util.*;

class Solution {

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayMap = musicHash(genres, plays);
        Map<String, List<Music>> genreMusicMap = makeHash(genres, plays);
        return answer(genrePlayMap, genreMusicMap);
    }

    private Map<String, Integer> musicHash(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            if (map.containsKey(genre)) {
                int total = map.get(genre);
                map.put(genre, total + play);
            } else {
                map.put(genre, play);
            }
        }
        return map;
    }

    private Map<String, List<Music>> makeHash(String[] genres, int[] plays) {
        Map<String, List<Music>> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            Music music = new Music(i, play);
            if (!map.containsKey(genre)) {
                map.put(genre, new ArrayList<Music>());
            }
            map.get(genre).add(music);
        }
        return map;
    }


    private int[] answer(Map<String, Integer> genrePlayMap, Map<String, List<Music>> genreMusicMap) {
        List<String> genreList = new ArrayList<>(genrePlayMap.keySet());
        genreList.sort((a, b) -> Integer.compare(genrePlayMap.get(b), genrePlayMap.get(a)));
        List<Integer> answer = new ArrayList<>();
        for (String g : genreList) {
            List<Music> musics = genreMusicMap.getOrDefault(g, Collections.emptyList());
            musics.sort((m1, m2) -> {
                if (m1.play != m2.play) return Integer.compare(m2.play, m1.play);
                return Integer.compare(m1.index, m2.index);
            });
            for (int i = 0; i < musics.size() && i < 2; i++) {
                answer.add(musics.get(i).index);
            }
        }
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) result[i] = answer.get(i);
        return result;
    }
}

class Music {
    int index;
    int play;

    Music(int index, int play) {
        this.index = index;
        this.play = play;
    }
}
