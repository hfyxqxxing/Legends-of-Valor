package legendsofvalor;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

public class TestGamePlatform {

    @Test
    public void TestGamePlatformCreation() {
        GamePlatform game = new GamePlatform();
        // game.startGame();
        Assertions.assertTrue(true);
        Assertions.assertEquals("Test", "Test"); // Write unit tests like this
    }
}
