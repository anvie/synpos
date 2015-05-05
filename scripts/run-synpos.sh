#!/usr/bin/env bash

java -Djava.library.path="./lib" -cp "target/synpos-1.jar:target/classes:lib/*" com.baycloud.synpos.synPOS
