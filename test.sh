#!/usr/bin/env bash
mvn clean package surefire:test -Dtest="io.choerodon.selenium.basic.**"