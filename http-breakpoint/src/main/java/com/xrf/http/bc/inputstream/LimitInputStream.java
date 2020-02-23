package com.xrf.http.bc.inputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 限流inputStream
 */
public class LimitInputStream extends RandomAccessFile {

    private RandomAccessFile inputStream;
    private BandwidthLimiter bandwidthLimiter;

    public LimitInputStream(File file, String mode, RandomAccessFile inputStream, BandwidthLimiter bandwidthLimiter) throws FileNotFoundException {
        super(file, mode);
        this.inputStream = inputStream;
        this.bandwidthLimiter = bandwidthLimiter;
    }

    @Override
    public int read() throws IOException {
        if (bandwidthLimiter != null) {
            bandwidthLimiter.limitNextBytes();
        }
        return inputStream.read();
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        if (bandwidthLimiter != null) {
            bandwidthLimiter.limitNextBytes(len);
        }
        return inputStream.read(b, off, len);
    }

    @Override
    public int read(byte[] b) throws IOException {
        if (bandwidthLimiter != null && b.length > 0) {
            bandwidthLimiter.limitNextBytes(b.length);
        }
        return inputStream.read(b);
    }
}
