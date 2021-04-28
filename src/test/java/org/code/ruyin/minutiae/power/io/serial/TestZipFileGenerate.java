package org.code.ruyin.minutiae.power.io.serial;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author hjxz
 * @date 2021/4/28
 * @title
 * @description
 */
public class TestZipFileGenerate {

    @Test
    public void generateZipFile() throws IOException {
        String filename = "bac.zip";
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(filename));
        String s = "hello world!";

        ZipEntry entry = new ZipEntry("bac.txt");
        zos.putNextEntry(entry);
        zos.write(s.getBytes(StandardCharsets.UTF_8));
        zos.closeEntry();
        zos.close();
    }

}
