##  170. Hepsiemlak Java Spring Bootcamp

###### Tacettin Utku Süer



#### Ödev 6 Soru 2 - Checked vs UnChecked Exception



Java'da exceptionlar 2'ye ayrılır biri checked diğeri unchecked exception'lardır. Checked exceptionlar derleme sırasında ortaya çıkar ve eğer try-catch yapısı olmazsa derleyici hata verir ve program çalışmaz. IOException SQLException bu tür checked exception'lara örnektir. Unchecked exceptionlar ise derleme sırasında hata vermez, program çalışırken yani Runtime sırasında karşılaşılan exceptionlardır. Bu yüzden de derleme sırasında try-catch yazılmasada hata vermez, Runtime sırasında hata ile karşılaşıldığında exception oluşturmaktadır. NullPointer NumberFormat bu tür unchecked exception'lara örnektir. Aşağıda exception şematiği gösterilmiştir. Error'lerde unchecked exception türüne aittir.



![img](https://howtodoinjava.com/wp-content/uploads/ExceptionHierarchyJava.png)



```java
try{
    FileReader dosya = new FileReader("dosya.txt");
}catch(FileNotFoundException e) {
    log.info(e);
}
```



Yukarıda dosya işlemleri yapıldığından dolayı checked exception'dır ve try-catch'e alınmadığı takdirde derleme sırasında hata verecektir.



```java
try{
    FileReader dosya = new FileReader("dosya.txt");
    dosya = null;
    dosya.read();
}catch(FileNotFoundException e) {
    log.info(e);
}
```



Yukarıda ki kodda ise dosya null olarak değiştirilmiş ve okunmaya çalışılmıştır. Değer null olduğundan okuma yapılamayacağından, NullPointerException fırlatacaktır. Bu okuma işlemi sırasında Runtime sırasında olacağından unchecked exception türüne aittir.
