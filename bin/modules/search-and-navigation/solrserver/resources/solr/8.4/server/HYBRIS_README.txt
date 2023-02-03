
hybris Changes
=============================

This is a modified version of Solr.

The following directories were removed:
- docs
- example

The following files/directories were added:
- HYBRIS_README.txt
- contrib/hybris
- server/solr/security.json.example
- server/solr/solr.jks

The following files/directories were modified/replaced:
- bin/solr.cmd:
	- workaround for https://issues.apache.org/jira/browse/SOLR-7283 (lines 19-20)
- bin/solr.in.cmd:
	- authentication and ssl configuration example (lines 179-192)
	- workaround for JDK 11.0.2 and TLS 1.3 issue - https://bugs.openjdk.java.net/browse/JDK-8212885 (line 194)
	- remove UseLargePages parameter from GC_TUNE parameters due to problems with running solr within docker container (line 196)
- bin/solr.in.sh:
	- authentication and ssl configuration example (lines 207-220)
	- workaround for JDK 11.0.2 and TLS 1.3 issue - https://bugs.openjdk.java.net/browse/JDK-8212885 (line 222)
	- remove UseLargePages parameter from GC_TUNE parameters due to problems with running solr within docker container (line 224)
- server/solr/solr.xml
- server/solr/configsets
- zookeeper related files (due to https://issues.apache.org/jira/browse/ZOOKEEPER-3056, https://issues.apache.org/jira/browse/ZOOKEEPER-3513)
  - licenses/zookeeper-3.5.5.jar.sha1 -> licenses/zookeeper-3.5.7.jar.sha1
  - licenses/zookeeper-jute-3.5.5.jar.sha1 -> licenses/zookeeper-jute-3.5.7.jar.sha1
  - dist/solrj-lib/zookeeper-3.5.5.jar -> dist/solrj-lib/zookeeper-3.5.7.jar
  - dist/solrj-lib/zookeeper-jute-3.5.5.jar -> dist/solrj-lib/zookeeper-jute-3.5.7.jar
  - server/solr-webapp/webapp/WEB-INF/lib/zookeeper-3.5.5.jar -> server/solr-webapp/webapp/WEB-INF/lib/zookeeper-3.5.7.jar
  - server/solr-webapp/webapp/WEB-INF/lib/zookeeper-jute-3.5.5.jar -> server/solr-webapp/webapp/WEB-INF/lib/zookeeper-jute-3.5.7.jar
