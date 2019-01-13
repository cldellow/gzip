package com.cldellow.zip;

import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

import static org.junit.Assert.*;


public class GZIPInputStreamTest {
    @Test
    public void testUncompress() throws Exception {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("three-files.gz");
        int[] offsets = new int[32];
        GZIPInputStream gzis = new GZIPInputStream(is, (index, offset) -> {
            offsets[index] = offset;
        });
        while(gzis.read() != -1) { }

        assertEquals(0, offsets[0]);
        assertEquals(24, offsets[1]);
        assertEquals(48, offsets[2]);
    }
}
