#!/usr/bin/env bash

set -eo pipefail

mvn clean package
java -jar $(find target/ -name "*.jar")
