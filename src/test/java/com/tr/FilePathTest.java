package com.tr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class FilePathTest {
    FilePath filePath = new FilePath();
    private static final String STRUCTURE = "0|root,1|dir1,2|file1.txt,2|subdir,3|subfile.txt,1|dir2,2|file2.txt,1|file3.txt";

    @Test
    public void canGetFilePath() {
        assertEquals("/root/dir1/subdir/subfile.txt",filePath.getFilePath(STRUCTURE, "subfile.txt"));
        assertEquals("/root/file3.txt",filePath.getFilePath(STRUCTURE, "file3.txt"));
        assertEquals("/root/dir1/file1.txt",filePath.getFilePath(STRUCTURE, "file1.txt"));
        assertEquals("/root/dir2/file2.txt",filePath.getFilePath(STRUCTURE, "file2.txt"));
    }
}
