# Makefile

.PHONY: setup test lint report

setup:
	./gradlew build

test:
	./gradlew test

lint:
	./gradlew checkstyleMain checkstyleTest

report:
	./gradlew test jacocoTestReport