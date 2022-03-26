package com.interview.programs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Application {

    public static void main(String[] args) throws IncorrectFileNameException {
        extracted();
    }

    private static String extracted() throws IncorrectFileNameException {
        String fileName = "someFileName";
        try (Scanner file = new Scanner(new File("fileName"))) {
            if (file.hasNextLine()) {
                return file.nextLine();
            } else {
                throw new IllegalArgumentException("Non readable file");
            }
        } catch (FileNotFoundException err) {
            if (!isCorrectFileName()) {
                throw new IncorrectFileNameException(
                        "Incorrect filename : " + fileName, err);
            }
        } catch (IllegalArgumentException err) {
            if (!isContainsExtension()) {
                throw new IncorrectFileExtensionException(
                        "Filename does not contain extension : " + fileName, err);
            }
        }
        return fileName;
    }

    private static boolean isCorrectFileName() {
        return false;
    }

    private static boolean isContainsExtension() {
        return false;
    }
}

class IncorrectFileNameException extends Exception {

    public IncorrectFileNameException() {
        super();
    }

    public IncorrectFileNameException(String s, FileNotFoundException err) {
        super(s, err);
    }
}

class IncorrectFileExtensionException extends RuntimeException {

    public IncorrectFileExtensionException(String s, IllegalArgumentException err) {
    }
}