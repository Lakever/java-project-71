# Makefile

.PHONY: build

setup:
	./gradlew build

test:
	./gradlew test

lint:
	./gradlew checkstyleMain checkstyleTest

report:
	./gradlew test jacocoTestReport