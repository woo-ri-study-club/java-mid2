# 제네릭 미션

## 1. 제네릭을 활용한 데이터 스택 구현
### 문제 설명
- GenericStack<T> 클래스를 구현하세요.
- 이 스택은 LIFO(Last In, First Out) 구조를 가지며, 기본적인 기능을 제공합니다.
- 내부적으로 ArrayList<T>를 사용하여 데이터를 저장합니다.
- 제네릭을 활용하여 어떤 타입의 데이터도 저장할 수 있어야 합니다.
### 구현 기능
- void push(T item): 스택에 요소를 추가합니다.
- T pop(): 스택에서 마지막으로 추가된 요소를 제거하고 반환합니다.
- T peek(): 스택의 마지막 요소를 반환하지만 제거하지 않습니다.
- boolean isEmpty(): 스택이 비어있는지 확인합니다.
- int size(): 스택에 저장된 요소의 개수를 반환합니다.
### 제약 사항
- 내부 데이터 구조로 ArrayList<T>를 사용해야 합니다.
- pop()을 호출할 때 스택이 비어있으면 null을 반환해야 합니다.
- peek()을 호출할 때 스택이 비어있으면 null을 반환해야 합니다.

## 2. 제네릭을 활용한 쌍(Pair) 클래스 구현
### 문제 설명
- 두 개의 값을 한 쌍으로 저장하는 Pair<K, V> 클래스를 구현하세요.
- K는 키(Key), V는 값(Value)을 의미합니다.
- K와 V의 타입은 서로 다를 수 있습니다.
### 구현 기능
- K getKey(): 키를 반환합니다.
- V getValue(): 값을 반환합니다.
- void setValue(V value): 값을 변경합니다.
### 제약 사항
- 키(K)는 생성 후 변경할 수 없습니다.
- 값(V)은 변경이 가능합니다.

## 3. 제네릭을 활용한 비교 가능 객체 (Comparable) 구현
### 문제 설명
- Box<T extends Comparable<T>> 클래스를 구현하세요.
- T 타입은 Comparable<T> 인터페이스를 구현해야 합니다.
- compareTo()를 이용하여 두 개의 Box 객체를 비교할 수 있어야 합니다.
### 구현 기능
- int compareTo(Box<T> other): 두 Box 객체의 값을 비교하여 결과를 반환합니다.
- T getValue(): 박스에 저장된 값을 반환합니다.
### 제약 사항
- T는 Comparable<T>를 구현한 타입이어야 합니다.
- compareTo()는 this.value와 other.value를 비교하여 반환해야 합니다.

## 4. 제네릭을 활용한 리스트 필터링
### 문제 설명
- GenericFilter 클래스에 filterList 메서드를 구현하세요.
- List<T>를 필터링하는 제네릭 메서드를 구현하세요.
- 필터 조건을 람다식(Predicate<T>)으로 받을 수 있어야 합니다.
### 구현 기능
- List<T> filterList(List<T> list, Predicate<T> condition): 리스트에서 조건을 만족하는 요소만 반환합니다.
### 제약 사항
- Predicate<T> 인터페이스를 사용하여 조건을 정의해야 합니다.