package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import example.util.Calculator;

import org.junit.jupiter.api.Test;

import org.junit.Test;

public class test{ //assume user guesses string, if found calls method to check, if the check returns true, then test passes

    @Test
    public void RandomTargetWordTest(){ //check to see if random target word words

        WordelGame game = new WordelGame(); //creates game

        List<String> validWords = Arrays.asList("apple", "berry", "tests", "grape", "hello"); //list of random 5 char words

        String randomword = game.selectRandomWord(validWords); //gets random word from list

        assertTrue(validWords.contains(randomword)); //checks if the random word is in the list so that its not un-random
    }

    @Test
    public void validInput1(){ //tests if the user can input guesses

        WordelGame game = new WordelGame();

        String guess = "gdsas";

        boolean valid = game.UserGuess(guess); //check if word is valid

        assertFalse(valid); //should return false as gdsas is not a real word (should be a word in a bank full of words assuming the game we make is similar to wordle)
    }

    @Test
    public void validInput2(){ //tests if the user can input guesses #2
        WordelGame game = new WordelGame();

        String guess = "tests";

        boolean valid = UserGuess(guess); //check if word is valid

        assertTrue(valid); //should return true since tests is a valid word for input
    }

    @Test // assuming the game words where you start initially with 6 attemps, then decrease every time
    public void maxAttempts(){ //test to check if the game starts off with 6 attempts

        WordelGame game = new WordelGame();

        assertEquals(6, getAttempts()); //so when the game starts, the amount of attempts should be equal to 6

    }

    @Test // assuming the game words where you start initially with 6 attemps, then decrease every time
    public void maxAttempts(){ //test to check if the game stops after 6 attempts

        WordelGame game = new WordelGame();

        List<String> validWords = Arrays.asList("tests"); //list of random 5 char words

        String randomword = game.selectRandomWord(validWords); //gets random word from list

        for (int i = 0; i < 6; i++) { //guesses the wrong word 6 times, should check that the attemps are 0
            game.UserGuess("wrong");
        }

        assertEquals(0, getAttempts()); //0 guesses remaining after 6 attempts

    }

    @Test // assuming the game words where you start initially with 6 attemps, then decrease every time
    public void gameOver(){ //test to check if the game stops after 6 attempts

        WordelGame game = new WordelGame();

        List<String> validWords = Arrays.asList("tests"); //list of random 5 char words

        String randomword = game.selectRandomWord(validWords); //gets random word from list

        for (int i = 0; i < 6; i++) { //guesses the wrong word 6 times, should check that the attemps are 0
            game.UserGuess("wrong");
        }

        boolean gameend = game.IsOver(); //method to see if 0 attempts left
        assertTrue(gameend); //the gameend should be true to signify that there are zero attempts left

    }

    @Test // assuming the game words where you start initially with 6 attemps, then decrease every time, once its at 0, use a method to check if game is over
    // test should display the game over message, it should follow the format and say the games word was berry (only word in the List)
    public void DisplaysAnswer(){ //test to check if the game stops after 6 attempts

        WordelGame game = new WordelGame();

        List<String> validWords = Arrays.asList("berry"); //list of random 5 char words

        String randomword = game.selectRandomWord(validWords); //gets random word from list for the game

        for (int i = 0; i < 6; i++) { //guesses the wrong word 6 times, should check that the attemps are 0
            game.UserGuess("wrong");
        }

        String expectedMessage = "Game Over! The word was: berry"; //expected message should say the game is over, and the word
        assertEquals(expectedMessage, game.getGameOverMessage());

    }

}
