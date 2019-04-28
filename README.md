# DEPRECATED

_Don't use this library!_

It relied on accessing internals of `java.util.zip.Inflater`, which have
changed in JDK 11.

Instead, use [GzipCompressorInputStream](https://commons.apache.org/proper/commons-compress/apidocs/org/apache/commons/compress/compressors/gzip/GzipCompressorInputStream.html)
from Apache compress-commons. An example of how to use it is at https://github.com/cldellow/warc-service/blob/e95f8f5906c39efeb781a47b343a7cec179af7e3/src/main/scala/com/cldellow/warc/framework/WarcHandler.scala#L62



## gzip

[![Build Status](https://travis-ci.org/cldellow/gzip.svg?branch=master)](https://travis-ci.org/cldellow/gzip)
[![codecov](https://codecov.io/gh/cldellow/gzip/branch/master/graph/badge.svg)](https://codecov.io/gh/cldellow/gzip)
[![Maven Central](https://img.shields.io/maven-central/v/com.cldellow/gzip.svg)](https://mvnrepository.com/artifact/com.cldellow/gzip)

Emit offsets of nested GZIP streams.

GZIP has the interesting property that a sequence of concatenated
GZIP streams can be read as though it were a single GZIP stream.

The Web Archive (WARC) format takes advantage of this to store tens
of thousands of GZIP streams in a single file. When processing such
a file, it can be useful to know the start of the underlying stream.
The stock `java.util.zip.GZIPInputStream` class does not expose this.

This library patches that class expose a callback which gets invoked
with the offsets of the member streams.

### Usage

```
int[] offsets = new int[100];

GZIPInputStream gzis = new GZIPInputStream(is, (member, offset) -> { offsets[member] = offset; });
```

### License

This library is a fork of `java.util.zip.GZIPInputStream` as implemented
by Oracle.

This library's contents are subject to the GPL "Classpath" exception. You may
link it into an executable without that executable itself having to be licensed
under the GPL.
