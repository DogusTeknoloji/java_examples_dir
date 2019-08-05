package com.dteknoloji.java;


import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Dir
 */
public class Dir {
    public static void main(String[] args) throws IOException {
        Path currentRelativePath = Paths.get("");
        System.out.println(currentRelativePath.toAbsolutePath());

        File startDirectory = new File(currentRelativePath.toAbsolutePath().toString());

        File[] directories = startDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        for (File directory : directories) {
            System.out.print("D ");
            System.out.printf("%-30s", directory.getName());
            System.out.println();
        }

        File[] files = startDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });

        for (File file : files) {
            BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            System.out.print("F ");
            System.out.printf("%-30s %10s %s", file.getName(), file.length(), attributes.creationTime().toString());
            System.out.println();
        }

    }
}
