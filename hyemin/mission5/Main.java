package mission5;

public class Main {
    public static void main(String[] args) {
        ChessGameManager game = new ChessGameManager();

        game.addPlayer("타노스");
        game.addPlayer("성기훈");
        game.addPlayer("김민수");

        game.recordMatch("타노스", "성기훈");
        game.recordMatch("김민수", "타노스");
        game.recordMatch("타노스", "김민수");

        System.out.println("📌 전체 점수 목록");
        System.out.println("game.getScores() = " + game.getScores()); // 점수 내림차순 정렬된 목록 출력

        System.out.println("📌 최고 점수 플레이어");
        System.out.println("game.getTopPlayer() = " + game.getTopPlayer()); // 최고 점수 플레이어 출력

        System.out.println("📌 승리 횟수 기준 정렬");
        System.out.println("game.sortByWins() = " + game.sortByWins()); // 승리 횟수 기준 정렬 후 출력
    }
}

