# Makefile

.PHONY: build

setup:
	./gradlew clean build

test:
	./gradlew test

lint:
	./gradlew checkstyleMain checkstyleTest

report:
	./gradlew test jacocoTestReport