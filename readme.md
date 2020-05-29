## Stream Api vs Collection

сравнение скорости выполнения Stream Api и Collection

все примеры для java 8 (1.8.0_151)

#### collect - преобразовать коллекцию в другую коллекцию

для маленьких коллекций до миллиона записей, 
лучше использовать `collection`

stream api: медленно, лучше не использовать
```java
list.stream()
    .collect(toCollection(TreeSet::new));
```

collection: компактнее и быстрее  

```java
new TreeSet<>(list);
```

|         | stream | collection |
|---------|--------|------------|
| 100     | 18     | 3          |
| 10000   | 36     | 12         |
| 1000000 | 121    | 117        |

#### count - количество элементов

в stream api java 8 имеется баг, 
stream api подсчитывает количество элементов в коллекции
перебирая их, если большое количество элементов в коллекции, 
то программа зависнет

stream api: медленно, лучше не использовать 

```java 
list.stream().count();
```

collection: компактнее и быстрее 

```java
list.size();
```

|         | stream | collection |
|---------|--------|------------|
| 100     | 16     | 1          |
| 10000   | 25     | 2          |
| 1000000 | 45     | 2          |

 #### distinct - получить уникальные значения коллекции
  
  stream api: по скорости одинаков с collection
  
  ```java 
  list.stream()
      .distinct();
  ```
  
  parallelStream: очень медленный лучше не использовать
  
  collection: по скорости одинаков со stream api
  
  ```java
  Set<Integer> set = new HashSet<>(list);
  ```
  
  |         | stream | parallelStream | collection |
  |---------|--------|----------------|------------|
  | 100     | 23     | 20             | 1          |
  | 10000   | 16     | 28             | 3          |
  | 1000000 | 58     | 67             | 45         |

#### filter - получить только записи по условию

stream api: по возможности не использовать  

```java 
list.stream()
    .filter(o -> o > 50)
    .collect(Collectors.toList());
```

collection: компактнее и быстрее

```java
list.removeIf(o -> o > 50);
```

|         | stream | collection |
|---------|--------|------------|
| 100     | 13     | 4          |
| 10000   | 26     | 10         |
| 1000000 | 85     | 74         |

#### forEach - перебрать элементы коллекции

stream api: одинаково 

```java 
list.stream()
    .forEach(i -> {});
```

collection: компактнее, по скорости одинаково

```java
list.forEach(i -> {});
```

|         | stream | collection |
|---------|--------|------------|
| 100     | 7      | 5          |
| 10000   | 3      | 5          |
| 1000000 | 35     | 35         |

 #### max / min - поиск максимального / минимального элемента в коллекции
 
 для больших коллекций лучше использовать stream api,
 а для маленьких предпочтительнее collection
 
 stream api: лучше не использовать
 
 ```java 
 list.stream()
     .max(Comparator.naturalOrder()).get();
 ```
 
 collection: быстрее   
 
 ```java
 Collections.max(list, Comparator.naturalOrder());
 ```
 
 |         | stream | collection |
 |---------|--------|------------|
 | 100     | 8      | 1          |
 | 10000   | 15     | 6          |
 | 1000000 | 58     | 33         |
 
 #### skip - пропустить первые n - элементов
  
  stream api: очень медленный, лучше не использовать
  
  ```java 
  list.stream()
      .limit(m)
      .skip(n)
      .forEach(System.out::println);
  ```
  
  parallelStream: быстрый при большом пропуске большого 
  количества данных
  
  
  collection: быстрее
  
  ```java
  list.subList(n, m)
      .stream()
      .forEach(System.out::println);
  ```
  
  |         | stream | parallelStream | collection |
  |---------|--------|----------------|------------|
  | 100     | 1      | 40             | 0          |
  | 10000   | 3      | 37             | 0          |
  | 1000000 | 19     | 28             | 0          |
 
 #### sorted - отсортировать коллекцию
 
 stream api: одинаково 
 
 ```java 
 list.stream()
     .sorted(Comparator.naturalOrder())
     .forEach(System.out::println);
 ```
 
 collection: одинаково 
 
 ```java
 list.sort(Comparator.naturalOrder());
 list.stream().forEach(System.out::println);
 ```
 
 |         | stream | collection |
 |---------|--------|------------|
 | 100     | 11     | 1          |
 | 10000   | 15     | 18         |
 | 1000000 | 404    | 252        |
