# gzip

Emit offsets of nested GZIP streams.

GZIP has the interesting property that a sequence of concatenated
GZIP streams can be read as though it were a single GZIP stream.

The Web Archive (WARC) format takes advantage of this to store tens
of thousands of GZIP streams in a single file. When processing such
a file, it can be useful to know the start of the underlying stream.
The stock `java.util.zip.GZIPInputStream` class does not expose this.

This library patches that class expose a callback which gets invoked
with the offsets of the member streams.


## License

This library is a fork of `java.util.zip.GZIPInputStream` as implemented
by Oracle.

This library's contents are subject to the GPL "Classpath" exception. You may
link it into an executable without that executable itself having to be licensed
under the GPL.
