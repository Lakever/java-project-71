### Hexlet tests and linter status:
[![Actions Status](https://github.com/Lakever/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Lakever/java-project-71/app/actions)

[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Lakever_java-project-71&metric=coverage)](https://sonarcloud.io/summary/new_code?id=Lakever_java-project-71)

**gendiff** — консольное приложение на Java, которое сравнивает два файла конфигурации и выводит различия между ними в удобном формате.

##  Поддерживаемые форматы файлов

- JSON
- YAML (.yml, .yaml)

##  Поддерживаемые форматы вывода

- `stylish` — древовидный формат по умолчанию
- `plain` — формат в стиле текста
- `json` — формат машинного чтения

---
## gendiff [опции] <путь к первому файлу> <путь ко второму файлу>

Сравнение файлов с выводом по умолчанию (stylish)
- `gendiff file1.json file2.json`
- `gendiff -f plain file1.yaml file2.yaml`
- `gendiff --format json file1.json file2.json`
