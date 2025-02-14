public class Main {
    public static void main(String[] args) {
        ChessGameManager game = new ChessGameManager();
        game.addPlayer("Sam");
        game.addPlayer("Meep");
        game.addPlayer("Pong");
        game.addPlayer("Moo");

        game.recordMatch("Meep", "Sam");
        game.recordMatch("Meep", "Sam");
        game.recordMatch("Sam", "Meep");
        game.recordMatch("Sam", "Meep");
        game.recordMatch("Sam", "Meep");
        game.recordMatch("Sam", "Meep");
        game.recordMatch("Pong", "Meep");
        game.recordMatch("Pong", "Sam");
        game.recordMatch("Pong", "Sam");

        System.out.println("📌 전체 점수 목록");
        game.getScores(); // 점수 내림차순 정렬된 목록 출력

        System.out.println("📌 최고 점수 플레이어");
        game.getTopPlayer(); // 최고 점수 플레이어 출력

        System.out.println("📌 승리 횟수 기준 정렬");
        game.sortByWins(); // 승리 횟수 기준 정렬 후 출력
    }
}
